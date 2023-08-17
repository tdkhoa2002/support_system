/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.repository;

import com.tdkhoa.pojo.Faculty;
import java.util.List;

/**
 *
 * @author Khoa Tran
 */
public interface FacultyRepository {
    boolean addFaculty(Faculty faculty);
    Faculty getFacultyById(int id);
    List<Faculty> getFaculties();
    boolean deleteFaculty(int id);
}
