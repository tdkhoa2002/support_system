/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers.API;

import com.tdkhoa.pojo.Major;
import com.tdkhoa.services.MajorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Khoa Tran
 */
@RestController
@RequestMapping("/api")
public class ApiMajorController {
    @Autowired MajorService mjServ;
    
    @GetMapping("/majors/")
    @CrossOrigin
    public ResponseEntity<List<Major>> list() {
        return new ResponseEntity<>(this.mjServ.getMajors(), HttpStatus.OK);
    }
    
    @PostMapping("/create_major/")
    @CrossOrigin
    public ResponseEntity<Boolean> add(@RequestBody Major m) {
        return new ResponseEntity<>(this.mjServ.addOrUpdate(m), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete_major/{major_id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "major_id") int major_id) {
        this.mjServ.deleteMajor(major_id);
    }
}
