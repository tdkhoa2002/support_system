/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers.API;

import com.tdkhoa.pojo.Livestream;
import com.tdkhoa.pojo.Question;
import com.tdkhoa.services.LiveStreamService;
import com.tdkhoa.services.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Khoa Tran
 */
@RestController
@RequestMapping("/api")
public class ApiQuestionController {
//    @Autowired
//    private QuestionService questionServ;
//    @Autowired
//    private LiveStreamService liveServ;
    
//    @GetMapping("/questions/livestream/{livestream_id}/")
//    @CrossOrigin
//    public ResponseEntity<List<Question>> getCommentsOfArticle(@PathVariable(value = "livestream_id") int livestream_id) {
//        Livestream live = liveServ.getLivestreamById(livestream_id);
//        return new ResponseEntity<>(this.questionServ.getListQuestionsByLivestreamId(live), HttpStatus.OK);
//    }
//    
//    @DeleteMapping("/delete_question/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable(value = "id") int id) {
//        this.questionServ.deleteQuestion(id);
//    }
}
