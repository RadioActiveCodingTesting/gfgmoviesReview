package com.example.movies.moviesReview.controlller;

import com.example.movies.moviesReview.service.AdminService;
import com.example.movies.moviesReview.service.reponse.MovieResponse;
import com.example.movies.moviesReview.service.request.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @PostMapping("/movie/add")
    public ResponseEntity<MovieResponse> addMovie (@RequestBody MovieRequest movieRequest) {
        System.out.println(movieRequest);
        return new ResponseEntity<>(adminService.addMovie(movieRequest.toMovie()).toMovieResponse(), HttpStatus.CREATED);

    }



}
