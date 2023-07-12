/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services;

import java.util.List;
import com.tdkhoa.pojo.User;

/**
 *
 * @author Khoa Tran
 */
public interface UserService {
    List<User> getUsers();
    User addUser(User user);
}
