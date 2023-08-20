/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Faculty;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Khoa Tran
 */
public interface FacultyService {
    Faculty addFaculty(Map<String, String> params, MultipartFile image);
    List<Faculty> getFaculties();
    Faculty getFacultyById(int id);
    boolean deleteFaculty(int id);
}
