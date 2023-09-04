/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers.API;

import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.pojo.Livestream;
import com.tdkhoa.pojo.Question;
import com.tdkhoa.pojo.User;
import com.tdkhoa.services.LiveStreamService;
import com.tdkhoa.services.QuestionService;
import com.tdkhoa.services.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Khoa Tran
 */
@RestController
@RequestMapping("/api")
public class ApiQuestionController {
    @Autowired
    private QuestionService questionServ;
    @Autowired
    private LiveStreamService liveServ;
    @Autowired
    private UserService uServ;
    
    @GetMapping("/questions/livestream/{livestream_id}/")
    @CrossOrigin
    public ResponseEntity<List<Question>> getCommentsOfArticle(@PathVariable(value = "livestream_id") int livestream_id) {
        Livestream live = liveServ.getLivestreamById(livestream_id);
        return new ResponseEntity<>(this.questionServ.getListQuestionsByLivestreamId(live), HttpStatus.OK);
    }
    
     @PostMapping("/questions/send_question/")
    @CrossOrigin
    public ResponseEntity<Question> add(@RequestParam Map<String, String> params) throws ParseException {
        int liveId = Integer.parseInt(params.get("livestreamId"));
        Livestream liveStream = liveServ.getLivestreamById(liveId);
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = this.uServ.findUserByUsername(userDetails.getUsername());
        
        Question q = this.questionServ.saveOrUpdate(params, liveStream, currentUser);
        return new ResponseEntity<>(q, HttpStatus.CREATED);
    }
   
    @DeleteMapping("/delete_question/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.questionServ.deleteQuestion(id);
    }
}
