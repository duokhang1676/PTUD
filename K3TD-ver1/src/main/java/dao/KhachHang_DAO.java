/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;

import entities.HangHoa;
import entities.KhachHang;
import entities.LoaiHang;
import entities.NhomHang;
import entities.TrangThaiHangHoa;

import java.sql.Connection;
import java.sql.Date;

import db.ConnectDB;
import entities.TrangThaiKhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public KhachHang getKHbyMa(String maKH) {
    	ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from KhachHang where MaKhachHang = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maKH);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			String tenKH = rs.getString("TenKhachHang");
			LocalDate ngaySinh = null;
			try {
				 ngaySinh = rs.getDate("NgaySinh").toLocalDate();
			} catch (Exception e) {
				// TODO: handle exception
				
			}
			
			Boolean gioiTinh = rs.getBoolean("GioiTinh");
			String sdt = rs.getString("SoDienThoai");
			Integer diem = rs.getInt("DiemThuong");
			LocalDate ngayTao = rs.getDate("NgayTao").toLocalDate();
			String ghiChu = rs.getString("GhiChu");
			TrangThaiKhachHang tt =  TrangThaiKhachHang.valueOf(rs.getString("TrangThai"));
			
			KhachHang khachHang = new KhachHang(maKH, tenKH, ngaySinh, gioiTinh, sdt, diem, ngayTao, ghiChu, tt);
			return khachHang;
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return null;
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
    
    public boolean taoKhachVangLai(KhachHang kh){
        Connection con  = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        int n =0;
        try {
            stmt = con.prepareStatement("insert into KhachHang (TenKhachHang, NgaySinh, GioiTinh, SoDienThoai, DiemThuong, NgayTao, GhiChu, TrangThai) values(?,?,?,?,?,?,?,?)");
            stmt.setString(1,kh.getTenKhachHang());
            stmt.setDate(2, null);
            stmt.setBoolean(3, kh.isGioiTinh());
            stmt.setString(4,kh.getSoDienThoai());
            stmt.setInt(5, kh.getDiemThuong());
            stmt.setDate(6, null);
            stmt.setString(7, kh.getGhiChu());
            stmt.setString(8, null);
            n =stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n >0;
    }
    
    public KhachHang layKhachVangLaiTheoTen(String tenKH) {
    	ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pst = null;
		try {
			String sql = "SELECT * FROM KhachHang WHERE KhachHang.TenKhachHang LIKE ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, tenKH);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString(1);
				String ten = rs.getString(2);
				LocalDate ngaySinh = null;
				boolean gioiTinh = rs.getBoolean(4);
				String soDienThoai = rs.getString(5);
				int diem = rs.getInt(6);
				LocalDate ngayTao = null;
				String ghiChu = null;
				TrangThaiKhachHang trangThaiKH = null;			
				KhachHang khach= new KhachHang(maKH, ten, ngaySinh, gioiTinh, soDienThoai, diem, ngayTao, ghiChu, trangThaiKH);
				return khach;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    
    public KhachHang layKhachHangTheoSDT(String sdt) {
    	ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pst = null;
		try {
			String sql = "SELECT * FROM KhachHang WHERE KhachHang.SoDienThoai LIKE ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, sdt);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				boolean gioiTinh = rs.getBoolean(4);
				String soDienThoai = rs.getString(5);
				int diem = rs.getInt(6);
				LocalDate ngayTao = rs.getDate(7).toLocalDate();
				String ghiChu = rs.getString(8);
				String trangThai = rs.getString(9);
				TrangThaiKhachHang trangThaiKH = trangthaihoatdong(trangThai);			
				KhachHang khach= new KhachHang(maKH, tenKH, ngaySinh, gioiTinh, soDienThoai, diem, ngayTao, ghiChu, trangThaiKH);
				return khach;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
    
    public boolean capNhatDiemKhachHang(KhachHang khachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;			
		try {
			String sql = "update KhachHang set DiemThuong = ? where KhachHang.MaKhachHang = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, khachHang.getDiemThuong());
			stmt.setString(2, khachHang.getMaKhachHang());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
