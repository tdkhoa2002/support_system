/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.tdkhoa.services.ArticleService;
import com.tdkhoa.pojo.Article;
import com.tdkhoa.pojo.Category;
import com.tdkhoa.pojo.Comment;
import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.pojo.User;
import com.tdkhoa.services.CategoryService;
import com.tdkhoa.services.CommentService;
import com.tdkhoa.services.FacultyService;
import com.tdkhoa.services.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Khoa Tran
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService cmtService;
    @Autowired
    private HttpSession s;
    
    @GetMapping("/admin/articles")
    public String index(Model model) {
        List<Article> articles = articleService.getArticles();
        model.addAttribute("articles", articles);
        return "article/index_article";
    }
    
    @GetMapping("/view_article/{id}")
    public String view(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("article", this.articleService.getArticleById(id));
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", this.cmtService.getCommentsByArticleId(id));
        return "article/view_article";
    }

    @GetMapping("/admin/create_article")
    public String create(Model model) {
        
        List<Faculty> faculties = facultyService.getFaculties();
        model.addAttribute("faculties", faculties);
        
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        
        model.addAttribute("article", new Article());
        return "article/create_article";
    }
    
    @GetMapping("/admin/edit_article/{articleId}")
    public String edit(Model model, @PathVariable(value = "articleId") int articleId) {
        
        List<Faculty> faculties = facultyService.getFaculties();
        model.addAttribute("faculties", faculties);
        
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("article", this.articleService.getArticleById(articleId));
        return "article/create_article";
    }

    @PostMapping("/admin/create_article")
    public String add(@ModelAttribute("article") Article article, BindingResult result, Authentication authentication) throws ParseException {
        List<User> users = userService.getUsers(authentication.getName());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat parseFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Date date = new Date();
        
        article.setDate(parseFormat.parse(dateFormat.format(date)));
        article.setUserId(users.get(0));
        
        articleService.addArticle(article);
        return "redirect: /support_system/admin/articles";
    }
}
