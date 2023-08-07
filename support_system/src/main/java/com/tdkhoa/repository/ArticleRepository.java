/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.repository;

import com.tdkhoa.pojo.Article;
import java.util.List;

/**
 *
 * @author Khoa Tran
 */
public interface ArticleRepository {
    List<Article> getArticles();
    boolean addArticle(Article article);
    Article getArticleById(int id);
    boolean deleteArticle(int id);
}
