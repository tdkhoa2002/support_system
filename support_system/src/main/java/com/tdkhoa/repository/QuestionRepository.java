/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.repository;

import com.tdkhoa.pojo.Livestream;
import com.tdkhoa.pojo.Question;
import java.util.List;

/**
 *
 * @author Khoa Tran
 */
public interface QuestionRepository {
    List<Question> getListQuestionsByLivestreamId(Livestream livestream);
    Question getQuestionById(int id);
    boolean saveQuestionOrUpdate(Question question);
    boolean deleteQuestion(int id);
}
