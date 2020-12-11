/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.controller;

import com.ygame.yg05.config.DataManager;
import static com.ygame.yg05.controller.BaseController.PASSING_ROOT;
import static com.ygame.yg05.controller.MainController.PASSING_PATH_IMG;
import com.ygame.yg05.dao.UserDB;
import com.ygame.yg05.entity_cometics.User;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActivityController extends BaseController{
    public static final String uploading = System.getProperty("user.dir");
    protected static final String PASSING_PATH_IMG = "uploads/";
    @Autowired
    UserDB userDB;
    
    @RequestMapping(value="/activity", method=RequestMethod.GET)
    public ModelAndView activityGet(HttpServletRequest request){
        Map<String, Object> params = new LinkedHashMap<>();
        String path_img = "";
        try{
            User user = DataManager.getUser(request.getSession());
            if(user==null || user.getId_user() == 0){
                String page = "/login?page=" + URLEncoder.encode(PASSING_ROOT+"activity", "utf-8");
                return new ModelAndView("redirect:"+page, params);
            }
            else{
                String[] arr = user.getAvartar_img().split("/");
                path_img = PASSING_PATH_IMG+user.getAvartar_img();
                if(arr.length > 1){
                    path_img = user.getAvartar_img();
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        params.put("title", "Điểm danh");
        params.put("path_img", path_img);
        return new ModelAndView("page/activityPage", params);
    }
}
