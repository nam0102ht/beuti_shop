/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.controller;

import com.ygame.yg05.config.DataManager;
import com.ygame.yg05.dao.UserDB;
import com.ygame.yg05.db.UserDBJDBC;
import com.ygame.yg05.entity_cometics.User;
import com.ygame.ygame05.util.Utils;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends BaseController{
    @Autowired
    private UserDB userDB;
    
    protected static final String PASSING_AVATAR = "meow-black-cat-comestic.png";
    private static final String PASSING_TITLE = "title";
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public ModelAndView loginControllerGet(){
        Map<String, Object> params = new LinkedHashMap<>();
        try{
            params.put(PASSING_TITLE, "Login");
        }catch(Exception ex){
            ex.getStackTrace();
        }
        return new ModelAndView("page/login", params);
    }
    @RequestMapping(value="/register", method= RequestMethod.GET)
    public ModelAndView registerController(){
        Map<String, Object> params = new LinkedHashMap<>();
        try{
            params.put(PASSING_TITLE, "Register");
        }catch(Exception ex){
            ex.getStackTrace();
        }
        return new ModelAndView("page/register", params);
    }
    @RequestMapping(value = "/login_nm", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> loginNM(@RequestParam(value="username") String username, 
            @RequestParam(value="password") String password, HttpSession session){
        Map<String, Object> result = new LinkedHashMap<>();
        String passwordMD5 = "";
        int popup = 0;
        try{
            passwordMD5 = Utils.md5(password);
            User user = userDB.findUserByUsernamePassword(username, passwordMD5);
            if(user == null || user.getId_user()==0)
                popup = 1;
            else{
                popup =0;
                DataManager.saveUser(session, user);
            }
            result.put("user", user);
            result.put("popup", popup);
            result.put("root_url", PASSING_ROOT);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;        
    }
    
    @RequestMapping(value = "/register_nm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> registerNM(@RequestParam(value="username") String username,
                                            @RequestParam(value="password") String password,
                                            @RequestParam(value="repeatpassword") String repeatpass){
        Map<String, Object>  result = new LinkedHashMap<>();
        int popUp = 0;
        String passswordMD5, repeatpassMD5 = "";
        UserDBJDBC userDBJSBC = new UserDBJDBC();
        try{
            User user = new User();
            passswordMD5 = Utils.md5(password);
            repeatpassMD5 = Utils.md5(repeatpass);
            if(passswordMD5.equals(repeatpassMD5)){
                user = userDB.findUserByUsernamePassword(username, passswordMD5);
                if(user.getId_user()>0){
                    popUp = 1;
                }
                else{
                    user.setUsername(username);
                    user.setPassword(passswordMD5);
                    user.setAvartar_img(PASSING_AVATAR);
                    userDB.updateUser(user);
                    popUp = 0;
                }
            }
            else{
                popUp = 2;
            }
            result.put("popup", popUp);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value="/login_fb", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> loginFBCn(@RequestParam(value="open_email") String email,
            @RequestParam(value="open_name") String name,
            @RequestParam(value="open_id") String token_user,
            @RequestParam(value= "open_avatar") String avatar,
            HttpSession session
            ){
        Map<String, Object> result = new LinkedHashMap<>();
        int popup = 0;
        try{
            User user = userDB.findUserByEmail(email);
            if(user.getId_user() > 0){
                popup = 1;
                DataManager.saveUser(session, user);
            }else{
                popup = 0;
                user = new User();
                user.setEmail(email);
                user.setLast_name(name);
                user.setToken_user(token_user);
                user.setAvartar_img(avatar);
                userDB.updateUser(user);
            }
            result.put("root_url", PASSING_ROOT);
            result.put("popup", popup);
            result.put("user", user);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
