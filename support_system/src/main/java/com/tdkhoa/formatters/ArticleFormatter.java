/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.formatters;

import com.tdkhoa.pojo.Article;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Khoa Tran
 */
public class ArticleFormatter implements Formatter<Article>{

    @Override
    public String print(Article article, Locale locale) {
        return String.valueOf(article.getId());
    }

    @Override
    public Article parse(String articleId, Locale locale) throws ParseException {
        return new Article(Integer.parseInt(articleId));
    }
    
}
