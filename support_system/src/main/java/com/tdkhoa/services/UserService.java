/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services;

import java.util.List;
import com.tdkhoa.pojo.User;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Khoa Tran
 */
public interface UserService extends UserDetailsService {

    List<User> getUsers(String username);

    List<User> getAllUsers();

    User addOrUpdateUser(Map<String, String> params, MultipartFile avatar);

    User findUserByUsername(String username);

    boolean authUser(String username, String password);

}
