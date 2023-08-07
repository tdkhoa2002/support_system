/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.formatters;

import com.tdkhoa.pojo.Faculty;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Khoa Tran
 */
public class FacultyFormatter implements Formatter<Faculty>{

    @Override
    public String print(Faculty f, Locale locale) {
        return String.valueOf(f.getId());
    }

    @Override
    public Faculty parse(String facultyId, Locale locale) throws ParseException {
        return new Faculty(Integer.parseInt(facultyId));
    }
    
}
