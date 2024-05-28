USE master
--DROP DATABASE QUANLYHIEUTHUOCTAYK3TD
GO
CREATE DATABASE QUANLYHIEUTHUOCTAYK3TD
GO
USE QUANLYHIEUTHUOCTAYK3TD

GO
CREATE TABLE NhaCungCap (
	MaNhaCungCap VARCHAR(7) PRIMARY KEY,
	TenNhaCungCap NVARCHAR(50) NOT NULL,
	SoDienThoai VARCHAR(10) ,
	DiaChi NVARCHAR(100) ,
	Email VARCHAR(50) ,
	GhiChu NVARCHAR(500),
	TrangThai VARCHAR(20) DEFAULT 'DANG_HOAT_DONG'
);

GO
CREATE TABLE NhomHang (
	MaNhomHang  INT PRIMARY KEY IDENTITY (1, 1),
	TenNhomHang NVARCHAR(100) NOT NULL
);

GO
CREATE TABLE DonThuocMau (
	MaDonThuocMau VARCHAR(7) PRIMARY KEY,
	TenDonThuocMau NVARCHAR(50) NOT NULL,
	NgayBatDauApDung DATE,
	GhiChu NVARCHAR(500),
	TrangThai VARCHAR(20) DEFAULT 'HOAT_DONG'
);

GO
CREATE TABLE KhachHang (
	MaKhachHang VARCHAR(7) PRIMARY KEY,
	TenKhachHang NVARCHAR(50) NOT NULL,
	NgaySinh DATE,
	GioiTinh BIT,
	SoDienThoai VARCHAR(10) NOT NULL,
	DiemThuong INT DEFAULT 0,
	NgayTao DATE DEFAULT GETDATE(),
	GhiChu NVARCHAR(500),
	TrangThai VARCHAR(20) DEFAULT 'DANG_HOAT_DONG' 
);

GO
CREATE TABLE NhanVien (
	MaNhanVien VARCHAR(7) PRIMARY KEY,
	TenNhanVien NVARCHAR(50) NOT NULL,
	NgaySinh DATE,
	GioiTinh BIT,
	SoDienThoai VARCHAR(10) NOT NULL,
	MatKhau VARCHAR(500) DEFAULT '0000',
	NgayTao DATE DEFAULT GETDATE(),
	GhiChu NVARCHAR(500),
	ChucVu NVARCHAR(20) DEFAULT 'NhanVien',
	TrangThai VARCHAR(20) DEFAULT 'DANG_HOAT_DONG' 
);

GO
CREATE TABLE Ca (
	MaCa VARCHAR(7) PRIMARY KEY,
	TenCa NVARCHAR(50) ,
	MaNhanVien VARCHAR(7) FOREIGN KEY REFERENCES NhanVien(MaNhanVien) NOT NULL,
	ThoiGianVaoCa DATETIME DEFAULT GETDATE(),
	ThoiGianKetCa DATETIME ,
	TongTien REAL ,
	TongTienThucTe REAL ,
	GhiChu NVARCHAR(500),
	TrangThai bit default 0,
	TienChenhLech REAL DEFAULT 0 
);

Go
CREATE TABLE HangHoa (
	MaHangHoa VARCHAR(7) PRIMARY KEY,
	TenHangHoa NVARCHAR(50) NOT NULL,
	LoaiHang NVARCHAR(50),
	SoDangKy VARCHAR(50),
	MaNhomHang INT FOREIGN KEY REFERENCES NhomHang(MaNhomHang),
	NuocSanXuat NVARCHAR(50),
	HangSanXuat NVARCHAR(100),
	HoatChatChinh NVARCHAR(200),
	HamLuong NVARCHAR(50),
	QuyCachDongGoi NVARCHAR(50),
	MoTa NVARCHAR(500),
	Thue REAL DEFAULT 10,
	SoLuongDinhMuc INT,
	SoLuongCanhBao INT,
	TrangThai VARCHAR(20) DEFAULT 'DANG_BAN' 
);

