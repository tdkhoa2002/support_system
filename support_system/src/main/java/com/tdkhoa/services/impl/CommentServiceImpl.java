/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdkhoa.services.impl;

import com.tdkhoa.pojo.Comment;
import com.tdkhoa.repository.CommentRepository;
import com.tdkhoa.services.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Khoa Tran
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository cmtRepo;

    @Override
    public boolean addOrUpdateComment(Comment comment) {
        return this.cmtRepo.addOrUpdateComment(comment);
    }

    @Override
    public List<Comment> getCommentsByArticleId(int id) {
        return cmtRepo.getCommentsByArticleId(id);
    }

    @Override
    public Comment getCommentById(int id) {
        return cmtRepo.getConmmentById(id);
    }

    @Override
    public boolean deleteConment(int id) {
        return this.cmtRepo.deleteComment(id);
    }
    
}
