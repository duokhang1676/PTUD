package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.Ca;
import entities.HangHoa;
import entities.HoaDon;
import entities.KhachHang;
import entities.LoaiHang;
import entities.NhanVien;
import entities.NhomHang;
import entities.TrangThaiHangHoa;
import entities.TrangThaiHoaDon;

public class HoaDonDao {
	public HoaDonDao() {
		// TODO Auto-generated constructor stub
	}
	public double getTongTienHoaDonTrongKhoang(LocalDate from, LocalDate to) {
		double tongTien = 0;
		try {
			db.ConnectDB.getInstance();
			Connection con = db.ConnectDB.getConnection();
			String sql = "SELECT SUM(TongTien) AS TongTienCacHoaDon\r\n"
					+ "FROM HoaDon\r\n"
					+ "WHERE CAST(ThoiGianLapHoaDon AS DATE) BETWEEN ? AND ? AND TrangThai = 'HOAN_THANH';";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(from));
			stmt.setDate(2, Date.valueOf(to));
		
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			tongTien = rs.getDouble("TongTienCacHoaDon");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tongTien;
	}
	public int getSoLuongHoaDonTrongKhoang(LocalDate from, LocalDate to) {
		int soLuong = 0;
		try {
			db.ConnectDB.getInstance();
			Connection con = db.ConnectDB.getConnection();
			String sql = "select count(MaHoaDon) as SoLuongHoaDon\r\n"
					+ "from HoaDon\r\n"
					+ "where CAST(ThoiGianLapHoaDon AS DATE) BETWEEN ? AND ? AND TrangThai = 'HOAN_THANH';";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(from));
			stmt.setDate(2, Date.valueOf(to));
		
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			soLuong = rs.getInt("SoLuongHoaDon");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return soLuong;
	}
	public List<HoaDon> getAllHoaDon() {
		List<HoaDon> dsHoaDon = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from HoaDon join KhachHang on HoaDon.MaKhachHang = KhachHang.MaKhachHang join NhanVien on HoaDon.MaNhanVien = NhanVien.MaNhanVien";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			while (rs.next()) {
				String maHD = rs.getString("MaHoaDon");
				LocalDateTime thoiGianLap = LocalDateTime.parse(rs.getString("ThoiGianLapHoaDon"), formatter);
				NhanVien nv = new NhanVien(rs.getString("MaNhanVien"), rs.getString("TenNhanVien"));
				KhachHang kh = new KhachHang(rs.getString("MaKhachHang"), rs.getString("TenKhachHang"));
				double tienKhachTra = rs.getDouble("TienKhachTra");
				int diemQuyDoi = rs.getInt("DiemQuyDoi");
				double tongTien = rs.getDouble("TongTien");
//				double tienThua = rs.getDouble("TienThua");
				String ghiChu = rs.getString("GhiChu");
				Ca ca = new Ca(rs.getString("MaCa"));
				String trangThaiStr = rs.getString("TrangThai");
				TrangThaiHoaDon trangThai = TrangThaiHoaDon.valueOf(trangThaiStr);
				
				
				HoaDon hd = new HoaDon(maHD, thoiGianLap, nv, kh, tienKhachTra, diemQuyDoi, ghiChu, ca, trangThai, 0);
				dsHoaDon.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHoaDon;
	}
	
	public boolean addHoaDon(HoaDon hd, double tongTien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "insert into HoaDon (ThoiGianLapHoaDon, MaNhanVien, MaKhachHang, TienKhachTra, DiemQuyDoi, GhiChu, MaCa, TrangThai, TongTien, MaHoaDon) "
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setDate(1, Date.valueOf(hd.getThoiGianLapHoaDon().toLocalDate()));
			stmt.setString(2, hd.getNhanVien().getMaNhanVien());
			stmt.setString(3, hd.getKhachHang().getMaKhachHang());
			stmt.setDouble(4, hd.getTienKhachTra());
			stmt.setInt(5, hd.getDiemQuyDoi());
			stmt.setString(6, hd.getGhiChu());
			stmt.setString(7, hd.getCa().getMaCa());
			stmt.setString(8, hd.getTrangThaiHoaDon().toString());
			stmt.setDouble(9, tongTien);
			stmt.setString(10, hd.getMaHoaDon());
			
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
