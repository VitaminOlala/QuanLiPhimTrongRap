/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.nhanvien;

import Controller.nhanvien.DataProvider;
import Controller.nhanvien.ThongTinNhanVien;
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
public class NhanVienBusiness {

    List<ThongTinNhanVien> lstNv = new ArrayList();

    public List<ThongTinNhanVien> layDanhSach() {
        //Khai báo kết nối
        Connection conn = null;
        try {

            conn = DataProvider.getConnection();

            //Khai báo 1 công việc
            String strSQL = "SELECT * FROM `nhanvien`";

            Statement comm = conn.createStatement();

            //Thực hiện và trả về kết qu
            ResultSet rs = comm.executeQuery(strSQL);
            ThongTinNhanVien objPc = null;
            //Đọc từng dòng thông tin
            while (rs.next()) {
                objPc = new ThongTinNhanVien();
                //Gán giá trị cho các thuộc tính
                objPc.setMaNhanVien(rs.getString("MaNhanVien"));
                objPc.setTenNhanVien(rs.getString("TenNhanVien"));
                objPc.setNgaySinh(rs.getString("NgaySinh"));
                objPc.setGioiTinh(rs.getString("GioiTinh"));
                objPc.setSoCMT(rs.getString("SoCMT"));
                objPc.setChucVu(rs.getString("ChucVu"));
                objPc.setQueQuan(rs.getString("QueQuan"));
                objPc.setThuongTru(rs.getString("ThuongTru"));

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
                    Logger.getLogger(NhanVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return lstPc;

    }

    public ThongTinNhanVien layChiTiet(String maNv) {
        //Khai báo doi tuong
        ThongTinNhanVien objPc = null;

        //Khai báo kết nối
        Connection conn = null;
        try {
            conn = DataProvider.getConnection();

            //Khai báo 1 công viec
            String strSQL = "SELECT *" + " FROM `nhanvien` WHERE `MaNhanVien` = '" + maNv + "'";

            Statement comm = conn.createStatement();

            ResultSet rs = comm.executeQuery(strSQL);

            while (rs.next()) {
                //Khởi tạo đối tượng
                objPc = new ThongTinNhanVien();
                objPc.setMaNhanVien(rs.getString("MaNhanVien"));
                objPc.setTenNhanVien(rs.getString("TenNhanVien"));
                objPc.setNgaySinh(rs.getString("NgaySinh"));
                objPc.setGioiTinh(rs.getString("GioiTinh"));
                objPc.setSoCMT(rs.getString("SoCMT"));
                objPc.setChucVu(rs.getString("ChucVu"));
                objPc.setQueQuan(rs.getString("QueQuan"));
                objPc.setThuongTru(rs.getString("ThuongTru"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhanVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Đóng kết nối
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return objPc;
    }

    //Khi đã điền bảng thêm mới và chuyển vào bảng chính
    public boolean themMoiNhanVien(ThongTinNhanVien objPc) {
        Connection conn = null;
        try {
            conn = DataProvider.getConnection();

            //Bảng thêm mới có ô nước SX và lịch chiếu đặc biet
            String strInsert = "INSERT INTO `nhanvien` (`MaNhanVien`, `TenNhanVien`, `NgaySinh`, `GioiTinh`, `SoCMT`, `ChucVu`,`QueQuan`,`ThuongTru`) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement comm = conn.prepareStatement(strInsert);
            //Gán giá trị cho các tham số
            comm.setString(1, objPc.getMaNhanVien());
            comm.setString(2, objPc.getTenNhanVien());
            comm.setString(3, objPc.getNgaySinh());
            comm.setString(4, objPc.getGioiTinh());
            comm.setString(5, objPc.getSoCMT());
            comm.setString(6, objPc.getChucVu());
            comm.setString(7, objPc.getQueQuan());
            comm.setString(8, objPc.getThuongTru());

            //return trả về số dòng
            return comm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Đóng kết nối
            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    public boolean capNhatNhanVien(ThongTinNhanVien objNv) {
        Connection conn = null;
        try {

            conn = DataProvider.getConnection();

            String strUpdate = "UPDATE `nhanvien` set `TenNhanVien`=?, `NgaySinh`=?, `GioiTinh`=?, `SoCMT`=?, `ChucVu`=?, `QueQuan`=?, `ThuongTru`=? WHERE `MaNhanVien`=?";
            PreparedStatement comm = conn.prepareStatement(strUpdate);

            //Gán giá trị cho các tham số (phải cùng thứ tự câu lệnh strUpdate)
           
            comm.setString(1, objPc.getTenNhanVien());
            comm.setString(2, objPc.getNgaySinh());
            comm.setString(3, objPc.getGioiTinh());
            comm.setString(4, objPc.getSoCMT());
            comm.setString(5, objPc.getChucVu());
            comm.setString(6, objPc.getQueQuan());
            comm.setString(7, objPc.getThuongTru());
            comm.setString(8, objPc.getMaNhanVien());

            //thực hiện công việc'
            return comm.executeUpdate() > 0;
//            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Đóng kết nối
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;

    }

    public List<ThongTinNhanVien> timKiemNhanVien(String timTen) {
        //Khia báo 1 danh sách
        List<ThongTinNhanVien> lstNv = new ArrayList();

        Connection conn = null;
        try {
            conn = DataProvider.getConnection();

            //Khia báo 1 công việc
            String strSQL = "SELECT `MaNhanVien`, `TenNhanVien`, `NgaySinh`, `GioiTinh`, `SoCMT`, `ChucVu`, `QueQuan`, `ThuongTru`" + " FROM `nhanvien` WHERE 1=1";

            if (!timTen.isEmpty()) {
                strSQL += " And (`TenNhanVien` LIKE '%" + timTen + "%')";
            }

            Statement comm = conn.createStatement();

            //Thực hiện và trả lại kết quả
            ResultSet rs = comm.executeQuery(strSQL);

            //Khai báo 1 dối tượng
            ThongTinNhanVien objPc = null;

            //Đọc từng thông tin
            while (rs.next()) {
                objPc = new ThongTinNhanVien();
                objPc.setMaNhanVien(rs.getString("MaNhanVien"));
                objPc.setTenNhanVien(rs.getString("TenNhanVien"));
                objPc.setNgaySinh(rs.getString("NgaySinh"));
                objPc.setGioiTinh(rs.getString("GioiTinh"));
                objPc.setSoCMT(rs.getString("SoCMT"));
                objPc.setChucVu(rs.getString("ChucVu"));
                objPc.setQueQuan(rs.getString("QueQuan"));
                objPc.setThuongTru(rs.getString("ThuongTru"));
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
                Logger.getLogger(NhanVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lstPc;
    }

    public boolean xoaNhanVien(String maNv) {
        Connection conn = null;

        try {
            conn = DataProvider.getConnection();
            Statement comm = conn.createStatement();

            String strDelete = "DELETE FROM `nhanvien` WHERE `MaNhanVien` = '" + maNv + "'";

            //Thực hiện và trả về kết quả
            return comm.executeUpdate(strDelete) > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NhanVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public List<ThongTinNhanVien> sapXepNhanVien() {
        List<ThongTinNhanVien> lstNv = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DataProvider.KetNoi();
            String strSQL = "SELECT * FROM `nhanvien` ORDER BY `TenNhanVien`";

            Statement comm = conn.createStatement();
            ResultSet rs = comm.executeQuery(strSQL);
            NhanVienBusiness objNv = null;

            while(rs.next()) {
                objNv = new NhanVienBusiness();
                objNv.setMaNhanVien(rs.getString("MaNhanVien"));
                objNv.setTenNhanVien(rs.getString("TenNhanVien"));
                objNv.setNgaySinh(rs.getString("NgaySinh"));
                objNv.setGioiTinh(rs.getString("GioiTinh"));
                objNv.setSoCMT(rs.getString("SoCMT"));
                objNv.setChucVu(rs.getString("ChucVu"));
                objNv.setQueQuan(rs.getString("QueQuan"));
                objNv.setThuongTru(rs.getString("ThuongTru"));
            }
        } catch (SQLException ex) {
            System.out.println("Có lỗi xảy ra trong quá trình làm việc với mysql." + "Chi tiết: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienBusiness.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lstNv;
    }
}
