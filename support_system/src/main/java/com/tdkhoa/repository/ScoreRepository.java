/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.repository;

import com.tdkhoa.pojo.Category;
import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.pojo.Score;
import java.util.List;

/**
 *
 * @author Khoa Tran
 */
public interface ScoreRepository {
    List<Score> getScoresLast();
    Score getScoreById(int id);
    boolean addOrUpdate(Score score);
    boolean deleteScore(int id);
}
