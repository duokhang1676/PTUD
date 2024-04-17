/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.ConnectDB;
import entities.ChucVuNhanVien;
import entities.NhaCungCap;

import java.util.ArrayList;
import entities.NhanVien;
import entities.TrangThaiNCC;
import entities.TrangThaiNhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
/**
 *
 * @author Admin
 */
public class NhanVien_DAO {
    ArrayList<NhanVien> dsNhanVien;
	private NhanVien nV;
    
    public NhanVien_DAO(){
        dsNhanVien = new ArrayList<NhanVien>();
    }
    public ArrayList<NhanVien> docTuBang(){
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "Select * from NhanVien";
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String ma = rs.getString(1);
                String ten  = rs.getString(2);
                LocalDate ngaySinh = rs.getDate(3).toLocalDate();
                boolean gioitinh = rs.getBoolean(4);
                String sdt = rs.getString(5);
                String matKhau = rs.getString(6);
                LocalDate ngayTao = rs.getDate(7).toLocalDate();
                String ghiChu = rs.getString(8);
                String chucVu = rs.getString(9);
                ChucVuNhanVien cvNhanVien =  chucvuNhanVien(chucVu);
                String trangThai = rs.getString(10);
                TrangThaiNhanVien ttNhanVien = trangthaiNhanVien(trangThai);
                
                NhanVien nv = new NhanVien(ma, ten, ngaySinh, gioitinh, sdt, matKhau, ngayTao,ghiChu,cvNhanVien, ttNhanVien);
                dsNhanVien.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsNhanVien;
        
    }
    private ChucVuNhanVien chucvuNhanVien(String cv){
        if (cv.equals("Quản Lý")) {
            return ChucVuNhanVien.QUAN_LY;
        }
        return ChucVuNhanVien.NHAN_VIEN;
    }
    private TrangThaiNhanVien trangthaiNhanVien(String ct){
        if (ct.equals("Đang hoạt động")) {
            return TrangThaiNhanVien.DANG_HOAT_DONG;
        }
        return TrangThaiNhanVien.NGUNG_HOAT_DONG;
    }
    public boolean create (NhanVien nv){
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,nv.getMaNhanVien());
            stmt.setString(2, nv.getTenNhanVien());
            stmt.setDate(3,java.sql.Date.valueOf(nv.getNgaySinh()));
            stmt.setBoolean(4, nv.isGioiTinh());
            stmt.setString(5, nv.getSoDienThoai());
            stmt.setString(6, nv.getMatKhau());
            stmt.setDate(7, java.sql.Date.valueOf(nv.getNgayTao()));
            stmt.setString(8, nv.getGhiChu());
            stmt.setString(9, nv.getChucVu().toString());
            stmt.setString(10,nv.getTrangThaiNhanVien().toString());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n >0;
    }
    public ArrayList<NhanVien> timkiem_TuKhoa_TrangThai(String tuKhoa,String chucVu, String trangThai){
    	ArrayList<NhanVien> dsNhanVien4 = new ArrayList<>();
		String Change_Value__TrangThai = trangThai.equals("Đang hoạt động") ? "DANG_HOAT_DONG" : "NGUNG_HOAT_DONG";
		String Change_Value__ChucVu = chucVu.equals("Nhân Viên") ? "NHAN_VIEN" : "QUAN_LY";

    	try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql ;
			PreparedStatement stmt;
			if (tuKhoa.isEmpty() ) {
				if (chucVu.equals("Tất cả")) {
					if (trangThai.equalsIgnoreCase("Tất cả")) {
						sql = "SELECT * FROM NhanVien";
						stmt =con.prepareStatement(sql);
					}
					else {
						sql = "SELECT * FROM NhanVien WHERE TrangThai = ? ";
						stmt =con.prepareStatement(sql);
						stmt.setString(1, Change_Value__TrangThai);
					}
				}
				else {
					if (trangThai.equals("Tất cả")) {
						sql = "SELECT * FROM NhanVien WHERE ChucVu = ?";
						stmt =con.prepareStatement(sql);
						stmt.setString(1, Change_Value__ChucVu);
					}
					else {
						sql = "SELECT * FROM NhanVien WHERE TrangThai = ? AND ChucVu = ? ";
						stmt =con.prepareStatement(sql);
						stmt.setString(1, Change_Value__ChucVu);
						stmt.setString(2, Change_Value__TrangThai);
					}
				}
					
			}
			else {
				if (chucVu.equals("Tất cả")) {
					if (trangThai.equalsIgnoreCase("Tất cả")) {
						sql = "SELECT * FROM NhanVien WHERE MaNhanVien LIKE ? OR TenNhanVien LIKE ? OR"
								+ " ChucVu LIKE ? OR SoDienThoai LIKE ? OR GhiChu LIKE ?";
						stmt =con.prepareStatement(sql);
			            stmt.setString(1, "%" + tuKhoa + "%");
			            stmt.setString(2, "%" + tuKhoa + "%");
			            stmt.setString(3, "%" + tuKhoa + "%");
			            stmt.setString(4, "%" + tuKhoa + "%");
			            stmt.setString(5, "%" + tuKhoa + "%");
					}
					else {
						sql = "SELECT * FROM NhanVien WHERE (  MaNhanVien LIKE ? OR TenNhanVien LIKE ? OR\"\r\n"
								+ "								+ \" ChucVu LIKE ? OR SoDienThoai LIKE ? OR GhiChu LIKE ?  ) AND TrangThai = ?";
						stmt =con.prepareStatement(sql);
			            stmt.setString(1, "%" + tuKhoa + "%");
			            stmt.setString(2, "%" + tuKhoa + "%");
			            stmt.setString(3, "%" + tuKhoa + "%");
			            stmt.setString(4, "%" + tuKhoa + "%");
			            stmt.setString(5, "%" + tuKhoa + "%");
						stmt.setString(6, Change_Value__TrangThai);
					}
				}
				else {
					if (trangThai.equals("Tất cả")) {
						sql = "SELECT * FROM NhanVien WHERE ChucVu = ?";
						stmt =con.prepareStatement(sql);
						stmt.setString(1, chucVu);
					}
					else {
						sql = "SELECT * FROM NhanVien WHERE   (  MaNhanVien LIKE ? OR TenNhanVien LIKE ? OR\\\"\\r\\n\"\r\n"
								+ "								+ \"								+ \\\" ChucVu LIKE ? OR SoDienThoai LIKE ? OR GhiChu LIKE ?  ) AND   (TrangThai = ? AND ChucVu = ? )";
						stmt =con.prepareStatement(sql);
			            stmt.setString(1, "%" + tuKhoa + "%");
			            stmt.setString(2, "%" + tuKhoa + "%");
			            stmt.setString(3, "%" + tuKhoa + "%");
			            stmt.setString(4, "%" + tuKhoa + "%");
			            stmt.setString(5, "%" + tuKhoa + "%");
						stmt.setString(6, Change_Value__TrangThai);
						stmt.setString(7, Change_Value__ChucVu);
					}
				}
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString("MaNhanVien");
				String ten = rs.getString("TenNhanVien");
				LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
				boolean gioiTinh = rs.getBoolean("GioiTinh");
				String soDienThoai = rs.getString("SoDienThoai");
				String matKhau = rs.getString("MatKhau");
				LocalDate ngayTao = rs.getDate("NgayTao").toLocalDate();
				String ghiChu = rs.getString("GhiChu");
				ChucVuNhanVien chucVu1 = rs.getString("ChucVu").equalsIgnoreCase("NHAN_VIEN") ? ChucVuNhanVien.NHAN_VIEN : ChucVuNhanVien.QUAN_LY;
				TrangThaiNhanVien trangthai = rs.getString("TrangThai").equals("DANG_HOAT_DONG") ? TrangThaiNhanVien.DANG_HOAT_DONG : TrangThaiNhanVien.NGUNG_HOAT_DONG;
				nV = new NhanVien(ma, ten, ngaySinh, gioiTinh, soDienThoai, matKhau, ngayTao, ghiChu, chucVu1, trangthai);
				dsNhanVien4.add(nV);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return dsNhanVien4;
    }
}
