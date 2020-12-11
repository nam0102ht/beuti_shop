/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.controller;

import com.ygame.yg05.config.ConfigInfo;
import com.ygame.yg05.config.DataManager;
import static com.ygame.yg05.controller.MainController.PASSING_PATH_IMG;
import com.ygame.yg05.dao.ArticleDB;
import com.ygame.yg05.entity_cometics.Article;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {
    @Autowired
    ArticleDB artDB;
    
    public static final String uploading = System.getProperty("user.dir");
    protected static final String PASSING_IMG_PATH = "uploads/";
    @RequestMapping(value="/getListArticle", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getListArticle(int page){
        Map<String, Object> result = new LinkedHashMap<>();
        List<Article> lst = new ArrayList<>();
        int totalPage = 0;
        try{
            long totalRecord =  artDB.countArticle();
            int size =12;
            totalPage = (int) Math.ceil(totalRecord/size) +1;
            int start = (page - 1)*12;
            lst = artDB.getAllListArticle(start, size);
            result.put("index", page);
            result.put("totalPage", totalPage);
            result.put("listArticle", lst);
            result.put("path_img", PASSING_IMG_PATH);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    
    @RequestMapping(value="/detailArticle", method=RequestMethod.GET)
    public ModelAndView detailArticle(HttpSession session,@RequestParam("idArt") int id){
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
            Article art = artDB.getArticleById(id);
            params.put(ConfigInfo.USER_WEB, user);
            params.put("upload", uploading);
            params.put("path_img", path_img);
            params.put("path_dir", PASSING_PATH_IMG);
            params.put("art", art);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ModelAndView("page/detailArt", params);
    }
}
