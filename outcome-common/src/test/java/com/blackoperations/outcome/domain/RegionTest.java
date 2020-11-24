package com.blackoperations.outcome.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class RegionTest {

    @Test
    void creation() {
        Region region = Region.builder().name("서울").build();

        assertThat(region.getName(), is("서울"));
    }
}