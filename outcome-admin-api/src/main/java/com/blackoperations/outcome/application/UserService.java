package com.blackoperations.outcome.application;

import com.blackoperations.outcome.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(User.builder()
                .email("tester@example.com")
                .name("tester")
                .level(1L)
                .build());

        return users;
    }
}
