package com.example.movies.moviesReview.service;

import com.example.movies.moviesReview.domain.Movie;
import com.example.movies.moviesReview.domain.Review;
import com.example.movies.moviesReview.repositories.MovieRepository;
import com.example.movies.moviesReview.repositories.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    Logger logger = LoggerFactory.getLogger(ReviewService.class);

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    MovieRepository movieRepository;

    public void addReview(Review review) {
        Review savedReview = reviewRepository.save(review);
        Long   movieId = review.getMovie().getMovieId();
       Movie movie  = movieRepository.findMovieById(review.getMovie().getMovieId());
       Double existingMovieAvg = movie.getNoOfReviews();
        Integer totalNumberOfReviews = reviewRepository.getNumberOfReviews(review.getMovie().getMovieId()) +1;
       Double calculatedMovieAvg = existingMovieAvg - ((review.getRating()-existingMovieAvg)/totalNumberOfReviews);
               // getNumberOfReviews(review.getMovie().getMovieId());
       // Double movieRatingAvg = review.getMovie().getNoOfReviews().doubleValue() +
      //                          ((review.getRating()-review.getMovie().getNoOfReviews().doubleValue())/reviewRepository.getNumberOfReviews(review.getMovie().getMovieId()));
        reviewRepository.updateMovie(review.getMovie().getMovieId(),calculatedMovieAvg);
        logger.info("saved the review for movie", review.getReviewId());
    }



    public Review getReviewById(Long reviewId) {
        /*
        Optional<Review> optionalReview=reviewRepository.findById(reviewId);
        if(optionalReview.isPresent())
            return optionalReview.get();
        else {
            // throw exception
            return null; // or return blank new Review();
        }
        */
        Review review = reviewRepository.findById(reviewId).orElse(null);
        System.out.println(review.toString());



        return review;

        //  return reviewRepository.findById(reviewId).orElseThrow(new Exception());

    }
}

