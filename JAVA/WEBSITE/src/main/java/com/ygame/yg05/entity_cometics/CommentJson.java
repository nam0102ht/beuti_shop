/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.entity_cometics;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author Nam
 */
public class CommentJson {
    private int id;
    private String comment_content;
    private int user_id;
    private int blog_id;
    private Date create_date;
    private String user_name;
    private String path_img;
    @JsonCreator
    public CommentJson(@JsonProperty("id") int id, 
            @JsonProperty("comment_content") String comment_content, 
            @JsonProperty("user_id") int user_id,
            @JsonProperty("blog_id") int blog_id,
            @JsonProperty("create_date") Date create_date,
            @JsonProperty("user_name") String username,
            @JsonProperty("path_img") String pathImg){
        this.id = id;
        this.comment_content = comment_content;
        this.user_id = user_id;
        this.blog_id = blog_id;
        this.create_date = create_date;
        this.user_name = username;
        this.path_img = pathImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPath_img() {
        return path_img;
    }

    public void setPath_img(String path_img) {
        this.path_img = path_img;
    }
}
