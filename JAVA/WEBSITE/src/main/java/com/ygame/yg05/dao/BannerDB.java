/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.dao;

import com.ygame.yg05.ConstantsDatasource;
import com.ygame.yg05.entity_cometics.Banner;
import com.ygame.yg05.repository.BannerRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BannerDB implements BannerRepository{
    @Autowired(required = true)
    @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = ConstantsDatasource.JPA_UNIT_NAME_COMESTIC)
    EntityManager entityManager;

    @Override
    public void insertBanner(Banner banner) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Banner getBannerById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Banner> getListBanner() {
        List<Banner> lst = new ArrayList<>();
        try{
            entityManager.clear();
            String sql = "SELECT e "
                    + "FROM "+Banner.class.getName()+" e "
                    + "WHERE  now() BETWEEN start_date AND end_date "
                    + "AND active = 0 "
                    + "ORDER BY priority DESC";
            Query query = entityManager.createQuery(sql);
            query.setFirstResult(0);
            query.setMaxResults(4);
            lst = query.getResultList();
        }catch(NoResultException ex){
            ex.printStackTrace();
        }
        return lst;
    }
    
}
