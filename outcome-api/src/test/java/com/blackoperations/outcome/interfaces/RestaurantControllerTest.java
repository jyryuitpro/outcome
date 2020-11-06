package com.blackoperations.outcome.interfaces;

import com.blackoperations.outcome.application.RestaurantService;
import com.blackoperations.outcome.domain.MenuItem;
import com.blackoperations.outcome.domain.Restaurant;
import com.blackoperations.outcome.domain.RestaurantRepository;
import com.blackoperations.outcome.domain.RestaurantRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class RestaurantControllerTest {

    @Autowired
    private RestaurantController restaurantController;

    @MockBean
    private RestaurantService restaurantService;

//    @SpyBean(RestaurantService.class)
//    private RestaurantService restaurantService;

//    @SpyBean(RestaurantRepositoryImpl.class)
//    private RestaurantRepository restaurantRepository;

//    @SpyBean(MenuItemRepositoryImpl.class)
//    private MenuItemRepository menuItemRepository;

    private MockMvc mvc;

    @BeforeEach
    void beforeEach() {
        mvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
    }

    @Test
    void list() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "JOKER House", "Seoul"));

        given(restaurantService.getRestaurants()).willReturn(restaurants);

        mvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"JOKER House\"")));
    }

    @Test
    void detail() throws Exception {
        Restaurant restaurant1 = new Restaurant(1004L, "JOKER House", "Seoul");
        restaurant1.addMenuItem(new MenuItem("Kimchi"));

        Restaurant restaurant2 = new Restaurant(2020L, "Cyber Food", "Seoul");

        given(restaurantService.getRestaurant(1004L)).willReturn(restaurant1);
        given(restaurantService.getRestaurant(2020L)).willReturn(restaurant2);

        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"JOKER House\"")))
                .andExpect(content().string(containsString("Kimchi")));

        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":2020")))
                .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")));
    }
}