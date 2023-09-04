/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services.impl;

import com.tdkhoa.pojo.Livestream;
import com.tdkhoa.pojo.Question;
import com.tdkhoa.pojo.User;
import com.tdkhoa.repository.QuestionRepository;
import com.tdkhoa.services.QuestionService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khoa Tran
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository qRepo;

    @Override
    public Question saveOrUpdate(Map<String, String> params, Livestream livsS, User user) {
        Date currentDate = new Date();
        
        Question q = new Question();
        q.setContent(params.get("content"));
        q.setDateSubmitted(currentDate);
        q.setLivestreamId(livsS);
        q.setUserId(user);
        
        this.qRepo.saveQuestionOrUpdate(q);
        return q;
    }

    @Override
    public List<Question> getListQuestionsByLivestreamId(Livestream livestream) {
        return this.qRepo.getListQuestionsByLivestreamId(livestream);
    }

    @Override
    public boolean deleteQuestion(int id) {
        return this.qRepo.deleteQuestion(id);
    }
    
}
