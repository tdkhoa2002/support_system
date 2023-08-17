/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository.impl;

import com.tdkhoa.pojo.Major;
import com.tdkhoa.repository.MajorRepository;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class MajorRepositoryImpl implements MajorRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Major> getMajors() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT m FROM Major m");

        return q.getResultList();
    }

    @Override
    public Major getMajorById(int major_id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Major.class, major_id);
    }

    @Override
    public boolean addOrUpdate(Major major) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (major.getId() == null) {
                s.save(major);
            } else {
                s.update(major);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMajor(int major_id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Major major = this.getMajorById(major_id);
            s.delete(major);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
