//package com.tdkhoa.controllers;
//
//import com.tdkhoa.pojo.User;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/register")
//public class RegisterController {
//    @GetMapping
//    public String index() {
//        return "register";
//    }
//
////    @PostMapping
////    public String registerUser(User user, Model model) {
////        String msg = "";
////        String username = user.getUsername();
////        String password = user.getPassword();
////        String confirm_password = user.getConfirm_password();
////        String email = user.getEmail();
////        if(password.equalsIgnoreCase(confirm_password)) {
////            //Password same
////            if(password.length() < 8) {
////                msg = "Mật khẩu không được nhỏ hơn 8 ký tự";
////            }
////            else {
//////                String encodedPassword = passwordEncoder.encode(password);
//////                System.out.println(encodedPassword);
//////                msg = encodedPassword;
//////                return "login";
////            }
////        }
////        else {
////            msg = "Xác nhận mật khẩu không đúng";
////        }
////        model.addAttribute("message", msg);
////        return "register";
////    }
//
////    @Bean
////    public PasswordEncoder encoder() {
////        return new BCryptPasswordEncoder();
////    }
//}
