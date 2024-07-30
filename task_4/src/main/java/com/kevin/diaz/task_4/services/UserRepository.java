package com.kevin.diaz.task_4.services;

import com.kevin.diaz.task_4.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
