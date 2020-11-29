package com.blackoperations.outcome.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAll();

    List<Restaurant> findAllByAddressContaining(String region);

    Optional<Restaurant> findById(Long id);

    Restaurant save(Restaurant restaurant);
}
