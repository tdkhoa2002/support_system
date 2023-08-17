/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services;

import java.util.List;
import com.tdkhoa.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Khoa Tran
 */
public interface UserService extends UserDetailsService {
    List<User> getUsers(String username);
    List<User> getAllUsers();
    boolean addOrUpdateUser(User user);
    User findUserByUsername(String username);
    
}
