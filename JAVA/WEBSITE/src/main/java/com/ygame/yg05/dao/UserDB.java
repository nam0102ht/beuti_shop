/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.dao;

import com.ygame.yg05.ConstantsDatasource;
import com.ygame.yg05.entity_cometics.User;
import com.ygame.yg05.repository.UserRepository;
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
public class UserDB implements UserRepository{
    @Autowired(required = true)
    @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = ConstantsDatasource.JPA_UNIT_NAME_COMESTIC)
    EntityManager entityManager;
    

    @Override
    public User findUserById(int id) {
        User user = new User();
        try{
            entityManager.clear();
            String sql = "Select e from "+User.class.getName()+" e where id_user = :id";
            Query query = entityManager.createQuery(sql);
            query.setParameter("id", id);
            List<?> lst = query.getResultList();
            if(lst.isEmpty() || lst == null || lst.size() == 1){
                user = (User) query.getSingleResult();
            }
        }catch(NoResultException ex){
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public User findUserByUsernamePassword(String username, String Password) {
        User user = new User();
        try{
            entityManager.clear();
            String sql = "Select e "
                    + " from "+User.class.getName()+" e where e.username =:id and password=:pass";
            Query query = entityManager.createQuery(sql);
            query.setParameter("id", username);
            query.setParameter("pass", Password);
            List<User> lst = query.getResultList();
            if(lst.isEmpty() || lst == null || lst.size() == 1)
                user = (User) query.getSingleResult();
        }
        catch(NoResultException ex){
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    @Transactional(value = "comesticTransactionManager")
    public void updateUser(User user) {
        try{
            entityManager.clear();
            String sql = "Insert into user(username, password,token_user,email,phone, auth_key, first_name, last_name, create_date, active, gender, dateofbirth, reset_token_user, avartar_img)"
                    + " values(:username, :password,:token_user,:email, :phone, :auth_key,:first_name, :lastname, :createdate, :active, :gender, :dateofbirth, :resettokenuser, :avatarimg )";
            entityManager.createNativeQuery(sql).
                    setParameter("username", user.getUsername()).
                    setParameter("password", user.getPassword()).
                    setParameter("token_user", user.getToken_user()).
                    setParameter("email", user.getEmail()).
                    setParameter("phone", user.getPhone()).
                    setParameter("auth_key", user.getAuth_key()).
                    setParameter("first_name", user.getFirst_name()).
                    setParameter("lastname", user.getLast_name()).
                    setParameter("createdate", user.getCreate_date()).
                    setParameter("active", user.getActive()).
                    setParameter("gender", user.getGender()).
                    setParameter("dateofbirth", user.getDateofbirth()).
                    setParameter("resettokenuser", user.getReset_token_user()).
                    setParameter("avatarimg", user.getAvartar_img()).
                    executeUpdate();
        }catch(NoResultException ex){
            ex.printStackTrace();
        }
    }
    @Override
    @Transactional(value = "comesticTransactionManager")
    public void updateInfo(User user) {
        try{
            entityManager.clear();
            String sql = "UPDATE user set first_name = :firstname, last_name = :lastname, gender = :gender, email= :email, dateofbirth = :dateofbirth "
                    + "where id_user = :id_user";
            entityManager.createNativeQuery(sql).
                    setParameter("firstname", user.getFirst_name()).
                    setParameter("lastname", user.getLast_name()).
                    setParameter("gender", user.getGender()).
                    setParameter("email", user.getEmail()).
                    setParameter("dateofbirth", user.getDateofbirth()).
                    setParameter("id_user", user.getId_user()).
                    executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    @Override
    public User findUserByEmail(String email){
        User user = new User();
        try{
            entityManager.clear();
            String sql = "Select e "
                    + " from "+User.class.getName()+" e where e.email =:email ";
            Query query = entityManager.createQuery(sql);
            query.setParameter("email", email);
            List<User> lst = new ArrayList<>();
            lst = query.getResultList();
            if(lst.size() == 1){
                user = (User) lst.get(0);
            }
        }
        catch(NoResultException ex){
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    @Transactional(value = "comesticTransactionManager")
    public void updateAvatar(String avatar_img, int id) {
        try{
            entityManager.clear();
            String sql = "UPDATE user set avartar_img = :img "
                    + "where id_user = :id_user";
            entityManager.createNativeQuery(sql).
                    setParameter("img", avatar_img).
                    setParameter("id_user", id).
                    executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
