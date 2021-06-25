/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.github.riddhi.shikha.supermarket.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
    
    public static Connection getDBConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String databaseURL = "jdbc:mysql://localhost:3306/superMarketdb";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(databaseURL, username, password);
        return con;
    }
}
