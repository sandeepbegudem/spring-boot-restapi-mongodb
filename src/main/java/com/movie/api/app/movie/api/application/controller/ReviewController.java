package com.movie.api.app.movie.api.application.controller;

import com.movie.api.app.movie.api.application.model.Review;
import com.movie.api.app.movie.api.application.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/movies")
public class ReviewController {
    
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    
    @PostMapping("/reviews")
    public ResponseEntity<Review> postMovieReview(@RequestBody Map<String, String> payload){

        return new ResponseEntity<Review>(reviewService.insertReviewsUsingImdbId
                (payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }
}
