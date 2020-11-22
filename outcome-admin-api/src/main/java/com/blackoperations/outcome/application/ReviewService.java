package com.blackoperations.outcome.application;

import com.blackoperations.outcome.domain.Review;
import com.blackoperations.outcome.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Review addReview(Long restaurantId, Review review) {
        review.setRestaurantId(restaurantId);

        return reviewRepository.save(review);
    }
}
