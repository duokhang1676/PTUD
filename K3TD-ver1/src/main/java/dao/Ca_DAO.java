package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import db.ConnectDB;
import entities.Ca;
import entities.HoaDon;
import entities.NhanVien;


public class Ca_DAO {
	public Ca_DAO() {
		// TODO Auto-generated constructor stub
	}
	public Ca getCaByMaCa(String maCa) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		
		try {
			String sql = "select * from Ca where maca = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maCa);
			ResultSet rs = stmt.executeQuery();
			// Định dạng mẫu để phân tích
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			while (rs.next()) {
				String tenCa = rs.getString("tenca");
				NhanVien nv = new NhanVien_DAO().getNVbyMa(rs.getString("manhanvien"));
				// Lấy dữ liệu dưới dạng Timestamp
                Timestamp tgVaoTimestamp = rs.getTimestamp("thoigianvaoca");
                Timestamp tgKetCaTimestamp = rs.getTimestamp("thoigianketca");
                LocalDateTime thoiGianKetCa = null;
                if(tgKetCaTimestamp!=null)
                	thoiGianKetCa = tgKetCaTimestamp.toLocalDateTime();
                // Chuyển đổi Timestamp sang LocalDateTime
                LocalDateTime thoiGianVaoCa = tgVaoTimestamp.toLocalDateTime();
                
				double tongTien = rs.getDouble("tongtien");
				double tongTienThucTe = rs.getDouble("tongTienThucTe");
				String ghiChu = rs.getString("ghichu");
				Ca ca = new Ca(maCa, tenCa, nv, thoiGianVaoCa, thoiGianKetCa, tongTien, tongTienThucTe, ghiChu);
				return ca;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public Ca taoCa(NhanVien nv, String tenCa) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		try {
			String sql = "insert into Ca(tenca,manhanvien) values(?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tenCa);
			stmt.setString(2, nv.getMaNhanVien());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maCa = rs.getString("maca");
				Ca ca = new Ca(maCa, tenCa, nv, null, null, 0, 0, "");
				return ca;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public Ca layMaCaTheoMaNVVaThoiGian(String maNV, LocalDate thoiGian) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		try {
			String sql = "select * from Ca where Ca.MaNhanVien = ?  and CAST(Ca.ThoiGianVaoCa AS DATE) = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maNV);
			stmt.setDate(2, Date.valueOf(thoiGian));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maCa = rs.getString(1);
				String tenCa = rs.getString(2);
				String maNhanVien = rs.getString(3);
				NhanVien nhanVien = new NhanVien(maNhanVien);
				LocalDateTime thoiGianVaoCa = LocalDateTime.parse(rs.getString(4), formatter);
				LocalDateTime thoiGianKetCa = LocalDateTime.parse(rs.getString(5), formatter);
				double tongTien = rs.getDouble(6);
				double tongTienThucTe = rs.getDouble(7);
				String ghiChu = rs.getString(8);
				Ca ca = new Ca(maCa, tenCa, nhanVien, thoiGianVaoCa, thoiGianKetCa, tongTien, tongTienThucTe, ghiChu);
				return ca;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
