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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="id_user")
    private int id_user;

    @Column(name="token_user")
    private String token_user;
    
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    
    @Column(name="email")
    private String email;
    
    @Column(name="phone")
    private String phone;
    
    @Column(name= "auth_key")
    private String auth_key;
    
    @Column(name="first_name")
    private String first_name;
    
    @Column(name="last_name")
    private String last_name;
    
    @Column(name="create_date")
    @Temporal(TemporalType.DATE)
    private Date create_date;
    
    @Column(name="active")
    private int active;
    
    @Column(name="gender")
    private int gender;
    
    @Column(name="dateofbirth")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    
    @Column(name="reset_token_user")
    private String reset_token_user;
    
    @Column(name="avartar_img")
    private String avartar_img;
   

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuth_key() {
        return auth_key;
    }

    public void setAuth_key(String auth_key) {
        this.auth_key = auth_key;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAvartar_img() {
        return avartar_img;
    }

    public void setAvartar_img(String avartar_img) {
        this.avartar_img = avartar_img;
    }

    public String getToken_user() {
        return token_user;
    }

    public void setToken_user(String token_id) {
        this.token_user = token_id;
    }

    public String getReset_token_user() {
        return reset_token_user;
    }

    public void setReset_token_user(String reset_token_user) {
        this.reset_token_user = reset_token_user;
    }
    
    
}
