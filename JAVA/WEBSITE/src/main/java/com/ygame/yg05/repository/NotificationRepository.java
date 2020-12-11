/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.repository;

import com.ygame.yg05.entity_cometics.Notification;
import com.ygame.yg05.entity_cometics.NotificationJson;
import java.util.List;

public interface NotificationRepository {
    void insertNotic(NotificationJson notic);
    Notification getNoticById();
    List<Notification> getListNotification();
    
}
