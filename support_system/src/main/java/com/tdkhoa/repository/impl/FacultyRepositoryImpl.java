/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository.impl;

import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.repository.FacultyRepository;
import java.util.List;
import javax.persistence.Query;
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
public class FacultyRepositoryImpl implements FacultyRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addFaculty(Faculty faculty) {
        Session s = this.factory.getObject().getCurrentSession();

        try {
            if (faculty.getId() == null) {
                s.save(faculty);
            } else {
                s.update(faculty);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        s.clear();
        return false;
    }

    @Override
    public List<Faculty> getFaculties() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT f FROM Faculty f");
        
        return q.getResultList();
    }

    @Override
    public Faculty getFacultyById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Faculty.class, id);
    }

    @Override
    public boolean deleteFaculty(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            Faculty faculty = this.getFacultyById(id);
            s.delete(faculty);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    
}
