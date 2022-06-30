package com.example.movies.moviesReview.domain;

import com.example.movies.moviesReview.service.reponse.MovieResponse;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movie_table")
@Builder
@ToString
@Getter
@Setter
public class Movie {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long movieId;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private double rating;

    private Double noOfReviews;

    private String adminName;

    private String Description;

    public MovieResponse toMovieResponse() {
        return MovieResponse.builder().genre(genre).title(title).rating(rating).build();

    }
}
