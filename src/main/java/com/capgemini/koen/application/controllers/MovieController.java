package com.capgemini.koen.application.controllers;

import com.capgemini.koen.application.models.Movie;
import com.capgemini.koen.application.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
    }
}
