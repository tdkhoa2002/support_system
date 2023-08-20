/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers;

import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.services.FacultyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Khoa Tran
 */
@Controller
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    
    @GetMapping("/admin/faculties")
    public String index(Model model) {
        List<Faculty> faculties = this.facultyService.getFaculties();
        model.addAttribute("faculties", faculties);
        return "faculty/index_faculty";
    }
    
    @GetMapping("/admin/create_faculty")
    public String create(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "faculty/create_faculty";
    }
    
    @GetMapping("/admin/edit_faculty/{faculty_id}")
    public String edit(Model model, @PathVariable(value = "faculty_id") int faculty_id) {
        model.addAttribute("faculty", this.facultyService.getFacultyById(faculty_id));
        return "faculty/create_faculty";
    }
    
//    @PostMapping("/admin/create_faculty")
//    public String create(@ModelAttribute Faculty faculty) {
//        facultyService.addFaculty(faculty);
//        //https://www.youtube.com/watch?v=6F6RGmVvfdM
//        return "redirect: /support_system/admin/faculties";
//    }
}
