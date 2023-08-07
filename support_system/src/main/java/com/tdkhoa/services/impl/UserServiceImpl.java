/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tdkhoa.pojo.User;
import com.tdkhoa.repository.UserRepository;
import com.tdkhoa.services.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khoa Tran
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<User> getUsers(String username) {
        return this.userRepo.getUsers(username);
    }

    @Override
    public boolean addOrUpdateUser(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setRoleName(User.USER);
        if (!user.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                user.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return this.userRepo.addOrUpdateUser(user);
    }

    
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        List<User> users = userRepo.getUsers(string);
        System.out.println("Cac user hien co: " + users);
        

        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Không tồn tại!");
        }

        User u = userRepo.getUser((users.get(0)).getId());
        
        System.out.println("User: " + u.getRoleName());
        

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getRoleName()));
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }
}
