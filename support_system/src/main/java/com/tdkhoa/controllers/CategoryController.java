/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers;

import com.tdkhoa.pojo.Category;
import com.tdkhoa.pojo.User;
import com.tdkhoa.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Khoa Tran
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryService cateService;
    
    @GetMapping("admin/categories")
    public String index(Model model) {
        model.addAttribute("categories", cateService.getCategories());
        return "category/index_category";
    }
    
    @GetMapping("/admin/create_category")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/create_category";
    }
    
    @PostMapping("/admin/create_category")
    public String save(@ModelAttribute Category category, BindingResult rs) {
        cateService.addOrUpdateCategory(category);
        return "index";
    }
    
}
