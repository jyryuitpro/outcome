package com.blackoperations.outcome.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class RestaurantTests {

    @Test
    void creattion() {
        Restaurant restaurant = new Restaurant("Bob zip", "Seoul");
        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getAddress(), is("Seoul"));
    }

    @Test
    void information() {
        Restaurant restaurant = new Restaurant("Bob zip", "Seoul");
        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
    }
}