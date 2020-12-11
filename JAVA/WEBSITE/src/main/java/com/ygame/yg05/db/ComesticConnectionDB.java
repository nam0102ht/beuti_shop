/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nam
 */
public class ComesticConnectionDB {
    protected static final ComesticConnectionDB INSTANCE = new ComesticConnectionDB();
    public static ComesticConnectionDB getInstance(){
        return INSTANCE;
    }
    public Connection connectionDB(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_intern","root", "root");
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return conn;
    }
}
