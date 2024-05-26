package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.ChiTietPhieuNhapHang;
import entities.ChiTietPhieuXuatTra;
import entities.DonViTinh;
import entities.LoHang;
import entities.PhieuNhapHang;
import entities.PhieuXuatTra;

public class ChiTietPhieuXuatTraDao {
	public boolean addChiTietPNH(ChiTietPhieuXuatTra ct, double thanhTien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "insert into ChiTietPhieuXuatTra (MaPhieuXuatTra, SoLo, MaDonViTinh, SoLuong, ChietKhau, ThanhTien) "
				+ "values (?,?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ct.getPhieuXuatTraNCC().getMaPhieuXuatTra());
			stmt.setString(2, ct.getLoHang().getSoLo());
			stmt.setInt(3, ct.getDonViTinh().getMaDonViTinh());
			stmt.setInt(4, ct.getSoLuong());
			stmt.setDouble(5, ct.getChietKhau());
			stmt.setDouble(6, thanhTien);
			
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public List<ChiTietPhieuXuatTra> getChiTietPXT(String maPhieu){
		List<ChiTietPhieuXuatTra> dsCT = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		DonViTinhDao dvt_dao = new DonViTinhDao();
		PhieuXuatTraDao pxt_dao = new PhieuXuatTraDao();
		LoHangDao lo_dao = new LoHangDao();
		String sql = "select * from ChiTietPhieuXuatTra where MaPhieuXuatTra = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maPhieu);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maPNH = rs.getString("MaPhieuXuatTra");
				PhieuXuatTra pxt = pxt_dao.getPXTTheoMa(maPNH);
				
				String soLo = rs.getString("SoLo");
				LoHang lo = lo_dao.timLoHangTheoMa(soLo);
				
				DonViTinh dvt = dvt_dao.timDVTTheoMa(rs.getInt("MaDonViTinh"));
				int soLuong = rs.getInt("SoLuong");
				double chietKhau = rs.getDouble("ChietKhau");
				double thanhTien = rs.getDouble("ThanhTien");
						
				ChiTietPhieuXuatTra ct = new ChiTietPhieuXuatTra(pxt, lo, dvt, soLuong, thanhTien, chietKhau);
				dsCT.add(ct);
				return dsCT;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
