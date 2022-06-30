package com.example.movies.moviesReview.service.request;

import com.example.movies.moviesReview.domain.Movie;
import com.example.movies.moviesReview.domain.Review;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ReviewRequest {
    private String movieReview;

    private double rating;

    private Long movieId;

    public Review toReview(){
        return Review.builder()
                .movieReview(movieReview)
                .rating(rating)
                .movie(Movie.builder()
                        .movieId(movieId)
                        .build())
                .build();

    }

}
