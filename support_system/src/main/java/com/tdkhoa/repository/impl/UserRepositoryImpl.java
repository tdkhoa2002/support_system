/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository.impl;

import com.tdkhoa.pojo.User;
import com.tdkhoa.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addOrUpdateUser(User user) {
        Session s = this.factory.getObject().getCurrentSession();

        try {
            if (user.getId() == null) {
                s.save(user);
            } else {
                s.update(user);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        s.clear();
        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query.select(root);

        if (username != null) {
            Predicate p = builder.like(root.get("username").as(String.class), String.format("%%%s%%", username));
            query = query.where(p);
        }

        org.hibernate.query.Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public User getUser(int id) {
        Session session = this.factory.getObject().getCurrentSession();

        return session.get(User.class, id);
    }

    @Override
    public String getRoleOfUser(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM Role where id = :id");
        query.setParameter("id", user.getId());
        return (String) query.getSingleResult();
    }

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From User Where username=:un");
        q.setParameter("un", username);
        
        return (User) q.getSingleResult();
    }

}
