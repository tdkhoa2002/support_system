/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository.impl;

import com.tdkhoa.pojo.Banner;
import com.tdkhoa.repository.BannerRepository;
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
public class BannerRepositoryImpl implements BannerRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addOrUpdate(Banner banner) {
        Session s = this.factory.getObject().getCurrentSession();

        try {
            if (banner.getId() == null) {
                s.save(banner);
            } else {
                s.update(banner);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        s.clear();
        return false;
    }

    @Override
    public List<Banner> getAllBanners() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT b FROM Banner b");

        return q.getResultList();
    }

    @Override
    public Banner getBannerById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Banner.class, id);
    }

    @Override
    public boolean deleteBanner(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            Banner banner = this.getBannerById(id);
            s.delete(banner);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Banner> getNewBanners() {
        Session s = this.factory.getObject().getCurrentSession();
        String hql = "FROM Banner ORDER BY id DESC";
        Query q = s.createQuery(hql, Banner.class);
        q.setMaxResults(5);
        return q.getResultList();
    }
}
