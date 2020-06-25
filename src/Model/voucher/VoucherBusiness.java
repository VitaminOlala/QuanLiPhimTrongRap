/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.voucher;

import Controller.phim.DataProvider;
import Controller.thongke.ThongTinThongKe;
import Controller.voucher.ThongTinVoucher;
import Model.thongke.ThongKeBusiness;
import java.sql.Connection;
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
public class VoucherBusiness {
    List<ThongTinVoucher> lstVoucher=new ArrayList();
    public List<ThongTinVoucher> layDanhSach(){
            //Khai báo kết nối
            Connection conn = null;
        try {            
            conn = DataProvider.getConnection();
            
            String strSQL = "Select MaThe, LoaiThe, TenKhachHang, GioiTinh, SoCMT, SDT, DiaChi, SoLanTichLuy, Voucher from quanlithethanhvien";
            
            Statement comm = conn.createStatement();
            
            //Thực hiện và trả về kết quả
            ResultSet rs = comm.executeQuery(strSQL);
            ThongTinVoucher objVoucher = null;
            //Đọc từng dòng thông tin
            while(rs.next()){
                objVoucher = new ThongTinVoucher();
                objVoucher.setMaThe(rs.getString("MaThe"));
                objVoucher.setLoaiThe(rs.getString("LoaiThe"));
                objVoucher.setTenKhachHang(rs.getString("TenKhachHang"));
                objVoucher.setGioiTinh(rs.getString("GioiTinh"));
                objVoucher.setSoCMT(rs.getString("SoCMT"));
                objVoucher.setSDT(rs.getString("SDT"));
                objVoucher.setDiaChi(rs.getString("DiaChi"));
                objVoucher.setSoLanTichLuy(rs.getString("SoLanTichLuy"));
                objVoucher.setVoucher(rs.getString("Voucher"));

                
                lstVoucher.add(objVoucher);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoucherBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VoucherBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lstVoucher;
    }
    
    public ThongTinVoucher layChiTiet(String maThe){
            //Khia báo kết nối
            Connection conn = null;
            //Khai báo đối tượng
            ThongTinVoucher objVoucher = null;
        try {            
            
            conn=DataProvider.getConnection();
            
            //Khai báo 1 công việc
            String strSQL = "Select MaThe, LoaiThe, TenKhachHang, GioiTinh, SoCMT, SDT, DiaChi, SoLanTichLuy, Voucher from quanlithethanhvien where MaThe= '"+maThe+"'";
            
            Statement comm = conn.createStatement();
            
            ResultSet rs = comm.executeQuery(strSQL);
            
            while(rs.next()){
                objVoucher = new ThongTinVoucher();
                objVoucher.setMaThe(rs.getString("MaThe"));
                objVoucher.setLoaiThe(rs.getString("LoaiThe"));
                objVoucher.setTenKhachHang(rs.getString("TenKhachHang"));
                objVoucher.setGioiTinh(rs.getString("GioiTinh"));
                objVoucher.setSoCMT(rs.getString("SoCMT"));
                objVoucher.setSDT(rs.getString("SDT"));
                objVoucher.setDiaChi(rs.getString("DiaChi"));
                objVoucher.setSoLanTichLuy(rs.getString("SoLanTichLuy"));
                objVoucher.setVoucher(rs.getString("Voucher"));               
               


            }
        } catch (SQLException ex) {
            Logger.getLogger(VoucherBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VoucherBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return objVoucher;
    }
    
    public boolean themMoiVoucher(ThongTinVoucher objVoucher){
            Connection conn = null;        
        try {
            
            conn=DataProvider.getConnection();
            
            String strInsert = "Insert into quanlithethanhvien (MaThe, LoaiThe, TenKhachHang, GioiTinh, SoCMT, SDT, DiaChi, SoLanTichLuy, Voucher) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement comm = conn.prepareStatement(strInsert);
            
            //Gán giá trị cho các tham số
            comm.setString(1, objVoucher.getMaThe());
            comm.setString(2, objVoucher.getLoaiThe());
            comm.setString(3, objVoucher.getTenKhachHang());
            comm.setString(4, objVoucher.getGioiTinh());
            comm.setString(5, objVoucher.getSoCMT());
            comm.setString(6, objVoucher.getSDT());
            comm.setString(7, objVoucher.getDiaChi());
            comm.setString(8, objVoucher.getSoLanTichLuy());
            comm.setString(9, objVoucher.getVoucher());

            
            //Return trả về số dòng
            return comm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(VoucherBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VoucherBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;

    }
    
    public boolean capNhatVoucher(ThongTinVoucher objVoucher){
            Connection conn = null;        
        try {
            
            conn=DataProvider.getConnection();
            
            String strUpdate="Update quanlithethanhvien set LoaiThe=?, TenKhachHang=?, GioiTinh=?, SoCMT=?, SDT=?, DiaChi=?, SoLanTichLuy=?, Voucher=? where MaThe=?";
            PreparedStatement comm= conn.prepareStatement(strUpdate);
             
            //Gán giá trị cho các tham số (phải cùng thứ tự câu lệnh strUpdate)
            comm.setString(1, objVoucher.getLoaiThe());
            comm.setString(2, objVoucher.getTenKhachHang());
            comm.setString(3, objVoucher.getGioiTinh());
            comm.setString(4, objVoucher.getSoCMT());
            comm.setString(5, objVoucher.getSDT());
            comm.setString(6, objVoucher.getDiaChi());
            comm.setString(7, objVoucher.getSoLanTichLuy());
            comm.setString(8, objVoucher.getVoucher());
            comm.setString(9, objVoucher.getMaThe());
            

            
            //thực hiện công việc'
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(VoucherBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            //Đóng kết nối
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VoucherBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
        
    }
    
    public List<ThongTinVoucher> timKiemVoucher(String maThe){
        //Khia báo 1 danh sách
        List<ThongTinVoucher> lstVoucher = new ArrayList();
            
        Connection conn=null;
        try {            
            conn=DataProvider.getConnection();
            
            //Khia báo 1 công việc
            String strSQL = "Select MaThe, LoaiThe, TenKhachHang, GioiTinh, SoCMT, SDT, DiaChi, SoLanTichLuy, Voucher "+ " from quanlithethanhvien where 1=1";
            
            if(!maThe.isEmpty()){
                strSQL += " And (MaThe like '%"+maThe+"%' OR" + " TenKhachHang like '%"+maThe+"%')";
            }
  
            Statement comm=conn.createStatement();
            
            //Thực hiện và trả lại kết quả
            ResultSet rs = comm.executeQuery(strSQL);
            
            //Khai báo 1 dối tượng
            ThongTinVoucher objVoucher=null;
            
            //Đọc từng thông tin
            while(rs.next()){
                objVoucher = new ThongTinVoucher();
                objVoucher.setMaThe(rs.getString("MaThe"));
                objVoucher.setLoaiThe(rs.getString("LoaiThe"));
                objVoucher.setTenKhachHang(rs.getString("TenKhachHang"));
                objVoucher.setGioiTinh(rs.getString("GioiTinh"));
                objVoucher.setSoCMT(rs.getString("SoCMT"));
                objVoucher.setSDT(rs.getString("SDT"));
                objVoucher.setDiaChi(rs.getString("DiaChi"));
                objVoucher.setSoLanTichLuy(rs.getString("SoLanTichLuy"));
                objVoucher.setVoucher(rs.getString("Voucher"));   
                
 
                
                lstVoucher.add(objVoucher);
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
                    Logger.getLogger(VoucherBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        return lstVoucher;
    }
    
    public boolean xoaVoucher(String maThe){
        Connection conn= null;
   
        try {
            conn=DataProvider.getConnection();
            Statement comm=conn.createStatement();
            
            String strDelete = "Delete from quanlithethanhvien where MaThe = '"+ maThe +"'";
            
            //Thực hiện và trả về kết quả
            return comm.executeUpdate(strDelete)>0;
        } catch (SQLException ex) {
            Logger.getLogger(VoucherBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(VoucherBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }      
}
