package com.blackoperations.outcome.utils;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

    @Test
    void createToken() {
        JwtUtil jwtUtil = new JwtUtil();

        String token = jwtUtil.createToken(1004L, "John");

        assertThat(token, containsString("."));
    }
}