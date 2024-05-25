package org.example.backend.Managers;


import org.example.backend.Entities.User;
import org.example.backend.Repository.UserRepo;
import org.example.backend.Requests.UserCreateRequest;
import org.example.backend.Responses.UserResponse;
import org.example.backend.Services.SequenceGeneratorService;
import org.example.backend.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {
    private UserRepo userRepo;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public UserManager(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<UserResponse> getAllUsers(Optional<String> email, Optional<String> password) {
        List<User> userList = null;
        if(email.isPresent() && password.isPresent()){
            userList = userRepo.findByEmailAndPassword(email.get(), password.get());
        } else if (email.isPresent()) {
            userList = userRepo.findByEmail(email.get());
        }
        else if (password.isPresent()) {
            userList = userRepo.findByPassword(password.get());
        } else userList = userRepo.findAll();
        return userList.stream().map(p -> new UserResponse(p)).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long userId) {
        User user = userRepo.findById(userId).orElse(null);
        UserResponse userResponse = new UserResponse(user);
        return userResponse;
    }

    @Override
    public User addUser(UserCreateRequest userCreateRequest) {
        User user = new User();
        user.setId(sequenceGeneratorService.getSquenceNumber(userCreateRequest.SEQUENCE_NAME));
        user.setUsername(userCreateRequest.getUsername());
        user.setEmail(userCreateRequest.getEmail());
        user.setPassword(userCreateRequest.getPassword());
        user.setRoles(Arrays.asList(userCreateRequest.getRoles()));
        user.setComments(userCreateRequest.getComments());
        return userRepo.save(user);
    }

    @Override
    public ResponseEntity<?> partialUpdateUser(Long id, Map<String, Object> updates) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        updates.forEach((key, value) -> {
            switch (key) {
                case "username":
                    user.setUsername((String) value);
                    break;

                case "comments":
                    user.getComments().add((String) value);
                    break;
            }
        });

        // Değişiklikleri kaydet
        userRepo.save(user);

        return ResponseEntity.ok(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepo.deleteAll();
    }
}