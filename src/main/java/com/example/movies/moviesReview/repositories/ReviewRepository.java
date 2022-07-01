package com.example.movies.moviesReview.repositories;


import com.example.movies.moviesReview.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {



   // void updateMovie(@Param(value="id") long id, @Param(value="noOfReviews") double noOfReviews);

    @Query(value = "select count(*) from review_table r where r.movie_movie_id = :id",nativeQuery = true)
    Integer getNumberOfMovieReviews (long id);

}
