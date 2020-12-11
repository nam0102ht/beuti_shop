/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.dao;

import com.ygame.yg05.ConstantsDatasource;
import com.ygame.yg05.entity_cometics.Article;
import com.ygame.yg05.repository.ArticleRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ArticleDB implements ArticleRepository{
    @Autowired(required = true)
    @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = ConstantsDatasource.JPA_UNIT_NAME_COMESTIC)
    EntityManager entityManager;
    
    @Override
    @Transactional(value = "cometicsTransactionManager")
    public void insertArticle(Article art) {
        try{
            entityManager.clear();
            String sql = "Insert into article(page_title, content, status, creator_id, img, create_date) "
                    + "values(:page_title, :content, :status, :creator_id. :img, :create_date) ";
            entityManager.createNativeQuery(sql).
                    setParameter("page_title", art.getPage_title()).
                    setParameter("content", art.getContent()).
                    setParameter("status", art.getStatus()).
                    setParameter("creator_id", art.getCreator_id()).
                    setParameter("img", art.getImg()).
                    setParameter("create_date", art.getCreate_date()).
                    executeUpdate();
        }catch(NoResultException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Article> getAllListArticle(int start, int size) {
        List<Article> lst = new ArrayList<>();
        try{
            entityManager.clear();
            String sql = "Select e from "+Article.class.getName()+" e order by create_date desc";
            Query query = entityManager.createQuery(sql);
            query.setFirstResult(start);
            query.setMaxResults(size);
            lst = query.getResultList();
        }catch(NoResultException ex){
           ex.printStackTrace();
        }
        return lst;
    }

    @Override
    public Article getArticleById(int id) {
        Article art = new Article();
        try{
            entityManager.clear();
            String sql = "Select e from "+Article.class.getName()+" e where id_article = :id";
            Query query = entityManager.createQuery(sql);
            query.setParameter("id", id);
            List<Article> lst = query.getResultList();
            if(lst.size() < 2 || lst == null || lst.isEmpty()){
                art = (Article) query.getSingleResult();
            }
        }catch(NoResultException ex){
           ex.printStackTrace();
        }
        return art;
    
    }

    @Override
    public void updateArticle(Article art) {
        
    }

    @Override
    public long countArticle() {
        long result = 0;
        try{
            entityManager.clear();
            String sql = "Select count(e) from "+Article.class.getName()+" e";
            Query query = entityManager.createQuery(sql);
            List<Long> lst = query.getResultList();
            if(lst.size() < 2 || lst == null || lst.isEmpty()){
                result = (long) query.getSingleResult();
            }
        }catch(NoResultException ex){
           ex.printStackTrace();
        }
        return result;
    }
    
}
