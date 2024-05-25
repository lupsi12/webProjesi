package org.example.backend.Repository;

import org.example.backend.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends MongoRepository<User, Long> {
    List<User> findByEmailAndPassword(String email, String password);
    List<User> findByEmail(String email);
    List<User> findByPassword(String Password);
    Optional<User> findByUsername(String username);
}

