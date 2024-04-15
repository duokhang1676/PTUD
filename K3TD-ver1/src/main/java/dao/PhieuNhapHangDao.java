package dao;

import java.sql.Connection;
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
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			while (rs.next()) {
				String maPNH = rs.getString("MaPhieuNhapHang");
//				LocalDateTime thoiGianTao = LocalDateTime.parse(rs.getString("ThoiGianTao"), formatter);
				LocalDate thoiGianTao = LocalDate.parse(rs.getString("ThoiGianTao"));
				String maHoaDon = rs.getString("MaHoaDonNCC");
				NhaCungCap ncc = new NhaCungCap(rs.getString("MaNhaCungCap"), rs.getString("TenNhaCungCap"));
				String ghiChu = rs.getString("GhiChu");
				String trangThaiStr = rs.getString("TrangThai");
				double tienGiam = rs.getDouble("TongTienGiam");
				TrangThaiPhieuNhapHang trangThai = TrangThaiPhieuNhapHang.valueOf(trangThaiStr);
				
				PhieuNhapHang pnh = new PhieuNhapHang(maPNH, thoiGianTao, ghiChu, maHoaDon, ncc, tienGiam, trangThai);
				dsPNH.add(pnh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPNH;
	}
}
