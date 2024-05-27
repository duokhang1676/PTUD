package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.ChiTietPhieuNhapHang;
import entities.DonViTinh;
import entities.LoHang;
import entities.PhieuNhapHang;

public class ChiTietPhieuNhapHangDao {
	public boolean addChiTietPNH(ChiTietPhieuNhapHang ct) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "insert into ChiTietPhieuNhapHang (MaPhieuNhapHang, SoLo, MaDonViTinh, SoLuong, ChietKhau, ThanhTien) "
				+ "values (?,?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ct.getPhieuNhapHang().getMaPhieu());
			stmt.setString(2, ct.getLoHang().getSoLo());
			stmt.setInt(3, ct.getDonViTinh().getMaDonViTinh());
			stmt.setInt(4, ct.getSoLuong());
			stmt.setDouble(5, ct.getChietKhau());
			stmt.setDouble(6, ct.tinhThanhTien());
			
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public List<ChiTietPhieuNhapHang> getChiTietPNH(String maPhieu){
		List<ChiTietPhieuNhapHang> dsCT = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		DonViTinhDao dvt_dao = new DonViTinhDao();
		PhieuNhapHangDao pnh_dao = new PhieuNhapHangDao();
		LoHangDao lo_dao = new LoHangDao();
		String sql = "select * from ChiTietPhieuNhapHang where MaPhieuNhapHang = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maPhieu);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maPNH = rs.getString("MaPhieuNhapHang");
				PhieuNhapHang pnh = pnh_dao.getPNHTheoMa(maPNH);
				
				String soLo = rs.getString("SoLo");
				LoHang lo = lo_dao.timLoHangTheoMa(soLo);
				
				DonViTinh dvt = dvt_dao.timDVTTheoMa(rs.getInt("MaDonViTinh"));
				int soLuong = rs.getInt("SoLuong");
				double chietKhau = rs.getDouble("ChietKhau");
				
						
				ChiTietPhieuNhapHang ct = new ChiTietPhieuNhapHang(pnh, lo, dvt, soLuong, chietKhau);
				dsCT.add(ct);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsCT;
	}
}
