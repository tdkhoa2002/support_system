/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Article;
import java.util.List;
/**
 *
 * @author Khoa Tran
 */
public interface ArticleService {
    List<Article> getArticles();
    boolean addArticle(Article article);
    Article getArticleById(int id);
    boolean deleteArticle(int id);
}
