package com.kevin.diaz.task_4.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;

/**
 * DTO for {@link User}
 */


public class UserDto implements Serializable {
    
    @NotEmpty(message="ID is required")
    Long id;
    @NotEmpty(message="Name is required")
    String name;
    
    @NotEmpty(message="Email is required")
    String email;
     
    @NotEmpty(message="Password is required")
    String password;
    
    LocalDateTime lastLoginTime;
    LocalDateTime registrationTime;
    boolean active;

    public UserDto() {
    }

    public UserDto(Long id, String name, String email, String password, LocalDateTime lastLoginTime, LocalDateTime registrationTime, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.lastLoginTime = lastLoginTime;
        this.registrationTime = registrationTime;
        this.active = active;
    }

}