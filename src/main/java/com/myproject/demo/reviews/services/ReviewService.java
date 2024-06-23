package com.myproject.demo.reviews.services;

import com.myproject.demo.reviews.model.Reviews;

import java.util.List;

public interface ReviewService {
    List<Reviews> findAll(Long companyId);
    boolean createReview(Long companyId, Reviews review);

    Reviews getReviewById(Long companyId, Long reviewId);

    boolean updateReviewById(Long companyId, Long reviewId, Reviews review);

    boolean deleteReviewById(Long companyId, Long reviewId);
}
