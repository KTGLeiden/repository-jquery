package com.capgemini.koen.application.controllers;

import com.capgemini.koen.application.exceptions.NotFoundException;
import com.capgemini.koen.application.models.Movie;
import com.capgemini.koen.application.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {
        Movie movie = movieRepository.findOneById(id);
        if(movie == null) {
            throw new NotFoundException();
        }
        return movie;
    }

    @PutMapping
    public Movie updateMovie(@RequestBody Movie movie) {
        if(movie.getId() == null || movieRepository.findOneById(movie.getId()) == null) {
            throw new NotFoundException();
        }
        return movieRepository.save(movie);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
    }

    @GetMapping("/search/year/{year}")
    public List<Movie> searchMovieByYear(@PathVariable int year) {
        return movieRepository.findByYear(year);
    }

}
