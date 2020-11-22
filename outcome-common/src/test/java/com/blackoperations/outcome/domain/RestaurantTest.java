package com.blackoperations.outcome.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class RestaurantTest {

    @Test
    void creation() {
//        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");
        Restaurant restaurant = Restaurant.builder().id(1004L).name("Bob zip").address("Seoul").build();

        assertThat(restaurant.getId(), is(1004L));
        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getAddress(), is("Seoul"));
    }

    @Test
    void information() {
        Restaurant restaurant = Restaurant.builder().id(1004L).name("Bob zip").address("Seoul").build();

//        restaurant.setName("Sool zip");

        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
    }
}