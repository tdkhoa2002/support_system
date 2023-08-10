/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository.impl;

import com.tdkhoa.pojo.Article;
import com.tdkhoa.pojo.Livestream;
import com.tdkhoa.pojo.Question;
import com.tdkhoa.repository.QuestionRepository;
import com.tdkhoa.repository.UserRepository;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Khoa Tran
 */
@Repository
@Transactional
public class QuestionRepositoryImpl implements QuestionRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Question> getListQuestionsByLivestreamId(Livestream livestream) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT q FROM Question q WHERE livestream_id = :livestream_id");
        q.setParameter("livestream_id", livestream.getId());

        return q.getResultList();
    }
    
    @Override
    public Question getQuestionById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Question.class, id);
    }

    @Override
    public boolean saveQuestionOrUpdate(Question question) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        question.setUserId(this.userRepo.getUserByUsername(authentication.getName()));
        System.out.println("User: " + question.getUserId());
        try {
            if (question.getId() == null) {
                s.save(question);
            } else {
                s.update(question);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteQuestion(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Question question = this.getQuestionById(id);
            s.delete(question);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
