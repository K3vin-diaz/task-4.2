package com.kevin.diaz.task_4.models;


import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime lastLoginTime;
    @Column(nullable = false)
    private LocalDateTime registrationTime;

    @Column(nullable = false)
    private boolean getStatus;

    public User(LocalDateTime lastLoginTime, LocalDateTime registrationTime) {
        this.lastLoginTime = lastLoginTime;
        this.registrationTime = registrationTime;
    }

    public void setStatus(String active) {
    }





}