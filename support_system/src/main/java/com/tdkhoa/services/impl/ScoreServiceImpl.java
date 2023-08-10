/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services.impl;

import com.tdkhoa.pojo.Score;
import com.tdkhoa.repository.ScoreRepository;
import com.tdkhoa.services.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khoa Tran
 */
@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreRepository scRepo;

    @Override
    public boolean saveOrUpdate(Score score, int yearPicked) {
        return scRepo.addOrUpdate(score, yearPicked);
    }

    @Override
    public List<Score> getScoresLast() {
        return scRepo.getScoresLast();
    }
    
}
