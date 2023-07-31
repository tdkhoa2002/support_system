package com.tdkhoa.controllers;

import com.tdkhoa.pojo.Role;
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
        Role r=new Role();
        r.setId(1);
        user.setAvatar("asdasdasd");
        user.setEmail("asdasdasd");
        user.setRoleId(r);

        userService.addOrUpdateUser(user);

        return "index";
    }

    public boolean isPasswordMatch(String rawPassword, String encodedPassword) {
        // Kiểm tra sự khớp nhau giữa password gốc và password đã được băm
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
