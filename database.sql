-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 26, 2020 lúc 05:31 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanli_rap`
--
CREATE DATABASE IF NOT EXISTS `quanli_rap` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `quanli_rap`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `banvetheophim`
--

CREATE TABLE `banvetheophim` (
  `MaVe` char(20) NOT NULL,
  `MaPhim` char(10) DEFAULT NULL,
  `Time` varchar(30) DEFAULT NULL,
  `RunTime` varchar(45) DEFAULT NULL,
  `GiaVe` varchar(45) DEFAULT NULL,
  `Voucher` char(11) DEFAULT NULL,
  `MaPhongChieu` char(12) DEFAULT NULL,
  `MaNhanVien` char(13) DEFAULT NULL,
  `MaGhe` char(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `banvetheophim`
--

INSERT INTO `banvetheophim` (`MaVe`, `MaPhim`, `Time`, `RunTime`, `GiaVe`, `Voucher`, `MaPhongChieu`, `MaNhanVien`, `MaGhe`) VALUES
('V1', 'KO1', '2020-06-23 13:20:00', '1h20', '200000', '15%', 'A1', 'NV1', 'VIP1'),
('V2', 'KO1', '2020-06-23 14:50:00', '2h30', '75000', '30%', 'A1', 'NV1', 'NOR'),
('V3', 'KO2', '2020-06-23 10:00:00', '1h50', '50000', 'Không có', 'A2', 'NV2', 'NOR'),
('V4', 'KO3', '2020-06-23 11:30:00', '2h10', '300000', 'Không có', 'A2', 'NV1', 'VIP2'),
('V5', 'KO3', '2020-06-23 12:00:00', '1h10', '75000', '50%', 'A3', 'NV3', 'NOR'),
('V6', 'KO4', '2020-06-23 17:30:00', '3h10', '210000', '100%', 'A3', 'NV3', 'VIP1'),
('V7', 'KO4', NULL, '2h30', '400000', '15%', 'A4', 'NV4', 'VIP1'),
('V8', 'KO4', '12:30', '1h40', '455555', 'Không có', 'A1', 'NV3', 'NOR');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dotuoi`
--

