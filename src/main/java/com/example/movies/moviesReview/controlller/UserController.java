package com.example.movies.moviesReview.controlller;

import com.example.movies.moviesReview.domain.Review;
import com.example.movies.moviesReview.service.ReviewService;
import com.example.movies.moviesReview.service.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    ReviewService reviewService;

    @PostMapping("/add/review")
    public void addReview(@RequestBody ReviewRequest reviewRequest){
        reviewService.addReview(reviewRequest.toReview());


    }

    @GetMapping("/find/review")
    public Review getReview(@RequestParam Long reviewId){
        return reviewService.getReviewById(reviewId);
    }
}
