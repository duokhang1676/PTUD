package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.Ca;
import entities.ChiTietHoaDon;
import entities.DonViTinh;
import entities.HangHoa;
import entities.NhanVien;
import entities.TrangThaiDonViTinh;

public class ChiTietHoaDonDao {
	public boolean addChiTietHD(ChiTietHoaDon ct, double thanhTien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "insert into ChiTietHoaDon (MaHoaDon, MaDonViTinh, SoLuong, DonGia, ThanhTien) values(?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, ct.getHoaDon().getMaHoaDon());
			stmt.setInt(2, ct.getDonViTinh().getMaDonViTinh());
			stmt.setInt(3, ct.getSoLuong());
			stmt.setDouble(4, ct.getDonGia());
			stmt.setDouble(5, thanhTien);
			
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public List<ChiTietHoaDon> getDSDonViTinh(LocalDate from, LocalDate to){
		List<ChiTietHoaDon> dsDVT = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT \r\n"
					+ "	ct.MaDonViTinh,\r\n"
					+ "	sum(ct.SoLuong) as SoLuong,\r\n"
					+ "	sum(ct.ThanhTien) as ThanhTien \r\n"
					+ "FROM \r\n"
					+ "    HoaDon hd\r\n"
					+ "JOIN \r\n"
					+ "    ChiTietHoaDon ct ON hd.MaHoaDon = ct.MaHoaDon\r\n"
					+ "WHERE \r\n"
					+ "    hd.ThoiGianLapHoaDon BETWEEN ? AND ? and hd.TrangThai = 'HOAN_THANH'\r\n"
					+ "Group by\r\n"
					+ "	ct.MaDonViTinh\r\n"
					+ "order by\r\n"
					+ "	SoLuong DESC,ThanhTien DESC";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, from.toString());
			stmt.setString(2, to.toString());
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int maDVT = rs.getInt("MaDonViTinh");	
				DonViTinh dvt = new DonViTinhDao().timDVTTheoMa(maDVT);
				int soLuong = rs.getInt("SoLuong");
				double thanhTien = rs.getDouble("ThanhTien");
				
				ChiTietHoaDon cthd = new ChiTietHoaDon(null, soLuong, thanhTien, dvt);
				dsDVT.add(cthd);
			}
			return dsDVT;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	

}
