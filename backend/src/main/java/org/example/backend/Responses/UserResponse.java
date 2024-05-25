package org.example.backend.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backend.Entities.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String[] roles;
    private List<String> comments;
    public UserResponse(User userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
        this.roles = userEntity.getRoles().toArray(new String[0]);
        this.comments = userEntity.getComments();
    }
}
