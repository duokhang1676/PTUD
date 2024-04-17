/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import entities.KhachHang;
import java.sql.Connection;
import db.ConnectDB;
import entities.TrangThaiKhachHang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */
public class KhachHang_DAO {
    ArrayList<entities.KhachHang> dsKhachHang;
    KhachHang kh;
    // chuyen chuoi thanh localdate
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
    public KhachHang_DAO(){
        dsKhachHang = new ArrayList<KhachHang>();
    }
    public ArrayList<KhachHang> docTuBang(){
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "Select * from KhachHang";
            Statement statement = con.createStatement();
  
            // thuc thi cau lenh
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String ma = rs.getString(1);
                String ten =rs.getString(2);
                
   
                LocalDate ngaySinh1 = rs.getDate(3).toLocalDate();
                boolean gioitinh = rs.getBoolean(4);
                String soDienThoai = rs.getString(5);
                int diemThuong = rs.getInt(6);
                
//                LocalDate ngayTao0 = LocalDate.parse(rs.getString("NgayTa    o"),formatter);
                LocalDate ngayTao = rs.getDate(7).toLocalDate();
                
                String ghiChu = rs.getString(8);
                
                String trangThaiKhachHang2 = rs.getString(9);
                TrangThaiKhachHang trangthaiKhachHang = trangthaihoatdong(trangThaiKhachHang2); ;
     
               KhachHang kh = new KhachHang(ma, ten, ngaySinh1, gioitinh, soDienThoai, diemThuong, ngayTao, ghiChu, trangthaiKhachHang);
                dsKhachHang.add(kh);
            }
     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsKhachHang;

    }

    
    
    private TrangThaiKhachHang trangthaihoatdong(String trangthaikhachhang){
        if (trangthaikhachhang.equals("DANG_HOAT_DONG")) {
            return TrangThaiKhachHang.DANG_HOAT_DONG;
        }
        return TrangThaiKhachHang.NGUNG_HOAT_DONG;
    }
    
    public boolean create(KhachHang kh){
        Connection con  = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        int n =0;
        try {
            stmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, kh.getMaKhachHang());
            stmt.setString(2,kh.getTenKhachHang());
 
            // chuyen doi 
            LocalDate ngaySinh2 = kh.getNgaySinh();
            java.sql.Date ngaySinhSQL =  java.sql.Date.valueOf(ngaySinh2);
            stmt.setDate(3, ngaySinhSQL);
            //
            stmt.setBoolean(4, kh.isGioiTinh());
            stmt.setString(5,kh.getSoDienThoai());
            stmt.setInt(6, kh.getDiemThuong());
            
            java.sql.Date ngayTaoSQL = java.sql.Date.valueOf(kh.getNgayTao());
            stmt.setDate(7, ngayTaoSQL);
            
            stmt.setString(8, kh.getGhiChu());
            stmt.setString(9, kh.getTrangThaiKhachHang().toString());
            n =stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n >0;
    }
    public ArrayList<ArrayList<Object>> timKiem_tuKhoa_TrangThai(String tuKhoa, String trangThai){
    	ArrayList<ArrayList<Object>> dsTamThoi = new ArrayList<>();
    	ArrayList<Object> doituong = new ArrayList<>();
		String Change_Value__TrangThai = trangThai.equals("Đang hoạt động") ? "DANG_HOAT_DONG" : "NGUNG_HOAT_DONG";
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql;
			PreparedStatement stmt;
			if (tuKhoa.trim().isEmpty() ) {
				if (trangThai.equalsIgnoreCase("Tất cả")) {
					sql ="select * from KhachHang join HoaDon on KhachHang.MaKhachHang = HoaDon.MaKhachHang";
					stmt =con.prepareStatement(sql);
				
				}
				else {
					sql = "SELECT * "
							+ "FROM KhachHang "
							+ "JOIN HoaDon on KhachHang.MaKhachHang = HoaDon.MaKhachHang"
							+ " WHERE TrangThai = ?";
					stmt = con.prepareStatement(sql);
					stmt.setString(1, Change_Value__TrangThai);
				}	
			}
			else {
				if (trangThai.equalsIgnoreCase("Tất cả")) {
					sql = "SELECT * "
							+ "FROM KhachHang "
							+ "JOIN HoaDon on KhachHang.MaKhachHang = HoaDon.MaKhachHang"
							+ " WHERE MaKhachHang LIKE ? OR TenKhachHang LIKE ?  OR TongTien LIKE ? SoDienThoai LIKE ? OR GhiChu LIKE ?";
					stmt = con.prepareStatement(sql);
		            stmt.setString(1, "%" + tuKhoa + "%");
		            stmt.setString(2, "%" + tuKhoa + "%");
		            stmt.setString(3, "%" + tuKhoa + "%");
		            stmt.setString(4, "%" + tuKhoa + "%");
		            stmt.setString(5, "%" + tuKhoa + "%");
				}
				else {
					sql = "SELECT * "
							+ "FROM KhachHang "
							+ "JOIN HoaDon on KhachHang.MaKhachHang = HoaDon.MaKhachHang"
							+ " WHERE (MaKhachHang LIKE ? OR TenKhachHang LIKE ?  OR TongTien LIKE ? SoDienThoai LIKE ? OR GhiChu LIKE ?) AND TrangThai";
					stmt = con.prepareStatement(sql);
		            stmt.setString(1, "%" + tuKhoa + "%");
		            stmt.setString(2, "%" + tuKhoa + "%");
		            stmt.setString(3, "%" + tuKhoa + "%");
		            stmt.setString(4, "%" + tuKhoa + "%");
		            stmt.setString(5, "%" + tuKhoa + "%");
		            stmt.setString(6, Change_Value__TrangThai);
				}
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String ma = rs.getString("MaKhachHang");
				String ten  = rs.getString("TenKhachHang");
				double tongTien = rs.getDouble("TongTien");
				String sdt = rs.getString("SoDienThoai");
				String ghiChu = rs.getString("GhiChu");
				TrangThaiKhachHang ttKh = rs.getString("TrangThai").equals("DANG_HOAT_DONG") ? TrangThaiKhachHang.DANG_HOAT_DONG : TrangThaiKhachHang.NGUNG_HOAT_DONG;
				doituong.add(ma);
				doituong.add(ten);
				doituong.add(tongTien);
				doituong.add(sdt);
				doituong.add(ghiChu);
				doituong.add(ttKh);
				dsTamThoi.add(doituong);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsTamThoi;
    }
}
