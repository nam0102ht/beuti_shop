/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.dao;

import com.ygame.yg05.ConstantsDatasource;
import com.ygame.yg05.entity_cometics.Notification;
import com.ygame.yg05.entity_cometics.NotificationJson;
import com.ygame.yg05.repository.NotificationRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationDB implements NotificationRepository{
    @Autowired(required = true)
    @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = ConstantsDatasource.JPA_UNIT_NAME_COMESTIC)
    EntityManager entityManager;
    
    @Override
    public void insertNotic(NotificationJson notic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Notification getNoticById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Notification> getListNotification() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
