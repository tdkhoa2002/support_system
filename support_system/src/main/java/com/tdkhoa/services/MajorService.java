/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.pojo.Major;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Khoa Tran
 */
public interface MajorService {
    List<Major> getMajors();
    Major getMajorById(int major_id);
    Major addOrUpdate(Map<String, String> params, Faculty f);
    boolean deleteMajor(int major_id);
}
