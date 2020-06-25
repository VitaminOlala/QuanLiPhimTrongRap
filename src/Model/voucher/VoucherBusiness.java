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
                objVoucher.setVoucher(rs.getString("TongDoanhThu"));

                
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
                    Logger.getLogger(ThongKeBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lstThongKe;
    }
    
    public ThongTinThongKe layChiTiet(String matk){
            //Khia báo kết nối
            Connection conn = null;
            //Khai báo đối tượng
            ThongTinThongKe objtk = null;
        try {            
            
            conn=DataProvider.getConnection();
            
            //Khai báo 1 công việc
            String strSQL = "Select MaPhim, TenPhim, SoBuoiChieu, SoVeBanRa, TongDoanhThu from thongkedoanhthu where MaPhim= '"+matk+"'";
            
            Statement comm = conn.createStatement();
            
            ResultSet rs = comm.executeQuery(strSQL);
            
            while(rs.next()){
                objtk = new ThongTinThongKe();
                objtk.setMaPhim(rs.getString("MaPhim"));
                objtk.setTenPhim(rs.getString("TenPhim"));

                objtk.setSoBuoiChieu(rs.getString("SoBuoiChieu"));
                objtk.setSoVeBanRa(rs.getString("SoVeBanRa"));
                objtk.setTongDoanhThu(rs.getString("TongDoanhThu"));                


            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return objtk;
    }
    
    public boolean themMoiThongKe(ThongTinThongKe objtk){
            Connection conn = null;        
        try {
            
            conn=DataProvider.getConnection();
            
            String strInsert = "Insert into thongkedoanhthu (MaPhim, TenPhim, SoBuoiChieu, SoVeBanRa, TongDoanhThu) values(?, ?, ?, ?, ?)";
            PreparedStatement comm = conn.prepareStatement(strInsert);
            
            //Gán giá trị cho các tham số
            comm.setString(1, objtk.getMaPhim());
            comm.setString(2, objtk.getTenPhim());
            comm.setString(3, objtk.getSoBuoiChieu());
            comm.setString(4, objtk.getSoVeBanRa());
            comm.setString(5, objtk.getTongDoanhThu());

            
            //Return trả về số dòng
            return comm.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ThongKeBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;

    }
    
    public boolean capNhatThongKe(ThongTinThongKe objtk){
            Connection conn = null;        
        try {
            
            conn=DataProvider.getConnection();
            
            String strUpdate="Update thongkedoanhthu set TenPhim=?, SoBuoiChieu=?, SoVeBanRa=?, TongDoanhThu=? where MaPhim=?";
            PreparedStatement comm= conn.prepareStatement(strUpdate);
             
            //Gán giá trị cho các tham số (phải cùng thứ tự câu lệnh strUpdate)
            comm.setString(1, objtk.getTenPhim());
            comm.setString(2, objtk.getSoBuoiChieu());
            comm.setString(3, objtk.getSoVeBanRa());
            comm.setString(4, objtk.getTongDoanhThu());
            comm.setString(5, objtk.getMaPhim());

            
            //thực hiện công việc'
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            //Đóng kết nối
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
        
    }
    
    public List<ThongTinThongKe> timKiemThongKe(String maPhim){
        //Khia báo 1 danh sách
        List<ThongTinThongKe> lstThongKe = new ArrayList();
            
        Connection conn=null;
        try {            
            conn=DataProvider.getConnection();
            
            //Khia báo 1 công việc
            String strSQL = "Select MaPhim, TenPhim, SoBuoiChieu, SoVeBanRa, TongDoanhThu "+ " from thongkedoanhthu where 1=1";
            
            if(!maPhim.isEmpty()){
                strSQL += " And (MaPhim like '%"+maPhim+"%' OR" + " TenPhim like '%"+maPhim+"%')";
            }
  
            Statement comm=conn.createStatement();
            
            //Thực hiện và trả lại kết quả
            ResultSet rs = comm.executeQuery(strSQL);
            
            //Khai báo 1 dối tượng
            ThongTinThongKe objtk=null;
            
            //Đọc từng thông tin
            while(rs.next()){
                objtk = new ThongTinThongKe();
                objtk.setMaPhim(rs.getString("MaPhim"));
                objtk.setTenPhim(rs.getString("TenPhim"));

                objtk.setSoBuoiChieu(rs.getString("SoBuoiChieu"));
                objtk.setSoVeBanRa(rs.getString("SoVeBanRa"));
                objtk.setTongDoanhThu(rs.getString("TongDoanhThu"));  
                
                lstThongKe.add(objtk);
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
                    Logger.getLogger(ThongKeBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        return lstThongKe;
    }
    
    public boolean xoaThongKe(String matk){
        Connection conn= null;
   
        try {
            conn=DataProvider.getConnection();
            Statement comm=conn.createStatement();
            
            String strDelete = "Delete from thongkedoanhthu where MaPhim = '"+ matk +"'";
            
            //Thực hiện và trả về kết quả
            return comm.executeUpdate(strDelete)>0;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }      
}
