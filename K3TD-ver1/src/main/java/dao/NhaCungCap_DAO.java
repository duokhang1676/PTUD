/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.ConnectDB;
import java.util.ArrayList;

import entities.HangHoa;
import entities.LoaiHang;
import entities.NhaCungCap;
import entities.NhomHang;
import entities.TrangThaiHangHoa;
import entities.TrangThaiNCC;
import java.sql.Connection;
import java.sql.Date;
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
            String sql = "SELECT * FROM NhaCungCap";
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
             stmt = con.prepareStatement("insert into NhaCungCap(TenNhaCungCap,SoDienThoai,DiaChi,Email,GhiChu,TrangThai) values(?,?,?,?,?,?)");
//             stmt.setString(1, ncc.getMaNhaCungCap());
             stmt.setString(1, ncc.getTenNhaCungCap());
             stmt.setString(2, ncc.getSoDienThoai());
             stmt.setString(3, ncc.getDiaChi());
             stmt.setString(4, ncc.getEmail());
             stmt.setString(5, ncc.getGhiChu());
             stmt.setString(6, ncc.getTrangThaiNCC().toString());
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
			String sql =" SELECT * FROM NhaCungCap " ;
			PreparedStatement stmt =null;
                        ResultSet rs ;
			if (tuKhoa.trim().isEmpty() ) {
				if (trangThai.equalsIgnoreCase("Tất cả")) {
					sql ="SELECT * FROM NhaCungCap ";             
                                        stmt =con.prepareStatement(sql);
				}
				else {
                                        sql = " SELECT * FROM NhaCungCap WHERE TrangThai = ? ";
                                        stmt =con.prepareStatement(sql);
                                        stmt.setString(1, Change_Value__TrangThai);
                                }	
			}
                        else{
                            if (trangThai.equalsIgnoreCase("Tất cả")) {
                                sql = "SELECT * FROM NhaCungCap"
                                        + " WHERE MaNhaCungCap LIKE ? OR TenNhaCungCap LIKE ? OR SoDienThoai LIKE ? OR Email LIKE ? OR GhiChu LIKE ?   ";
                                stmt = con.prepareStatement(sql);
                                stmt.setString(1, "%" + tuKhoa + "%");
                                stmt.setString(2, "%" + tuKhoa + "%");
                                stmt.setString(3, "%" + tuKhoa + "%");
                                stmt.setString(4, "%" + tuKhoa + "%");
                                stmt.setString(5, "%" + tuKhoa + "%");
                            }
                            else{
                                sql = "SELECT * FROM NhaCungCap"
                                        + " WHERE (MaNhaCungCap LIKE ? OR TenNhaCungCap LIKE ? OR SoDienThoai LIKE ? OR Email LIKE ? OR GhiChu LIKE ? ) AND TrangThai = ?   ";
                                                                stmt = con.prepareStatement(sql);
                                stmt.setString(1, "%" + tuKhoa + "%");
                                stmt.setString(2, "%" + tuKhoa + "%");
                                stmt.setString(3, "%" + tuKhoa + "%");
                                stmt.setString(4, "%" + tuKhoa + "%");
                                stmt.setString(5, "%" + tuKhoa + "%");
                                stmt.setString(6, Change_Value__TrangThai);
                            }
                        }
                        rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString("MaNhaCungCap");
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
    
    public NhaCungCap timNhaCCTheoMaNCC(String maNCC) {
    	ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from NhaCungCap where MaNhaCungCap = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maNCC);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maNcc = rs.getString(1);
				String tenNCC = rs.getString(2);
				String sdt = rs.getString(3);
				String diaChi = rs.getString(4);
				String email = rs.getString(5);
				String ghiChu = rs.getString(6);
				TrangThaiNCC trangthai = rs.getString(7).equals("DANG_HOAT_DONG") ? TrangThaiNCC.DANG_HOAT_DONG : TrangThaiNCC.NGUNG_HOAT_DONG;
				NhaCungCap nhaCC = new NhaCungCap(maNcc, tenNCC, sdt, diaChi, email, ghiChu, trangthai);
				return nhaCC;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
      public NhaCungCap getNCCByMa(String maNCC){
          try {
              Connection con = ConnectDB.getInstance().getConnection();
              String sql = "SELECT * FROM NhaCungCap where manhacungcap = ?";
              PreparedStatement stmt = null;
  			stmt = con.prepareStatement(sql);
  			stmt.setString(1,maNCC);
  			ResultSet rs = stmt.executeQuery();
              while (rs.next()){
                  String ten = rs.getString("TenNhaCungCap");
                  String soDienThoai = rs.getString("SoDienThoai");
                  String diaChi = rs.getString("DiaChi");
                  String eMail  = rs.getString("Email");
                  String ghiChu = rs.getString("GhiChu");
                  TrangThaiNCC ttNCC = trangThaiHoatDong(rs.getString("TrangThai"));
                  NhaCungCap nhaCC = new NhaCungCap(maNCC, ten, soDienThoai, diaChi, eMail, ghiChu, ttNCC);
                  return nhaCC;
          
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
          return null;
      }
     
}
