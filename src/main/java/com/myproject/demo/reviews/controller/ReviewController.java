package com.myproject.demo.reviews.controller;

import com.myproject.demo.reviews.model.Reviews;
import com.myproject.demo.reviews.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies/{companyId}")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReviews(@PathVariable Long companyId, @RequestBody Reviews review) {
        boolean isReview = reviewService.createReview(companyId, review);
        if (isReview) {

            return new ResponseEntity<>("review created", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("review not created", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Reviews>> getReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.findAll(companyId), HttpStatus.FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Reviews> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReviewById(companyId, reviewId), HttpStatus.FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                                @PathVariable Long reviewId,
                                                @RequestBody Reviews review) {
        boolean isReview = reviewService.updateReviewById(companyId, reviewId, review);
        if (isReview) {
            return new ResponseEntity<>("review updated", HttpStatus.OK);
        }
        return  new ResponseEntity<>("review updated failed", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReviewById(companyId, reviewId);
        if(isReviewDeleted){
            return new ResponseEntity<>("review delete success", HttpStatus.OK);
        }
        return new ResponseEntity<>("review delete failed", HttpStatus.NOT_FOUND);
    }
}
