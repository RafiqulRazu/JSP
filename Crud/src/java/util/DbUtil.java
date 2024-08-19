/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USERAS
 */
public class DbUtil {
    private static String url = "jdbc:mysql://localhost:3306/dbcrud";
    private static String user = "root";
    private static String password = "";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    
    private static Connection con = null;
    
    public static Connection getCon(){
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException ex) {
                Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) {
        Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
            
        
    }
}
