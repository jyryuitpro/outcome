package com.blackoperations.outcome.application;

import com.blackoperations.outcome.domain.Review;
import com.blackoperations.outcome.domain.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
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
    void getReviews() {
        //given
        List<Review> mockReviews = new ArrayList<>();
        mockReviews.add(Review.builder().description("Cool!").build());

        given(reviewRepository.findAll()).willReturn(mockReviews);

        //when
        List<Review> reviews = reviewService.getReviews();
        Review review = reviews.get(0);

        //then
        assertThat(review.getDescription(), is("Cool!"));
    }

    @Test
    void addReview() {
        Review review = Review.builder()
                .name("JOKER")
                .score(3)
                .description("Mat-it-da")
                .build();

        reviewService.addReview(1004L, review);

        verify(reviewRepository).save(any());
    }
}