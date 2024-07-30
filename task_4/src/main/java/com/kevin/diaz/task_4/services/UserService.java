package com.kevin.diaz.task_4.services;

import com.kevin.diaz.task_4.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void blockUsers(List<Long> userIds) {
        for (Long id : userIds) {
            User user = userRepository.findById(id).orElse(null);
            if (user != null) {
                user.setStatus("blocked");
                userRepository.save(user);
            }
        }
    }

    public void unblockUsers(List<Long> userIds) {
        for (Long id : userIds) {
            User user = userRepository.findById(id).orElse(null);
            if (user != null) {
                user.setStatus("active");
                userRepository.save(user);
            }
        }
    }

    public void deleteUsers(List<Long> ids) {
        for (Long id : ids) {
            userRepository.deleteById(id);
        }
    }
}
