package com.example.movies.moviesReview.repositories;

import com.example.movies.moviesReview.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);

    Movie findByTitleAndRating(String title, Double rating);

    @Query("select m from Movie m where m.title= :name")
    Movie findByName(String name);

    @Query("select m from Movie m where m.title= ?1")
    Movie findByName1(String name);

    @Query(value = "select * from movie_table m where m.title= ? and m.rating=?",nativeQuery = true)
    Movie findByNameAndRating(String name,Double rating);

    @Query("select m from Movie m where m.movieId= :id")
    Movie findMovieById(@Param(value="id") long id);

    @Query(value = "update movie_table m set m.no_of_reviews = ? where m.movie_id = ?",nativeQuery = true)
    Movie updateMovie( Double noOfReviews,long id);



}
