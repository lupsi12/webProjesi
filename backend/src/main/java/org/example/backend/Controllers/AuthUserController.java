package org.example.backend.Controllers;

import lombok.AllArgsConstructor;
import org.example.backend.Requests.UserCreateRequest;
import org.example.backend.Requests.UserLoginRequest;
import org.example.backend.Services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthUserController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserCreateRequest signupRequest) {
        return authenticationService.signup(signupRequest);
    }

}
