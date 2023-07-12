/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository.impl;

import com.tdkhoa.pojo.User;
import com.tdkhoa.repository.UserRepository;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Khoa Tran
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public User addUser(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(user);
            return user;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getUsers(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
