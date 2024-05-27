package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.Ca;
import entities.HoaDon;
import entities.NhanVien;


public class Ca_DAO {
	public Ca_DAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean updateCa(Ca ca) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

        try {
            String sql = "UPDATE Ca SET "
                       + "TenCa = ?, "
                       + "ThoiGianKetCa = ?,"
                       + "TongTien = ?, "
                     + "TongTienThucTe = ?,"
                       + "GhiChu = ? ,"
                      + "TienChenhLech = ?, "
                       + "TrangThai = ? "
                       + "WHERE MaCa = ?"
;
           
            stmt = con.prepareStatement(sql);
            stmt.setString(1, ca.getTenCa());
            stmt.setTimestamp(2,Timestamp.valueOf(ca.getThoiGianKetCa()));
            stmt.setDouble(3, ca.getTongTien());
            stmt.setDouble(4, ca.getTongTienThucTe());
            stmt.setString(5, ca.getGhiChu());
            stmt.setDouble(6, ca.tinhTienChenhLech());
            stmt.setBoolean(7, ca.isTrangThai());
            stmt.setString(8, ca.getMaCa());

            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
	public Ca taoCa(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		try {
			String sql = "insert into Ca(manhanvien) values(?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nv.getMaNhanVien());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maCa = rs.getString("maca");
				Ca ca = getCaByMaCa(maCa);
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
	public List<Ca> getCaByNV(String maNV, boolean trangThai, String tenCa) {
		List<Ca> dsCa = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "";
		if(tenCa.equals("Tất cả")) {
			
			sql = "select * from Ca where manhanvien = ? and trangthai = ?";
		}
		else sql = "select * from Ca where manhanvien = ? and trangthai = ?  and tenca = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maNV);
			stmt.setBoolean(2,trangThai);
			if(!tenCa.equals("Tất cả"))
				stmt.setString(3, tenCa);
			ResultSet rs = stmt.executeQuery();
			// Định dạng mẫu để phân tích
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			while (rs.next()) {
				String maCa = rs.getString("maca");
				String ten = rs.getString("tenca");
				// Lấy dữ liệu dưới dạng Timestamp
                Timestamp tgVaoTimestamp = rs.getTimestamp("thoigianvaoca");
                Timestamp tgKetCaTimestamp = rs.getTimestamp("thoigianketca");
                LocalDateTime thoiGianKetCa = null;
                if(tgKetCaTimestamp!=null)
                	thoiGianKetCa = tgKetCaTimestamp.toLocalDateTime();
                // Chuyển đổi Timestamp sang LocalDateTime
                LocalDateTime thoiGianVaoCa = tgVaoTimestamp.toLocalDateTime();
                NhanVien nv = new NhanVien_DAO().getNVbyMa(maNV);
				double tongTien = rs.getDouble("tongtien");
				double tongTienThucTe = rs.getDouble("tongTienThucTe");
				String ghiChu = rs.getString("ghichu");
				Ca ca = new Ca(maCa, ten, nv , thoiGianVaoCa, thoiGianKetCa, tongTien, tongTienThucTe, ghiChu, trangThai);
				dsCa.add(ca); 
			}
			return dsCa;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public List<Ca> getCaByTime(LocalDate from,LocalDate to, boolean trangThai, String tenCa) {
		List<Ca> dsCa = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "";
		if(tenCa.equals("Tất cả"))
			sql = "select * from Ca where (CAST(ThoiGianVaoCa AS DATE) BETWEEN ? AND ? or CAST(ThoiGianKetCa AS DATE) BETWEEN ? AND ?)  and trangthai = ?";
		else sql = "select * from Ca where (CAST(ThoiGianVaoCa AS DATE) BETWEEN ? AND ? or CAST(ThoiGianKetCa AS DATE) BETWEEN ? AND ?)  and trangthai = ? and tenca = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setDate(1,Date.valueOf(from));
			stmt.setDate(2,Date.valueOf(to));
			stmt.setDate(3,Date.valueOf(from));
			stmt.setDate(4,Date.valueOf(to));
			stmt.setBoolean(5,trangThai);
			if(!tenCa.equals("Tất cả"))
				stmt.setString(6, tenCa);
			ResultSet rs = stmt.executeQuery();
			// Định dạng mẫu để phân tích
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			while (rs.next()) {
				String maCa = rs.getString("maca");
				String ten = rs.getString("tenca");
				// Lấy dữ liệu dưới dạng Timestamp
                Timestamp tgVaoTimestamp = rs.getTimestamp("thoigianvaoca");
                Timestamp tgKetCaTimestamp = rs.getTimestamp("thoigianketca");
                LocalDateTime thoiGianKetCa = null;
                if(tgKetCaTimestamp!=null)
                	thoiGianKetCa = tgKetCaTimestamp.toLocalDateTime();
                // Chuyển đổi Timestamp sang LocalDateTime
                LocalDateTime thoiGianVaoCa = tgVaoTimestamp.toLocalDateTime();
                NhanVien nv = new NhanVien_DAO().getNVbyMa(rs.getString("manhanvien"));
				double tongTien = rs.getDouble("tongtien");
				double tongTienThucTe = rs.getDouble("tongTienThucTe");
				String ghiChu = rs.getString("ghichu");
				Ca ca = new Ca(maCa, ten, nv , thoiGianVaoCa, thoiGianKetCa, tongTien, tongTienThucTe, ghiChu, trangThai);
				dsCa.add(ca); 
			}
			return dsCa;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
