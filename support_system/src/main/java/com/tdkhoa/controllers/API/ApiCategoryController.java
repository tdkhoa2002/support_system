/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.controllers.API;

import com.tdkhoa.pojo.Article;
import com.tdkhoa.pojo.Category;
import com.tdkhoa.services.ArticleService;
import com.tdkhoa.services.CategoryService;
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
public class ApiCategoryController {

    @Autowired
    private CategoryService cateServ;
    @Autowired
    private ArticleService aServ;

    @GetMapping("/categories/")
    @CrossOrigin
    public ResponseEntity<List<Category>> list() {
        return new ResponseEntity<>(this.cateServ.getCategories(), HttpStatus.OK);
    }

    @PostMapping("/create_category/")
    @CrossOrigin
    public ResponseEntity<Category> add(@RequestBody Category c) {
        return new ResponseEntity<>(this.cateServ.addOrUpdateCategory(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_category/{cate_id}/")
    @CrossOrigin
    public ResponseEntity<String> add(@PathVariable(value = "cate_id") int cate_id) {
        
        List<Article> articles = aServ.getArticlesByCateId(cate_id);
        for(Article a: articles) {
            this.aServ.deleteArticle(a.getId());
        }
        
        boolean deleted = this.cateServ.deleteCategory(cate_id);
        if (deleted) {
            return ResponseEntity.ok("Đã xóa danh mục thành công");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy danh mục để xóa");
        }
    }
}
