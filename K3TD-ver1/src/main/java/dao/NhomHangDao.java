package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.NhomHang;


public class NhomHangDao {
	public List<NhomHang> getAllDataNhomHang() {
		List<NhomHang> dsNhomHang = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "SELECT * FROM NhomHang";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int maNH = rs.getInt("MaNhomHang");
				String tenNH = rs.getString("TenNhomHang");
				
				NhomHang nhomHang = new NhomHang(maNH,tenNH);
				
				dsNhomHang.add(nhomHang);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return dsNhomHang;
	}
}
