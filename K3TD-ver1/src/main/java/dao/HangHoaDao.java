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
			String sql = "select * from HangHoa left join NhomHang on HangHoa.MaNhomHang = NhomHang.MaNhomHang where MaHangHoa = ?";
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
	public List<HangHoa> getHangHoaHetHang() {
		List<HangHoa> dsHangHoa = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from HangHoa\r\n"
					+ "where SoLuongDinhMuc <= SoLuongCanhBao";
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
}
