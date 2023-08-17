/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services.impl;

import com.tdkhoa.pojo.Major;
import com.tdkhoa.repository.MajorRepository;
import com.tdkhoa.services.MajorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khoa Tran
 */
@Service
public class MajorServiceImpl implements MajorService {
    @Autowired MajorRepository mjRepo;

    @Override
    public List<Major> getMajors() {
        return this.mjRepo.getMajors();
    }

    @Override
    public Major getMajorById(int major_id) {
        return this.mjRepo.getMajorById(major_id);
    }

    @Override
    public boolean addOrUpdate(Major major) {
        return this.mjRepo.addOrUpdate(major);
    }

    @Override
    public boolean deleteMajor(int major_id) {
        return this.mjRepo.deleteMajor(major_id);
    }
    
}
