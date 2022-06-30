package com.example.movies.moviesReview.service.reponse;

import com.example.movies.moviesReview.domain.Genre;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {

    private String title;
    private Genre genre;
    private Double rating;

//    public Movie toMovie(){
//        return Movie.builder().title(title).genre(genre).rating(0.0).adminName("localhostAdmin").build();
//    }
}
