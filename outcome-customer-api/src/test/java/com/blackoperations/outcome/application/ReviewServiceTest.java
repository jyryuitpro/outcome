package com.blackoperations.outcome.application;

import com.blackoperations.outcome.domain.Review;
import com.blackoperations.outcome.domain.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class ReviewServiceTest {

    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        reviewService = new ReviewService(reviewRepository);
    }

    @Test
    void addReview() {
        reviewService.addReview(1004L, "JOKER", 3, "Mat-it-da");

        verify(reviewRepository).save(any());
    }
}