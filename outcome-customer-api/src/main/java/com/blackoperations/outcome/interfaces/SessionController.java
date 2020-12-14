package com.blackoperations.outcome.interfaces;

import com.blackoperations.outcome.application.UserService;
import com.blackoperations.outcome.domain.User;
import com.blackoperations.outcome.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class SessionController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/session")
    public ResponseEntity<SessionResponseDto> create(@RequestBody SessionRequestDto resource) throws URISyntaxException {
        String email = resource.getEmail();
        String password = resource.getPassword();

        User user = userService.authenticate(email, password);

        String accessToken = jwtUtil.createToken(user.getId(), user.getName());

        String uri = "/session";
        SessionResponseDto sessionDto = SessionResponseDto.builder().accessToken(accessToken).build();
        return ResponseEntity.created(new URI(uri)).body(sessionDto);
    }
}
