package com.example.movies.moviesReview.repositories;

import com.example.movies.moviesReview.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Modifying
    @Query("update Movie m set m.noOfReviews = :noOfReviews where movieId = :id")
    void updateMovie(@Param(value="id") long id, @Param(value="noOfReviews") double noOfReviews);

    @Query(value = "select count(*) from Review r where movie = :id")
    Integer getNumberOfReviews (@Param(value="id") long id);
}
