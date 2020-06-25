/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.nhanvien;

/**
 *
 * @author Acer
 * 
 */
import Controller.phim.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DataProvider {
    private static String DB_URL = "jdbc:mysql://localhost:3306/quanli_rap?serverTimezone=UTC";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
 
    /**
     * main
     * 
     * @author viettuts.vn
     * @param args
     */

 
 
    /**
     * create connection 
     * 
     * @author viettuts.vn
     * @param dbURL: database's url
     * @param userName: username is used to login
     * @param password: password is used to login
     * @return connection
     */
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
}
