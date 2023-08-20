/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Article;
import com.tdkhoa.pojo.Category;
import com.tdkhoa.pojo.Faculty;
import com.tdkhoa.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author Khoa Tran
 */
public interface ArticleService {
    List<Article> getArticles();
    List<Article> getArticlesByCateId(int id);
    List<Article> getArticlesByFacultyId(int id);
    Article addArticle(Map<String, String> params, MultipartFile thumbnail, User user, Faculty fal, Category cate);
    Article getArticleById(int id);
    boolean deleteArticle(int id);
}
