package com.library.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.BorrowRecordRepository;
import com.library.repository.CategoryRepository;
import com.library.repository.PublisherRepository;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final CategoryRepository categoryRepository;
    private final BorrowRecordRepository borrowRecordRepository;

    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads";

    public BookController(BookRepository bookRepository,
                          AuthorRepository authorRepository,
                          PublisherRepository publisherRepository,
                          CategoryRepository categoryRepository,
                          BorrowRecordRepository borrowRecordRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.categoryRepository = categoryRepository;
        this.borrowRecordRepository = borrowRecordRepository;
    }

    // ✅ Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam("q") String keyword) {
        return bookRepository.searchBooks(keyword);
    }
    
    // ✅ Get single book (with borrow info)
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        BorrowRecord borrowed = borrowRecordRepository.findFirstByBookIdOrderByBorrowDateDesc(id);

        Map<String, Object> response = new HashMap<>();
        response.put("id", book.getId());
        response.put("title", book.getTitle());
        response.put("description", book.getDescription());
        response.put("image", book.getImage());
        response.put("shelf", book.getShelf());
        response.put("author", book.getAuthor());
        response.put("publisher", book.getPublisher());
        response.put("category", book.getCategory());
        response.put("status", borrowed != null ? "BORROWED" : "AVAILABLE");
        response.put("borrowedBy", borrowed != null ? borrowed.getMember().getName() : null);

        return ResponseEntity.ok(response);
    }

    // ✅ Add book (with optional image)
    @PostMapping(consumes = {"multipart/form-data"})
    public String addBook(@RequestParam String title,
                          @RequestParam(required = false) Integer authorId,
                          @RequestParam(required = false) Integer publisherId,
                          @RequestParam(required = false) Integer categoryId,
                          @RequestParam(required = false) String shelf,
                          @RequestParam(required = false) String description,
                          @RequestParam(required = false) MultipartFile image) {

        Book book = new Book();
        book.setTitle(title);
        book.setShelf(shelf);
        book.setDescription(description);

        // 🔥 Set relations properly
        setAuthorPublisherCategory(book, authorId, publisherId, categoryId);

        // 🔥 Handle image
        handleImageUpload(book, image);

        bookRepository.save(book);

        return "Book added successfully!";
    }
//    @PostMapping(consumes = {"multipart/form-data"})
//    public String addBook(@RequestParam String title,
//                          @RequestParam(required = false) Integer authorId,
//                          @RequestParam(required = false) Integer publisherId,
//                          @RequestParam(required = false) Integer categoryId,
//                          @RequestParam(required = false) String shelf,
//                          @RequestParam(required = false) String description,
//                          @RequestParam(required = false) MultipartFile image) {
//        Book book = new Book();
//        book.setTitle(title);
//        book.setShelf(shelf);
//        book.setDescription(description);
//
//        authorId = setAuthorPublisherCategory(book, authorId, publisherId, categoryId);
//        handleImageUpload(book, image);
//
//        bookRepository.save(book);
//        return "Book added successfully!";
//    }

    // ✅ Update book
    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public String updateBook(@PathVariable int id,
                             @RequestParam String title,
                             @RequestParam(required = false) Integer authorId,
                             @RequestParam(required = false) Integer publisherId,
                             @RequestParam(required = false) Integer categoryId,
                             @RequestParam(required = false) String shelf,
                             @RequestParam(required = false) String description,
                             @RequestParam(required = false) MultipartFile image) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) return "Book not found!";

        book.setTitle(title);
        book.setShelf(shelf);
        book.setDescription(description);

        setAuthorPublisherCategory(book, authorId, publisherId, categoryId);
        handleImageUpload(book, image);

        bookRepository.save(book);
        return "Book updated successfully!";
    }

    // ✅ Delete book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        if (!bookRepository.existsById(id)) return "Book not found!";
        bookRepository.deleteById(id);
        return "Book deleted successfully!";
    }

    // 🔧 Helper: assign related entities
    private void setAuthorPublisherCategory(Book book,
                                            Integer authorId,
                                            Integer publisherId,
                                            Integer categoryId) {

        if (authorId != null) {
            Author author = authorRepository.findById(authorId)
                    .orElseThrow(() -> new RuntimeException("Author not found"));
            book.setAuthor(author);
        }

        if (publisherId != null) {
            Publisher publisher = publisherRepository.findById(publisherId)
                    .orElseThrow(() -> new RuntimeException("Publisher not found"));
            book.setPublisher(publisher);
        }

        if (categoryId != null) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            book.setCategory(category);
        }
    }

    // 🔧 Helper: handle image upload
    private void handleImageUpload(Book book, MultipartFile image) {
        if (image != null && !image.isEmpty()) {
            try {
                String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
                Path path = Paths.get("uploads/" + fileName);

                Files.createDirectories(path.getParent());
                Files.write(path, image.getBytes());

                book.setImage(fileName);
            } catch (Exception e) {
                throw new RuntimeException("Image upload failed");
            }
        }
    }
}
