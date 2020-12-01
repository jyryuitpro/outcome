package com.blackoperations.outcome.interfaces;

import com.blackoperations.outcome.application.UserService;
import com.blackoperations.outcome.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> list() {
        List<User> users = userService.getUsers();

        return users;
    }
}