CREATE TABLE `dotuoi` (
  `MaDoTuoi` char(10) NOT NULL,
  `DoTuoi` varchar(145) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `dotuoi`
--

INSERT INTO `dotuoi` (`MaDoTuoi`, `DoTuoi`) VALUES
('12-', 'Mọi lứa tuổi'),
('16+', 'Dành cho thanh thiếu niên'),
('18+', 'Không dành cho người dưới 18 tuổi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ghe`
--

CREATE TABLE `ghe` (
  `MaGhe` char(14) NOT NULL,
  `Ghe` varchar(45) DEFAULT ' NULL'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ghe`
--

INSERT INTO `ghe` (`MaGhe`, `Ghe`) VALUES
('NOR', 'Ghế thường'),
('VIP1', 'Ghế Vip'),
('VIP2', 'Thương gia'),
('VIP3', 'Ghế đôi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
--

CREATE TABLE `nguoidung` (
  `ID` int(11) NOT NULL,
  `TenDangNhap` varchar(100) DEFAULT NULL,
  `MatKhau` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nguoidung`
--

INSERT INTO `nguoidung` (`ID`, `TenDangNhap`, `MatKhau`) VALUES
(1, 'admin', '123'),
(2, 'admin1', '1234');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` char(13) NOT NULL,
  `TenNhanVien` varchar(145) DEFAULT NULL,
  `NgaySinh` varchar(100) DEFAULT NULL,
  `GioiTinh` varchar(45) DEFAULT NULL,
  `SoCMT` varchar(45) DEFAULT NULL,
  `ChucVu` varchar(145) DEFAULT NULL,
  `QueQuan` varchar(145) DEFAULT NULL,
  `ThuongTru` varchar(145) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNhanVien`, `TenNhanVien`, `NgaySinh`, `GioiTinh`, `SoCMT`, `ChucVu`, `QueQuan`, `ThuongTru`) VALUES
('NV1', 'Quách Đình Quang', '1999-03-02', 'Nam', '5654', 'Nhan vien ban ve', 'Thai Binh', 'Vinh Hung'),
('NV2', 'Quách Đình Tuan', '1999-12-12', 'Nam', '5653564', 'Nhan vien ban ve', 'Thai Binh', 'Vinh Hung'),
('NV3', 'Quách Đình Huy', '2001-10-20', 'Nu', '45463', 'Nhan vien ban do an', 'Ca Mau', 'Yen So'),
('NV4', 'Le Thi La', '2000-11-02', 'Nu', '5557654', 'Quan li', 'Hung Yen', 'O Cho Dua');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quanli`
--

CREATE TABLE `quanli` (
  `MaPhim` char(10) NOT NULL,
  `TenPhim` varchar(145) DEFAULT NULL,
  `TheLoai` varchar(145) DEFAULT NULL,
  `LichChieu` date DEFAULT NULL,
  `TenDaoDien` varchar(145) DEFAULT NULL,
  `TenDienVien` varchar(145) DEFAULT NULL,
  `MoTa` varchar(500) DEFAULT NULL,
  `Nuoc` varchar(45) DEFAULT NULL,
  `MaDoTuoi` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `quanli`
--

INSERT INTO `quanli` (`MaPhim`, `TenPhim`, `TheLoai`, `LichChieu`, `TenDaoDien`, `TenDienVien`, `MoTa`, `Nuoc`, `MaDoTuoi`) VALUES
('KO1', 'Mắt biếc', 'Tình cảm, Tâm lí', '2019-04-04', 'Tuấn', 'Quang, Huy', 'Câu chuyện tình cảm', 'Việt Nam', '18+'),
('KO2', 'Hatena Illusion', 'Hành động, Tình cảm', '2019-05-12', 'Tuấn Anh', 'Hiệu', 'Câu chuyện xoay quanh Makoto Shiranui', 'Nhật Bản', '16+'),
('KO3', 'Sóng ghi âm', 'Hoạt hình', '2020-12-12', 'Đình Quang', 'Linh , Asuna', 'Câu chuyện được diễn ra tại Sapporo, Hokkaido', 'Nhật Bản', '12-'),
('KO4', '2 phút nổi tiếng', 'Hài, Tình cảm', '2020-06-07', 'Anh Duy', 'Justin, Amanda', 'Anh chàng viết truyện tranh bất ngờ đạt được tương tác khi số lượt xem tăng nhanh chóng mặt', 'Mỹ', '18+'),
('KO5', 'Âm khí', 'Kinh dị, Tâm lí', '2021-12-13', 'Cao Tiến Minh', 'Ngụy Nguy, Ngô Giai Hi', 'Bộ phim kể về hành trinh Na Tra', 'Trung Quốc', '16+'),
('KO6', 'dgf', 'fdggfd', '2020-06-25', 'fgfd', 'fdgfd', '', 'gfdfgd', '16+');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quanliphongchieu`
--

CREATE TABLE `quanliphongchieu` (
  `MaPhongChieu` char(12) NOT NULL,
  `SoCho` varchar(50) DEFAULT NULL,
  `MayChieu` varchar(10) DEFAULT NULL,
  `AmThanh` varchar(10) DEFAULT NULL,
  `DienTich` varchar(10) DEFAULT NULL,
  `TinhTrang` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `quanliphongchieu`
--

INSERT INTO `quanliphongchieu` (`MaPhongChieu`, `SoCho`, `MayChieu`, `AmThanh`, `DienTich`, `TinhTrang`) VALUES
('A1', '100', 'Loại A', 'Loại C', '200m2', 'Tốt'),
('A2', '120', 'Loại B', 'Loại B', '230m2', 'Khá'),
('A3', '150', 'Loại C', 'Loại C', '250m2', 'Tốt'),
('A4', '9', 'Loại D', 'Loại A', '280m2', 'Tốt'),
('A5', 'fggf', 'dfg', 'fgdgf', 'fgd', 'gffgd'),
('A6', '110', 'Loại A', 'Loại A', '280m2', 'Tốt');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quanlithethanhvien`
--

CREATE TABLE `quanlithethanhvien` (
  `MaThe` char(25) NOT NULL,
  `LoaiThe` varchar(50) DEFAULT NULL,
  `TenKhachHang` varchar(200) DEFAULT NULL,
  `GioiTinh` varchar(10) DEFAULT NULL,
  `SoCMT` varchar(20) DEFAULT NULL,
  `SDT` varchar(20) DEFAULT NULL,
  `DiaChi` varchar(200) DEFAULT NULL,
  `SoLanTichLuy` varchar(100) DEFAULT NULL,
  `Voucher` char(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `quanlithethanhvien`
--

INSERT INTO `quanlithethanhvien` (`MaThe`, `LoaiThe`, `TenKhachHang`, `GioiTinh`, `SoCMT`, `SDT`, `DiaChi`, `SoLanTichLuy`, `Voucher`) VALUES
('MT1', 'HS-SV', 'Quách Đình Quang', 'Nam', '3464', '425464', 'Số 6 Vĩnh Hưng', '2', '15%'),
('MT2', 'HS-SV', 'Nguyễn Anh Tuấn', 'Nam', '34644', '4256464', 'Số 1 Vĩnh Hưng', '20', '50%'),
('MT3', 'Trên 22 tuổi', 'Nguyễn Hạ Linh', 'Nữ', '434', '4364', 'Số 9 Mai Động', '10', '30%'),
('MT4', 'Trên 22 tuổi', 'Lê Hữu Hiệu', 'Nam', '3436664', '4325464', 'Số 61 Tân Mai', '100', '100%');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongkedoanhthu`
--

CREATE TABLE `thongkedoanhthu` (
  `MaPhim` char(10) NOT NULL,
  `TenPhim` varchar(145) DEFAULT NULL,
  `SoBuoiChieu` varchar(100) DEFAULT NULL,
  `SoVeBanRa` varchar(100) DEFAULT NULL,
  `TongDoanhThu` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `thongkedoanhthu`
--

INSERT INTO `thongkedoanhthu` (`MaPhim`, `TenPhim`, `SoBuoiChieu`, `SoVeBanRa`, `TongDoanhThu`) VALUES
('KO1', 'Mắt biếc', '25', '1000', '1232323'),
('KO2', 'Hatena Illusion', '25', '2000', '12323243'),
('KO3', 'Sóng ghi âm', '25', '1000', '1232323'),
('KO4', '2 phút nổi tiếng', '25', '1000', '1232323'),
('KO5', 'Âm khí', '25', '1000', '1232323'),
('KO6', 'strtr', '34544444', '435345', '4354');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `banvetheophim`
--
ALTER TABLE `banvetheophim`
  ADD PRIMARY KEY (`MaVe`),
  ADD KEY `MaPhim` (`MaPhim`),
  ADD KEY `MaGhe` (`MaGhe`),
  ADD KEY `MaNhanVien` (`MaNhanVien`),
  ADD KEY `MaPhongChieu` (`MaPhongChieu`);

--
-- Chỉ mục cho bảng `dotuoi`
--
ALTER TABLE `dotuoi`
  ADD PRIMARY KEY (`MaDoTuoi`);

--
-- Chỉ mục cho bảng `ghe`
--
ALTER TABLE `ghe`
  ADD PRIMARY KEY (`MaGhe`);

--
-- Chỉ mục cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNhanVien`);

--
-- Chỉ mục cho bảng `quanli`
--
ALTER TABLE `quanli`
  ADD PRIMARY KEY (`MaPhim`),
  ADD KEY `MaDoTuoi` (`MaDoTuoi`);

--
-- Chỉ mục cho bảng `quanliphongchieu`
--
ALTER TABLE `quanliphongchieu`
  ADD PRIMARY KEY (`MaPhongChieu`);

--
-- Chỉ mục cho bảng `quanlithethanhvien`
--
ALTER TABLE `quanlithethanhvien`
  ADD PRIMARY KEY (`MaThe`);

--
-- Chỉ mục cho bảng `thongkedoanhthu`
--
ALTER TABLE `thongkedoanhthu`
  ADD PRIMARY KEY (`MaPhim`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `banvetheophim`
--
ALTER TABLE `banvetheophim`
  ADD CONSTRAINT `banvetheophim_ibfk_1` FOREIGN KEY (`MaPhim`) REFERENCES `quanli` (`MaPhim`),
  ADD CONSTRAINT `banvetheophim_ibfk_2` FOREIGN KEY (`MaPhim`) REFERENCES `quanli` (`MaPhim`),
  ADD CONSTRAINT `banvetheophim_ibfk_3` FOREIGN KEY (`MaGhe`) REFERENCES `ghe` (`MaGhe`),
  ADD CONSTRAINT `banvetheophim_ibfk_4` FOREIGN KEY (`MaGhe`) REFERENCES `ghe` (`MaGhe`),
  ADD CONSTRAINT `banvetheophim_ibfk_5` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`),
  ADD CONSTRAINT `banvetheophim_ibfk_6` FOREIGN KEY (`MaPhongChieu`) REFERENCES `quanliphongchieu` (`MaPhongChieu`);

--
-- Các ràng buộc cho bảng `quanli`
--
ALTER TABLE `quanli`
  ADD CONSTRAINT `quanli_ibfk_1` FOREIGN KEY (`MaDoTuoi`) REFERENCES `dotuoi` (`MaDoTuoi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
