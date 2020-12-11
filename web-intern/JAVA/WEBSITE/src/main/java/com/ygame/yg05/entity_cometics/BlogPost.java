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
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table( name = "blogpost", schema = "web_intern" )
@EntityListeners(AuditingEntityListener.class)
public class BlogPost implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="description")
    private String description;
    
    @Column(name="url")
    private String url;
    
    @Column(name="likes")
    private int likes;
    
    @Column(name="post_by")
    private int post_by;
    
    @Column(name="create_time")
    @Temporal(TemporalType.DATE)
    private Date create_date;
    
    @Column(name="img")
    private String img;
    
    @Column(name= "status")
    private int status;
    
    @Column(name="avatar_user")
    private String avatar_user;
    
    @Column(name="username")
    private String username;
    
    @Transient
    private int path_img;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getPost_by() {
        return post_by;
    }

    public void setPost_by(int post_by) {
        this.post_by = post_by;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPath_img() {
        return path_img;
    }

    public void setPath_img(int path_img) {
        this.path_img = path_img;
    }

    public String getAvatar_user() {
        return avatar_user;
    }

    public void setAvatar_user(String avatar_user) {
        this.avatar_user = avatar_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
