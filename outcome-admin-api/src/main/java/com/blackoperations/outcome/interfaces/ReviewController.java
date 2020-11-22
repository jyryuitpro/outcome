package com.blackoperations.outcome.interfaces;

import com.blackoperations.outcome.application.ReviewService;
import com.blackoperations.outcome.domain.Review;
import org.h2.command.ddl.CreateView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> list() {
        List<Review> reviews = reviewService.getReviews();
        return reviews;
    }
}
