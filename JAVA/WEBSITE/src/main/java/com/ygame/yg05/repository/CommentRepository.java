/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.repository;

import com.ygame.yg05.entity_cometics.Comment;
import java.util.List;


public interface CommentRepository {
    void insertComment(Comment comm);
    List<Comment> getListCommentById_Post(int idPost, int start, int size);
    long totalRecordCommentPerBlog(int idPost);
    
}
