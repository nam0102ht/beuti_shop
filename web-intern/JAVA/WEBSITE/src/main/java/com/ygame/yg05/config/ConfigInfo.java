/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.yg05.config;

import com.ygame.framework.common.Config;

public class ConfigInfo {
    public static final String SPRING_BOOT_CONFIG = Config.getParam("spring_boot", "conf_path");
    public static final String USER_WEB = "user";
    public static final String IMAGE_FOLDER = "D:/web-intern/JAVA/WEBSITE/templates/static";
}
