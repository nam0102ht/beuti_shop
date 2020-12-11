package com.ygame.yg05.entity_cometics;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="article", schema = "web_intern")
public class Article {

    @Id
    @GeneratedValue
    @Column(name="id_article")
    private Long id;
    
    @Column(name="page_title")
    private String page_title;
    
    @Column(name="content")
    private String content;
    
    @Column(name="status")
    private int status;
    
    @Temporal(TemporalType.DATE)
    @Column(name="create_date")
    private Date create_date;
    
    @Column(name="creator_id")
    private int creator_id;
    
    @Column(name="img")
    private String img;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPage_title() {
        return page_title;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }
    
}
