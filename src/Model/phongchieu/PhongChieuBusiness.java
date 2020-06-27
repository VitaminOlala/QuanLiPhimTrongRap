/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.phongchieu;


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
public class PhongChieuBusiness {

    List<ThongTinPhongChieu> lstPc = new ArrayList();

    public List<ThongTinPhongChieu> layDanhSach() {
        //Khai báo kết nối
        Connection conn = null;
        try {

            conn = DataProvider.getConnection();

            //Khai báo 1 công việc
            String strSQL = "Select MaPhongChieu, SoCho, MayChieu, AmThanh, DienTich, TinhTrang from quanliphongchieu";

            Statement comm = conn.createStatement();

            //Thực hiện và trả về kết qu
            ResultSet rs = comm.executeQuery(strSQL);
            ThongTinPhongChieu objPc = null;
            //Đọc từng dòng thông tin
            while (rs.next()) {
                objPc = new ThongTinPhongChieu();
                //Gán giá trị cho các thuộc tính
                objPc.setMaPhongChieu(rs.getString("MaPhongChieu"));
                objPc.setSoCho(rs.getString("SoCho"));
                objPc.setMayChieu(rs.getString("MayChieu"));
                objPc.setAmThanh(rs.getString("AmThanh"));
                objPc.setDienTich(rs.getString("DienTich"));
                objPc.setTinhTrang(rs.getString("TinhTrang"));

                //Them vào danh sách
                lstPc.add(objPc);
            }

        } catch (SQLException ex) {
            System.out.println("Có lỗi xảy ra .Chi tiết: " + ex.getMessage());;
        } finally {
            //ĐÓng kết nối
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongChieuBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return lstPc;

    }

    public ThongTinPhongChieu layChiTiet(String maPc) {
        //Khai báo doi tuong
        ThongTinPhongChieu objPc = null;

        //Khai báo kết nối
        Connection conn = null;
        try {
            conn = DataProvider.getConnection();

            //Khai báo 1 công viec
            String strSQL = "Select MaPhongChieu, SoCho, MayChieu, AmThanh, DienTich, TinhTrang" + " from quanliphongchieu where MaPhongChieu = '" + maPc + "'";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            while (rs.next()) {
                //Khởi tạo đối tượng
                objPc = new ThongTinPhongChieu();
                objPc.setMaPhongChieu(rs.getString("MaPhongChieu"));
                objPc.setSoCho(rs.getString("SoCho"));
                objPc.setMayChieu(rs.getString("MayChieu"));
                objPc.setAmThanh(rs.getString("AmThanh"));
                objPc.setDienTich(rs.getString("DienTich"));
                objPc.setTinhTrang(rs.getString("TinhTrang"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PhongChieuBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Đóng kết nối
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongChieuBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return objPc;
    }

    //Khi đã điền bảng thêm mới và chuyển vào bảng chính
    public boolean themMoiPhongChieu(ThongTinPhongChieu objPc) {
        Connection conn = null;
        try {
            conn = DataProvider.getConnection();

            //Bảng thêm mới có ô nước SX và lịch chiếu đặc biet
            String strInsert = "Insert into quanliphongchieu (MaPhongChieu, SoCho, MayChieu, AmThanh, DienTich, TinhTrang) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement comm = conn.prepareStatement(strInsert);
            //Gán giá trị cho các tham số
            comm.setString(1, objPc.getMaPhongChieu());
            comm.setString(2, objPc.getSoCho());
            comm.setString(3, objPc.getMayChieu());
            comm.setString(4, objPc.getAmThanh());
            comm.setString(5, objPc.getDienTich());
            comm.setString(6, objPc.getTinhTrang());

            //return trả về số dòng
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhongChieuBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Đóng kết nối
            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhongChieuBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    public boolean capNhatPhongChieu(ThongTinPhongChieu objPc) {
        Connection conn = null;
        try {

            conn = DataProvider.getConnection();

            String strUpdate = "Update quanliphongchieu set SoCho=?, MayChieu=?, AmThanh=?, DienTich=?, TinhTrang=? where MaPhongChieu=?";
            PreparedStatement comm = conn.prepareStatement(strUpdate);

            //Gán giá trị cho các tham số (phải cùng thứ tự câu lệnh strUpdate)
           
            comm.setString(1, objPc.getSoCho());
            comm.setString(2, objPc.getMayChieu());
            comm.setString(3, objPc.getAmThanh());
            comm.setString(4, objPc.getDienTich());
            comm.setString(5, objPc.getTinhTrang());
            comm.setString(6, objPc.getMaPhongChieu());

            //thực hiện công việc'
            return comm.executeUpdate() > 0;
//            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PhongChieuBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Đóng kết nối
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongChieuBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;

    }

    public List<ThongTinPhongChieu> timKiemPhongChieu(String timTen) {
        //Khia báo 1 danh sách
        List<ThongTinPhongChieu> lstPc = new ArrayList();

        Connection conn = null;
        try {
            conn = DataProvider.getConnection();

            //Khia báo 1 công việc
            String strSQL = "Select MaPhongChieu, SoCho, MayChieu, AmThanh, DienTich, TinhTrang" + " from quanliphongchieu where 1=1";

            if (!timTen.isEmpty()) {
                strSQL += " And (MaPhongChieu like '%" + timTen + "%' OR" + " TinhTrang like '%" + timTen + "%')";
            }

            Statement comm = conn.createStatement();

            //Thực hiện và trả lại kết quả
            ResultSet rs = comm.executeQuery(strSQL);

            //Khai báo 1 dối tượng
            ThongTinPhongChieu objPc = null;

            //Đọc từng thông tin
            while (rs.next()) {
                objPc = new ThongTinPhongChieu();
                objPc.setMaPhongChieu(rs.getString("MaPhongChieu"));
                objPc.setSoCho(rs.getString("SoCho"));
                objPc.setMayChieu(rs.getString("MayChieu"));
                objPc.setAmThanh(rs.getString("AmThanh"));
                objPc.setDienTich(rs.getString("DienTich"));
                objPc.setTinhTrang(rs.getString("TinhTrang"));
                lstPc.add(objPc);
            }
        } catch (SQLException ex) {
            System.out.println("Có lỗi xảy ra trong quá trình làm việc với mysql." + "Chi tiết: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhongChieuBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lstPc;
    }

    public boolean xoaPhongChieu(String maPc) {
        Connection conn = null;

        try {
            conn = DataProvider.getConnection();
            Statement comm = conn.createStatement();

            String strDelete = "Delete from quanliphongchieu where MaPhongChieu = '" + maPc + "'";

            //Thực hiện và trả về kết quả
            return comm.executeUpdate(strDelete) > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhongChieuBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PhongChieuBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
