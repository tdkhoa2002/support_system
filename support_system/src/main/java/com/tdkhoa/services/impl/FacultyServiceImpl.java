/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services.impl;

import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.repository.FacultyRepository;
import com.tdkhoa.services.FacultyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khoa Tran
 */
@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepo;

    @Override
    public boolean addFaculty(Faculty faculty) {
        return this.facultyRepo.addFaculty(faculty);
    }

    @Override
    public List<Faculty> getFaculties() {
        return this.facultyRepo.getFaculties();
    }
    
}
