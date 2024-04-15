package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.HangHoa;
import entities.LoaiHang;
import entities.NhomHang;
import entities.TrangThaiHangHoa;

public class HangHoaDao {
	public List<HangHoa> getAllDataHangHoa() {
		List<HangHoa> dsHangHoa = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "SELECT * FROM HangHoa";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maHH = rs.getString("MaHangHoa");
				String tenHH = rs.getString("TenHangHoa");
				
				String loaiHangStr = rs.getString("LoaiHang");
				LoaiHang loaiHang = LoaiHang.valueOf(loaiHangStr);
				
				String soDKy = rs.getString("SoDangKy");
				NhomHang maNH = new NhomHang(Integer.parseInt(rs.getString("MaNhomHang")));
				String nuocSX = rs.getString("NuocSanXuat");
				String hangSX = rs.getString("HangSanXuat");
				String hoatChat = rs.getString("HoatChatChinh");
				String hamLuong = rs.getString("HamLuong");
				String quyCachDG = rs.getString("QuyCachDongGoi");
				String moTa = rs.getString("MoTa");
				double thue = rs.getDouble("Thue");
				String maVach = rs.getString("MaVach");
				int soLuongDinhMuc = rs.getInt("SoLuongDinhMuc");
				int soLuongCanhBao = rs.getInt("SoLuongCanhBao");
				
				String trangThaiStr = rs.getString("TrangThai");
				TrangThaiHangHoa trangThai = TrangThaiHangHoa.valueOf(trangThaiStr);
				
				HangHoa hangHoa = new HangHoa(maHH, tenHH, soDKy, maNH, nuocSX, hangSX, hoatChat, hamLuong, quyCachDG, moTa, thue, maVach, soLuongDinhMuc, soLuongCanhBao, trangThai, loaiHang);
				
				dsHangHoa.add(hangHoa);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHangHoa;
	}
	public HangHoa timHangHoaTheoMa(String maHHoa) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from HangHoa left join NhomHang on HangHoa.MaNhomHang = NhomHang.MaNhomHang "
					+ "where MaHangHoa = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHHoa);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maHH = rs.getString("MaHangHoa");
				String tenHH = rs.getString("TenHangHoa");
				
				String loaiHangStr = rs.getString("LoaiHang");
				LoaiHang loaiHang = LoaiHang.valueOf(loaiHangStr);
				
				String soDKy = rs.getString("SoDangKy");
				
				int maNhomHang = Integer.parseInt(rs.getString("MaNhomHang"));
				String tenNhomHang = rs.getString("TenNhomHang");
				NhomHang maNH = new NhomHang(maNhomHang, tenNhomHang);
				String nuocSX = rs.getString("NuocSanXuat");
				String hangSX = rs.getString("HangSanXuat");
				String hoatChat = rs.getString("HoatChatChinh");
				String hamLuong = rs.getString("HamLuong");
				String quyCachDG = rs.getString("QuyCachDongGoi");
				String moTa = rs.getString("MoTa");
				double thue = rs.getDouble("Thue");
				String maVach = rs.getString("MaVach");
				int soLuongDinhMuc = rs.getInt("SoLuongDinhMuc");
				int soLuongCanhBao = rs.getInt("SoLuongCanhBao");
				
				String trangThaiStr = rs.getString("TrangThai");
				TrangThaiHangHoa trangThai = TrangThaiHangHoa.valueOf(trangThaiStr);
				
				HangHoa hangHoa = new HangHoa(maHH, tenHH, soDKy, maNH, nuocSX, hangSX, hoatChat, hamLuong, quyCachDG, moTa, thue, maVach, soLuongDinhMuc, soLuongCanhBao, trangThai, loaiHang);
				
