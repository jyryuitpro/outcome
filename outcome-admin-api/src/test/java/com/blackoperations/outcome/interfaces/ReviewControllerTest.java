package com.blackoperations.outcome.interfaces;

import com.blackoperations.outcome.application.ReviewService;
import com.blackoperations.outcome.domain.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
class ReviewControllerTest {

    @Autowired
    private ReviewController reviewController;

    @MockBean
    private ReviewService reviewService;

    private MockMvc mvc;

    @BeforeEach
    void beforeEach() {
        mvc = MockMvcBuilders.standaloneSetup(reviewController).build();
    }

    @Test
    void list() throws Exception {
        List<Review> reviews = new ArrayList<>();
        reviews.add(Review.builder().description("Cool!").build());

        given(reviewService.getReviews()).willReturn(reviews);

        mvc.perform(get("/reviews"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Cool!")));
    }
}