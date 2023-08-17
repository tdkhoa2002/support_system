/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.repository;

import com.tdkhoa.pojo.Major;
import java.util.List;

/**
 *
 * @author Khoa Tran
 */
public interface MajorRepository {
    List<Major> getMajors();
    Major getMajorById(int major_id);
    boolean addOrUpdate(Major major);
    boolean deleteMajor(int major_id);
}
