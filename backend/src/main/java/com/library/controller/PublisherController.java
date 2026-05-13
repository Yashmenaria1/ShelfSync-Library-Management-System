package com.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.library.model.Publisher;
import com.library.repository.PublisherRepository;

@RestController
@RequestMapping("/api/publishers")
@CrossOrigin(origins = "http://localhost:3000")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    // GET all publishers
    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    // GET publisher by ID
    @GetMapping("/{id}")
    public Publisher getPublisherById(@PathVariable int id) {
        return publisherRepository.findById(id).orElse(null);
    }

    // POST a new publisher
    @PostMapping
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        System.out.println("Incoming: " + publisher.getName() + " | " + publisher.getBio());
        return publisherRepository.save(publisher);
    }

    // PUT update publisher
    @PutMapping("/{id}")
    public Publisher updatePublisher(@PathVariable int id, @RequestBody Publisher publisher) {
        Publisher crntCat=publisherRepository.findById(id).orElse(null);
        if(crntCat!=null){
            
            // crntCat.setId(publisher.getId());
            crntCat.setName(publisher.getName());
            crntCat.setBio(publisher.getBio());
            return publisherRepository.save(crntCat);

        }else{
            return null;
        }
    }

    // DELETE publisher
    @DeleteMapping("/{id}")
    public void deletePublisher(@PathVariable int id) {
        publisherRepository.deleteById(id);
    }
}
