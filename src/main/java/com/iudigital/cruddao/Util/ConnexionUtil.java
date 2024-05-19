
package com.iudigital.cruddao.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnexionUtil {
     //variables
    private static final String URL = "jdbc:postgresql://localhost:5432/CRUDDAO";
    
    private static final String USER = "postgres";
    
    private static final String PASSWORD = "1234";
    
    public static Connection getConnection() throws SQLException {
          return DriverManager.getConnection(URL, USER, PASSWORD);
    } 
}
