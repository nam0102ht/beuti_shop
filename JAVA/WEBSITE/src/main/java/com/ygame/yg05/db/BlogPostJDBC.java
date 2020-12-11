/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BlogPostJDBC {
    protected  static final BlogPostJDBC INSTANCE = new BlogPostJDBC();
    public static BlogPostJDBC getInstance(){
        return INSTANCE;
    }
    public long countTotalBlogPost(){
        long result = 0;
        Connection conn = null;
        try{
            conn = ComesticConnectionDB.getInstance().connectionDB();
            String sql = "Select count(*) as total from blogpost";
            try(PreparedStatement ptmt = conn.prepareStatement(sql)){
                try(ResultSet res= ptmt.executeQuery()){
                    while(res.next()){
                        result = res.getLong("total");
                    }
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }
}
