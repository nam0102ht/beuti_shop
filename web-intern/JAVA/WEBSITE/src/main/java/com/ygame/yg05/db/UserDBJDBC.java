package com.ygame.yg05.db;

import com.ygame.yg05.entity_cometics.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class UserDBJDBC {
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
    
    public User findUserByUsernamePassword(String username, String password){
        User user = new User();
        Connection conn = null;
        try{
            conn = connectionDB();
            String sql = "Select * from user where username like ? and password like ? ";
            try(PreparedStatement stmt = conn.prepareCall(sql)){
                stmt.setString(1, username);
                stmt.setString(2, password);
                try(ResultSet rs = stmt.executeQuery()){
                    while(rs.next()){
                        user.setId_user(rs.getInt("id_user"));
                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                        user.setFirst_name(rs.getString("first_name"));
                        user.setLast_name(rs.getString("last_name"));
                        user.setCreate_date(new Date(rs.getDate("create_date").getTime()));
                        user.setGender(rs.getInt("gender"));
                        user.setDateofbirth(new Date(rs.getDate("dateofbirth").getTime()));
                        user.setAvartar_img(rs.getString("avartar_img"));
                    }
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return user;
    }
    public void updateUser(User user){
        
    }
}
