package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.ChiTietHoaDon;
import entities.DonViTinh;

public class ChiTietPhieuTraHangDao {
	public List<ChiTietHoaDon> getDSDonViTinh(LocalDate from, LocalDate to){
		List<ChiTietHoaDon> dsDVT = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT \r\n"
					+ "	ct.MaDonViTinh,\r\n"
					+ "	sum(ct.SoLuongTra) as SoLuong,\r\n"
					+ "	sum(ct.ThanhTien) as ThanhTien \r\n"
					+ "FROM \r\n"
					+ "    PhieuTraHang hd\r\n"
					+ "JOIN \r\n"
					+ "    ChiTietPhieuTraHang ct ON hd.MaPhieuTraHang = ct.MaPhieuTraHang\r\n"
					+ "WHERE \r\n"
					+ "    hd.ThoiGianTao BETWEEN ? AND ? and hd.TrangThai = 'HOAN_THANH'\r\n"
					+ "Group by\r\n"
					+ "	ct.MaDonViTinh\r\n"
					+ "order by\r\n"
					+ "	SoLuong DESC,ThanhTien DESC";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, from.toString());
			stmt.setString(2, to.toString());
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int maDVT = rs.getInt("MaDonViTinh");	
				DonViTinh dvt = new DonViTinhDao().timDVTTheoMa(maDVT);
				int soLuong = rs.getInt("SoLuong");
				double thanhTien = rs.getDouble("ThanhTien");
				
				ChiTietHoaDon cthd = new ChiTietHoaDon(null, soLuong, thanhTien, dvt);
				dsDVT.add(cthd);
			}
			return dsDVT;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
