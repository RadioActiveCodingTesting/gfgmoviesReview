package com.example.movies.moviesReview.service;

import com.example.movies.moviesReview.domain.Movie;
import com.example.movies.moviesReview.repositories.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private MovieRepository movieRepository;

    public AdminService(MovieRepository movieRepository) {this.movieRepository = movieRepository;}

    public Movie addMovie(Movie movie) {

        return movieRepository.save(movie);
    }
}