GO
CREATE TABLE DonViTinh(
	MaDonViTinh int PRIMARY KEY IDENTITY(1,1),
	TenDonViTinh NVARCHAR(50) NOT NULL,
	MaHangHoa VARCHAR(7) FOREIGN KEY REFERENCES HangHoa(MaHangHoa) ON DELETE CASCADE NOT NULL,
	QuyDoi INT DEFAULT 1,
	GiaBan REAL,
	MaVach VARCHAR(50),
	TrangThaiDonViTinh VARCHAR(20) DEFAULT 'DANG_BAN' 
);

GO
CREATE TABLE LoHang (
	SoLo VARCHAR(20) PRIMARY KEY,
	MaHangHoa VARCHAR(7) FOREIGN KEY REFERENCES HangHoa(MaHangHoa) NOT NULL,
	SoLuong INT NOT NULL,
	NgaySanXuat DATE NOT NULL,
	HanSuDung DATE NOT NULL,
	GiaNhap REAL NOT NULL,
	MaNhaCungCap VARCHAR(7) FOREIGN KEY REFERENCES NhaCungCap(MaNhaCungCap) NOT NULL,
);

GO
CREATE TABLE HoaDon (
	MaHoaDon VARCHAR(12) PRIMARY KEY,
	ThoiGianLapHoaDon DATETIME DEFAULT GETDATE() NOT NULL,
	MaNhanVien VARCHAR(7) FOREIGN KEY REFERENCES NhanVien(MaNhanVien) NOT NULL,
	MaKhachHang VARCHAR(7) FOREIGN KEY REFERENCES KhachHang(MaKhachHang),
	TienKhachTra REAL,
	DiemQuyDoi INT DEFAULT 0,
	TongTien REAL NOT NULL,
	ThanhTien REAL,
	TienThua REAL DEFAULT 0,
	GhiChu NVARCHAR(500),
	MaCa VARCHAR(7) FOREIGN KEY REFERENCES Ca(MaCa),
	TrangThai VARCHAR(20) DEFAULT 'HOAN_THANH'
);
GO
CREATE TABLE ChiTietHoaDon (
	MaHoaDon VARCHAR(12) NOT NULL,
	MaDonViTinh INT NOT NULL,
	SoLuong INT NOT NULL,
	DonGia REAL NOT NULL,
	ThanhTien REAL NOT NULL
	PRIMARY KEY (MaHoaDon, MaDonViTinh)
    CONSTRAINT FK_ChiTietHoaDon_HoaDon FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    CONSTRAINT FK_ChiTietHoaDon_DonViTinh FOREIGN KEY (MaDonViTinh) REFERENCES DonViTinh(MaDonViTinh)
);

GO
CREATE TABLE DonThuoc(
	MaDonThuoc VARCHAR(20) PRIMARY KEY,
	MaHoaDon VARCHAR(12) FOREIGN KEY REFERENCES HoaDon(MaHoaDon) ON DELETE CASCADE NOT NULL,
	LinkHinh VARCHAR(100)
);

GO
CREATE TABLE PhieuTraHang(
	MaPhieuTraHang VARCHAR(12) PRIMARY KEY,
	ThoiGianTao DATETIME DEFAULT GETDATE(),
	MaHoaDon VARCHAR(12) FOREIGN KEY REFERENCES HoaDon(MaHoaDon) NOT NULL,
	GhiChu NVARCHAR(500),
	MaCa VARCHAR(7) FOREIGN KEY REFERENCES Ca(MaCa),
	MaNhanVien VARCHAR(7) FOREIGN KEY REFERENCES NhanVien(MaNhanVien),
	TongTien REAL,
	TrangThai VARCHAR(20) DEFAULT 'HOAN_THANH'
);

GO
CREATE TABLE ChiTietPhieuTraHang(
	MaPhieuTraHang VARCHAR(12),
	SoLuongTra INT DEFAULT 1,
	DonGia real,
	MaDonViTinh INT,
	LyDoTra NVARCHAR(50),
	SoLo VARCHAR(20),
	ThanhTien REAL,
	PRIMARY KEY (MaPhieuTraHang, MaDonViTinh, SoLo),
    CONSTRAINT FK_ChiTietPhieuTraHang_PhieuTraHang FOREIGN KEY (MaPhieuTraHang) REFERENCES PhieuTraHang(MaPhieuTraHang),
    CONSTRAINT FK_ChiTietPhieuTraHang_DonViTinh FOREIGN KEY (MaDonViTinh) REFERENCES DonViTinh(MaDonViTinh),
	CONSTRAINT FK_ChiTietPhieuTraHang_LoHang FOREIGN KEY (SoLo) REFERENCES LoHang(SoLo)
);

