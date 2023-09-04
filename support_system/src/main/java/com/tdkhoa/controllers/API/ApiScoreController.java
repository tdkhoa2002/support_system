/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers.API;

import com.tdkhoa.pojo.Category;
import com.tdkhoa.pojo.Major;
import com.tdkhoa.pojo.Score;
import com.tdkhoa.services.CategoryService;
import com.tdkhoa.services.MajorService;
import com.tdkhoa.services.ScoreService;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Khoa Tran
 */
@RestController
@RequestMapping("/api")
public class ApiScoreController {

    @Autowired
    private ScoreService scServ;
    @Autowired
    private CategoryService cateServ;
    @Autowired
    private MajorService mServ;
    
    @GetMapping("/scores/")
    @CrossOrigin
    public ResponseEntity<List<Score>> list() {
        return new ResponseEntity<>(this.scServ.getScoresLast(), HttpStatus.OK);
    }
    
    @PostMapping("/create_score/")
    @CrossOrigin
    public ResponseEntity<Score> add(@RequestParam Map<String, String> params) {
        
        int cateId = Integer.parseInt(params.get("categoryId"));
        Category cate = cateServ.getCategoryById(cateId);
        
        int majorId = Integer.parseInt(params.get("majorId"));
        Major m = mServ.getMajorById(majorId);
        
        Score s = this.scServ.saveOrUpdate(params, cate, m);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete_score/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.scServ.deleteScore(id);
    }
}
