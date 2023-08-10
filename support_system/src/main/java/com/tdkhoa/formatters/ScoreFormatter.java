/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.formatters;

import com.tdkhoa.pojo.Score;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Khoa Tran
 */
public class ScoreFormatter implements Formatter<Score>{

    @Override
    public String print(Score score, Locale locale) {
        return String.valueOf(score.getId());
    }

    @Override
    public Score parse(String scoreId, Locale locale) throws ParseException {
        return new Score(Integer.parseInt(scoreId));
    }
    
}
