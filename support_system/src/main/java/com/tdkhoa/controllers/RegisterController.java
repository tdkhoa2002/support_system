package com.tdkhoa.controllers;

import com.tdkhoa.pojo.User;
import com.tdkhoa.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RegisterController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, BindingResult rs) {
//        System.out.println("username: " + user.getUsername());
//        System.out.println("paswword:: " + user.getPassword());
//        MultipartFile file = user.getFile();
//        System.out.println("avatar: " + file);
        System.out.println("id: " + user.getId());
        user.setAvatar("asdasdasd");
//        userService.addOrUpdateUser(user);
        return "index";
    }

    public boolean isPasswordMatch(String rawPassword, String encodedPassword) {
        // Kiểm tra sự khớp nhau giữa password gốc và password đã được băm
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
