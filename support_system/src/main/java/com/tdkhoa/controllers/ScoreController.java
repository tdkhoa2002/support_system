/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers;

import com.tdkhoa.pojo.Category;
import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.pojo.Score;
import com.tdkhoa.services.CategoryService;
import com.tdkhoa.services.FacultyService;
import com.tdkhoa.services.ScoreService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Khoa Tran
 */
@Controller
public class ScoreController {

    @Autowired
    private FacultyService fctServ;
    @Autowired
    private CategoryService cateServ;
    @Autowired
    private ScoreService scServ;

    @GetMapping("/admin/scores")
    public String index(Model model) {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        List<Category> categories = cateServ.getCategories();
        List<Faculty> faculties = fctServ.getFaculties();
        model.addAttribute("faculties", faculties);
        model.addAttribute("categories", categories);
        model.addAttribute("scores", scServ.getScoresLast());
        model.addAttribute("yearNow", currentYear);
        System.out.println("Scores: " + scServ.getScoresLast());
        //for cate 
            //for faculty
                //nap scores vo
        
        return "score/index";
    }

    @GetMapping("/admin/create_score")
    public String create(Model model) {
        model.addAttribute("categories", cateServ.getCategories());
        model.addAttribute("faculties", fctServ.getFaculties());
        model.addAttribute("score", new Score());

        return "score/create";
    }

    @PostMapping("admin/create_score")
    public String save(@ModelAttribute("score") Score score, @RequestParam int yearPicked) throws ParseException {
        this.scServ.saveOrUpdate(score, yearPicked);
        return "redirect: /support_system/admin/scores";
    }
}
