/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.phim;

import java.sql.Date;

/**
 *
 * @author Acer
 */
public class ThongTin {

    public String getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(String maPhim) {
        this.maPhim = maPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }



    public String getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(String phongChieu) {
        this.phongChieu = phongChieu;
    }



    public String getTenDaoDien() {
        return tenDaoDien;
    }

    public void setTenDaoDien(String tenDaoDien) {
        this.tenDaoDien = tenDaoDien;
    }

    public String getTenDienVien() {
        return tenDienVien;
    }

    public void setTenDienVien(String tenDienVien) {
        this.tenDienVien = tenDienVien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNuocSanXuat() {
        return nuocSanXuat;
    }

    public void setNuocSanXuat(String nuocSanXuat) {
        this.nuocSanXuat = nuocSanXuat;
    }
    private String maPhim = "";
    private String tenPhim = "";
    private String theLoai = "";
    private String runTime = "";

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
    private String thoiGian = "";
    private String phongChieu = "";

    public String getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(String soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }
    private String soLuongGhe = "";
    private String tenDaoDien = "";
    private String tenDienVien = "";
    private String moTa = "";
    private String nuocSanXuat= "";

    public String getMaDoTuoi() {
        return maDoTuoi;
    }

    public void setMaDoTuoi(String maDoTuoi) {
        this.maDoTuoi = maDoTuoi;
    }
    private String maDoTuoi;
}
