package com.blackoperations.outcome.application;

import com.blackoperations.outcome.domain.CategoryRepository;
import com.blackoperations.outcome.domain.User;
import com.blackoperations.outcome.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    void getUsers() {
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(User.builder()
                .email("tester@example.com")
                .name("tester")
                .level(1L)
                .build());

        given(userRepository.findAll()).willReturn(mockUsers);

        List<User> users = userService.getUsers();

        User user = users.get(0);

        assertThat(user.getName(), is("tester"));
    }
}