				return hangHoa;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public HangHoa timHangHoa(String maTenHHoa,  String loaiHHoa, String nhomHHoa, String trangThaiHH) {
//		List<HangHoa> dsHangHoa = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from HangHoa left join NhomHang on HangHoa.MaNhomHang = NhomHang.MaNhomHang "
					+ "where (MaHangHoa = ?  and LoaiHang = ? and TrangThai = ? or TenNhomHang = ?) "
					+ "or (TenHangHoa = ? and LoaiHang = ? and TrangThai = ? or TenNhomHang = ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maTenHHoa);
			stmt.setString(2, loaiHHoa);
			stmt.setString(3, trangThaiHH);
			stmt.setString(4, nhomHHoa);
			
			stmt.setString(5, maTenHHoa);
			stmt.setString(6, loaiHHoa);
			stmt.setString(7, trangThaiHH);
			stmt.setString(8, nhomHHoa);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maHH = rs.getString("MaHangHoa");
				String tenHH = rs.getString("TenHangHoa");
				
				String loaiHangStr = rs.getString("LoaiHang");
				LoaiHang loaiHang = LoaiHang.valueOf(loaiHangStr);
				
				String soDKy = rs.getString("SoDangKy");
				
				int maNhomHang = Integer.parseInt(rs.getString("MaNhomHang"));
				String tenNhomHang = rs.getString("TenNhomHang");
				NhomHang maNH = new NhomHang(maNhomHang, tenNhomHang);
				String nuocSX = rs.getString("NuocSanXuat");
				String hangSX = rs.getString("HangSanXuat");
				String hoatChat = rs.getString("HoatChatChinh");
				String hamLuong = rs.getString("HamLuong");
				String quyCachDG = rs.getString("QuyCachDongGoi");
				String moTa = rs.getString("MoTa");
				double thue = rs.getDouble("Thue");
				String maVach = rs.getString("MaVach");
				int soLuongDinhMuc = rs.getInt("SoLuongDinhMuc");
				int soLuongCanhBao = rs.getInt("SoLuongCanhBao");
				
				String trangThaiStr = rs.getString("TrangThai");
				TrangThaiHangHoa trangThai = TrangThaiHangHoa.valueOf(trangThaiStr);
				
				HangHoa hangHoa = new HangHoa(maHH, tenHH, soDKy, maNH, nuocSX, hangSX, hoatChat, hamLuong, quyCachDG, moTa, thue, maVach, soLuongDinhMuc, soLuongCanhBao, trangThai, loaiHang);
				
//				dsHangHoa.add(hangHoa);
				return hangHoa;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public List<HangHoa> locHangHoa( String loaiHHoa, String nhomHHoa, String trangThaiHH) {
		List<HangHoa> dsHangHoa = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from HangHoa left join NhomHang on HangHoa.MaNhomHang = NhomHang.MaNhomHang "
					+ "where  LoaiHang = ? or TrangThai = ? or TenNhomHang = ? ";
					
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, loaiHHoa);
			stmt.setString(2, trangThaiHH);
			stmt.setString(3, nhomHHoa);
			
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maHH = rs.getString("MaHangHoa");
				String tenHH = rs.getString("TenHangHoa");
				
				String loaiHangStr = rs.getString("LoaiHang");
				LoaiHang loaiHang = LoaiHang.valueOf(loaiHangStr);
				
				String soDKy = rs.getString("SoDangKy");
				
				int maNhomHang = Integer.parseInt(rs.getString("MaNhomHang"));
				String tenNhomHang = rs.getString("TenNhomHang");
				NhomHang maNH = new NhomHang(maNhomHang, tenNhomHang);
				String nuocSX = rs.getString("NuocSanXuat");
				String hangSX = rs.getString("HangSanXuat");
				String hoatChat = rs.getString("HoatChatChinh");
				String hamLuong = rs.getString("HamLuong");
				String quyCachDG = rs.getString("QuyCachDongGoi");
				String moTa = rs.getString("MoTa");
				double thue = rs.getDouble("Thue");
				String maVach = rs.getString("MaVach");
				int soLuongDinhMuc = rs.getInt("SoLuongDinhMuc");
				int soLuongCanhBao = rs.getInt("SoLuongCanhBao");
				
				String trangThaiStr = rs.getString("TrangThai");
				TrangThaiHangHoa trangThai = TrangThaiHangHoa.valueOf(trangThaiStr);
				
				HangHoa hangHoa = new HangHoa(maHH, tenHH, soDKy, maNH, nuocSX, hangSX, hoatChat, hamLuong, quyCachDG, moTa, thue, maVach, soLuongDinhMuc, soLuongCanhBao, trangThai, loaiHang);
				
				dsHangHoa.add(hangHoa);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHangHoa;
	}
	
	public boolean themHangHoa(HangHoa hh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection(); 
		PreparedStatement stmt = null;
		String sql = "Insert into HangHoa "
				+ "(TenHangHoa, LoaiHang, SoDangKy, MaNhomHang, NuocSanXuat,"
				+ "HangSanXuat, HoatChatChinh, HamLuong, QuyCachDongGoi, MoTa, Thue, MaVach, SoLuongDinhMuc, SoLuongCanhBao, TrangThai) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, hh.getTenHangHoa());
			stmt.setString(2, hh.getLoaiHang().toString());
			stmt.setString(3, hh.getSoDangKy());
			stmt.setInt(4, hh.getNhomHang().getMaNhomHang());
			stmt.setString(5, hh.getNuocSanXuat());
			stmt.setString(6, hh.getHangSanXuat());
			stmt.setString(7, hh.getHoatChatChinh());
			stmt.setString(8, hh.getHamLuong());
			stmt.setString(9,  hh.getQuyCachDongGoi());
			stmt.setString(10, hh.getMoTa());
			stmt.setDouble(11, hh.getThue());
			stmt.setString(12, hh.getMaVach());
			stmt.setInt(13, hh.getSoLuongDinhMuc());
			stmt.setInt(14, hh.getSoLuongCanhBao());
			stmt.setString(15, hh.getTrangThaiHangHoa().toString());
			
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
