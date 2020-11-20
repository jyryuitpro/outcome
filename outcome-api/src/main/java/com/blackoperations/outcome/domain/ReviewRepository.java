package com.blackoperations.outcome.domain;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    Review save(Review review);
}
