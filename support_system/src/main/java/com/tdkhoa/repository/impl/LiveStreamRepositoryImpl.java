/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository.impl;

import com.tdkhoa.pojo.Livestream;
import com.tdkhoa.repository.LiveStreamRepository;
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
public class LiveStreamRepositoryImpl implements LiveStreamRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Livestream> getListLivestreams() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT l FROM Livestream l");

        return q.getResultList();
    }
    
    @Override
    public Livestream getLivestreamById(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Livestream.class, id);
    }

    @Override
    public boolean addOrUpdate(Livestream livestream) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (livestream.getId() == null) {
                s.save(livestream);
            } else {
                s.update(livestream);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteLivestream(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Livestream live = this.getLivestreamById(id);
            s.delete(live);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
