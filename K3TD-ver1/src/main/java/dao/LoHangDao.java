package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.HangHoa;
import entities.LoHang;
import entities.LoaiHang;
import entities.NhaCungCap;
import entities.NhomHang;
import entities.TrangThaiHangHoa;

public class LoHangDao {
	public LoHangDao() {
		// TODO Auto-generated constructor stub
	}
	public List<LoHang> getDSLoTheoHSD(LocalDate hsd){
		List<LoHang> dsLoHang = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from LoHang\r\n"
					+ "where HanSuDung < ?";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(hsd));
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String soLo = rs.getString("SoLo");
				HangHoa hangHoa = new HangHoaDao().timHangHoaTheoMa(rs.getString("MaHangHoa"));
				int soLuong = rs.getInt("SoLuong");
				LocalDate hanSuDung = rs.getDate("HanSuDung").toLocalDate();
				
				
				LoHang loHang = new LoHang(soLo, hangHoa, soLuong, null, hanSuDung, 0, null);
				
				dsLoHang.add(loHang);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return dsLoHang;
	}
	public List<LoHang> getDSLoSapHetHSD(LocalDate hsd){
		List<LoHang> dsLoHang = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from LoHang\r\n"
					+ "where HanSuDung < ? AND HanSuDung > GETDATE()";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(hsd));
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String soLo = rs.getString("SoLo");
				HangHoa hangHoa = new HangHoaDao().timHangHoaTheoMa(rs.getString("MaHangHoa"));
				int soLuong = rs.getInt("SoLuong");
				LocalDate hanSuDung = rs.getDate("HanSuDung").toLocalDate();
				
				
				LoHang loHang = new LoHang(soLo, hangHoa, soLuong, null, hanSuDung, 0, null);
				
				dsLoHang.add(loHang);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return dsLoHang;
	}

	public LoHang timLoHangTheoMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		
		try {
			String sql = "Select * from LoHang where SoLo = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	String soLo = rs.getString("SoLo");
				HangHoa hangHoa = new HangHoaDao().timHangHoaTheoMa(rs.getString("MaHangHoa"));
				int soLuong = rs.getInt("SoLuong");
				LocalDate hanSuDung = rs.getDate("HanSuDung").toLocalDate();
				LocalDate ngaySX = rs.getDate("NgaySanXuat").toLocalDate();
				double giaNhap = rs.getDouble("GiaNhap");
				NhaCungCap ncc = new NhaCungCap_DAO().timNhaCCTheoTen(rs.getString("MaNhaCungCap"));
				
				LoHang loHang = new LoHang(soLo, hangHoa, soLuong, ngaySX, hanSuDung, giaNhap, ncc);
				return loHang;
            }
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return null;
	}
	
	public LoHang timLoHangTheoMaVaMaHH(String maLo,String maHH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		
		try {
			String sql = "Select * from LoHang where SoLo = ? and MaHangHoa = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maLo);
			stmt.setString(2, maHH);
			ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	String soLo = rs.getString("SoLo");
				HangHoa hangHoa = new HangHoaDao().timHangHoaTheoMa(rs.getString("MaHangHoa"));
				int soLuong = rs.getInt("SoLuong");
				LocalDate hanSuDung = rs.getDate("HanSuDung").toLocalDate();
				LocalDate ngaySX = rs.getDate("NgaySanXuat").toLocalDate();
				double giaNhap = rs.getDouble("GiaNhap");
				NhaCungCap ncc = new NhaCungCap_DAO().timNhaCCTheoTen(rs.getString("MaNhaCungCap"));
				
				LoHang loHang = new LoHang(soLo, hangHoa, soLuong, ngaySX, hanSuDung, giaNhap, ncc);
				return loHang;
            }
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return null;
		
	}
	public boolean createLoHang(LoHang lo) {
		// TODO Auto-generated method stub
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "insert into LoHang values(?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, lo.getSoLo());
			stmt.setString(2, lo.getHangHoa().getMaHangHoa());
			stmt.setInt(3, lo.getSoLuong());
			stmt.setDate(4, Date.valueOf(lo.getNgaySanXuat()));
			stmt.setDate(5, Date.valueOf(lo.getHanSuDung()));
			stmt.setDouble(6, lo.getGiaNhap());
			stmt.setString(7, lo.getNhaCungCap().getMaNhaCungCap());
			
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	public List<LoHang> getTop5LoTheoNgaySX(String mahh) {
		List<LoHang> dsLH = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from LoHang where MaHangHoa = ? order by NgaySanXuat DESC";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, mahh);
			ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	String soLo = rs.getString("SoLo");
				HangHoa hangHoa = new HangHoaDao().timHangHoaTheoMa(rs.getString("MaHangHoa"));
				int soLuong = rs.getInt("SoLuong");
				LocalDate hanSuDung = rs.getDate("HanSuDung").toLocalDate();
				LocalDate ngaySX = rs.getDate("NgaySanXuat").toLocalDate();
				double giaNhap = rs.getDouble("GiaNhap");
				NhaCungCap ncc = new NhaCungCap_DAO().timNhaCCTheoTen(rs.getString("MaNhaCungCap"));
				
				LoHang loHang = new LoHang(soLo, hangHoa, soLuong, ngaySX, hanSuDung, giaNhap, ncc);
				dsLH.add(loHang);
            }
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return dsLH;
	}


	
	public List<LoHang> timLoHangTheoHangHoa(HangHoa hangHoa) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		List<LoHang> dsLoHang = new ArrayList<>();
		try {
			String sql = "select * from LoHang where MaHangHoa = ?  order by hansudung";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, hangHoa.getMaHangHoa());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String soLo = rs.getString("SoLo");
				HangHoa hh = new HangHoaDao().timHangHoaTheoMa(rs.getString("MaHangHoa"));
				int soLuong = rs.getInt("SoLuong");
				LocalDate ngaySanXuat = rs.getDate("NgaySanXuat").toLocalDate();
				LocalDate hanSuDung = rs.getDate("HanSuDung").toLocalDate();
				double giaNhap = rs.getDouble("GiaNhap");
				NhaCungCap nhaCC = new NhaCungCap_DAO().timNhaCCTheoMaNCC(rs.getString("MaNhaCungCap"));
				LoHang loHang = new LoHang(soLo, hh, soLuong, ngaySanXuat, hanSuDung, giaNhap, nhaCC);
				dsLoHang.add(loHang);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return dsLoHang;
	}
	

	public LoHang getLoHangBySoLo(String soLo){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from LoHang\r\n"
					+ "where solo = ?";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setString(1, soLo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			HangHoa hangHoa = new HangHoaDao().timHangHoaTheoMa(rs.getString("MaHangHoa"));
			int soLuong = rs.getInt("SoLuong");
			LocalDate ngaySanXuat = rs.getDate("ngaysanxuat").toLocalDate();
			LocalDate hanSuDung = rs.getDate("HanSuDung").toLocalDate();
			double giaNhap = rs.getDouble("gianhap");
			NhaCungCap ncc = new NhaCungCap_DAO().getNCCByMa(rs.getString("manhacungcap"));
				
			LoHang loHang = new LoHang(soLo, hangHoa, soLuong, ngaySanXuat, hanSuDung, giaNhap, ncc);
				
			return loHang;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	

	public boolean updateSoLuong(int soLuong, String soLo) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "update LoHang set SoLuong = SoLuong + ? where SoLo = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, soLuong);
			stmt.setString(2, soLo);
			
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	public List<LoHang> getLoHangTheoMaHH(String ma) {
		List<LoHang> dsLoHang = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		
		try {
			String sql = "select * from LoHang where MaHangHoa = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	String soLo = rs.getString("SoLo");
				HangHoa hangHoa = new HangHoaDao().timHangHoaTheoMa(rs.getString("MaHangHoa"));
				int soLuong = rs.getInt("SoLuong");
				LocalDate hanSuDung = rs.getDate("HanSuDung").toLocalDate();
				LocalDate ngaySX = rs.getDate("NgaySanXuat").toLocalDate();
				double giaNhap = rs.getDouble("GiaNhap");
				NhaCungCap ncc = new NhaCungCap_DAO().timNhaCCTheoTen(rs.getString("MaNhaCungCap"));
				
				LoHang loHang = new LoHang(soLo, hangHoa, soLuong, ngaySX, hanSuDung, giaNhap, ncc);
				dsLoHang.add(loHang);
            }
            return dsLoHang;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean capNhatSoLuongLoTheoMaHHVaSoLo(int ketQua,HangHoa hangHoa, LoHang lo) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;			
		try {
				String sql = "update LoHang set SoLuong = ? where MaHangHoa = ? and SoLo = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, ketQua);
				stmt.setString(2, hangHoa.getMaHangHoa());
				stmt.setString(3, lo.getSoLo());
				stmt.executeUpdate();
				stmt.close();
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
