/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.controller;

import com.ygame.yg05.config.ConfigInfo;
import com.ygame.yg05.config.DataManager;
import com.ygame.yg05.dao.BlogPostDB;
import com.ygame.yg05.dao.CommentDB;
import com.ygame.yg05.dao.UserDB;
import com.ygame.yg05.db.BlogPostJDBC;
import com.ygame.yg05.entity_cometics.BlogPost;
import com.ygame.yg05.entity_cometics.Comment;
import com.ygame.yg05.entity_cometics.CommentJson;
import com.ygame.yg05.entity_cometics.User;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostBlogController {
    
    @Autowired
    BlogPostDB postDB;
    
    @Autowired
    CommentDB commentDB;
    
    protected static final String PASSING_PATH_IMG = "uploads/";
    //API lưu blog được viết
    @RequestMapping(value="/post_blog", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> savePostController(HttpSession session,
            @RequestParam("content") String content,
            @RequestParam("fileImage") String fileImage
            ){
        Map<String, Object> result = new LinkedHashMap<>();
        int post = 1;
        try{
            User user = DataManager.getUser(session);
            if(user == null){
                post = 2;
            }else{
                //lưu post xuống database
                Date date= new Date();
                BlogPost  blogpost = new BlogPost();
                blogpost.setDescription(content);
                blogpost.setImg(fileImage);
                blogpost.setCreate_date(date);
                blogpost.setPost_by(user.getId_user());
                blogpost.setAvatar_user(user.getAvartar_img());
                if(user.getUsername()==null)
                    blogpost.setUsername(user.getLast_name());
                else
                    blogpost.setUsername(user.getUsername());
                //hàm insert xuống database
                postDB.insertBlogPost(blogpost);
            }
            result.put("post", post);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value="/getListBlog", method=RequestMethod.GET)
    @ResponseBody
    //Lấy ra danh sách bài blog và phân trang
    public Map<String, Object> getListBlog(HttpSession session, @RequestParam("page") int page){
        Map<String, Object> result = new LinkedHashMap<>();
        List<BlogPost> lst = new ArrayList<>();
        int totalPage = 0;
        try{
            //Lấy user từ phiên đã lưu
            User user = DataManager.getUser(session);
            //khởi tạo số record trên một trang
            int size = 20;
            int start= (page-1)*size;
            long totalRecord = postDB.totalBlogPostAll();
            totalPage = (int)Math.ceil(totalRecord/size)+1;
            lst = postDB.getAllPostByCreateTime(start, size);
            result.put("index", page);
            result.put("totalPage", totalPage);
            result.put("listPost", lst);
            result.put("path_img", PASSING_PATH_IMG);
            result.put(ConfigInfo.USER_WEB, user);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value="/getListBlogUser", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getListBlogByID(HttpSession session, 
            @RequestParam("page") int page,
            @RequestParam(value = "id", required = false, defaultValue = "0") int id){
        Map<String, Object> result = new LinkedHashMap<>();
        List<BlogPost> lst = new ArrayList<>();
        int totalPage = 0;
        User user;
        try{
            if(id == 0)
                user = DataManager.getUser(session);
            else 
                user = userDB.findUserById(id);
            int size = 20;
            int start= (page-1)*size;
            if(user != null){
                long totalRecord = postDB.totalBlogPostByUser(user.getId_user());
                totalPage = (int)Math.ceil(totalRecord/size)+1;
                lst = postDB.getAllPostByUser_Id(user.getId_user(),start, size);
            }
            result.put("index", page);
            result.put("totalPage", totalPage);
            result.put("listPost", lst);
            result.put("path_img", PASSING_PATH_IMG);
            result.put(ConfigInfo.USER_WEB, user);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value="/comment", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> saveComment(HttpSession session,
            @RequestParam("content") String content, 
            @RequestParam("idPost") int idPost){
        Map<String, Object> result = new LinkedHashMap<>();
        try{
            User user = DataManager.getUser(session);
            if(user != null){
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value = "/getListComment", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllListComment(HttpSession session,@RequestParam("idPost") int idPost, 
            @RequestParam("page") int page){
        Map<String, Object> result = new LinkedHashMap<>();
        List<Comment> listComment = new ArrayList<>();
        int totalPage = 0;
        try{
            User user = DataManager.getUser(session);
            if(user != null || user.getId_user() != 0){
                int size = 10;
                long totalRecord =  commentDB.totalRecordCommentPerBlog(idPost);
                int start = (page-1)*size;
                totalPage = (int) Math.ceil(totalRecord/size);
                listComment = commentDB.getListCommentById_Post(idPost, start, size);
            }
            result.put("path_img", PASSING_PATH_IMG);
            result.put("indexPage", page);
            result.put("totalPage", totalPage);
            result.put("listComment", listComment);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    
    @Autowired
    UserDB userDB;
    
    @MessageExceptionHandler(MessageConversionException.class)
    @MessageMapping("/receive-comments")
    @SendTo("/topic/comments")
    public CommentJson getCommentJson(CommentJson mess){
        try{
            Thread.sleep(1000);
            User user = userDB.findUserById(mess.getUser_id());
            if(user != null){
                String[] arr = user.getAvartar_img().split("/");
                String path_img = PASSING_PATH_IMG+user.getAvartar_img();
                if(arr.length > 1){
                    path_img = user.getAvartar_img();
                }
                Comment comment = new Comment();
                comment.setComment_content(mess.getComment_content());
                if(user.getUsername() == "" || user.getUsername() == null)
                    comment.setUser_name(user.getLast_name());
                else
                    comment.setUser_name(user.getUsername());
                comment.setCreate_date(mess.getCreate_date());
                comment.setUser_id(mess.getUser_id());
                comment.setBlog_id(mess.getBlog_id());
                comment.setAvatar_img(user.getAvartar_img());
                commentDB.insertComment(comment);
                mess.setUser_name(user.getUsername());
                mess.setPath_img(path_img);
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        return mess;
    }
    
}
