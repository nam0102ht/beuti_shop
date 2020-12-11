/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.listener;

import com.ygame.yg05.dao.NotificationDB;
import com.ygame.yg05.entity_cometics.Notification;
import com.ygame.yg05.entity_cometics.NotificationJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotifiactionMessageListener {
    @Autowired
    private NotificationDB noticDB;
    
    public NotifiactionMessageListener(NotificationDB noticDB){
        this.noticDB = noticDB;
    }
    
    public void reciveMessage(NotificationJson message){
        noticDB.insertNotic(message);
    }
    
}
