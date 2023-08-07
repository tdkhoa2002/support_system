/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers;

import com.tdkhoa.pojo.Article;
import com.tdkhoa.pojo.Comment;
import com.tdkhoa.pojo.User;
import com.tdkhoa.services.ArticleService;
import com.tdkhoa.services.CommentService;
import com.tdkhoa.services.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Khoa Tran
 */
@Controller
public class CommentController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService cmtService;
    
    @PostMapping("/view_article/{article_id}/comment_article")
    public String addComment(@ModelAttribute Comment comment, @PathVariable(value = "article_id") int article_id, Authentication authenticate) throws ParseException {
        Article article = articleService.getArticleById(article_id);
        List<User> users = userService.getUsers(authenticate.getName());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat parseFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        
        comment.setDate(parseFormat.parse(dateFormat.format(date)));
        comment.setArticleId(article);
        comment.setUserId(users.get(0));
        
        this.cmtService.addOrUpdateComment(comment);
        return "redirect: /support_system/view_article/{article_id}";
    }
}
