/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.phim;


import quanlirapphim.*;
import Model.phim.ThucHienBusiness;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class NguoiDungBusiness {
    public NguoiDung kiemTraDangNhap(String username){
            //Khai báo doi tuong
            NguoiDung objNguoiDung=null;
            
            //Khai báo kết nối
            Connection conn=null;        
        try {
            conn=DataProvider.getConnection();
            
            //Khai báo 1 công viec
            String strSQL = "Select ID, TenDangNhap, MatKhau"+ " from nguoidung where TenDangNhap = '"+username+"'";
            
            Statement comm = conn.createStatement();
            
            ResultSet rs = comm.executeQuery(strSQL);
            
            while(rs.next()){
                //Khởi tạo đối tượng
                objNguoiDung = new NguoiDung();
                objNguoiDung.setId(rs.getInt("ID"));
                objNguoiDung.setTenDangNhap(rs.getString("TenDangNhap"));
                objNguoiDung.setMatKhau(rs.getString("MatKhau"));
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ThucHienBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            //Đóng kết nối
            if(conn !=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThucHienBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }
        return objNguoiDung;
    }    
}
