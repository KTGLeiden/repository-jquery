package com.capgemini.koen.application.repositories;

import com.capgemini.koen.application.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
