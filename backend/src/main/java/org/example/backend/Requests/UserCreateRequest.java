package org.example.backend.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
    public static final String SEQUENCE_NAME = "user_sequence";
    private Long id;
    private String username;
    private String email;
    private String password;
    private String[] roles;

    private List<String> comments;
}