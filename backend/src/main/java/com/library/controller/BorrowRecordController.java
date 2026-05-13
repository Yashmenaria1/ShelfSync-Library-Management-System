package com.library.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.library.model.Book;
import com.library.model.Member;
import com.library.model.BorrowRecord;
import com.library.repository.BookRepository;
import com.library.repository.MemberRepository;
import com.library.repository.BorrowRecordRepository;

@RestController
@RequestMapping("/api/borrow")
@CrossOrigin(origins = "http://localhost:3000")
public class BorrowRecordController {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping
    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    @PostMapping
    public BorrowRecord createBorrowRecord(@RequestBody BorrowRecord record) {

        // 🔥 Fetch actual entities
        Book book = bookRepository.findById(record.getBook().getId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Member member = memberRepository.findById(record.getMember().getId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        // 🔥 Set managed entities
        record.setBook(book);
        record.setMember(member);

        record.setBorrowDate(LocalDate.now());
        record.setStatus(BorrowRecord.Status.BORROWED);

        return borrowRecordRepository.save(record);
    }

    @PutMapping("/{id}/return")
    public BorrowRecord returnBook(@PathVariable int id) {
        BorrowRecord record = borrowRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record.setStatus(BorrowRecord.Status.RETURNED);
        record.setReturnDate(LocalDate.now());

        return borrowRecordRepository.save(record);
    }
}