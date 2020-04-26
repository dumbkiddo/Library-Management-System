package kz.iitu.libmanagement.controller;

import io.swagger.annotations.Api;
import kz.iitu.libmanagement.entity.Genre;
import kz.iitu.libmanagement.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value="Book Genre Controller")
@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("")
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable("id") Long id) {
        return genreRepository.findById(id).get();
    }

    @GetMapping("/find/")
    public List<Genre> getGenreByName(@RequestParam String type) {
        return genreRepository.findByType(type);
    }

    @PostMapping("")
    public Genre createGenre(@RequestBody Genre genre) {
        return genreRepository.saveAndFlush(genre);
    }

    @DeleteMapping("/{id}")
    public Genre deleteGenre(@PathVariable("id") Long id) {
        genreRepository.deleteById(id);
        return genreRepository.saveAndFlush(genreRepository.findById(id).get());
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable Long id, @RequestBody Genre genre) {
        genre.setId(id);
        return genreRepository.saveAndFlush(genre);
    }

}
