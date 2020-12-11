/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.dao;

import com.ygame.yg05.ConstantsDatasource;
import com.ygame.yg05.entity_cometics.BlogPost;
import com.ygame.yg05.repository.BlogPostRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogPostDB implements BlogPostRepository{
    @Autowired(required = true)
    @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = ConstantsDatasource.JPA_UNIT_NAME_COMESTIC)
    EntityManager entityManager;
    
    @Override
    public BlogPost getBlogPostById(int id) {
        BlogPost blogPost = new BlogPost();
        try{
            String sql = "Select e from blogpost e where e.id = :id";
            Query query = entityManager.createQuery(sql);
            query.setParameter("id", id);
            List<BlogPost> lst = query.getResultList();
            if(lst.isEmpty() || lst == null || lst.size() == 1){
                blogPost = (BlogPost) query.getSingleResult();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return blogPost;
    }

    @Override
    public BlogPost getBlogPostByUser_Id(int post_by) {
        BlogPost blogPost = new BlogPost();
        try{
            entityManager.clear();
            String sql = "Select e from blogpost e where e.postby = :post_by";
            Query query = entityManager.createQuery(sql);
            query.setParameter("post_by", post_by);
            List<BlogPost> lst = query.getResultList();
            if(lst.isEmpty() || lst == null || lst.size() == 1){
                blogPost = (BlogPost) query.getSingleResult();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return blogPost;
    }

    @Override
    public List<BlogPost> getAllPostByCreateTime(int limit, int page) {
        List<BlogPost> lst = new ArrayList<>();
        try{
            String sql = "Select e from "+BlogPost.class.getName()+" e where status = 0 order by create_time desc";
            Query query = entityManager.createQuery(sql);
            query.setFirstResult(limit);
            query.setMaxResults(page);
            lst = query.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lst;
    }

    @Override
    public List<BlogPost> getAllPostByUser_Id(int post_by, int limit, int page) {
        List<BlogPost> lst = new ArrayList<>();
        try{
            String sql = "Select e from "+BlogPost.class.getName()+" e where e.post_by = :post_by order by create_time asc";
            Query query = entityManager.createQuery(sql);
            query.setParameter("post_by", post_by);
            lst = query.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lst;
    }

    @Override
    @Transactional(value = "cometicsTransactionManager")
    public void insertBlogPost(BlogPost blogpost) {
        try{
            String sql = "Insert into blogpost(title, description,url,post_by, create_time, img, avatar_user, username)"
                    + " values(:title,:description,:url,:post_by, :create_time,:img, :avatar_user, :username)";
            entityManager.createNativeQuery(sql).
                    setParameter("title", blogpost.getTitle()).
                    setParameter("description", blogpost.getDescription()).
                    setParameter("url", blogpost.getUrl()).
                    setParameter("post_by", blogpost.getPost_by()).
                    setParameter("create_time", blogpost.getCreate_date()).
                    setParameter("img", blogpost.getImg()).
                    setParameter("avatar_user", blogpost.getAvatar_user()).
                    setParameter("username", blogpost.getUsername()).
                    executeUpdate();
        }catch(NoResultException ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void deleteBlogPost(BlogPost blogpost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateBlogPostById(BlogPost blogpost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public long totalBlogPostAll() {
        long total  = 0;
        try{
            String sql = "SELECT COUNT(e.id) FROM "+BlogPost.class.getName()+" e";
            Query query = entityManager.createQuery(sql);
            List<Integer> lst = query.getResultList();
            if(lst.isEmpty() || lst == null || lst.size() == 1){
                total = (Long) query.getSingleResult();
            }
        }catch(NoResultException ex){
            ex.printStackTrace();
        }
        return total;
    }

    @Override
    public long totalBlogPostByUser(int id) {
        long total  = 0;
        try{
            String sql = "SELECT COUNT(e.id) FROM "+BlogPost.class.getName()+" e WHERE post_by = :id";
            Query query = entityManager.createQuery(sql);
            query.setParameter("id", id);
            List<Integer> lst = query.getResultList();
            if(lst.isEmpty() || lst == null || lst.size() == 1){
                total = (Long) query.getSingleResult();
            }
        }catch(NoResultException ex){
            ex.printStackTrace();
        }
        return total;
    }
    
}
