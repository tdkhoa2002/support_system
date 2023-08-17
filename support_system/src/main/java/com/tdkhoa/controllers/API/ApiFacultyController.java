/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers.API;

import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.services.FacultyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ApiFacultyController {
    @Autowired
    private FacultyService facultyServ;
    
    @GetMapping("/faculties/")
    @CrossOrigin
    public ResponseEntity<List<Faculty>> list() {
        return new ResponseEntity<>(this.facultyServ.getFaculties(), HttpStatus.OK);
    }
    
    @PostMapping("/create_faculty/")
    @CrossOrigin
    public ResponseEntity<Boolean> add(@RequestBody Faculty f) {
        return new ResponseEntity<>(this.facultyServ.addFaculty(f), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete_faculty/{faculty_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "faculty_id") int faculty_id) {
        this.facultyServ.deleteFaculty(faculty_id);
    }
}
