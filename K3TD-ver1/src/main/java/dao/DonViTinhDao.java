package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.DonViTinh;
import entities.HangHoa;
import entities.LoaiHang;
import entities.NhomHang;
import entities.TrangThaiDonViTinh;
import entities.TrangThaiHangHoa;

public class DonViTinhDao {
	public boolean themDVT(DonViTinh dvt) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "Insert into DonViTinh(TenDonViTinh, MaHangHoa, QuyDoi, GiaBan, TrangThaiDonViTinh) "
				+ "values(?,?,?,?,?)";
				
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, dvt.getTenDonViTinh());
			stmt.setString(2, dvt.getHangHoa().getMaHangHoa());
			stmt.setInt(3, dvt.getQuyDoi());
			stmt.setDouble(4, dvt.getGiaBan());
			stmt.setString(5, dvt.getTrangThaiDonViTinh().toString());
			
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public List<DonViTinh> timDVTTheoMaHH(String maHHoa) {
		List<DonViTinh> dsDVT = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from DonViTinh where MaHangHoa = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHHoa);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int maDVT = rs.getInt("MaDonViTinh");	
				String tenDVT = rs.getString("TenDonViTinh");
				String maHH = rs.getString("MaHangHoa");
				HangHoa hh = null;
				int quyDoi = rs.getInt("QuyDoi");
				Double giaBan = rs.getDouble("GiaBan");
				String maVach = rs.getString("MaVach");
				
				String trangThaiStr = rs.getString("TrangThaiDonViTinh");
				TrangThaiDonViTinh trangThai = TrangThaiDonViTinh.valueOf(trangThaiStr);
				
				DonViTinh dvt = new DonViTinh(maDVT, tenDVT, hh, quyDoi, giaBan, maVach, trangThai);
				dsDVT.add(dvt);
				return dsDVT;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
