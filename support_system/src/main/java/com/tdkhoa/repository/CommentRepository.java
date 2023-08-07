/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.repository;

import com.tdkhoa.pojo.Comment;
import java.util.List;

/**
 *
 * @author Khoa Tran
 */
public interface CommentRepository {
    List<Comment> getCommentsByArticleId(int id);
    boolean addOrUpdateComment(Comment comment);
    Comment getConmmentById(int id);
    boolean deleteComment(int id);
}
