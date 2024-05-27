package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.Ca;
import entities.ChiTietDonThuocMau;
import entities.DonThuocMau;
import entities.DonViTinh;
import entities.NhanVien;

public class ChiTietDonThuocMau_DAO {
	public ChiTietDonThuocMau_DAO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<ChiTietDonThuocMau>  layChiTietDTMTheoMaDTM(DonThuocMau dtm) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		List<ChiTietDonThuocMau> dsCTDTM = new ArrayList<>();
		try {
			String sql = "select * from ChiTietDonThuocMau where MaDonThuocMau = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, dtm.getMaDonThuocMau());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maDTM = rs.getString(1);
				DonThuocMau dt = new DonThuocMauDao().getDonThuocMau_theoMa(maDTM);
				int maDVT = rs.getInt(2);
				DonViTinh dvt = new DonViTinhDao().timDVTTheoMa(maDVT);
				String lieuDung = rs.getString(3);
				int soLuong = rs.getInt(4);
				ChiTietDonThuocMau ctdtm = new ChiTietDonThuocMau(dt, lieuDung, soLuong, dvt);
				dsCTDTM.add(ctdtm);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsCTDTM;
	}
}
