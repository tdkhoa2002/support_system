/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers.API;

import com.tdkhoa.components.JwtService;
import com.tdkhoa.pojo.User;
import com.tdkhoa.services.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Khoa Tran
 */
@RestController
public class ApiUserController {
    @Autowired 
     private UserService uServ;
    @Autowired
    private JwtService jwtService;
    
    @GetMapping("/users/api/")
    @CrossOrigin
    public ResponseEntity<List<User>> list() {
        return new ResponseEntity<>(this.uServ.getAllUsers(), HttpStatus.OK);
    }
    
    @PostMapping("/login/api/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody User user) {
        if (this.uServ.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());
            
            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping(path = "/register/api/", 
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<User> addUser(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        System.out.println("abc");
        User user = this.uServ.addOrUpdateUser(params, avatar);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/current-user/api/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<User> details(Principal user) {
        User u = this.uServ.findUserByUsername(user.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
}
