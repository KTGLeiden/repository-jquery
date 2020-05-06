package com.capgemini.koen.application.repositories;

import com.capgemini.koen.application.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByYear(int year);
    List<Movie> findByYearAndRating(int year, int rating);
    List<Movie> findByTitleStartingWith(String title);
    Movie findOneById(Long id);
}
