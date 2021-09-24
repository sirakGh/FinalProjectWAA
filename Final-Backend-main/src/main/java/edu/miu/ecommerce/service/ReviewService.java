package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Review;

import java.util.List;


public interface ReviewService {

    List<Review> getAllReviews();

    Review getReviewById(long id);

    Review approveReview(long id);
}
