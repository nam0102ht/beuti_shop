/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.config;

import com.ygame.yg05.entity_cometics.User;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.cliffc.high_scale_lib.NonBlockingHashMap;

public class DataManager {
    public static final String SESSION_USER ="user";
    private static final Map<Integer, HttpSession> sessionPool = new NonBlockingHashMap<>();
    
    static{
    }
    
    public static User getUser(HttpSession session) {
        return (User) session.getAttribute(SESSION_USER);
    }
    
    public static void saveToSession(HttpSession session, String key, Object obj) {
        session.setAttribute(key, obj);
    }
    public static void logout(HttpSession session) {
        try {
            session.removeAttribute(SESSION_USER);
            session.invalidate();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void saveUser(HttpSession session, User user) {
        HttpSession curSession = sessionPool.get(user.getId_user());
        if (curSession != null && curSession != session)
            logout(curSession);
        saveToSession(session, SESSION_USER, user);
        session.setMaxInactiveInterval(15 * 60);
        sessionPool.put(user.getId_user(), session);
    }
    
}
