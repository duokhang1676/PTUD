package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.Ca;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhaCungCap;
import entities.NhanVien;
import entities.PhieuNhapHang;
import entities.PhieuTraHang;
import entities.PhieuXuatTra;
import entities.TrangThaiPhieuNhapHang;
import entities.TrangThaiPhieuTraHang;
import entities.TrangThaiPhieuXuatTra;

public class PhieuTraHangDao {
	public PhieuTraHangDao() {
		// TODO Auto-generated constructor stub
	}
	public List<PhieuTraHang> getPhieuTraHangByMa(String ma) {
		List<PhieuTraHang> dsPhieuTraHang = new ArrayList<>();
		try {
			db.ConnectDB.getInstance();
			Connection con = db.ConnectDB.getConnection();
			String sql = "Select * from phieutrahang where maphieutrahang = ? or mahoadon = ?";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			stmt.setString(2, ma);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String maPhieu = rs.getString("maphieutrahang");
				String tgString = rs.getString("thoigiantao");
				// Định dạng mẫu để phân tích
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                
                // Chuyển chuỗi thành đối tượng LocalDateTime
                LocalDateTime thoiGianTao = LocalDateTime.parse(tgString, formatter);
				HoaDon hd = new HoaDonDao().getHDbyMa(rs.getString("mahoadon"));
				String ghiChu = rs.getString("ghichu");
				Ca ca = new Ca_DAO().getCaByMaCa(rs.getString("maca"));
				NhanVien nv = new NhanVien_DAO().getNVbyMa(rs.getString("manhanvien"));
				double tongTien = rs.getDouble("tongtien");
				TrangThaiPhieuTraHang tt = TrangThaiPhieuTraHang.valueOf(rs.getString("trangthai"));
				PhieuTraHang phieuTraHang = new PhieuTraHang(maPhieu, thoiGianTao, hd, ghiChu, ca, nv, tongTien, tt);
				dsPhieuTraHang.add(phieuTraHang);
			}
			return dsPhieuTraHang;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public List<PhieuTraHang> getDSPhieuTraHangFromTo(LocalDate from, LocalDate to, TrangThaiPhieuTraHang tt) {
		List<PhieuTraHang> ds = new ArrayList<>();
		try {
			db.ConnectDB.getInstance();
			Connection con = db.ConnectDB.getConnection();
			String sql = "Select * from phieutrahang where CAST(ThoiGianTao AS DATE) BETWEEN ? AND ? AND TrangThai = ?";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(from));
			stmt.setDate(2, Date.valueOf(to));
			stmt.setString(3, tt.toString());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String maPhieu = rs.getString("maphieutrahang");
				String tgString = rs.getString("thoigiantao");
				// Định dạng mẫu để phân tích
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                
                // Chuyển chuỗi thành đối tượng LocalDateTime
                Timestamp thoiGian = rs.getTimestamp("thoigiantao");
                LocalDateTime thoiGianTao = thoiGian.toLocalDateTime();
				HoaDon hd = new HoaDonDao().getHDbyMa(rs.getString("mahoadon"));
				String ghiChu = rs.getString("ghichu");
				Ca ca = new Ca_DAO().getCaByMaCa(rs.getString("maca"));
				NhanVien nv = new NhanVien_DAO().getNVbyMa(rs.getString("manhanvien"));
				double tongTien = rs.getDouble("tongtien");
				
				PhieuTraHang phieuTraHang = new PhieuTraHang(maPhieu, thoiGianTao, hd, ghiChu, ca, nv, tongTien, tt);
				ds.add(phieuTraHang);
			}
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public double getTongTienHoaDonTraTrongKhoang(LocalDate from, LocalDate to) {
		double tongTien = 0;
		try {
			db.ConnectDB.getInstance();
			Connection con = db.ConnectDB.getConnection();
			String sql = "SELECT SUM(ThanhTien) AS TongTienCacHoaDonTra\r\n"
					+ "FROM PhieuTraHang\r\n"
					+ "WHERE CAST(ThoiGianTao AS DATE) BETWEEN ? AND ? AND TrangThai = 'HOAN_THANH';\r\n"
					+ "";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(from));
			stmt.setDate(2, Date.valueOf(to));
		
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			tongTien = rs.getDouble("TongTienCacHoaDonTra");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tongTien;
	}
	public int getSoLuongHoaDonTraTrongKhoang(LocalDate from, LocalDate to) {
		int soLuong = 0;
		try {
			db.ConnectDB.getInstance();
			Connection con = db.ConnectDB.getConnection();
			String sql = "select count(MaPhieuTraHang) as SoLuongHoaDonTra\r\n"
					+ "from PhieuTraHang\r\n"
					+ "where CAST(ThoiGianTao AS DATE) BETWEEN ? AND ? AND TrangThai = 'HOAN_THANH';\r\n"
					+ "";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(from));
			stmt.setDate(2, Date.valueOf(to));
		
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			soLuong = rs.getInt("SoLuongHoaDonTra");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return soLuong;
	}
	
	public List<HoaDon> getDSKHbyHD(LocalDate from, LocalDate to) {
		List<HoaDon> dsHD = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT \r\n"
					+ "	h.MaKhachHang,\r\n"
					+ "	count(hd.MaHoaDon) as SoLuong,\r\n"
					+ "	sum(hd.TongTien) as ThanhTien \r\n"
					+ "FROM \r\n"
					+ "    PhieuTraHang hd\r\n"
					+ "Join \r\n"
					+ "	 HoaDon h ON hd.MaHoaDon = h.MaHoaDon\r\n"
					+ "WHERE \r\n"
					+ "    CAST(hd.ThoiGianTao AS DATE) BETWEEN ? AND ? and hd.TrangThai = 'HOAN_THANH' \r\n"
					+ "Group by\r\n"
					+ "	h.MaKhachHang\r\n"
					+ "order by\r\n"
					+ "	SoLuong desc,ThanhTien Desc";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, from.toString());
			stmt.setString(2, to.toString());
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				KhachHang kh = null;
				if(rs.getString("MaKhachHang")!=null)
					kh = new KhachHang_DAO().getKHbyMa(rs.getString("MaKhachHang"));
				int soLuong = rs.getInt("SoLuong");
				double tongTien = rs.getDouble("ThanhTien");
				HoaDon hd2 = new HoaDon(null, null, null, kh, 0, soLuong, "", null, null, tongTien);
				dsHD.add(hd2);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return dsHD;
	}
	public List<HoaDon> getDSNVbyHD(LocalDate from, LocalDate to) {
		List<HoaDon> dsHD = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT \r\n"
					+ "	hd.MaNhanVien,\r\n"
					+ "	count(hd.MaPhieuTraHang) as SoLuong,\r\n"
					+ "	sum(hd.TongTien) as ThanhTien \r\n"
					+ "FROM \r\n"
					+ "    PhieuTraHang hd\r\n"
				
					+ "WHERE \r\n"
					+ "    CAST(hd.ThoiGianTao AS DATE) BETWEEN ? AND ? and hd.TrangThai = 'HOAN_THANH' \r\n"
					+ "Group by\r\n"
					+ "	hd.MaNhanVien\r\n"
					+ "order by\r\n"
					+ "	SoLuong desc,ThanhTien Desc";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, from.toString());
			stmt.setString(2, to.toString());
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NhanVien nv = null;
				if(rs.getString("MaNhanVien")!=null)
					nv = new NhanVien_DAO().getNVbyMa(rs.getString("MaNhanVien"));
				int soLuong = rs.getInt("SoLuong");
				double tongTien = rs.getDouble("ThanhTien");
				HoaDon hd2 = new HoaDon(null, null, nv, null, 0, soLuong, "", null, null, tongTien);
				dsHD.add(hd2);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return dsHD;
	}
	public boolean addPhieuTraHang(PhieuTraHang phieuTraHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "insert into PhieuTraHang (maphieutrahang, mahoadon, ghichu, maca,manhanvien, TongTien) "
				+ "values (?,?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, phieuTraHang.getMaPhieu());
			stmt.setString(2, phieuTraHang.getHoaDon().getMaHoaDon());
			stmt.setString(3, phieuTraHang.getGhiChu());
			if(phieuTraHang.getCa()!=null)
				stmt.setString(4, phieuTraHang.getCa().getMaCa());
			else
				stmt.setString(4, null);
			stmt.setString(5, phieuTraHang.getNhanVien().getMaNhanVien());
			stmt.setDouble(6, phieuTraHang.getTongTien());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean huyPhieuTraHang(String maPhieu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "update phieutrahang set trangthai = 'DA_HUY' where maphieutrahang = ?";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, maPhieu);
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
