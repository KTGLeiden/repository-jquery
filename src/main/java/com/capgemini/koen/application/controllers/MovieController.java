package com.capgemini.koen.application.controllers;

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

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @GetMapping("/search/year/{year}")
    public List<Movie> searchMovieByYear(@PathVariable int year) {
        return movieRepository.findByYear(year);
    }

}
