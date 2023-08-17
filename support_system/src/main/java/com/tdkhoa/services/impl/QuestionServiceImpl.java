/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services.impl;

import com.tdkhoa.pojo.Livestream;
import com.tdkhoa.pojo.Question;
import com.tdkhoa.repository.QuestionRepository;
import com.tdkhoa.services.QuestionService;
import java.util.List;
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
    public boolean saveOrUpdate(Question question) {
        return this.qRepo.saveQuestionOrUpdate(question);
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
