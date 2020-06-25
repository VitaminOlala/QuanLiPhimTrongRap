/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.phim;

import Controller.phim.DataProvider;
import Controller.phim.ThongTin;
import quanlirapphim.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
public class ThucHienBusiness {
    List<ThongTin> lstPhim=new ArrayList();
    public List<ThongTin> layDanhSach(){
            //Khai báo kết nối
            Connection conn = null;        
        try {

            conn = DataProvider.getConnection();
                    
            //Khai báo 1 công việc
            String strSQL = "Select MaPhim, TenPhim, TheLoai, LichChieu, TenDaoDien, TenDienVien, MoTa, Nuoc, MaDoTuoi from quanli";
                    
            Statement comm = conn.createStatement();
                    
            //Thực hiện và trả về kết qu
            ResultSet rs = comm.executeQuery(strSQL);
            ThongTin objPhim =null;
            //Đọc từng dòng thông tin
            while(rs.next()){
                objPhim = new ThongTin();
                //Gán giá trị cho các thuộc tính
                objPhim.setMaPhim(rs.getString("MaPhim"));
                objPhim.setTenPhim(rs.getString("TenPhim"));
                objPhim.setTheLoai(rs.getString("TheLoai"));
                objPhim.setThoiGian(rs.getString("LichChieu"));
                objPhim.setTenDaoDien(rs.getString("TenDaoDien"));
                objPhim.setTenDienVien(rs.getString("TenDienVien"));
                objPhim.setMoTa(rs.getString("MoTa"));
                objPhim.setNuocSanXuat(rs.getString("Nuoc"));
                //Them vào danh sách
                lstPhim.add(objPhim);
        }
             
        } catch (SQLException ex) {
            System.out.println("Có lỗi xảy ra .Chi tiết: "+ex.getMessage());;
        }
        finally{
            //ĐÓng kết nối
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThucHienBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return lstPhim;

    }
    
    public ThongTin layChiTiet(String maPhim){
            //Khai báo doi tuong
            ThongTin objPhim=null;
            
            //Khai báo kết nối
            Connection conn=null;        
        try {
            conn=DataProvider.getConnection();
            
            //Khai báo 1 công viec
            String strSQL = "Select MaPhim, TenPhim, TheLoai, LichChieu, TenDaoDien, TenDienVien, MoTa, Nuoc, MaDoTuoi"+" from quanli where MaPhim = '"+maPhim+"'";
            
            Statement comm = conn.createStatement();
            
            ResultSet rs = comm.executeQuery(strSQL);
            
            while(rs.next()){
                //Khởi tạo đối tượng
                objPhim = new ThongTin();
                objPhim.setMaPhim(rs.getString("MaPhim"));
                objPhim.setTenPhim(rs.getString("TenPhim"));
                objPhim.setTheLoai(rs.getString("TheLoai"));
                objPhim.setThoiGian(rs.getString("LichChieu"));
                objPhim.setTenDaoDien(rs.getString("TenDaoDien"));
                objPhim.setTenDienVien(rs.getString("TenDienVien"));
                objPhim.setMoTa(rs.getString("MoTa"));
                objPhim.setNuocSanXuat(rs.getString("Nuoc"));  
                objPhim.setMaDoTuoi(rs.getString("MaDoTuoi"));
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
        return objPhim;
    }
    
    //Khi đã điền bảng thêm mới và chuyển vào bảng chính
    public boolean themMoiPhim(ThongTin objPhim){
            Connection conn = null;
        try {            
            conn=DataProvider.getConnection();        
            
            //Bảng thêm mới có ô nước SX và lịch chiếu đặc biet
            String strInsert = "Insert into QuanLi (MaPhim, TenPhim, TheLoai, LichChieu, TenDaoDien, TenDienVien, MoTa, Nuoc, MaDoTuoi) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement comm = conn.prepareStatement(strInsert);
            //Gán giá trị cho các tham số
            comm.setString(1, objPhim.getMaPhim());
            comm.setString(2, objPhim.getTenPhim());
            comm.setString(3, objPhim.getTheLoai());
            comm.setString(4, objPhim.getThoiGian());             
            comm.setString(5, objPhim.getTenDaoDien());
            comm.setString(6, objPhim.getTenDienVien());
            comm.setString(7, objPhim.getMoTa());
            comm.setString(8, objPhim.getNuocSanXuat());
            comm.setString(9, objPhim.getMaDoTuoi());

            
            //return trả về số dòng
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ThucHienBusiness.class.getName()).log(Level.SEVERE, null, ex);
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
        return false;
    }
    
    public boolean capNhatPhim(ThongTin objPhim){
            Connection conn = null;        
        try {
            
            conn=DataProvider.getConnection();
            
            String strUpdate="Update quanli set TenPhim=?, LichChieu=?, TenDaoDien=?, TenDienVien=?, MoTa=?, Nuoc=?, TheLoai=?, MaDoTuoi=? where MaPhim=?";
            PreparedStatement comm= conn.prepareStatement(strUpdate);
             
            //Gán giá trị cho các tham số (phải cùng thứ tự câu lệnh strUpdate)
            comm.setString(1, objPhim.getTenPhim());
            comm.setString(2, objPhim.getThoiGian());
            comm.setString(3, objPhim.getTenDaoDien());
            comm.setString(4, objPhim.getTenDienVien());
            comm.setString(5, objPhim.getMoTa());
            comm.setString(6, objPhim.getNuocSanXuat());
            comm.setString(7, objPhim.getTheLoai()); 
            comm.setString(8, objPhim.getMaDoTuoi());
            comm.setString(9, objPhim.getMaPhim());
            
            //thực hiện công việc'
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ThucHienBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            //Đóng kết nối
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThucHienBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
        
    }
    
    public List<ThongTin> timKiemPhim(String theLoai, String timTen, String nuocSanXuat){
        //Khia báo 1 danh sách
        List<ThongTin> lstPhim = new ArrayList();
            
        Connection conn=null;
        try {            
            conn=DataProvider.getConnection();
            
            //Khia báo 1 công việc
            String strSQL = "Select MaPhim, TenPhim, TheLoai, LichChieu, TenDaoDien, TenDienVien, MoTa, Nuoc, MaDoTuoi" + " from quanli where 1=1";
            
            if(!timTen.isEmpty()){
                strSQL += " And (TenPhim like '%"+timTen+"%' OR" + " MaPhim like '%"+timTen+"%')";
            }
            if(!theLoai.isEmpty()){
                if(theLoai=="Tất cả") {
                    strSQL += "";
                }else
                strSQL += " And TheLoai like '%" + theLoai + "%'";
            }
            if(!nuocSanXuat.isEmpty()){
                if(nuocSanXuat == "Tất cả"){
                    strSQL += "";
                }else
                strSQL += " And Nuoc = '"+ nuocSanXuat + "'";
            }
            
            Statement comm=conn.createStatement();
            
            //Thực hiện và trả lại kết quả
            ResultSet rs = comm.executeQuery(strSQL);
            
            //Khai báo 1 dối tượng
            ThongTin objPhim=null;
            
            //Đọc từng thông tin
            while(rs.next()){
                objPhim = new ThongTin();
                objPhim.setMaPhim(rs.getString("MaPhim"));
                objPhim.setTenPhim(rs.getString("TenPhim"));
                objPhim.setTheLoai(rs.getString("TheLoai"));
                objPhim.setThoiGian(rs.getString("LichChieu"));
                objPhim.setTenDaoDien(rs.getString("TenDaoDien"));
                objPhim.setTenDienVien(rs.getString("TenDienVien"));
                objPhim.setMoTa(rs.getString("MoTa"));
                objPhim.setNuocSanXuat(rs.getString("Nuoc"));    
                objPhim.setMaDoTuoi(rs.getString("MaDoTuoi"));
                
                lstPhim.add(objPhim);
            }
        } catch (SQLException ex) {
            System.out.println("Có lỗi xảy ra trong quá trình làm việc với mysql."+"Chi tiết: "+ex.getMessage());
        }
        finally{
            try {
                if(conn != null){
         
                    conn.close();
            }
                } catch (SQLException ex) {
                    Logger.getLogger(ThucHienBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        return lstPhim;
    }
    
    public boolean xoaPhim(String maPhim){
        Connection conn= null;
   
        try {
            conn=DataProvider.getConnection();
            Statement comm=conn.createStatement();
            
            String strDelete = "Delete from quanli where MaPhim = '"+ maPhim +"'";
            
            //Thực hiện và trả về kết quả
            return comm.executeUpdate(strDelete)>0;
        } catch (SQLException ex) {
            Logger.getLogger(ThucHienBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThucHienBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
