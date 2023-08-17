/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tdkhoa.pojo.Article;
import com.tdkhoa.services.ArticleService;
import com.tdkhoa.repository.ArticleRepository;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addArticle(Article article) {
//        if (!article.getFile().isEmpty()) {
//            try {
//                Map res = this.cloudinary.uploader().upload(article.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//                article.setThumbnail(res.get("secure_url").toString());
//            } catch (IOException ex) {
//                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
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

    @Override
    public List<Article> getArticlesByCateId(int id) {
        return this.articleRepository.getArticlesByCateId(id);
    }

    @Override
    public List<Article> getArticlesByFacultyId(int id) {
        return this.articleRepository.getArticlesByFacultyId(id);
    }
}
