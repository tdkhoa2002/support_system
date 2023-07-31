/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository.impl;

import com.tdkhoa.pojo.Article;
import com.tdkhoa.repository.ArticleRepository;
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
public class ArticleRepositoryImpl implements ArticleRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Article addArticle(Article article) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(article);
            return article;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
