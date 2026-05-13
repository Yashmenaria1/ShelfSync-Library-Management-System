package com.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.library.model.Author;
import com.library.repository.AuthorRepository;


@RestController
@RequestMapping("/api/authors")
 @CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // GET all authors
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // GET author by ID
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable int id) {
        return authorRepository.findById(id).orElse(null);
    }

    // POST a new author
    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        System.out.println("Name: " + author.getName());
        return authorRepository.save(author);
    }

    // PUT update author
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        Author eauthor = authorRepository.findById(id).orElse(null);
        if(eauthor!=null){
            eauthor.setId(author.getId());
            eauthor.setName(author.getName());
            eauthor.setBio(author.getBio());
            return authorRepository.save(eauthor);
        }else{
            return null;
        }
    }

    // DELETE an author
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable int id) {
        authorRepository.deleteById(id);
    }
}
