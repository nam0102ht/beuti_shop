/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.repository;

import com.ygame.yg05.entity_cometics.Article;
import java.util.List;


public interface ArticleRepository {
    void insertArticle(Article art);
    List<Article> getAllListArticle(int start, int size);
    Article getArticleById(int id);
    void updateArticle(Article art);
    long countArticle();
}
