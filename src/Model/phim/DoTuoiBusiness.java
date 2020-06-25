/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.phim;

import Controller.phim.DoTuoi;
import Controller.phim.DataProvider;
import quanlirapphim.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class DoTuoiBusiness {
    List<DoTuoi> lstTuoi = new ArrayList();
    public List<DoTuoi> layDanhSach(){
        
        //Khai báo kết nối
        Connection conn = null;
        try{
            conn = DataProvider.getConnection();
        
            //Khai báo 1 công việc
            String strSQL = "Select MaDoTuoi, DoTuoi from dotuoi";
       
            Statement comm= conn.createStatement();
            
            //Thuwck hiện và trả về kết quả
            ResultSet rs = comm.executeQuery(strSQL);
            //Khai báo 1 đối tương
            DoTuoi objTuoi=null;            
            
            //ĐỌc từng dòng thông tin
            while(rs.next()){
                //Khởi tạo đối tượng
                objTuoi=new DoTuoi();
                //Gán giá trị cho các thuộc tính
                objTuoi.setMaDoTuoi(rs.getString("MaDoTuoi"));
                objTuoi.setDoTuoi(rs.getString("DoTuoi"));
                
                //Thêm vào danh sách
                lstTuoi.add(objTuoi);
            }

        } catch (SQLException ex) {
            System.out.println("Có lỗi xảy ra trong quá trình làm việc với mysql."+"Chi tiết: "+ex.getMessage());
        }
        finally{
            //Đóng kết nối
            try {
                if(conn != null){

                    conn.close();
                }
                } catch (SQLException ex) {
                    Logger.getLogger(ThucHienBusiness.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        return lstTuoi;
        
}  
   public DoTuoi layChiTiet(String maDoTuoi){
        //Khai báo 1 đối tương
        DoTuoi objTuoi=null;
        
        //Khai báo kết nối
        Connection conn = null;
        try{
            conn = DataProvider.getConnection();
        
            //Khai báo 1 công việc
            String strSQL = "Select MaPhim, TenPhim, TheLoai, LichChieu, TenDaoDien, TenDienVien, MoTa, Nuoc, MaDoTuoi"+" from quanli where maPhim = '"+ maDoTuoi+"'";
//              String strSQL="SELECT * FROM sinhvien";
            Statement comm= conn.createStatement();
            
            //Thuwck hiện và trả về kết quả
            ResultSet rs = comm.executeQuery(strSQL);
            
            
            //ĐỌc từng dòng thông tin
            while(rs.next()){
                //Khởi tạo đối tượng
                objTuoi=new DoTuoi();
                //Gán giá trị cho các thuộc tính
                objTuoi.setDoTuoi(rs.getString("DoTuoi"));
                objTuoi.setMaDoTuoi(rs.getString("MaDoTuoi"));
             

                //Thêm vào danh sách
                lstTuoi.add(objTuoi);
            }
        } catch (SQLException ex) {
            System.out.println("Có lỗi xảy ra ."+"Chi tiết: "+ex.getMessage());
        }
        finally{
            //Đóng kết nối
            try {
                if(conn != null){

                    conn.close();
                }
                } catch (SQLException ex) {
                    Logger.getLogger(ThucHienBusiness.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        return objTuoi;
        
}         
    }

