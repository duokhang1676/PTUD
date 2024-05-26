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
import entities.NhaCungCap;
import entities.PhieuNhapHang;
import entities.PhieuXuatTra;
import entities.TrangThaiPhieuNhapHang;
import entities.TrangThaiPhieuXuatTra;

public class PhieuXuatTraDao {
	public List<PhieuXuatTra> getAllDataPXT() {
		List<PhieuXuatTra> dsPXT = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from PhieuXuatTra join NhaCungCap on PhieuXuatTra.MaNhaCungCap = NhaCungCap.MaNhaCungCap";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			String defaultTime = "00:00:00";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			while (rs.next()) {
				String maPTH = rs.getString("MaPhieuXuatTra");
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
				TrangThaiPhieuXuatTra trangThai = TrangThaiPhieuXuatTra.valueOf(trangThaiStr);
				
				PhieuXuatTra pth = new PhieuXuatTra(maPTH, thoiGianTao, ghiChu, maHoaDon, ncc, tienGiam,tongTienHang, trangThai);
				dsPXT.add(pth);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPXT;
	}
	
	public List<PhieuXuatTra> getPXTTheoTenNCCVaTheoNgay(String ten, LocalDate dateFrom, LocalDate dateTo) {
		List<PhieuXuatTra> dsPXT = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from PhieuXuatTra p join NhaCungCap n on p.MaNhaCungCap = n.MaNhaCungCap "
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
				TrangThaiPhieuXuatTra trangThai = TrangThaiPhieuXuatTra.valueOf(trangThaiStr);
				
				PhieuXuatTra pxt = new PhieuXuatTra(maPNH, thoiGianTao, ghiChu, maHoaDon, ncc, tienGiam, tongTienHang, trangThai);
				dsPXT.add(pxt);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPXT;
	}
	
	public PhieuXuatTra getPXTTheoMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from PhieuXuatTra p join NhaCungCap n on p.MaNhaCungCap = n.MaNhaCungCap where p.MaPhieuXuatTra = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			String defaultTime = "00:00:00";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			while (rs.next()) {
				String maPNH = rs.getString("MaPhieuXuatTra");
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
				TrangThaiPhieuXuatTra trangThai = TrangThaiPhieuXuatTra.valueOf(trangThaiStr);
				
				PhieuXuatTra pxt = new PhieuXuatTra(maPNH, thoiGianTao, ghiChu, maHoaDon, ncc, tienGiam, tongTienHang,trangThai);
				return pxt;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public PhieuXuatTra createPXT(PhieuXuatTra pxt, Double thanhTien) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "insert into PhieuXuatTra (ThoiGianTao, GhiChu, MaHoaDonNCC, MaNhaCungCap, TongGiamGia, TongTienHang, ThanhTien, TrangThai) "
				+ "values (?,?,?,?,?,?,?,?)";
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setDate(1, Date.valueOf(pxt.getThoiGianTao().toLocalDate()));
			stmt.setString(2, pxt.getGhiChu());
			stmt.setString(3, pxt.getMaHoaDonNCC());
			stmt.setString(4, pxt.getNhaCungCap().getMaNhaCungCap());
			stmt.setDouble(5, pxt.getTongGiamGia());
			stmt.setDouble(6, pxt.getTongTienHang());
			stmt.setDouble(7, thanhTien);
			stmt.setString(8, pxt.getTrangThai().toString());
			
			ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
				String maPXT = rs.getString("MaPhieuXuatTra");
				
				pxt.setMaPhieuXuatTra(maPXT);
				return pxt;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateTrangThaiPXT(String ma,TrangThaiPhieuXuatTra trangThaiMoi) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "update PhieuXuatTra set TrangThai = ? where MaPhieuXuatTra = ?";
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
