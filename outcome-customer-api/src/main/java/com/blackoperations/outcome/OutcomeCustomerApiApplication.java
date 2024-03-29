package com.blackoperations.outcome;

import com.blackoperations.outcome.utils.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OutcomeCustomerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OutcomeCustomerApiApplication.class, args);
    }
}
