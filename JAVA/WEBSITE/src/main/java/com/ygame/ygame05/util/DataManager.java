/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.ygame05.util;

import org.springframework.stereotype.Component;

@Component
public class DataManager {
    private static DataManager instance;
    
    private DataManager(){
        loadData();
    }
    
    public static synchronized DataManager getInstance(){
        if(instance == null)
            instance = new DataManager();
        return instance;
    }
    
    private void loadData(){
        
    }
}