GO
CREATE TABLE ChiTietDonThuocMau (
    MaDonThuocMau VARCHAR(7),
    MaDonViTinh INT,
    LieuDung NVARCHAR(50),
    SoLuong INT DEFAULT 1,
    PRIMARY KEY (MaDonThuocMau, MaDonViTinh),
    CONSTRAINT FK_ChiTietDonThuocMau_DonThuocMau FOREIGN KEY (MaDonThuocMau) REFERENCES DonThuocMau(MaDonThuocMau),
    CONSTRAINT FK_ChiTietDonThuocMau_DonViTinh FOREIGN KEY (MaDonViTinh) REFERENCES DonViTinh(MaDonViTinh)
)

GO
CREATE TABLE PhieuNhapHang(
	MaPhieuNhapHang VARCHAR(7) PRIMARY KEY,
	ThoiGianTao Date DEFAULT GETDATE(),
	GhiChu NVARCHAR(500),
	MaHoaDonNCC VARCHAR(20),
	MaNhaCungCap VARCHAR(7) FOREIGN KEY REFERENCES NhaCungCap(MaNhaCungCap) NOT NULL,
	TongGiamGia REAL DEFAULT 0,
	TongTienHang REAL NOT NULL,
	ThanhTien REAL NOT NULL,
	TrangThai VARCHAR(20) DEFAULT 'HOAN_THANH'
)

GO
CREATE TABLE ChiTietPhieuNhapHang(
	MaPhieuNhapHang VARCHAR(7),
	SoLo VARCHAR(20) FOREIGN KEY REFERENCES LoHang(SoLo),
	MaDonViTinh INT,
	SoLuong INT NOT NULL,
	ChietKhau REAL DEFAULT 0,
	ThanhTien REAL NOT NULL
	PRIMARY KEY (MaPhieuNhapHang, MaDonViTinh),
    CONSTRAINT FK_ChiTietPhieuNhapHang_PhieuNhapHang FOREIGN KEY (MaPhieuNhapHang) REFERENCES PhieuNhapHang(MaPhieuNhapHang),
    CONSTRAINT FK_ChiTietPhieuNhapHang_DonViTinh FOREIGN KEY (MaDonViTinh) REFERENCES DonViTinh(MaDonViTinh)

);

GO
CREATE TABLE PhieuXuatTra(
	MaPhieuXuatTra VARCHAR(7) PRIMARY KEY,
	ThoiGianTao Date DEFAULT GETDATE(),
	GhiChu NVARCHAR(500),
	MaHoaDonNCC VARCHAR(20),
	MaNhaCungCap VARCHAR(7) FOREIGN KEY REFERENCES NhaCungCap(MaNhaCungCap) NOT NULL,
	TongGiamGia REAL DEFAULT 0,
	TongTienHang REAL NOT NULL,
	ThanhTien REAL NOT NULL,
	TrangThai VARCHAR(20) DEFAULT 'HOAN_THANH'
);


