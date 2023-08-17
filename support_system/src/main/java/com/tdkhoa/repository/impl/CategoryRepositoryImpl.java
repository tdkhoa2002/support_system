/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository.impl;

import com.tdkhoa.pojo.Category;
import com.tdkhoa.repository.CategoryRepository;
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
public class CategoryRepositoryImpl implements CategoryRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Category addOrUpdateCategory(Category cate) {
        Session s = this.factory.getObject().getCurrentSession();

        try {
            if (cate.getId() == null) {
                s.save(cate);
            } else {
                s.update(cate);
            }

            return cate;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        s.clear();
        return null;
    }

    @Override
    public List<Category> getCategories() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT c FROM Category c");
        
        return q.getResultList();
    }
    
    @Override
    public Category getCategoryById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Category.class, id);
    }

    @Override
    public boolean deleteCategory(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            Category cate = this.getCategoryById(id);
            s.delete(cate);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
