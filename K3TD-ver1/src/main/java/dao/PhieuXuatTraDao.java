package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.NhaCungCap;
import entities.PhieuXuatTra;
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
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			while (rs.next()) {
				String maPTH = rs.getString("MaPhieuXuatTra");
				LocalDateTime thoiGianTao = LocalDateTime.parse(rs.getString("ThoiGianTao"), formatter);
				String maHoaDon = rs.getString("MaHoaDonNCC");
				NhaCungCap ncc = new NhaCungCap(rs.getString("MaNhaCungCap"), rs.getString("TenNhaCungCap"));
				String ghiChu = rs.getString("GhiChu");
				String trangThaiStr = rs.getString("TrangThai");
				double tienGiam = rs.getDouble("TongTienGiam");
				TrangThaiPhieuXuatTra trangThai = TrangThaiPhieuXuatTra.valueOf(trangThaiStr);
				
				PhieuXuatTra pth = new PhieuXuatTra(maPTH, thoiGianTao, ghiChu, maHoaDon, ncc, tienGiam, trangThai);
				dsPXT.add(pth);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPXT;
	}
}
