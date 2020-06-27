/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.phongchieu;

/**
 *
 * @author Acer
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DataProvider {
    private static String DB_URL = "jdbc:mysql://localhost:3306/quanli_rap?serverTimezone=UTC";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER_NAME ,PASSWORD );
//            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("Không tìm thấy driver, Chi tiết "+ex.getMessage());
            ex.printStackTrace();
        }
        return conn;
    }  
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // TODO code application logic here
            if(!DataProvider.getConnection().isClosed()){
                System.out.println("Ket noi denn database thanh cong!");
            }
            else{
                System.out.println("Ko the ket noi database");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }    
}
