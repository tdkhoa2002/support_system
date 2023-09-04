/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Livestream;
import com.tdkhoa.pojo.Question;
import com.tdkhoa.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Khoa Tran
 */
public interface QuestionService {
    Question saveOrUpdate(Map<String, String> params, Livestream livsS, User user);
    List<Question> getListQuestionsByLivestreamId(Livestream livestream);
    boolean deleteQuestion(int id);
}
