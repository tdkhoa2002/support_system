/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers;

import com.tdkhoa.pojo.Question;
import com.tdkhoa.pojo.User;
import com.tdkhoa.services.LiveStreamService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Khoa Tran
 */
@Controller
public class HomeController {
    @Autowired
    private HttpSession s;
    @Autowired
    private LiveStreamService liveServ;
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/admin")
    public String admin() {
        return "admin_dashboard";
    }
    
    @RequestMapping("/homepage")
    public String home(Model model, HttpSession session, Authentication authentication) {
        User user = (User) s.getAttribute("currentUser");
        model.addAttribute("currentUser", user);
        model.addAttribute("livestreams", liveServ.getListLivestreams());
        model.addAttribute("question", new Question());
        return "home_page";
    }
}
