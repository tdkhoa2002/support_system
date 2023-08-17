package com.tdkhoa.controllers;

import com.tdkhoa.pojo.User;
import com.tdkhoa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired UserService userService;
    
    @GetMapping("/login")
    public String index(Model model, Authentication authentication) {
        if(authentication == null) {
            model.addAttribute("user", new User());
            return "login";
        }
        UserDetails userDetails = this.userService.loadUserByUsername(authentication.getName());
        User user = this.userService.findUserByUsername(userDetails.getUsername());
        model.addAttribute("user", user);
        return "redirect: /support_system/homepage";
    }
}
