package org.example.backend.Services;

import org.example.backend.Entities.User;
import org.example.backend.Requests.UserCreateRequest;
import org.example.backend.Responses.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface UserService {
    List<UserResponse> getAllUsers(Optional<String> email, Optional<String> password);
    UserResponse getUserById(Long userId);
    User addUser(UserCreateRequest userCreateRequest);
    ResponseEntity<?> partialUpdateUser(Long id, Map<String, Object> updates);
    void deleteUser(Long id);
    void deleteAllUsers();
}
