package com.blackoperations.outcome.interfaces;

import com.blackoperations.outcome.application.RestaurantService;
import com.blackoperations.outcome.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list(@RequestParam("region") String region) {
        List<Restaurant> restaurants = restaurantService.getRestaurants(region);

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);

        return restaurant;
    }
}
