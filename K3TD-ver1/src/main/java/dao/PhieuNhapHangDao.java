package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.Ca;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhaCungCap;
import entities.NhanVien;
import entities.PhieuNhapHang;
import entities.TrangThaiHoaDon;
import entities.TrangThaiPhieuNhapHang;

public class PhieuNhapHangDao {
	public List<PhieuNhapHang> getAllDataPNH() {
		List<PhieuNhapHang> dsPNH = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from PhieuNhapHang join NhaCungCap on PhieuNhapHang.MaNhaCungCap = NhaCungCap.MaNhaCungCap";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			String defaultTime = "00:00:00";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			while (rs.next()) {
				String maPNH = rs.getString("MaPhieuNhapHang");
				String date = rs.getString("ThoiGianTao");
				String dateTime = date + " " +defaultTime;
				LocalDateTime thoiGianTao = LocalDateTime.parse(dateTime, formatter);
//				LocalDate thoiGianTao = LocalDate.parse(rs.getString("ThoiGianTao"));
				String maHoaDon = rs.getString("MaHoaDonNCC");
				NhaCungCap ncc = new NhaCungCap(rs.getString("MaNhaCungCap"), rs.getString("TenNhaCungCap"));
				String ghiChu = rs.getString("GhiChu");
				String trangThaiStr = rs.getString("TrangThai");
				double tienGiam = rs.getDouble("TongGiamGia");
				double tongTienHang = rs.getDouble("TongTienHang");
				TrangThaiPhieuNhapHang trangThai = TrangThaiPhieuNhapHang.valueOf(trangThaiStr);
				
				PhieuNhapHang pnh = new PhieuNhapHang(maPNH, thoiGianTao, ghiChu, maHoaDon, ncc, tienGiam, tongTienHang,trangThai);
				dsPNH.add(pnh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPNH;
	}
	
	public PhieuNhapHang createPNH(PhieuNhapHang pnh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "insert into PhieuNhapHang (ThoiGianTao, GhiChu, MaHoaDonNCC, MaNhaCungCap, TongGiamGia, TongTienHang, ThanhTien, TrangThai) "
				+ "values (?,?,?,?,?,?,?,?)";
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setDate(1, Date.valueOf(pnh.getThoiGianTao().toLocalDate()));
			stmt.setString(2, pnh.getGhiChu());
			stmt.setString(3, pnh.getMaHoaDonNCC());
			stmt.setString(4, pnh.getNhaCungCap().getMaNhaCungCap());
			stmt.setDouble(5, pnh.getTongGiamGia());
			stmt.setDouble(6, pnh.getTongTienHang());
			stmt.setDouble(7, pnh.tinhThanhTien());
			stmt.setString(8, pnh.getTrangThai().toString());
			
			ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
				String maPNH = rs.getString("MaPhieuNhapHang");
				
				pnh.setMaPhieu(maPNH);
				return pnh;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public PhieuNhapHang getPNHTheoMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from PhieuNhapHang p join NhaCungCap n on p.MaNhaCungCap = n.MaNhaCungCap where p.MaPhieuNhapHang = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			String defaultTime = "00:00:00";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			while (rs.next()) {
				String maPNH = rs.getString("MaPhieuNhapHang");
				String date = rs.getString("ThoiGianTao");
				String dateTime = date + " " +defaultTime;
				LocalDateTime thoiGianTao = LocalDateTime.parse(dateTime, formatter);
//				LocalDate thoiGianTao = LocalDate.parse(rs.getString("ThoiGianTao"));
				String maHoaDon = rs.getString("MaHoaDonNCC");
				NhaCungCap ncc = new NhaCungCap(rs.getString("MaNhaCungCap"), rs.getString("TenNhaCungCap"));
				String ghiChu = rs.getString("GhiChu");
				String trangThaiStr = rs.getString("TrangThai");
				double tienGiam = rs.getDouble("TongGiamGia");
				double tongTienHang = rs.getDouble("TongTienHang");
				TrangThaiPhieuNhapHang trangThai = TrangThaiPhieuNhapHang.valueOf(trangThaiStr);
				
				PhieuNhapHang pnh = new PhieuNhapHang(maPNH, thoiGianTao, ghiChu, maHoaDon, ncc, tienGiam, tongTienHang,trangThai);
				return pnh;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public List<PhieuNhapHang> getPNHTheoTenNCCVaTheoNgay(String ten, LocalDate dateFrom, LocalDate dateTo) {
		List<PhieuNhapHang> dsPNH = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from PhieuNhapHang p join NhaCungCap n on p.MaNhaCungCap = n.MaNhaCungCap "
					+ "where (n.MaNhaCungCap = ? and p.ThoiGianTao >= ? and p.ThoiGianTao <= ?)"
					+ "or (n.TenNhaCungCap = ? and p.ThoiGianTao >= ? and p.ThoiGianTao <= ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ten);
			stmt.setDate(2, Date.valueOf(dateFrom));
			stmt.setDate(3, Date.valueOf(dateTo));
			
			stmt.setString(4, ten);
			stmt.setDate(5, Date.valueOf(dateFrom));
			stmt.setDate(6, Date.valueOf(dateTo));
			ResultSet rs = stmt.executeQuery();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			String defaultTime = "00:00:00";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			while (rs.next()) {
				String maPNH = rs.getString("MaPhieuNhapHang");
				String date = rs.getString("ThoiGianTao");
				String dateTime = date + " " +defaultTime;
				LocalDateTime thoiGianTao = LocalDateTime.parse(dateTime, formatter);
//				LocalDate thoiGianTao = LocalDate.parse(rs.getString("ThoiGianTao"));
				String maHoaDon = rs.getString("MaHoaDonNCC");
				NhaCungCap ncc = new NhaCungCap(rs.getString("MaNhaCungCap"), rs.getString("TenNhaCungCap"));
				String ghiChu = rs.getString("GhiChu");
				String trangThaiStr = rs.getString("TrangThai");
				double tienGiam = rs.getDouble("TongGiamGia");
				double tongTienHang = rs.getDouble("TongTienHang");
				TrangThaiPhieuNhapHang trangThai = TrangThaiPhieuNhapHang.valueOf(trangThaiStr);
				
				PhieuNhapHang pnh = new PhieuNhapHang(maPNH, thoiGianTao, ghiChu, maHoaDon, ncc, tienGiam, tongTienHang,trangThai);
				dsPNH.add(pnh);
				
			}
			return dsPNH;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateTrangThaiPNH(String ma,TrangThaiPhieuNhapHang trangThaiMoi) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "update PhieuNhapHang set TrangThai = ? where MaPhieuNhapHang = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, trangThaiMoi.toString());
			stmt.setString(2, ma);
			stmt.executeUpdate();
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
