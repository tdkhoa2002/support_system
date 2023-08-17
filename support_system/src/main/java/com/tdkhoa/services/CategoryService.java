/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Category;
import java.util.List;

/**
 *
 * @author Khoa Tran
 */
public interface CategoryService {
    Category addOrUpdateCategory(Category cate);
    List<Category> getCategories();
    Category getCategoryById(int id);
    boolean deleteCategory(int id);
}
