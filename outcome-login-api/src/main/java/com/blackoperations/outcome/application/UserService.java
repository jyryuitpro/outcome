package com.blackoperations.outcome.application;

import com.blackoperations.outcome.domain.User;
import com.blackoperations.outcome.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepostory;

    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepostory, PasswordEncoder passwordEncoder) {
        this.userRepostory = userRepostory;
        this.passwordEncoder = passwordEncoder;
    }

    public User authenticate(String email, String password) {
        User user = userRepostory.findByEmail(email).orElseThrow(() -> new EmailNotExistedException(email));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new PasswordWrongException();
        }

        return user;
    }
}
