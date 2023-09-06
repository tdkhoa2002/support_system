/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository.impl;

import com.tdkhoa.pojo.Article;
import com.tdkhoa.repository.ArticleRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
    @Autowired
    private Environment env;

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

    @Override
    public List<Article> searchArticles(Map<String, String> params) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Article> q = b.createQuery(Article.class);
        Root root = q.from(Article.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("title"), String.format("%%%s%%", kw)));
            }

            String falcultyId = params.get("facultyId");
            if (falcultyId != null && !falcultyId.isEmpty()) {
                predicates.add(b.equal(root.get("facultyId"), Integer.parseInt(falcultyId)));
            }

            String cateId = params.get("categoryId");
            if (cateId != null && !cateId.isEmpty()) {
                predicates.add(b.equal(root.get("categoryId"), Integer.parseInt(cateId)));
            }

            q.where(predicates.toArray(Predicate[]::new));
        }

        q.orderBy(b.desc(root.get("id")));

        Query query = session.createQuery(q);

//        if (params != null) {
//            String page = params.get("page");
//            if (page != null && !page.isEmpty()) {
//                int p = Integer.parseInt(page);
//                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
//
//                query.setMaxResults(pageSize);
//                query.setFirstResult((p - 1) * pageSize);
//            }
//        }

        return query.getResultList();
    }
}
