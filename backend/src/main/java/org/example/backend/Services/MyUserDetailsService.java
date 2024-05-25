package org.example.backend.Services;

import org.example.backend.Entities.User;
import org.example.backend.Repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepository;

    public MyUserDetailsService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    //kullanıcı adıyla kullanıcıyı arama
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> foundUser = userRepository.findByUsername(username);
        if(foundUser.isEmpty()){
            throw new UsernameNotFoundException(username);
        }
        return foundUser.get();
    }
}