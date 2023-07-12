package com.tdkhoa.controllers;

import com.tdkhoa.pojo.User;
import com.tdkhoa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private UserService userService;

    @GetMapping
    public String index() {
        return "register";
    }

    @PostMapping
    public String registerUser(User user, Model model) {
        String msg = "";
        String username = user.getUsername();
        String password = user.getPassword();
        String confirm_password = user.getConfirm_password();
        String email = user.getEmail();
        String encodedPassword = passwordEncoder.encode(password);
        if (password.equalsIgnoreCase(confirm_password)) {
            //Password same
            if (password.length() < 8) {
                msg = "Mật khẩu không được nhỏ hơn 8 ký tự";
            } else {
//                user.setUsername(username);
//                user.setPassword(encodedPassword);
//                user.setEmail(email);
//                user = this.userService.addUser(user);
                return "login";
            }
        } else {
            msg = "Xác nhận mật khẩu không đúng";
        }
        model.addAttribute("message", msg);
        return "register";
    }
    
    public boolean isPasswordMatch(String rawPassword, String encodedPassword) {
        // Kiểm tra sự khớp nhau giữa password gốc và password đã được băm
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
