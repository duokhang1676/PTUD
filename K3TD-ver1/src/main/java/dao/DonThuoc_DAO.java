package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import db.ConnectDB;
import entities.Ca;
import entities.DonThuoc;
import entities.HoaDon;
import entities.NhanVien;

public class DonThuoc_DAO {
	public DonThuoc_DAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean themDonThuoc(DonThuoc donThuoc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "insert into DonThuoc (MaDonThuoc, MaHoaDon) values(?,?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, donThuoc.getMaDonThuoc());
			stmt.setString(2, donThuoc.getHoaDon().getMaHoaDon());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public DonThuoc layDonThuocTheoMa(String maDT) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from DonThuoc where MaDonThuoc = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maDT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maDonThuoc = rs.getString(1);
				String maHoaDon = rs.getString(2);
				HoaDon hd = new HoaDonDao().getHDbyMa(maHoaDon);
				DonThuoc donThuoc = new DonThuoc(maDonThuoc, hd);
				return donThuoc;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
