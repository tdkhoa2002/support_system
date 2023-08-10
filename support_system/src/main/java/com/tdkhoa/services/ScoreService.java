/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Score;
import java.util.List;

/**
 *
 * @author Khoa Tran
 */
public interface ScoreService {
    List<Score> getScoresLast();
    boolean saveOrUpdate(Score score, int yearPicked);
}
