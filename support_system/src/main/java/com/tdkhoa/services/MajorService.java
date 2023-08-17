/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Major;
import java.util.List;

/**
 *
 * @author Khoa Tran
 */
public interface MajorService {
    List<Major> getMajors();
    Major getMajorById(int major_id);
    boolean addOrUpdate(Major major);
    boolean deleteMajor(int major_id);
}
