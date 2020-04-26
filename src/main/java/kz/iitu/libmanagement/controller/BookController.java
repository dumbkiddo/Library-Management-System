package kz.iitu.libmanagement.controller;

import io.swagger.annotations.Api;
import kz.iitu.libmanagement.entity.Book;
import kz.iitu.libmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value="Book Controller")
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookRepository.findById(id).get();
    }

    @GetMapping("/find_title/")
    public List<Book> getBookByTitle(@RequestParam String title) {
        return bookRepository.findByTitle(title);
    }

    @GetMapping("/find_author/")
    public List<Book> getBookByAuthor(@RequestParam String author) {
        return bookRepository.findByAuthor(author);
    }

    @PostMapping("")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @DeleteMapping("/{id}")
    public Book deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return bookRepository.saveAndFlush(bookRepository.findById(id).get());
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return bookRepository.saveAndFlush(book);
    }

}
