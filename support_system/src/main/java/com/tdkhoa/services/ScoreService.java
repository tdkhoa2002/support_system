/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Category;
import com.tdkhoa.pojo.Major;
import com.tdkhoa.pojo.Score;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Khoa Tran
 */
public interface ScoreService {
    List<Score> getScoresLast();
    Score saveOrUpdate(Map<String, String> params, Category cate, Major major);
    boolean deleteScore(int id);
}
