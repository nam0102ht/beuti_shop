/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.controller;

import com.ygame.yg05.config.ConfigInfo;
import com.ygame.yg05.config.DataManager;
import com.ygame.yg05.dao.BannerDB;
import com.ygame.yg05.entity_cometics.Banner;
import com.ygame.yg05.entity_cometics.User;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    public static final String uploading = System.getProperty("user.dir");
    protected static final String PASSING_PATH_IMG = "uploads/";
    @Autowired
    BannerDB bannerDB;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainControl(HttpSession session){
        Map<String, Object> params = new LinkedHashMap<>();
        User user = null;
        String path_img = "";
        List<Banner> lstBanner =  new ArrayList<>();
        try{
            user = DataManager.getUser(session);
            if(user != null){
                String[] arr = user.getAvartar_img().split("/");
                path_img = PASSING_PATH_IMG+user.getAvartar_img();
                if(arr.length > 1){
                    path_img = user.getAvartar_img();
                }
            }
            lstBanner = bannerDB.getListBanner();
            params.put(ConfigInfo.USER_WEB, user);
            params.put("upload", uploading);
            params.put("path_img", path_img);
            params.put("lstBanner", lstBanner);
            params.put("path_dir", PASSING_PATH_IMG);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ModelAndView("page/indexPage", params);
    }
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView aboutController(HttpSession session){
        Map<String, Object> params = new LinkedHashMap<>();
        User user = null;
        String path_img = "";
        try{
            user = DataManager.getUser(session);
            if(user != null){
                String[] arr = user.getAvartar_img().split("/");
                path_img = PASSING_PATH_IMG+user.getAvartar_img();
                if(arr.length > 1){
                    path_img = user.getAvartar_img();
                }
            }
            params.put("title", "Giới thiệu");
            params.put(ConfigInfo.USER_WEB, user);
            params.put("upload", uploading);
            params.put("path_img", path_img);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ModelAndView("page/aboutMe", params);
    }
    
}
