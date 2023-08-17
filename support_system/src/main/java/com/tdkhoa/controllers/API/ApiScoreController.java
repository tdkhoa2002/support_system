/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers.API;

import com.tdkhoa.pojo.Score;
import com.tdkhoa.services.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/scores/")
    @CrossOrigin
    public ResponseEntity<List<Score>> list() {
        return new ResponseEntity<>(this.scServ.getScoresLast(), HttpStatus.OK);
    }
    
    @PostMapping("/create_score/")
    @CrossOrigin
    public ResponseEntity<Boolean> add(@RequestBody Score s) {
        return new ResponseEntity<>(this.scServ.saveOrUpdate(s), HttpStatus.CREATED);
    }
}
