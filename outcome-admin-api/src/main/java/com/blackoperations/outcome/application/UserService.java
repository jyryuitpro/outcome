package com.blackoperations.outcome.application;

import com.blackoperations.outcome.domain.User;
import com.blackoperations.outcome.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();

        return users;
    }

    public User addUser(String email, String name) {
        User user = User.builder()
                .email(email)
                .name(name)
                .level(1L)
                .build();

        return userRepository.save(user);
    }

    public User updateUser(Long id, String email, String name, Long level) {
        // TODO: 2020-12-14 : restaurantService의 예외 처리 참고. 
        User user = userRepository.findById(id).orElse(null);

        user.setEmail(email);
        user.setName(name);
        user.setLevel(level);

        return user;
    }

    public User deactivateUser(Long id) {
        // TODO: 2020-12-14 : restaurantService의 예외 처리 참고.
        User user = userRepository.findById(id).orElse(null);

        user.deactivate();

        return user;
    }
}
