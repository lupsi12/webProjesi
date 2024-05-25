package org.example.backend.Services;

import lombok.extern.slf4j.Slf4j;
import org.example.backend.Entities.User;
import org.example.backend.Repository.UserRepo;
import org.example.backend.Requests.UserCreateRequest;
import org.example.backend.Requests.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class AuthenticationService {
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    private final AuthenticationManager authenticationManager;

    private final UserRepo userRepository;


    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(AuthenticationManager authenticationManager, UserRepo userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<?> login(UserLoginRequest loginRequest) {
        log.info("Request: {}", loginRequest);

        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.getUsername(), loginRequest.getPassword());
        log.info("authenticationRequest: {}", authenticationRequest);

        Authentication authenticationResponse =
                this.authenticationManager.authenticate(authenticationRequest);
        log.info("authenticationResponse: {}", authenticationResponse);
        // Kullanıcı nesnesini ResponseEntity içinde döndür
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<?> signup(UserCreateRequest signupRequest) {
        log.info("Request: {}", signupRequest);
        User user = new User();

        if (userRepository.findByUsername(signupRequest.getUsername()).isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already taken. Please try again");
        else if (userRepository.findByEmail(signupRequest.getEmail()).size()!=0)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already taken. Please try again");



        user.setId(sequenceGeneratorService.getSquenceNumber(signupRequest.SEQUENCE_NAME));
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setRoles(Arrays.asList(signupRequest.getRoles()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setComments(signupRequest.getComments());

        userRepository.save(user);
        log.info("user saved: {}", user);
        return new ResponseEntity<>("<h1>You have been registered</h1>",HttpStatus.OK);
    }
}