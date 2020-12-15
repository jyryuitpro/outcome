package com.blackoperations.outcome.interfaces;

import com.blackoperations.outcome.application.ReservationService;
import com.blackoperations.outcome.domain.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ReservationControllerTest {

    @Autowired
    private ReservationController reservationController;

    private MockMvc mvc;

    @MockBean
    private ReservationService reservationService;

    @BeforeEach
    void beforeEach() {
        mvc = MockMvcBuilders.standaloneSetup(reservationController).build();
    }

    @Disabled
    @Test
    void create() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsIm5hbWUiOiJKb2huIn0.8hm6ZOJykSINHxL-rf0yV882fApL3hyQ9-WGlJUyo2A";

        Reservation mockReservation = Reservation.builder().id(12L).build();

        given(reservationService.addReservation(any(), any(), any(), any(), any(), any())).willReturn(mockReservation);

        mvc.perform(post("/restaurants/365/reservations")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"date\": \"2019-12-25\", \"time\": \"20:00\", \"partySize\": 20}"))
                .andExpect(status().isCreated());

        Long userId = 1004L;
        String name = "John";
        String date = "2019-12-25";
        String time = "20:00";
        Integer partySize = 20;

        verify(reservationService).addReservation(eq(365L), eq(userId), eq(name), eq(date), eq(time), eq(partySize));
    }
}