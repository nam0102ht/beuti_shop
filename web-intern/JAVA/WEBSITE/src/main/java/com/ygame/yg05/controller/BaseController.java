/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.controller;

import com.ygame.yg05.config.DataManager;
import com.ygame.yg05.entity_cometics.User;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nam
 */
@Controller
public abstract class BaseController {
    protected static final String PASSING_USER = "user";
    protected static final String PASSING_TITILE_PAGE = "title";
    protected static final String PASSING_ROOT = "localhost:8000/";
    protected static final String PASSING_LOGIN = "localhost:8000/login";
    
    protected void initParameter(HttpServletRequest request, Map<String, Object> params){
        User user = DataManager.getUser(request.getSession());
        if(user == null)
            user = new User();
        params.put(PASSING_USER, user);
    }
    protected void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
        User user = DataManager.getUser(request.getSession());
        if(user!=null)
            response.sendRedirect(PASSING_LOGIN);
    }
    
    protected ModelAndView redirectLogin(String page) throws UnsupportedEncodingException{
        return new ModelAndView("redirect:/login?page="+URLEncoder.encode(page, "utf-8"));
    }
}
