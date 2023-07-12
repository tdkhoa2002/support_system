/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository;

import com.tdkhoa.pojo.User;
import java.util.List;
/**
 *
 * @author Khoa Tran
 */
public interface UserRepository {
    User addUser(User user);
    List<User> getUsers(String username);
    
}
