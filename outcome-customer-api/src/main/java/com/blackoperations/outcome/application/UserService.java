package com.blackoperations.outcome.application;

import com.blackoperations.outcome.domain.User;
import com.blackoperations.outcome.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepostory;

    public UserService(UserRepository userRepostory) {
        this.userRepostory = userRepostory;
    }

    public User registerUser(String email, String name, String password) {
        User user = User.builder()
                .email(email)
                .name(name)
                .password(password)
                .level(1L)
                .build();

        return userRepostory.save(user);
    }
}
