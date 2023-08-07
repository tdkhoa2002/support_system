/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdkhoa.services;

import com.tdkhoa.pojo.Comment;
import java.util.List;

/**
 *
 * @author Khoa Tran
 */
public interface CommentService {
    boolean addOrUpdateComment(Comment comment);
    List<Comment> getCommentsByArticleId(int id);
    Comment getCommentById(int id);
    boolean deleteConment(int id);
}
