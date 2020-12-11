
package com.ygame.yg05.entity_cometics;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="comments", schema = "web_intern")
public class Comment {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    
    @Column(name="comment_content")
    private String comment_content;
    
    @Column(name="user_id")
    private int user_id;
    
    @Column(name="blog_id")
    private int blog_id;
    
    @Temporal(TemporalType.DATE)
    @Column(name="create_date")
    private Date create_date;
    
    @Column(name="user_name")
    private String user_name;
    
    @Column(name="avatar_img")
    private String avatar_img;
    
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

    public String getUsername() {
        return user_name;
    }

    public void setUsername(String username) {
        this.user_name = username;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAvatar_img() {
        return avatar_img;
    }

    public void setAvatar_img(String avatar_img) {
        this.avatar_img = avatar_img;
    }
}
