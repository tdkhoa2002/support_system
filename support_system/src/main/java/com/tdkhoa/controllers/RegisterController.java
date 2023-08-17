package com.tdkhoa.controllers;

import com.tdkhoa.pojo.User;
import com.tdkhoa.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
    public String index(Model model, Authentication authentication) {
        if(authentication == null) {
            model.addAttribute("user", new User());
            return "register";
        }
        UserDetails userDetails = this.userService.loadUserByUsername(authentication.getName());
        User user = this.userService.findUserByUsername(userDetails.getUsername());
        model.addAttribute("user", user);
        return "redirect: /support_system/homepage";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, BindingResult rs) {
        userService.addOrUpdateUser(user);

        return "redirect:/login";
    }

    public boolean isPasswordMatch(String rawPassword, String encodedPassword) {
        // Kiểm tra sự khớp nhau giữa password gốc và password đã được băm
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
