/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.github.riddhi.shikha.supermarket.utility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class Utilities {

    public static final String IMAGEURL = "E:/Supermarket/src/org/github/riddhi/shikha/supermarket/profile/";

    public static String getDate(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tDate = dateFormat.format(date);
        return tDate;
    }
    
    public static String getDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tDate = dateFormat.format(date);
        return tDate;
    }
    
    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

   public static String getDateWithTime(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String cDate = dateFormat.format(date);
        return cDate;
    }
   
   public static String getSQLDateWithTime(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String cDate = dateFormat.format(date);
        return cDate;
    }
   
   // function to generate a random string of length n
    public static String getUserId(){
        int userIdLength = 6;
        // chose a Character random from this String
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(userIdLength);
  
        for (int i = 0; i < userIdLength; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int)(alphaNumericString.length() * Math.random());
  
            // add Character one by one in end of sb
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.toString();
    }
    
    public static String getInvoiceNo(){
        int userIdLength = 5;
        // chose a Character random from this String
        String numericString = "0123456789";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(userIdLength);
  
        for (int i = 0; i < userIdLength; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int)(numericString.length() * Math.random());
  
            // add Character one by one in end of sb
            sb.append(numericString.charAt(index));
        }
        return sb.toString();
    }
    
    // function to generate a random string of length n
    public static String getPassword(){
        int userIdLength = 8;
        // chose a Character random from this String
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(userIdLength);
  
        for (int i = 0; i < userIdLength; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int)(alphaNumericString.length() * Math.random());
  
            // add Character one by one in end of sb
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.toString();
    }
    
}
