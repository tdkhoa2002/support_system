/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers.API;

import com.tdkhoa.pojo.Comment;
import com.tdkhoa.services.CommentService;
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
public class ApiCommentController {
    @Autowired
    private CommentService cmtService;
    
    @GetMapping("/comments/article/{article_id}/")
    @CrossOrigin
    public ResponseEntity<List<Comment>> getCommentsOfArticle(@PathVariable(value = "article_id") int article_id) {
        return new ResponseEntity<>(this.cmtService.getCommentsByArticleId(article_id), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete_comment/{comment_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "comment_id") int comment_id) {
        System.out.println("Xoa");
        this.cmtService.deleteConment(comment_id);
    }
}
