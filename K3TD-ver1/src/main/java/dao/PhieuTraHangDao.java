package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class PhieuTraHangDao {
	public PhieuTraHangDao() {
		// TODO Auto-generated constructor stub
	}
	public double getTongTienHoaDonTraTrongKhoang(LocalDate from, LocalDate to) {
		double tongTien = 0;
		try {
			db.ConnectDB.getInstance();
			Connection con = db.ConnectDB.getConnection();
			String sql = "SELECT SUM(ThanhTien) AS TongTienCacHoaDonTra\r\n"
					+ "FROM PhieuTraHang\r\n"
					+ "WHERE CAST(ThoiGianTao AS DATE) BETWEEN ? AND ? AND TrangThai = 'HOAN_THANH';\r\n"
					+ "";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(from));
			stmt.setDate(2, Date.valueOf(to));
		
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			tongTien = rs.getDouble("TongTienCacHoaDonTra");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tongTien;
	}
	public int getSoLuongHoaDonTraTrongKhoang(LocalDate from, LocalDate to) {
		int soLuong = 0;
		try {
			db.ConnectDB.getInstance();
			Connection con = db.ConnectDB.getConnection();
			String sql = "select count(MaPhieuTraHang) as SoLuongHoaDonTra\r\n"
					+ "from PhieuTraHang\r\n"
					+ "where CAST(ThoiGianTao AS DATE) BETWEEN ? AND ? AND TrangThai = 'HOAN_THANH';\r\n"
					+ "";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(from));
			stmt.setDate(2, Date.valueOf(to));
		
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			soLuong = rs.getInt("SoLuongHoaDonTra");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return soLuong;
	}
}
