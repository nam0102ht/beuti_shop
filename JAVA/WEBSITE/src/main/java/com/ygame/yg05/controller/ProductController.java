/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.controller;

import com.ygame.yg05.config.ConfigInfo;
import com.ygame.yg05.config.DataManager;
import static com.ygame.yg05.controller.MainController.PASSING_PATH_IMG;
import com.ygame.yg05.entity_cometics.Banner;
import com.ygame.yg05.entity_cometics.User;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    protected static final String PASSING_PATH_IMG = "uploads/";
    
    @RequestMapping(value="/face", method=RequestMethod.GET)
    public ModelAndView getProductFace(HttpSession session){
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
            params.put("title", "Chăm sóc da");
            params.put(ConfigInfo.USER_WEB, user);
            params.put("path_img", path_img);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ModelAndView("page/facePage", params);
    }
    
    @RequestMapping(value="/hair", method=RequestMethod.GET)
    public ModelAndView getProductHair(HttpSession session){
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
            params.put("title", "Chăm sóc tóc");
            params.put(ConfigInfo.USER_WEB, user);
            params.put("path_img", path_img);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ModelAndView("page/hairPage", params);
    }
    @RequestMapping(value="/nail", method=RequestMethod.GET)
    public ModelAndView getProductNail(HttpSession session){
        Map<String, Object> params =  new LinkedHashMap<>();
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
            params.put("title", "Chăm sóc móng");
            params.put(ConfigInfo.USER_WEB, user);
            params.put("path_img", path_img);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ModelAndView("page/nailPage", params);
    }
}