GO
CREATE TABLE ChiTietPhieuXuatTra(
	MaPhieuXuatTra VARCHAR(7),
	SoLo VARCHAR(20) ,
	MaDonViTinh INT,
	SoLuong INT NOT NULL,
	DonGia REAL,
	ChietKhau REAL DEFAULT 0,
	ThanhTien REAL NOT NULL
	PRIMARY KEY (MaPhieuXuatTra, MaDonViTinh, SoLo),
	CONSTRAINT FK_ChiTietPhieuXuatTra_PhieuXuatTra FOREIGN KEY (MaPhieuXuatTra) REFERENCES PhieuXuatTra(MaPhieuXuatTra),
    CONSTRAINT FK_ChiTietPhieuXuatTra_LoHang FOREIGN KEY (SoLo) REFERENCES LoHang(SoLo),
    CONSTRAINT FK_ChiTietPhieuXuatTra_DonViTinh FOREIGN KEY (MaDonViTinh) REFERENCES DonViTinh(MaDonViTinh)
);
---------------------------------
GO
CREATE TABLE ChiTietHoaDon_LoHang(
	MaHoaDon VARCHAR(12) NOT NULL,
	MaDonViTinh INT NOT NULL,
	SoLo VARCHAR(20),
	SoLuong INT NOT NULL,
	PRIMARY KEY (MaHoaDon, MaDonViTinh, SoLo),
    CONSTRAINT FK_ChiTietHoaDon_LoHang_HoaDon FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
    CONSTRAINT FK_ChiTietHoaDon_LoHang_DonViTinh FOREIGN KEY (MaDonViTinh) REFERENCES DonViTinh(MaDonViTinh),
	CONSTRAINT FK_ChiTietHoaDon_LoHang_LoHang FOREIGN KEY (SoLo) REFERENCES LoHang(SoLo)
);
GO
CREATE TRIGGER trg_InsertNhaCungCap
ON NhaCungCap
INSTEAD OF INSERT
AS
BEGIN
    DECLARE @idCounter INT

    SELECT @idCounter = ISNULL(MAX(CAST(SUBSTRING(MaNhaCungCap, 3, LEN(MaNhaCungCap)) AS INT)), 0) + 1
    FROM NhaCungCap

    INSERT INTO NhaCungCap (MaNhaCungCap, TenNhaCungCap, SoDienThoai, DiaChi, Email, GhiChu, TrangThai)
    SELECT 'NC' + RIGHT('00000' + CAST(@idCounter AS NVARCHAR(5)), 5), TenNhaCungCap, SoDienThoai, DiaChi, Email, GhiChu, TrangThai
    FROM inserted
END;
---------------------------------
GO
CREATE TRIGGER trg_InsertDonThuocMau
ON DonThuocMau
INSTEAD OF INSERT
AS
BEGIN
    DECLARE @idCounter INT

    SELECT @idCounter = ISNULL(MAX(CAST(SUBSTRING(MaDonThuocMau, 3, LEN(MaDonThuocMau)) AS INT)), 0) + 1
    FROM DonThuocMau

    INSERT INTO DonThuocMau (MaDonThuocMau, TenDonThuocMau, NgayBatDauApDung, GhiChu, TrangThai)
    output inserted.MaDonThuocMau
	SELECT 'DT' + RIGHT('00000' + CAST(@idCounter AS NVARCHAR(5)), 5), TenDonThuocMau, NgayBatDauApDung, GhiChu, TrangThai
    FROM inserted
END;
---------------------------------
GO
CREATE TRIGGER trg_InsertKhachHang
ON KhachHang
INSTEAD OF INSERT
AS
BEGIN
    DECLARE @idCounter INT

    SELECT @idCounter = ISNULL(MAX(CAST(SUBSTRING(MaKhachHang, 3, LEN(MaKhachHang)) AS INT)), 0) + 1
    FROM KhachHang

    INSERT INTO KhachHang (MaKhachHang, TenKhachHang, NgaySinh, GioiTinh, SoDienThoai, DiemThuong, NgayTao, GhiChu, TrangThai)
    SELECT 'KH' + RIGHT('00000' + CAST(@idCounter AS NVARCHAR(5)), 5), TenKhachHang, NgaySinh, GioiTinh, SoDienThoai, DiemThuong, NgayTao, GhiChu, TrangThai
    FROM inserted
END;
---------------------------------
GO
CREATE TRIGGER trg_InsertNhanVien
ON NhanVien
INSTEAD OF INSERT
AS
BEGIN
    DECLARE @idCounter INT

    SELECT @idCounter = ISNULL(MAX(CAST(SUBSTRING(MaNhanVien, 3, LEN(MaNhanVien)) AS INT)), 0) + 1
    FROM NhanVien

    INSERT INTO NhanVien (MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, SoDienThoai, MatKhau, NgayTao, GhiChu, ChucVu, TrangThai)
    SELECT 'NV' + RIGHT('00000' + CAST(@idCounter AS NVARCHAR(5)), 5), TenNhanVien, NgaySinh, GioiTinh, SoDienThoai, MatKhau, NgayTao, GhiChu, ChucVu, TrangThai
    FROM inserted
