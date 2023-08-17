/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers.API;

import com.tdkhoa.pojo.Article;
import com.tdkhoa.services.ArticleService;
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
public class ApiArticleController {
    @Autowired
    private ArticleService articleService;
    
    @GetMapping("/articles/")
    @CrossOrigin
    public ResponseEntity<List<Article>> list() {
        return new ResponseEntity<>(this.articleService.getArticles(), HttpStatus.OK);
    }
    
    @GetMapping("/articles/category/{cate_id}") //Lay tin tuyen sinh theo hinh thuc tuyen sinh
    @CrossOrigin
    public ResponseEntity<List<Article>> getArticlesByCateId(@PathVariable(value = "cate_id") int cate_id) {
        List<Article> articles = articleService.getArticlesByCateId(cate_id);
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
    
    @GetMapping("/articles/faculty/{faculty_id}") //Lay tin tuyen sinh theo khoa
    @CrossOrigin
    public ResponseEntity<List<Article>> getArticlesByFacultyId(@PathVariable(value = "faculty_id") int faculty_id) {
        List<Article> faculties = articleService.getArticlesByFacultyId(faculty_id);
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }
    
    @PostMapping("/create_article/")
    @CrossOrigin
    public ResponseEntity<Boolean> add(@RequestBody Article article) {
        System.out.println("hi");
        System.out.println(article);
        return new ResponseEntity<>(this.articleService.addArticle(article), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete_article/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.articleService.deleteArticle(id);
    }
}
