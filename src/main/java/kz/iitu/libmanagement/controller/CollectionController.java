package kz.iitu.libmanagement.controller;

import kz.iitu.libmanagement.entity.BookCollection;
import kz.iitu.libmanagement.repository.BookCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController {

    @Autowired
    private BookCollectionRepository collectionRepository;

    @GetMapping("")
    public List<BookCollection> getAllCollections() {
        return collectionRepository.findAll();
    }

    @GetMapping("/{id}")
    public BookCollection getCollectionById(@PathVariable("id") Long id) {
        return collectionRepository.findById(id).get();
    }

    @GetMapping("/find_author/")
    public List<BookCollection> getCollectionByAuthor(@RequestParam String author) {
        return collectionRepository.findByAuthor(author);
    }

    @PostMapping("")
    public BookCollection createCollection(@RequestBody BookCollection c) {
        return collectionRepository.saveAndFlush(c);
    }

    @DeleteMapping("/{id}")
    public BookCollection deleteCollection (@PathVariable("id") Long id) {
        collectionRepository.deleteById(id);
        return collectionRepository.saveAndFlush(collectionRepository.findById(id).get());
    }


    @PutMapping("/{id}")
    public BookCollection updateCollection(@PathVariable Long id, @RequestBody BookCollection bookCollection) {
        bookCollection.setId(id);
        return collectionRepository.saveAndFlush(bookCollection);
    }

}
