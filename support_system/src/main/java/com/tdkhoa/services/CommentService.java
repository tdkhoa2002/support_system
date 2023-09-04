/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Article;
import com.tdkhoa.pojo.Comment;
import com.tdkhoa.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Khoa Tran
 */
public interface CommentService {
    Comment addOrUpdateComment(Map<String, String> params, Article article, User user);
    List<Comment> getCommentsByArticleId(int id);
    Comment getCommentById(int id);
    boolean deleteConment(int id);
}
