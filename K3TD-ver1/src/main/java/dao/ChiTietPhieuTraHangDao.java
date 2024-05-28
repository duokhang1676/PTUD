package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.ChiTietHoaDon;
import entities.ChiTietPhieuTraHang;
import entities.DonViTinh;
import entities.LoHang;
import entities.PhieuTraHang;

public class ChiTietPhieuTraHangDao {
	public boolean addPhieuTraHang(ChiTietPhieuTraHang chiTietPhieuTraHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "insert into ChiTietPhieuTraHang (maphieutrahang, soluongtra, dongia, madonvitinh, lydotra, solo,thanhtien)"
				+ "values (?,?,?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, chiTietPhieuTraHang.getPhieuTraHang().getMaPhieu());
			stmt.setInt(2, chiTietPhieuTraHang.getSoLuongTra());
			stmt.setDouble(3, chiTietPhieuTraHang.getDonGia());
			stmt.setInt(4, chiTietPhieuTraHang.getDonViTinh().getMaDonViTinh());
			stmt.setString(5, chiTietPhieuTraHang.getLyDoTra());
			stmt.setString(6, chiTietPhieuTraHang.getLoHang().getSoLo());
			stmt.setDouble(7, chiTietPhieuTraHang.tinhThanhTien());
			
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
					+ "	sum(ct.SoLuongTra) as SoLuong,\r\n"
					+ "	sum(ct.ThanhTien) as ThanhTien \r\n"
					+ "FROM \r\n"
					+ "    PhieuTraHang hd\r\n"
					+ "JOIN \r\n"
					+ "    ChiTietPhieuTraHang ct ON hd.MaPhieuTraHang = ct.MaPhieuTraHang\r\n"
					+ "WHERE \r\n"
					+ "    CAST(hd.ThoiGianTao AS DATE) BETWEEN ? AND ? and hd.TrangThai = 'HOAN_THANH'\r\n"
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
	public List<ChiTietPhieuTraHang> getDSCTTHbyMaPhieuTH(String maPhieuTraHang){
		List<ChiTietPhieuTraHang> dsCTPTH = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from chitietphieutrahang where maphieutrahang = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maPhieuTraHang);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int soLuongTra = rs.getInt("soluongtra");
				double donGia = rs.getDouble("dongia");
				DonViTinh dvt = new DonViTinhDao().timDVTTheoMa(rs.getInt("madonvitinh"));
				String lyDoTra = rs.getString("lydotra");
				LoHang loHang = new LoHangDao().getLoHangBySoLo(rs.getString("solo"));
				ChiTietPhieuTraHang chiTietPhieuTraHang = new ChiTietPhieuTraHang(null, soLuongTra, donGia, dvt, lyDoTra, loHang);
				dsCTPTH.add(chiTietPhieuTraHang);
			}
			return dsCTPTH;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
