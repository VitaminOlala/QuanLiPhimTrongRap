/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.ve;

import Controller.ve.ThongTinVe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controller.phim.DataProvider;


/**
 *
 * @author Acer
 */
public class VeBusiness {
    List<ThongTinVe> lstVe=new ArrayList();
    public List<ThongTinVe> layDanhSach(){
            //Khai báo kết nối
            Connection conn = null;
        try {            
            conn = DataProvider.getConnection();
            
            String strSQL = "Select MaVe, MaPhim, Time, RunTime, GiaVe, Voucher, MaPhongChieu, MaNhanVien, MaGhe from banvetheophim";
            
            Statement comm = conn.createStatement();
            
            //Thực hiện và trả về kết quả
            ResultSet rs = comm.executeQuery(strSQL);
            ThongTinVe objVe = null;
            //Đọc từng dòng thông tin
            while(rs.next()){
                objVe = new ThongTinVe();
                objVe.setMaVe(rs.getString("MaVe"));
                objVe.setMaPhim(rs.getString("MaPhim"));
                objVe.setTime(rs.getString("Time"));
                objVe.setRunTime(rs.getString("RunTime"));
                objVe.setVoucher(rs.getString("Voucher"));
                objVe.setGiaVe(rs.getString("GiaVe"));
                objVe.setMaPhongChieu(rs.getString("MaPhongChieu"));                
                objVe.setMaNhanVien(rs.getString("MaNhanVien"));
                objVe.setMaGhe(rs.getString("MaGhe"));
                
                lstVe.add(objVe);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VeBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lstVe;
    }
    
    public ThongTinVe layChiTiet(String maVe){
            //Khia báo kết nối
            Connection conn = null;
            //Khai báo đối tượng
            ThongTinVe objVe = null;
        try {            
            
            conn=DataProvider.getConnection();
            
            //Khai báo 1 công việc
            String strSQL = "Select MaVe, MaPhim, Time, RunTime, Voucher, GiaVe, MaPhongChieu, MaNhanVien, MaGhe from banvetheophim where MaVe= '"+maVe+"'";
            
            Statement comm = conn.createStatement();
            
            ResultSet rs = comm.executeQuery(strSQL);
            
            while(rs.next()){
                objVe = new ThongTinVe();
                objVe.setMaVe(rs.getString("MaVe"));
                objVe.setMaPhim(rs.getString("MaPhim"));

                objVe.setTime(rs.getString("Time"));
                objVe.setRunTime(rs.getString("RunTime"));
                objVe.setGiaVe(rs.getString("GiaVe"));                
                objVe.setVoucher(rs.getString("Voucher"));
                objVe.setMaPhongChieu(rs.getString("MaPhongChieu"));                
                objVe.setMaNhanVien(rs.getString("MaNhanVien"));
                objVe.setMaGhe(rs.getString("MaGhe"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VeBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return objVe;
    }
    
    public boolean themMoiVe(ThongTinVe objVe){
            Connection conn = null;        
        try {
            
            conn=DataProvider.getConnection();
            
            String strInsert = "Insert into banvetheophim (MaVe, MaPhim, Time, RunTime, GiaVe, Voucher, MaPhongChieu, MaNhanVien, MaGhe) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement comm = conn.prepareStatement(strInsert);
            
            //Gán giá trị cho các tham số
            comm.setString(1, objVe.getMaVe());
            comm.setString(2, objVe.getMaPhim());
            comm.setString(3, objVe.getTime());
            comm.setString(4, objVe.getRunTime());
            comm.setString(5, objVe.getGiaVe());
            comm.setString(6, objVe.getVoucher());
            comm.setString(7, objVe.getMaPhongChieu());             
            comm.setString(8, objVe.getMaNhanVien());
            comm.setString(9, objVe.getMaGhe());
            
            //Return trả về số dòng
            return comm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(VeBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VeBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;

    }
    
    public boolean capNhatVe(ThongTinVe objVe){
            Connection conn = null;        
        try {
            
            conn=DataProvider.getConnection();
            
            String strUpdate="Update banvetheophim set MaPhim=?, Time=?, RunTime=?, GiaVe=?, Voucher=?,  MaPhongChieu=?, MaNhanVien=?, MaGhe=? where MaVe=?";
            PreparedStatement comm= conn.prepareStatement(strUpdate);
             
            //Gán giá trị cho các tham số (phải cùng thứ tự câu lệnh strUpdate)
            comm.setString(1, objVe.getMaPhim());
            comm.setString(2, objVe.getTime());
            comm.setString(3, objVe.getRunTime());
            comm.setString(4, objVe.getGiaVe());
            comm.setString(5, objVe.getVoucher());
            comm.setString(6, objVe.getMaPhongChieu());
            comm.setString(7, objVe.getMaNhanVien());
            comm.setString(8, objVe.getMaGhe()); 

            comm.setString(9, objVe.getMaVe());
            
            //thực hiện công việc'
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(VeBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            //Đóng kết nối
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VeBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
        
    }
    
    public List<ThongTinVe> timKiemVe(String maPhim){
        //Khia báo 1 danh sách
        List<ThongTinVe> lstVe = new ArrayList();
            
        Connection conn=null;
        try {            
            conn=DataProvider.getConnection();
            
            //Khia báo 1 công việc
            String strSQL = "Select MaVe, MaPhim, Time, RunTime, Voucher, GiaVe, MaPhongChieu, MaNhanVien, MaGhe "+ " from banvetheophim where 1=1";
            
            if(!maPhim.isEmpty()){
                strSQL += " And (MaPhim like '%"+maPhim+"%' OR" + " MaVe like '%"+maPhim+"%')";
            }
  
            Statement comm=conn.createStatement();
            
            //Thực hiện và trả lại kết quả
            ResultSet rs = comm.executeQuery(strSQL);
            
            //Khai báo 1 dối tượng
            ThongTinVe objVe=null;
            
            //Đọc từng thông tin
            while(rs.next()){
                objVe = new ThongTinVe();
                objVe.setMaVe(rs.getString("MaVe"));
                objVe.setMaPhim(rs.getString("MaPhim"));
                objVe.setTime(rs.getString("Time"));
                objVe.setRunTime(rs.getString("RunTime"));
                objVe.setGiaVe(rs.getString("GiaVe"));
                objVe.setVoucher(rs.getString("Voucher"));
                objVe.setMaPhongChieu(rs.getString("MaPhongChieu"));
                objVe.setMaNhanVien(rs.getString("MaNhanVien"));
                objVe.setMaGhe(rs.getString("MaGhe"));
                
                lstVe.add(objVe);
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
                    Logger.getLogger(VeBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        return lstVe;
    }
    
    public boolean xoaVe(String maVe){
        Connection conn= null;
   
        try {
            conn=DataProvider.getConnection();
            Statement comm=conn.createStatement();
            
            String strDelete = "Delete from banvetheophim where MaVe = '"+ maVe +"'";
            
            //Thực hiện và trả về kết quả
            return comm.executeUpdate(strDelete)>0;
        } catch (SQLException ex) {
            Logger.getLogger(VeBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VeBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
