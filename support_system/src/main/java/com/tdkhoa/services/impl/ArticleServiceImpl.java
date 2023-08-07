/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services.impl;

import com.tdkhoa.pojo.Article;
import com.tdkhoa.services.ArticleService;
import com.tdkhoa.repository.ArticleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khoa Tran
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public boolean addArticle(Article article) {
        return articleRepository.addArticle(article);
    }

    @Override
    public List<Article> getArticles() {
        return this.articleRepository.getArticles();
    }

    @Override
    public Article getArticleById(int id) {
        return this.articleRepository.getArticleById(id);
    }

    @Override
    public boolean deleteArticle(int id) {
        return this.articleRepository.deleteArticle(id);
    }
}
