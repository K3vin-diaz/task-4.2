package com.kevin.diaz.task_4.services;

import com.kevin.diaz.task_4.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> register(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        user.setStatus("active");
        user.setRegistrationTime(LocalDateTime.now());
        userRepository.save(user);
        return ResponseEntity.ok().body("Registration successful");
    }

    public ResponseEntity<?> login(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null ); {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials or account blocked");
        }
    }
}

