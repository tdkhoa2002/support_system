/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Livestream;
import com.tdkhoa.pojo.Question;
import java.util.List;

/**
 *
 * @author Khoa Tran
 */
public interface QuestionService {
    boolean saveOrUpdate(Question question);
    List<Question> getListQuestionsByLivestreamId(Livestream livestream);
    boolean deleteQuestion(int id);
}
