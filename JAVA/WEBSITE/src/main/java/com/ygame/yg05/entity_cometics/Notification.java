/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.entity_cometics;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="notification")
public class Notification implements Serializable{
    @Id
    @Column(name="id_notic")
    private String id;
    
    @Column(name="type")
    private int type;
    
    @Column(name="title")
    private String title;
    
    @Column(name="content")
    private String content;
    
    @Column(name="create_time")
    @Temporal(TemporalType.DATE)
    private Date create_time;
    
    @Column(name="status")
    private int status;
    
    @Column(name="user_id")
    private int user_id;
    
    @Column(name="user_activity")
    private int user_activity;
    
    @Column(name="img")
    private String path_img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_activity() {
        return user_activity;
    }

    public void setUser_activity(int user_activity) {
        this.user_activity = user_activity;
    }

    public String getPath_img() {
        return path_img;
    }

    public void setPath_img(String path_img) {
        this.path_img = path_img;
    }
    
    
}
