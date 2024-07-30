package com.kevin.diaz.task_4.controllers;

import com.kevin.diaz.task_4.models.User;
import com.kevin.diaz.task_4.services.UserRepository;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping({ "/login"})
    public String showUserList(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/login"; // Asegúrate de que login.html exista en src/main/resources/templates/users
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, Model model) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));
        if (userOptional.isPresent()) {
            return "redirect:/admin"; // Redirige al panel de administración si el email está registrado
        } else {
            model.addAttribute("error", "Email no registrado");
            return "/login"; // Redirige de nuevo a la página de login con un mensaje de error
        }
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "/register"; // Asegúrate de que register.html exista en src/main/resources/templates/users
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("email") String email, User user, Model model) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));
        if (userOptional.isPresent()) {
            model.addAttribute("warning", "Email ya registrado");
            return "/register"; // Redirige de nuevo a la página de registro con un mensaje de advertencia
        } else {
            user.setRegistrationTime(LocalDateTime.now());
            user.setLastLoginTime(LocalDateTime.now()); // Inicializa lastLoginTime antes de guardar
            userRepository.save(user);
            return "redirect:/login"; // Redirige a la página de login después de registrarse
        }
    }
}