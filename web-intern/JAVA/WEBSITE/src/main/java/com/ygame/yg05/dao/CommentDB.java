package com.ygame.yg05.dao;

import com.ygame.yg05.ConstantsDatasource;
import com.ygame.yg05.entity_cometics.Comment;
import com.ygame.yg05.repository.CommentRepository;
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
public class CommentDB implements CommentRepository{
    @Autowired(required = true)
    @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = ConstantsDatasource.JPA_UNIT_NAME_COMESTIC)
    EntityManager entityManager;
    
    @Override
    @Transactional(value ="cometicsTransactionManager")
    public void insertComment(Comment comm) {
        try{
            entityManager.clear();
            String sql = "Insert into comments(comment_content,user_name, user_id, blog_id, create_date, avatar_img)"
                    + " values(:content,:username, :userid, :blog_id, :createdate, :avatarimg)";
            entityManager.createNativeQuery(sql).
                    setParameter("content", comm.getComment_content()).
                    setParameter("userid", comm.getUser_id()).
                    setParameter("blog_id", comm.getBlog_id()).
                    setParameter("username", comm.getUser_name()).
                    setParameter("createdate", comm.getCreate_date()).
                    setParameter("avatarimg", comm.getAvatar_img()).
                    executeUpdate();
        }catch(NoResultException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Comment> getListCommentById_Post(int idPost, int start, int size) {
        List<Comment> lst = new ArrayList<>();
        try{
            String sql = "SELECT e FROM "+Comment.class.getName()+" e WHERE e.blog_id = :idPost ORDER BY create_date desc";
            Query query = entityManager.createQuery(sql);
            query.setParameter("idPost", idPost);
            query.setMaxResults(size);
            query.setFirstResult(start);
            lst = query.getResultList();
        }catch(NoResultException ex){
            ex.printStackTrace();
        }
        return lst;
    }

    @Override
    public long totalRecordCommentPerBlog(int idPost) {
        int total  = 0;
        try{
            String sql = "Select count(e) from "+Comment.class.getName()+" e where e.blog_id = :id";
            Query query = entityManager.createQuery(sql);
            query.setParameter("id", idPost);
            List<Integer> lst = query.getResultList();
            if(lst.isEmpty() || lst == null || lst.size() == 1){
                total = (int) Long.parseLong(query.getSingleResult()+"");
            }
        }catch(NoResultException ex){
            ex.printStackTrace();
        }
        return total;
    }
    
}
