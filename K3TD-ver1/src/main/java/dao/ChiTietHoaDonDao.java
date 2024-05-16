package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import db.ConnectDB;
import entities.ChiTietHoaDon;

public class ChiTietHoaDonDao {
	public boolean addChiTietHD(ChiTietHoaDon ct) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "insert into ChiTietHoaDon (MaHoaDon, SoLuong, DonGia, MaDonViTinh) values(?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, ct.getHoaDon().getMaHoaDon());
			stmt.setInt(2, ct.getSoLuong());
			stmt.setDouble(3, ct.getDonGia());
			stmt.setInt(4, ct.getDonViTinh().getMaDonViTinh());
			
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
