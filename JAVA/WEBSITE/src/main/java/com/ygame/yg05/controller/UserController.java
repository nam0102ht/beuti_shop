/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.controller;

import com.ygame.yg05.config.DataManager;
import com.ygame.yg05.dao.UserDB;
import com.ygame.yg05.entity_cometics.User;
import com.ygame.ygame05.util.Utils;
import java.net.URLEncoder;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController extends BaseController{
    protected static final String PASSING_PATH_IMG = "uploads/";
    @Autowired
    UserDB userDB;
    
    @RequestMapping(value= {"/profile"}, method = RequestMethod.GET)
    public ModelAndView profileController(HttpServletRequest request, @RequestParam(value="id", required = false, defaultValue = "0") int id){
        Map<String, Object> params = new LinkedHashMap<>();
        try{
            User user =  DataManager.getUser(request.getSession());
            if(user == null){
                String page = "/login?page=" + URLEncoder.encode(PASSING_ROOT+"profile", "utf-8");
                return new ModelAndView("redirect:"+page, params);
            }
            else{
                if(id != 0){
                    User user2 = userDB.findUserById(id);
                    String[] arr2 = user2.getAvartar_img().split("/");
                    String path_img2 = PASSING_PATH_IMG+user2.getAvartar_img();
                    if(arr2.length > 1){
                        path_img2 = user2.getAvartar_img();
                    }
                    params.put("path_img2", path_img2);
                    params.put("user2", user2);
                }
                initParameter(request, params);
                String[] arr = user.getAvartar_img().split("/");
                String path_img = PASSING_PATH_IMG+user.getAvartar_img();
                if(arr.length > 1){
                    path_img = user.getAvartar_img();
                }
                params.put(PASSING_USER, user);
                params.put(PASSING_TITILE_PAGE, "Thông tin tài khoản");
                params.put("path_img", path_img);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ModelAndView("page/profile", params);
    }
    @GetMapping(value = {"/logout"})
    public ModelAndView logoutPage(HttpServletRequest request) {
        Map<String, Object> params = new LinkedHashMap<>();
        DataManager.logout(request.getSession());
        return new ModelAndView("redirect:/", params);
    }
    @GetMapping(value = {"/diary"})
    public ModelAndView diaryController(HttpServletRequest request){
        Map<String, Object> params = new LinkedHashMap<>();
        try{
            User user =  DataManager.getUser(request.getSession());
            if(user == null){
                String page = "/login?page=" + URLEncoder.encode(PASSING_ROOT+"profile", "utf-8");
                return new ModelAndView("redirect:"+page, params);
            }
            initParameter(request, params);
            String[] arr = user.getAvartar_img().split("/");
            String path_img = PASSING_PATH_IMG+user.getAvartar_img();
            if(arr.length > 1){
                path_img = user.getAvartar_img();
            }
            params.put("title", "Nhật ký");
            params.put(PASSING_USER, user);
            params.put("path_img", path_img);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ModelAndView("page/diaryPage", params);
    }
    @GetMapping(value = {"/updateProfile"})
    public ModelAndView updateProfileController(HttpServletRequest request){
        Map<String, Object> params = new LinkedHashMap<>();
        try{
            User user =  DataManager.getUser(request.getSession());
            if(user == null){
                String page = "/login?page=" + URLEncoder.encode(PASSING_ROOT+"profile", "utf-8");
                return new ModelAndView("redirect:"+page, params);
            }
            initParameter(request, params);
            String[] arr = user.getAvartar_img().split("/");
            String path_img = PASSING_PATH_IMG+user.getAvartar_img();
            if(arr.length > 1){
                path_img = user.getAvartar_img();
            }
            params.put("title", "Thông tin tài khoản");
            params.put(PASSING_USER, user);
            params.put("path_img", path_img);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ModelAndView("page/updateProfile", params);
    }
    @RequestMapping(value ="/updatePro", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> postUpdateProfile(HttpServletRequest request,
            @RequestParam("name") String name,
            @RequestParam("ho") String ho,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam("gender") int gender,
            @RequestParam("dateofbirth") String dateofbirth){
        Map<String, Object> result = new LinkedHashMap<>();
        int PopUp = 0;
        try{
            User user = DataManager.getUser(request.getSession());
            String emailCurrent = user.getEmail();
            if(user != null){
                User user2 = userDB.findUserByEmail(email);
                if(user2.getId_user() > 0 || user2.getEmail() != null){
                    PopUp = 1;//email ton tai
                }
                else{
                    user.setFirst_name(ho);
                    user.setLast_name(name);
                    if(user.getEmail()!= "" || user.getEmail() != null)
                        user.setEmail(email);
                    else
                        user.setEmail(emailCurrent);
                    user.setGender(gender);
                    user.setDateofbirth(Utils.parseStringToDate(dateofbirth));
                    userDB.updateInfo(user);
                    PopUp = 2;
                }
            }
            result.put("popup", PopUp);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    
    @GetMapping(value="/password")
    public ModelAndView updatePassword(HttpServletRequest request){
        Map<String, Object> params = new LinkedHashMap<>();
        try{
            User user =  DataManager.getUser(request.getSession());
            if(user == null){
                String page = "/login?page=" + URLEncoder.encode(PASSING_ROOT+"profile", "utf-8");
                return new ModelAndView("redirect:"+page, params);
            }
            initParameter(request, params);
            String[] arr = user.getAvartar_img().split("/");
            String path_img = PASSING_PATH_IMG+user.getAvartar_img();
            if(arr.length > 1){
                path_img = user.getAvartar_img();
            }
            params.put("title", "Mật khẩu");
            params.put(PASSING_USER, user);
            params.put("path_img", path_img);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ModelAndView("page/updatePassword", params);
    }
    @RequestMapping(value = "/changeAvatar", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> changeAvatar(HttpServletRequest request,
            @RequestParam("filename") String filename){
        Map<String, Object> result = new LinkedHashMap<>();
        try{
            User user = DataManager.getUser(request.getSession());
            userDB.updateAvatar(filename, user.getId_user());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
