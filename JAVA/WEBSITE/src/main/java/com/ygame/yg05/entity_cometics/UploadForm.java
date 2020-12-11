/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.entity_cometics;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Nam
 */
public class UploadForm {
    private String description;
 
    private MultipartFile[] files;
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public MultipartFile[] getFiles() {
        return files;
    }
 
    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
