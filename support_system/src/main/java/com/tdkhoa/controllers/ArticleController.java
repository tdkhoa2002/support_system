/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.tdkhoa.services.ArticleService;
import javax.servlet.http.HttpSession;
import com.tdkhoa.pojo.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Khoa Tran
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    
    @RequestMapping(value = "/create_article", method = RequestMethod.GET)
    public String article(Model model) {
        model.addAttribute("article", new Article());
        return "article/create_article";
    }
    
    @RequestMapping(value = "/create_article", method = RequestMethod.POST)
    public String addArticle(Model model, @ModelAttribute("article") Article article, BindingResult result) {
//        articleService.addArticle(article);
        if(result.hasErrors()) {
            return "error";
        }
        System.out.println("Noi dung: " + article.getContent());
        return "index";
    }
}
