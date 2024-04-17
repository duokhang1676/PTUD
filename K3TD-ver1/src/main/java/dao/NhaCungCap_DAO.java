/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.ConnectDB;
import java.util.ArrayList;
import entities.NhaCungCap;
import entities.TrangThaiNCC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Admin
 */
public class NhaCungCap_DAO {
    ArrayList<NhaCungCap> dsNhaCungCap;
    NhaCungCap nCC;
    public NhaCungCap_DAO(){
        dsNhaCungCap = new ArrayList<NhaCungCap>();
    }
    public ArrayList<NhaCungCap> docTuBang(){
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "Select * from NhaCungCap";
            Statement stmt = con.createStatement();
            
            ResultSet rs  = stmt.executeQuery(sql);
            while (rs.next()){
                String ma  = rs.getString("MaNhaCungCap");
                String ten = rs.getString("TenNhaCungCap");
                String soDienThoai = rs.getString("SoDienThoai");
                String diaChi = rs.getString("DiaChi");
                String eMail  = rs.getString("Email");
                String ghiChu = rs.getString("GhiChu");
                TrangThaiNCC ttNCC = trangThaiHoatDong(rs.getString("TrangThai"));
                NhaCungCap nCC1 = new NhaCungCap(ma, ten, soDienThoai, diaChi, eMail, ghiChu, ttNCC);
                dsNhaCungCap.add(nCC1);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsNhaCungCap;
    }
      private TrangThaiNCC trangThaiHoatDong(String trangthaikhachhang){
        if (trangthaikhachhang.equals("DANG_HOAT_DONG")) {
            return TrangThaiNCC.DANG_HOAT_DONG;
        }
        return TrangThaiNCC.NGUNG_HOAT_DONG;
    }
     public boolean create(NhaCungCap ncc){
         Connection con = ConnectDB.getInstance().getConnection();
         PreparedStatement stmt = null;
         int n = 0;
         try {
             stmt = con.prepareStatement("insert into NhaCungCap values(?,?,?,?,?,?,?)");
             stmt.setString(1, ncc.getMaNhaCungCap());
             stmt.setString(2, ncc.getTenNhaCungCap());
             stmt.setString(3, ncc.getSoDienThoai());
             stmt.setString(4, ncc.getDiaChi());
             stmt.setString(5, ncc.getEmail());
             stmt.setString(6, ncc.getGhiChu());
             stmt.setString(7, ncc.getTrangThaiNCC().toString());
             n= stmt.executeUpdate();
         } catch (Exception e) {
             e.printStackTrace();
         }
         return n >0;
     }
    public ArrayList<NhaCungCap> timkiem_TuKhoa_TrangThai(String tuKhoa, String trangThai){
    	ArrayList<NhaCungCap> dsNhaCungCap4 = new ArrayList<>();
		String Change_Value__TrangThai = trangThai.equals("Đang hoạt động") ? "DANG_HOAT_DONG" : "NGUNG_HOAT_DONG";

    	try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql ;
			PreparedStatement stmt;
			if (tuKhoa.trim().isEmpty() ) {
				if (trangThai.equalsIgnoreCase("Tất cả")) {
					sql ="SELECT * FROM NhaCungCap";
					stmt =con.prepareStatement(sql);
				
				}
				else {
					sql = "SELECT * FROM NhaCungCap WHERE TrangThai = ?";
					stmt = con.prepareStatement(sql);
					stmt.setString(1, Change_Value__TrangThai);
				}	
			}
			else {
				if (trangThai.equalsIgnoreCase("Tất cả")) {
					sql = "SELECT * FROM LOPHOC WHERE MaNhaCungCap = ? OR TenNhaCungCap = ? OR SoDienThoai= ? OR  DiaChi = ? OR Email = ? OR GhiChu = ?";
					stmt = con.prepareStatement(sql);
		            stmt.setString(1, "%" + tuKhoa + "%");
		            stmt.setString(2, "%" + tuKhoa + "%");
		            stmt.setString(3, "%" + tuKhoa + "%");
		            stmt.setString(4, "%" + tuKhoa + "%");
		            stmt.setString(5, "%" + tuKhoa + "%");
		            stmt.setString(6, "%" + tuKhoa + "%");
		            stmt.setString(7, "%" + tuKhoa + "%");
				}
				else {
					String Change_Value_to_Suitable_for_sql = trangThai.equals("Đang hoạt động") ? "DANG_HOAT_DONG" : "NGUNG_HOAT_DONG";
					sql = "SELECT * FROM LOPHOC WHERE (MaNhaCungCap = ? OR TenNhaCungCap = ? OR SoDienThoai= ? OR  DiaChi = ? OR Email = ? OR GhiChu = ?) AND TrangThai =?";
					stmt = con.prepareStatement(sql);
		            stmt.setString(1, "%" + tuKhoa + "%");
		            stmt.setString(2, "%" + tuKhoa + "%");
		            stmt.setString(3, "%" + tuKhoa + "%");
		            stmt.setString(4, "%" + tuKhoa + "%");
		            stmt.setString(5, "%" + tuKhoa + "%");
		            stmt.setString(6, "%" + tuKhoa + "%");
		            stmt.setString(7, "%" + tuKhoa + "%");
		            stmt.setString(8, Change_Value_to_Suitable_for_sql);
				}
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString("MaNhaCUngCap");
				String ten = rs.getString("TenNhaCungCap");
				String so = rs.getString("SoDienThoai");
				String diachi = rs.getString("DiaChi");
				String email = rs.getString("Email");
				String ghiChu = rs.getString("GhiChu");
				TrangThaiNCC trangthai = rs.getString("TrangThai").equals("DANG_HOAT_DONG") ? TrangThaiNCC.DANG_HOAT_DONG : TrangThaiNCC.NGUNG_HOAT_DONG;
				NhaCungCap nCC = new NhaCungCap(ma, ten, so, diachi, email, ghiChu, trangthai);
				dsNhaCungCap4.add(nCC);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return dsNhaCungCap4;
    }
     
}
