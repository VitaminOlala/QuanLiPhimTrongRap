/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.ve;

import Model.phim.ThucHienBusiness;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import Model.phim.DataProvider;

/**
 *
 * @author Acer
 */
public class GheBusiness {
    List<Ghe> lstghe = new ArrayList();
    public List<Ghe> layDanhSach(){
        
        //Khai báo kết nối
        Connection conn = null;
        try{
            conn = DataProvider.getConnection();
        
            //Khai báo 1 công việc
            String strSQL = "Select MaGhe, Ghe from ghe";
       
            Statement comm= conn.createStatement();
            
            //Thuwck hiện và trả về kết quả
            ResultSet rs = comm.executeQuery(strSQL);
            //Khai báo 1 đối tương
            Ghe objGhe=null;            
            
            //ĐỌc từng dòng thông tin
            while(rs.next()){
                //Khởi tạo đối tượng
                objGhe=new Ghe();
                //Gán giá trị cho các thuộc tính
                objGhe.setMaGhe(rs.getString("MaGhe"));
                objGhe.setLoaiGhe(rs.getString("Ghe"));
                
                //Thêm vào danh sách
                lstghe.add(objGhe);
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
        return lstghe;
        
}  
   public Ghe layChiTiet(String maGhe){
        //Khai báo 1 đối tương
        Ghe objGhe=null; 
        
        //Khai báo kết nối
        Connection conn = null;
        try{
            conn = DataProvider.getConnection();
        
            //Khai báo 1 công việc
            String strSQL = "Select MaVe, MaPhim, Time, RunTime, GiaVe, Voucher, MaPhongChieu, MaNhanVien, MaGhe"+" from banvetheophim where maVe = '"+ maGhe+"'";
//              String strSQL="SELECT * FROM sinhvien";
            Statement comm= conn.createStatement();
            
            //Thuwck hiện và trả về kết quả
            ResultSet rs = comm.executeQuery(strSQL);
            
            
            //ĐỌc từng dòng thông tin
            while(rs.next()){
                //Khởi tạo đối tượng
                objGhe=new Ghe();
                //Gán giá trị cho các thuộc tính
                objGhe.setMaGhe(rs.getString("MaGhe"));
                objGhe.setLoaiGhe(rs.getString("Ghe"));
             

                //Thêm vào danh sách
                lstghe.add(objGhe);
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
        return objGhe;
        
}      
}
