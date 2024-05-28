package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.DonViTinh;
import entities.HangHoa;
import entities.LoaiHang;
import entities.NhomHang;
import entities.TrangThaiDonViTinh;
import entities.TrangThaiHangHoa;

public class DonViTinhDao {
	public boolean themDVT(DonViTinh dvt) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "Insert into DonViTinh(TenDonViTinh, MaHangHoa, QuyDoi, GiaBan, TrangThaiDonViTinh, MaVach) "
				+ "values(?,?,?,?,?,?)";
				
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, dvt.getTenDonViTinh());
			stmt.setString(2, dvt.getHangHoa().getMaHangHoa());
			stmt.setInt(3, dvt.getQuyDoi());
			stmt.setDouble(4, dvt.getGiaBan());
			stmt.setString(5, dvt.getTrangThaiDonViTinh().toString());
			stmt.setString(6, dvt.getMaVach());
			
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public List<DonViTinh> timDVTTheoMaHH(String maHHoa) {
		List<DonViTinh> dsDVT = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		HangHoaDao hangHoa_Dao = new HangHoaDao();
		try {
			String sql = "select * from DonViTinh where MaHangHoa = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHHoa);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int maDVT = rs.getInt("MaDonViTinh");	
				String tenDVT = rs.getString("TenDonViTinh");
				String maHH = rs.getString("MaHangHoa");

				HangHoa hh = new HangHoaDao().timHangHoaTheoMa(maHH);

				int quyDoi = rs.getInt("QuyDoi");
				Double giaBan = rs.getDouble("GiaBan");
				String maVach = rs.getString("MaVach");
				
				String trangThaiStr = rs.getString("TrangThaiDonViTinh");
				TrangThaiDonViTinh trangThai = TrangThaiDonViTinh.valueOf(trangThaiStr);
				
				DonViTinh dvt = new DonViTinh(maDVT, tenDVT, hh, quyDoi, giaBan, maVach, trangThai);
				dsDVT.add(dvt);
			}
			return dsDVT;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	//Lấy đơn vị tính theo mã hàng hóa vừa mới tìm được
	public DonViTinh layDVTTheoMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select top 1 * from DonViTinh \r\n"
					+ "where DonViTinh.MaVach = ? or MaHangHoa = ?\r\n"
					+ "ORDER BY QuyDoi\r\n"
					+ "ASC";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			stmt.setString(2, ma);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int maDVT = rs.getInt("MaDonViTinh");	
			String tenDVT = rs.getString("TenDonViTinh");
			String maHH = rs.getString("MaHangHoa");
			HangHoa hh = new HangHoaDao().timHangHoaTheoMa(maHH);
			int quyDoi = rs.getInt("QuyDoi");
			Double giaBan = rs.getDouble("GiaBan");
			String maVach = rs.getString("MaVach");
				
			String trangThaiStr = rs.getString("TrangThaiDonViTinh");
			TrangThaiDonViTinh trangThai = TrangThaiDonViTinh.valueOf(trangThaiStr);
				
			DonViTinh dvt = new DonViTinh(maDVT, tenDVT, hh, quyDoi, giaBan, maVach, trangThai);
			return dvt;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public DonViTinh timDVTTheoMa(int ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from DonViTinh where MaDonViTinh = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ma);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int maDVT = rs.getInt("MaDonViTinh");	
			String tenDVT = rs.getString("TenDonViTinh");
			String maHH = rs.getString("MaHangHoa");
			HangHoa hh = new HangHoaDao().timHangHoaTheoMa(maHH);
			int quyDoi = rs.getInt("QuyDoi");
			Double giaBan = rs.getDouble("GiaBan");
			String maVach = rs.getString("MaVach");
				
			String trangThaiStr = rs.getString("TrangThaiDonViTinh");
			TrangThaiDonViTinh trangThai = TrangThaiDonViTinh.valueOf(trangThaiStr);
				
			DonViTinh dvt = new DonViTinh(maDVT, tenDVT, hh, quyDoi, giaBan, maVach, trangThai);
			return dvt;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public DonViTinh timDVTTheoMaVach(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from DonViTinh where MaVach = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int maDVT = rs.getInt("MaDonViTinh");	
			String tenDVT = rs.getString("TenDonViTinh");
			String maHH = rs.getString("MaHangHoa");
			HangHoa hh = new HangHoaDao().timHangHoaTheoMa(maHH);
			int quyDoi = rs.getInt("QuyDoi");
			Double giaBan = rs.getDouble("GiaBan");
			String maVach = rs.getString("MaVach");
				
			String trangThaiStr = rs.getString("TrangThaiDonViTinh");
			TrangThaiDonViTinh trangThai = TrangThaiDonViTinh.valueOf(trangThaiStr);
				
			DonViTinh dvt = new DonViTinh(maDVT, tenDVT, hh, quyDoi, giaBan, maVach, trangThai);
			return dvt;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public List<DonViTinh> getAllDVT() {
		List<DonViTinh> dsDVT = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from DonViTinh ";
			stmt = con.prepareStatement(sql);
			
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int maDVT = rs.getInt("MaDonViTinh");	
			String tenDVT = rs.getString("TenDonViTinh");
			String maHH = rs.getString("MaHangHoa");
			HangHoa hh = new HangHoaDao().timHangHoaTheoMa(maHH);
			int quyDoi = rs.getInt("QuyDoi");
			Double giaBan = rs.getDouble("GiaBan");
			String maVach = rs.getString("MaVach");
				
			String trangThaiStr = rs.getString("TrangThaiDonViTinh");
			TrangThaiDonViTinh trangThai = TrangThaiDonViTinh.valueOf(trangThaiStr);
				
			DonViTinh dvt = new DonViTinh(maDVT, tenDVT, hh, quyDoi, giaBan, maVach, trangThai);
			dsDVT.add(dvt);
			return dsDVT;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	public DonViTinh timDVTTheoMaHHVaTen(String maHHoa, String tenDVTinh) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from DonViTinh where MaHangHoa = ? and TenDonViTinh = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHHoa);
			stmt.setString(2, tenDVTinh);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int maDVT = rs.getInt("MaDonViTinh");	
			String tenDVT = rs.getString("TenDonViTinh");
			String maHH = rs.getString("MaHangHoa");
			HangHoa hh = new HangHoaDao().timHangHoaTheoMa(maHH);
			int quyDoi = rs.getInt("QuyDoi");
			Double giaBan = rs.getDouble("GiaBan");
			String maVach = rs.getString("MaVach");
				
			String trangThaiStr = rs.getString("TrangThaiDonViTinh");
			TrangThaiDonViTinh trangThai = TrangThaiDonViTinh.valueOf(trangThaiStr);
				
			DonViTinh dvt = new DonViTinh(maDVT, tenDVT, hh, quyDoi, giaBan, maVach, trangThai);
			return dvt;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
		
		
		public DonViTinh layDVTTheoTenVaMaHangHoa(String maHangHoa, String tenDonVi) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			try {
				String sql = "select * from DonViTinh where DonViTinh.MaHangHoa = ? and DonViTinh.TenDonViTinh = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, maHangHoa);
				stmt.setString(2, tenDonVi);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				int maDVT = rs.getInt("MaDonViTinh");	
				String tenDVT = rs.getString("TenDonViTinh");
				String maHH = rs.getString("MaHangHoa");
				HangHoa hh = new HangHoaDao().timHangHoaTheoMa(maHH);
				int quyDoi = rs.getInt("QuyDoi");
				Double giaBan = rs.getDouble("GiaBan");
				String maVach = rs.getString("MaVach");		
				String trangThaiStr = rs.getString("TrangThaiDonViTinh");
				TrangThaiDonViTinh trangThai = TrangThaiDonViTinh.valueOf(trangThaiStr);
					
				DonViTinh dvt = new DonViTinh(maDVT, tenDVT, hh, quyDoi, giaBan, maVach, trangThai);
				return dvt;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}

		public boolean updateDVT(DonViTinh dvt, String mahh, String tenDVT) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection(); 
			PreparedStatement stmt = null;
			String sql = "UPDATE DonViTinh SET "
			           + "TenDonViTinh = ?, QuyDoi = ?, GiaBan = ?, TrangThaiDonViTinh = ?, MaVach = ? "
			           + "WHERE MaHangHoa = ? AND TenDonViTinh = ?";

			try {
				stmt = con.prepareStatement(sql);
				
				stmt.setString(1, dvt.getTenDonViTinh());
				stmt.setInt(2, dvt.getQuyDoi());
				stmt.setDouble(3, dvt.getGiaBan());
				stmt.setString(4, dvt.getTrangThaiDonViTinh().toString());
				stmt.setString(5, dvt.getMaVach());
				
				stmt.setString(6, mahh);
				stmt.setString(7, tenDVT);
				
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
