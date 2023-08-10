/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.repository.impl;

import com.tdkhoa.pojo.Category;
import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.pojo.Score;
import com.tdkhoa.repository.ScoreRepository;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
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
public class ScoreRepositoryImpl implements ScoreRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addOrUpdate(Score score, int yearPicked) {
        Session s = this.factory.getObject().getCurrentSession();
        Calendar calendar = Calendar.getInstance();
        calendar.set(yearPicked, Calendar.JANUARY, 1); // Month is 0-based, so January is 0

        // Convert Calendar to Date
        Date date = calendar.getTime();
        score.setYear(yearPicked);

        try {
            if (score.getId() == null) {
                s.save(score);
            } else {
                s.update(score);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        s.clear();
        return false;
    }

    @Override
    public List<Score> getScoresLast() {
        Session s = this.factory.getObject().getCurrentSession();
        LocalDate now = LocalDate.now();
//        Query query = s.createQuery("FROM Score WHERE faculty_id = :faculty_id AND category_id = :category_id ORDER BY year DESC LIMIT 5");
//        query.setParameter("faculty_id", faculty.getId());
//        query.setParameter("category_id", category.getId());
        Query query = s.createQuery("SELECT d\n"
                + "FROM Score d\n"
                + "WHERE d.year BETWEEN year(CURRENT_DATE) - 5 AND year(CURRENT_DATE)\n"
                + "ORDER BY d.year DESC");
        return query.getResultList();
    }
//SELECT d
//FROM Diem d
//WHERE d.nam BETWEEN YEAR(CURRENT_DATE) - 5 AND YEAR(CURRENT_DATE)
//ORDER BY d.nam DESC;
}
