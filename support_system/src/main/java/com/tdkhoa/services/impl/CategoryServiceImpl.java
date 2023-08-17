/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services.impl;

import com.tdkhoa.pojo.Category;
import com.tdkhoa.repository.CategoryRepository;
import com.tdkhoa.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khoa Tran
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository cateRepo;
    

    @Override
    public Category addOrUpdateCategory(Category cate) {
        return this.cateRepo.addOrUpdateCategory(cate);
    }

    @Override
    public List<Category> getCategories() {
        return this.cateRepo.getCategories();
    }

    @Override
    public Category getCategoryById(int id) {
        return this.cateRepo.getCategoryById(id);
    }

    @Override
    public boolean deleteCategory(int id) {
        return this.cateRepo.deleteCategory(id);
    }
    
}
