package com.blackoperations.outcome.application;

import com.blackoperations.outcome.domain.User;
import com.blackoperations.outcome.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        userService = new UserService(userRepository, passwordEncoder);
    }

    @Test
    void authenticateWithValidAttributes() {
        String email = "tester@example.com";
        String password = "test";

        User mockUser = User.builder().email(email).build();

        given(userRepository.findByEmail(email)).willReturn(Optional.of(mockUser));

        given(passwordEncoder.matches(any(), any())).willReturn(true);

        User user = userService.authenticate(email, password);

        assertThat(user.getEmail(), is(email));
    }

    @Disabled
    @Test
    void authenticateWithNotExistedEmail() {
        String email = "tester@example.com";
        String password = "test";

        given(userRepository.findByEmail(email)).willReturn(Optional.empty());

        userService.authenticate(email, password);

        assertThatThrownBy(() -> {
            userService.authenticate(email, password);
        }).isInstanceOf(EmailNotExistedException.class);
    }

    @Disabled
    @Test
    void authenticateWithWrongPassword() {
        String email = "tester@example.com";
        String password = "x";

        User mockUser = User.builder().email(email).build();

        given(userRepository.findByEmail(email)).willReturn(Optional.of(mockUser));

        given(passwordEncoder.matches(any(), any())).willReturn(false);

        userService.authenticate(email, password);

        assertThatThrownBy(() -> {
            userService.authenticate(email, password);
        }).isInstanceOf(PasswordWrongException.class);
    }
}