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
	
				int soLuongDinhMuc = rs.getInt("SoLuongDinhMuc");
				int soLuongCanhBao = rs.getInt("SoLuongCanhBao");
				
				String trangThaiStr = rs.getString("TrangThai");
				TrangThaiHangHoa trangThai = TrangThaiHangHoa.valueOf(trangThaiStr);
				
				HangHoa hangHoa = new HangHoa(maHH, tenHH, loaiHang, soDKy, maNH, nuocSX, hangSX, hoatChat, hamLuong, quyCachDG, moTa, thue, soLuongDinhMuc, soLuongCanhBao, trangThai);
				
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
				int soLuongDinhMuc = rs.getInt("SoLuongDinhMuc");
				int soLuongCanhBao = rs.getInt("SoLuongCanhBao");
				
				String trangThaiStr = rs.getString("TrangThai");
				TrangThaiHangHoa trangThai = TrangThaiHangHoa.valueOf(trangThaiStr);
				
				HangHoa hangHoa = new HangHoa(maHH, tenHH, loaiHang, soDKy, maNH, nuocSX, hangSX, hoatChat, hamLuong, quyCachDG, moTa, thue, soLuongDinhMuc, soLuongCanhBao, trangThai);
				
				return hangHoa;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public HangHoa timHangHoaTheoMaTheoTen(String maHHoa) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from HangHoa left join NhomHang on HangHoa.MaNhomHang = NhomHang.MaNhomHang "
					+ "where MaHangHoa = ? or TenHangHoa = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHHoa);
			stmt.setString(2, maHHoa);
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
				int soLuongDinhMuc = rs.getInt("SoLuongDinhMuc");
				int soLuongCanhBao = rs.getInt("SoLuongCanhBao");
				
				String trangThaiStr = rs.getString("TrangThai");
				TrangThaiHangHoa trangThai = TrangThaiHangHoa.valueOf(trangThaiStr);
				
				HangHoa hangHoa = new HangHoa(maHH, tenHH, loaiHang, soDKy, maNH, nuocSX, hangSX, hoatChat, hamLuong, quyCachDG, moTa, thue, soLuongDinhMuc, soLuongCanhBao, trangThai);
				
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
				int soLuongDinhMuc = rs.getInt("SoLuongDinhMuc");
				int soLuongCanhBao = rs.getInt("SoLuongCanhBao");
				
				String trangThaiStr = rs.getString("TrangThai");
				TrangThaiHangHoa trangThai = TrangThaiHangHoa.valueOf(trangThaiStr);
				
				HangHoa hangHoa = new HangHoa(maHH, tenHH, loaiHang, soDKy, maNH, nuocSX, hangSX, hoatChat, hamLuong, quyCachDG, moTa, thue, soLuongDinhMuc, soLuongCanhBao, trangThai);
				
				dsHangHoa.add(hangHoa);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHangHoa;
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
			
			String loaiHHStr = "";
			if (loaiHHoa.equals("Dược phẩm")) {
				loaiHHStr = LoaiHang.DUOC_PHAM.toString();
			}else if (loaiHHoa.equals("Khác")) {
				loaiHHStr = LoaiHang.KHAC.toString();
			}else {
				loaiHHStr = LoaiHang.VAT_TU_YTE.toString();
			}
			
			String trangThaiHHStr = "";
			if (trangThaiHH.equals("Đang bán")) {
				trangThaiHHStr = TrangThaiHangHoa.DANG_BAN.toString();
			}else {
				trangThaiHHStr = TrangThaiHangHoa.NGUNG_BAN.toString();
			}
			stmt.setString(1, maTenHHoa);
			stmt.setString(2, loaiHHStr);
			stmt.setString(3, trangThaiHHStr);
			stmt.setString(4, nhomHHoa);
			
			stmt.setString(5, maTenHHoa);
			stmt.setString(6, loaiHHStr);
			stmt.setString(7, trangThaiHHStr);
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
				int soLuongDinhMuc = rs.getInt("SoLuongDinhMuc");
				int soLuongCanhBao = rs.getInt("SoLuongCanhBao");
				
				String trangThaiStr = rs.getString("TrangThai");
				TrangThaiHangHoa trangThai = TrangThaiHangHoa.valueOf(trangThaiStr);
				
				HangHoa hangHoa = new HangHoa(maHH, tenHH, loaiHang, soDKy, maNH, nuocSX, hangSX, hoatChat, hamLuong, quyCachDG, moTa, thue, soLuongDinhMuc, soLuongCanhBao, trangThai);
				
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
				int soLuongDinhMuc = rs.getInt("SoLuongDinhMuc");
				int soLuongCanhBao = rs.getInt("SoLuongCanhBao");
				
				String trangThaiStr = rs.getString("TrangThai");
				TrangThaiHangHoa trangThai = TrangThaiHangHoa.valueOf(trangThaiStr);
				
				HangHoa hangHoa = new HangHoa(maHH, tenHH, loaiHang, soDKy, maNH, nuocSX, hangSX, hoatChat, hamLuong, quyCachDG, moTa, thue, soLuongDinhMuc, soLuongCanhBao, trangThai);
				
				dsHangHoa.add(hangHoa);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsHangHoa;
	}
	
	public HangHoa themHangHoa(HangHoa hh) {
	    int affectedRows = 0;
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection(); 
	    PreparedStatement stmt = null;
	    String sql = "Insert into HangHoa "
	                + "(TenHangHoa, LoaiHang, SoDangKy, MaNhomHang, NuocSanXuat,"
	                + "HangSanXuat, HoatChatChinh, HamLuong, QuyCachDongGoi, MoTa, Thue, SoLuongDinhMuc, SoLuongCanhBao, TrangThai) "
	                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    try {
	        stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

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
	        stmt.setInt(12, hh.getSoLuongDinhMuc());
	        stmt.setInt(13, hh.getSoLuongCanhBao());
	        stmt.setString(14, hh.getTrangThaiHangHoa().toString());

//	        affectedRows = stmt.executeUpdate();
//
//	        if (affectedRows > 0) {
//	            ResultSet generatedKeys = stmt.getGeneratedKeys();
//	            if (generatedKeys.next()) {
//	                String maHangHoa = generatedKeys.getString(1);
//	                hh.setMaHangHoa(maHangHoa);
//	                System.out.println(maHangHoa);
//	                return hh;
//	            }
//	        }
//	        if (affectedRows > 0) {
//	            // Thực hiện một truy vấn SELECT để lấy MaHangHoa mới
//	            String query = "SELECT MaHangHoa FROM HangHoa";
//	            PreparedStatement selectStmt = con.prepareStatement(query);
//	            // Thực hiện các tham số của truy vấn SELECT nếu cần
//	            ResultSet resultSet = selectStmt.executeQuery();
//
//	            if (resultSet.next()) {
//	                String maHangHoa = resultSet.getString("MaHangHoa");
//	                hh.setMaHangHoa(maHangHoa);
//	                System.out.println(maHangHoa);
//	                return hh;
//	            }
//	        }
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
				String maHH = rs.getString("MaHangHoa");
				
				hh.setMaHangHoa(maHH);
				return hh;
			}
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public boolean updateHangHoa(HangHoa hh, String maHH) {
		ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection(); 
	    PreparedStatement stmt = null;
	    String sql = "Update HangHoa set"
	                + "TenHangHoa = ?, LoaiHang = ?, SoDangKy = ?, MaNhomHang = ?, NuocSanXuat = ?,"
	                + "HangSanXuat = ?, HoatChatChinh = ?, HamLuong = ?, QuyCachDongGoi = ?, MoTa = ?, Thue = ?, SoLuongDinhMuc = ?, SoLuongCanhBao = ?, TrangThai = ?"
	                + "where MaThuoc = ?";
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
	        stmt.setInt(12, hh.getSoLuongDinhMuc());
	        stmt.setInt(13, hh.getSoLuongCanhBao());
	        stmt.setString(14, hh.getTrangThaiHangHoa().toString());
	        
	        stmt.setString(15, maHH);
	        
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