END;
---------------------------------
GO
CREATE TRIGGER trg_InsertCa
ON Ca
INSTEAD OF INSERT
AS
BEGIN
    DECLARE @idCounter INT

    SELECT @idCounter = ISNULL(MAX(CAST(SUBSTRING(MaCa, 3, LEN(MaCa)) AS INT)), 0) + 1
    FROM Ca

    INSERT INTO Ca (MaCa, TenCa, MaNhanVien, ThoiGianVaoCa, ThoiGianKetCa, TongTien, TongTienThucTe, GhiChu, TienChenhLech)
	output inserted.MaCa
	SELECT 'CA' + RIGHT('00000' + CAST(@idCounter AS NVARCHAR(5)), 5), TenCa, MaNhanVien, ThoiGianVaoCa, ThoiGianKetCa, TongTien, TongTienThucTe, GhiChu, TienChenhLech
    FROM inserted
END;

---------------------------------
GO
CREATE TRIGGER trg_InsertHangHoa
ON HangHoa
INSTEAD OF INSERT
AS
BEGIN
    DECLARE @idCounter INT

    SELECT @idCounter = ISNULL(MAX(CAST(SUBSTRING(MaHangHoa, 3, LEN(MaHangHoa)) AS INT)), 0) + 1
    FROM HangHoa

    INSERT INTO HangHoa (MaHangHoa, TenHangHoa, LoaiHang, SoDangKy, MaNhomHang, NuocSanXuat, HangSanXuat, HoatChatChinh, HamLuong, QuyCachDongGoi, MoTa, Thue, SoLuongDinhMuc, SoLuongCanhBao, TrangThai)
	output inserted.MaHangHoa
    SELECT 'HH' + RIGHT('00000' + CAST(@idCounter AS NVARCHAR(5)), 5), TenHangHoa, LoaiHang, SoDangKy, MaNhomHang, NuocSanXuat, HangSanXuat, HoatChatChinh, HamLuong, QuyCachDongGoi, MoTa, Thue, SoLuongDinhMuc, SoLuongCanhBao, TrangThai
    FROM inserted
END;

---------------------------------
GO
CREATE TRIGGER trg_InsertPhieuNhapHang
ON PhieuNhapHang
INSTEAD OF INSERT
AS
BEGIN
    DECLARE @idCounter INT

    SELECT @idCounter = ISNULL(MAX(CAST(SUBSTRING(MaPhieuNhapHang, 3, LEN(MaPhieuNhapHang)) AS INT)), 0) + 1
    FROM PhieuNhapHang

    INSERT INTO PhieuNhapHang (MaPhieuNhapHang, ThoiGianTao, GhiChu, MaHoaDonNCC, MaNhaCungCap, TongGiamGia, TongTienHang, ThanhTien, TrangThai)
	output inserted.MaPhieuNhapHang
	SELECT 'NH' + RIGHT('00000' + CAST(@idCounter AS NVARCHAR(5)), 5), ThoiGianTao, GhiChu, MaHoaDonNCC, MaNhaCungCap, TongGiamGia, TongTienHang, ThanhTien, TrangThai
    FROM inserted
END;

---------------------------------
GO
CREATE TRIGGER trg_InsertPhieuXuatTra
ON PhieuXuatTra
INSTEAD OF INSERT
AS
BEGIN
    DECLARE @idCounter INT

    SELECT @idCounter = ISNULL(MAX(CAST(SUBSTRING(MaPhieuXuatTra, 3, LEN(MaPhieuXuatTra)) AS INT)), 0) + 1
    FROM PhieuXuatTra

    INSERT INTO PhieuXuatTra (MaPhieuXuatTra, ThoiGianTao, GhiChu, MaHoaDonNCC, MaNhaCungCap, TongGiamGia, TongTienHang, ThanhTien, TrangThai)
	output inserted.MaPhieuXuatTra
    SELECT 'XT' + RIGHT('00000' + CAST(@idCounter AS NVARCHAR(5)), 5), ThoiGianTao, GhiChu, MaHoaDonNCC, MaNhaCungCap, TongGiamGia, TongTienHang, ThanhTien, TrangThai
    FROM inserted
END;
Go
