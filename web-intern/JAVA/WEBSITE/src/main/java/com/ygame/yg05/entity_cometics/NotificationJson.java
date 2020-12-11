/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.entity_cometics;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;


public class NotificationJson {
    private String id;
    private int type;
    private String title;
    private String content;
    private Date create_time;
    private int status;
    private int user_id;
    private int user_activity;
    private String path_img;
    @JsonCreator
    public NotificationJson(@JsonProperty("id") String id,@JsonProperty("type") int type, 
            @JsonProperty("title") String title,@JsonProperty("content") String content, 
            @JsonProperty("create_time") Date create_time, @JsonProperty("status") int status, 
            @JsonProperty("user_id") int user_id, @JsonProperty("user_activity") int user_activity, 
            @JsonProperty("path_img") String path_img){
        this.id = id;
        this.type = type;
        this.title = title;
        this.content = content;
        this.create_time = create_time;
        this.status = status;
        this.user_id = user_id;
        this.user_activity = user_activity;
        this.path_img = path_img;
    }

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
