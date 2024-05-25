package org.example.backend.Controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.backend.Entities.User;
import org.example.backend.Requests.UserCreateRequest;
import org.example.backend.Responses.UserResponse;
import org.example.backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@NoArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<UserResponse> getAllUsers(@RequestParam Optional<String> email, @RequestParam Optional<String> password){
        return userService.getAllUsers(email,password);
    }
    @GetMapping("/{userId}")
    public UserResponse getOneUser(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
    @PostMapping
    public User addUser(@RequestBody UserCreateRequest userCreateRequest){
        return userService.addUser(userCreateRequest);
    }
    @PatchMapping("/{userId}")
    public ResponseEntity<?> partialUpdateUser(@PathVariable Long userId, @RequestBody Map<String, Object> updates){
        return userService.partialUpdateUser(userId,updates);
    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
    @DeleteMapping
    public void deleteAllUsers(){
        userService.deleteAllUsers();
    }
}
