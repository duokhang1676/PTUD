package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.DonThuocMau;
import entities.TrangThaiDonThuocMau;
import entities.TrangThaiKhachHang;

public class DonThuocMau_DAO {
	public List<DonThuocMau> layDuLieuDonThuocMau() {
		List<DonThuocMau> dsDonThuoc = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "SELECT * FROM DonThuocMau";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maDonThuocMau = rs.getString(1);
				String tenDonThuoc = rs.getString(2);
				LocalDate ngayApDung = rs.getDate(3).toLocalDate();
				String ghiChu = rs.getString(4);
				String trangThaiDT = rs.getString(5);
				TrangThaiDonThuocMau trangThai = trangThai(trangThaiDT);
				
				DonThuocMau donThuoc = new DonThuocMau(maDonThuocMau, tenDonThuoc, ngayApDung, ghiChu, trangThai);
				dsDonThuoc.add(donThuoc);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return dsDonThuoc;
	}
	
    private TrangThaiDonThuocMau trangThai(String trangThai){
        if (trangThai.equals("DANG_BAN")) {
            return TrangThaiDonThuocMau.DANG_BAN;
        }
        return TrangThaiDonThuocMau.TAM_DUNG;
    }
}
