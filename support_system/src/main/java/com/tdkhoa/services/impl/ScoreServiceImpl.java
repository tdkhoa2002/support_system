/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services.impl;

import com.tdkhoa.pojo.Category;
import com.tdkhoa.pojo.Major;
import com.tdkhoa.pojo.Score;
import com.tdkhoa.repository.ScoreRepository;
import com.tdkhoa.services.ScoreService;
import java.util.List;
import java.util.Map;
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
    public Score saveOrUpdate(Map<String, String> params, Category cate, Major major) {
        Score score = new Score();
        
        score.setScore(Double.parseDouble(params.get("score")));
        score.setYear(Integer.parseInt(params.get("year")));
        score.setCategoryId(cate);
        score.setMajorId(major);
        
        scRepo.addOrUpdate(score);
        return score;
    }

    @Override
    public List<Score> getScoresLast() {
        return scRepo.getScoresLast();
    }

    @Override
    public boolean deleteScore(int id) {
        return this.scRepo.deleteScore(id);
    }
    
}
