/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers.API;

import com.tdkhoa.pojo.Article;
import com.tdkhoa.pojo.Category;
import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.pojo.User;
import com.tdkhoa.services.ArticleService;
import com.tdkhoa.services.CategoryService;
import com.tdkhoa.services.FacultyService;
import com.tdkhoa.services.UserService;
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
public class ApiArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private FacultyService falService;
    @Autowired
    private CategoryService cateServ;
    @Autowired
    private UserService uServ;
    
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
    public ResponseEntity<Article> add(@RequestParam Map<String, String> params, @RequestPart MultipartFile thumbnail) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = this.uServ.findUserByUsername(userDetails.getUsername());
        
        int facultyId = Integer.parseInt(params.get("facultyId"));
        Faculty fal = this.falService.getFacultyById(facultyId);
        
        int cateId = Integer.parseInt(params.get("cateId"));
        Category cate = this.cateServ.getCategoryById(cateId);
        
        Article article = this.articleService.addArticle(params, thumbnail, currentUser, fal, cate);
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete_article/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.articleService.deleteArticle(id);
    }
}
