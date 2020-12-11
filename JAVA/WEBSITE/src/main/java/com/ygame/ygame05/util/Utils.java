/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ygame.ygame05.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nam
 */
public class Utils {
    public static String md5(String str){
        String result = "";
        MessageDigest digest;
        try {
                digest = MessageDigest.getInstance("MD5");
                digest.update(str.getBytes());
                BigInteger bigInteger = new BigInteger(1,digest.digest());
                result = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
        }
        return result;
    }
    public static Date parseStringToDate(String date){
        Date d = null;
        try {
            d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
}
