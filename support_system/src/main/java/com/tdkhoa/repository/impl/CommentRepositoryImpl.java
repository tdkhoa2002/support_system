/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository.impl;

import com.tdkhoa.pojo.Comment;
import com.tdkhoa.repository.CommentRepository;
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
public class CommentRepositoryImpl implements CommentRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public Comment getConmmentById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Comment.class, id);
    }
    
    @Override
    public boolean addOrUpdateComment(Comment comment) {
        Session s = this.factory.getObject().getCurrentSession();
        
        try {
            if (comment.getId() == null) {
                s.save(comment);
            } else {
                s.update(comment);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        s.clear();
        return false;
    }

    @Override
    public List<Comment> getCommentsByArticleId(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT c FROM Comment c WHERE article_id = :article_id");
        q.setParameter("article_id", id);

        return q.getResultList();
    }

    @Override
    public boolean deleteComment(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            Comment cmt = this.getConmmentById(id);
            s.delete(cmt);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
