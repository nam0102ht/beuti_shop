/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.repository;

import com.ygame.yg05.entity_cometics.BlogPost;
import java.util.List;

/**
 *
 * @author Nam
 */
public interface BlogPostRepository {
    BlogPost getBlogPostById(int id);
    BlogPost getBlogPostByUser_Id(int post_by);
    List<BlogPost> getAllPostByCreateTime(int limit, int page);
    List<BlogPost> getAllPostByUser_Id(int post_by, int limit, int page);
    void insertBlogPost(BlogPost blogpost);
    void deleteBlogPost(BlogPost blogpost);
    void updateBlogPostById(BlogPost blogpost);
    long totalBlogPostAll();
    long totalBlogPostByUser(int id);
}
