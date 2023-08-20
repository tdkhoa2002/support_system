/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository.impl;

import com.tdkhoa.pojo.Article;
import com.tdkhoa.repository.ArticleRepository;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Khoa Tran
 */
@Repository
@Transactional
public class ArticleRepositoryImpl implements ArticleRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Article addArticle(Article article) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (article.getId() == null) {
                s.save(article);
            } else {
                s.update(article);
            }
            return article;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Article> getArticles() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT a FROM Article a");

        return q.getResultList();
    }

    @Override
    public Article getArticleById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Article.class, id);
    }

    @Override
    public boolean deleteArticle(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Article article = this.getArticleById(id);
            s.delete(article);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Article> getArticlesByCateId(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT a FROM Article a WHERE category_id = :category_id");
        q.setParameter("category_id", id);

        return q.getResultList();
    }

    @Override
    public List<Article> getArticlesByFacultyId(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT a FROM Article a WHERE faculty_id = :faculty_id");
        q.setParameter("faculty_id", id);

        return q.getResultList();
    }
}
