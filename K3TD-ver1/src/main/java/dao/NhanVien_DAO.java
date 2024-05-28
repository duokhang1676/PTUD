/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.ConnectDB;
import entities.ChucVuNhanVien;
import entities.KhachHang;

import java.util.ArrayList;
import entities.NhanVien;
import entities.TrangThaiKhachHang;
import entities.TrangThaiNhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
/**
 *
 * @author Admin
 */
public class NhanVien_DAO {
    ArrayList<NhanVien> dsNhanVien;
    
    public NhanVien_DAO(){
        dsNhanVien = new ArrayList<NhanVien>();
    }
    public ArrayList<NhanVien> docTuBang(){
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "Select * from NhanVien";
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String ma = rs.getString("MaNhanVien");
                String ten  = rs.getString("TenNhanVien");
                
                LocalDate ngaySinh = null;
                try {
                	ngaySinh = rs.getDate("NgaySinh").toLocalDate();
				} catch (Exception e) {
					// TODO: handle exception
				}
                boolean gioitinh = rs.getBoolean("GioiTinh");
                String sdt = rs.getString("SoDienThoai");
                String matKhau = rs.getString("MatKhau");
                LocalDate ngayTao = rs.getDate("NgayTao").toLocalDate();
                String ghiChu = rs.getString("GhiChu"); 
                
                String chucVu = rs.getString("ChucVu");
                ChucVuNhanVien cvNhanVien =  rs.getString("ChucVu").equals("QUAN_LY") ? ChucVuNhanVien.QUAN_LY : ChucVuNhanVien.NHAN_VIEN;
                
                String trangThai = rs.getString(10);
                TrangThaiNhanVien ttNhanVien = rs.getString("TrangThai").equals("DANG_HOAT_DONG") ? TrangThaiNhanVien.DANG_HOAT_DONG : TrangThaiNhanVien.NGUNG_HOAT_DONG;
                
                NhanVien nv = new NhanVien(ma, ten, ngaySinh, gioitinh, sdt, matKhau, ngayTao,ghiChu,cvNhanVien, ttNhanVien);
                dsNhanVien.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsNhanVien;
        
    }

    private ChucVuNhanVien chucvuNhanVien(String cv){
        if (cv.equals("Quản Lý")) {
            return ChucVuNhanVien.QUAN_LY;
        }
        return ChucVuNhanVien.NHAN_VIEN;
    }
    private TrangThaiNhanVien trangthaiNhanVien(String ct){
        if (ct.equals("Đang hoạt động")) {
            return TrangThaiNhanVien.DANG_HOAT_DONG;
        }
        return TrangThaiNhanVien.NGUNG_HOAT_DONG;
    }
    public boolean create (NhanVien nv){
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("insert into NhanVien(TenNhanVien,NgaySinh,GioiTinh,SoDienThoai,MatKhau,NgayTao,GhiChu,ChucVu,TrangThai) values(?,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1, nv.getTenNhanVien());
            stmt.setDate(2,java.sql.Date.valueOf(nv.getNgaySinh()));
            stmt.setBoolean(3, nv.isGioiTinh());
            stmt.setString(4, nv.getSoDienThoai());
            stmt.setString(5, nv.getMatKhau());
            stmt.setDate(6, java.sql.Date.valueOf(nv.getNgayTao()));
            stmt.setString(7, nv.getGhiChu());
            stmt.setString(8, nv.getChucVu().toString());
            stmt.setString(9,nv.getTrangThaiNhanVien().toString());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n >0;
    }
    public NhanVien getNVbyMa(String maNV) {
    	ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from NhanVien where MaNhanVien = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maNV);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String tenNV = rs.getString("TenNhanVien");
				LocalDate ngaySinh = null;
				try {
					 ngaySinh = rs.getDate("NgaySinh").toLocalDate();
				} catch (Exception e) {
					// TODO: handle exception
					
				}
				
				Boolean gioiTinh = rs.getBoolean("GioiTinh");
				String sdt = rs.getString("SoDienThoai");
				String matKhau = rs.getString("MatKhau");
				LocalDate ngayTao = rs.getDate("NgayTao").toLocalDate();
				String ghiChu = rs.getString("GhiChu");
				ChucVuNhanVien cv = ChucVuNhanVien.valueOf(rs.getString("ChucVu"));
				TrangThaiNhanVien tt =  TrangThaiNhanVien.valueOf(rs.getString("TrangThai"));
				
				NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, sdt, matKhau, ngayTao, ghiChu, cv, tt);
				return nv;
			}
			
			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return null;
    }
         public ArrayList<NhanVien> timkiem_TuKhoa_TrangThai(String tuKhoa,String chucVu, String trangThai){
    	ArrayList<NhanVien> dsNhanVien4 = new ArrayList<>();
		String Change_Value__TrangThai = trangThai.equals("Đang hoạt động") ? "DANG_HOAT_DONG" : "NGUNG_HOAT_DONG";
		String Change_Value__ChucVu = chucVu.equals("Nhân viên") ? "NHAN_VIEN" : "QUAN_LY";
    	try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql ;
			PreparedStatement stmt =null;
			if (tuKhoa.trim().isEmpty() ) {
				if (chucVu.equals("Tất cả")) {
					if (trangThai.equalsIgnoreCase("Tất cả")) {
						sql = "SELECT * FROM NhanVien";
						stmt =con.prepareStatement(sql);
					}
					else {
						sql = "SELECT * FROM NhanVien WHERE TrangThai = ? ";
						stmt =con.prepareStatement(sql);
						stmt.setString(1, Change_Value__TrangThai);
					}
				}
				else {
					if (trangThai.equals("Tất cả")) {
						sql = "SELECT * FROM NhanVien WHERE ChucVu = ?";
						stmt =con.prepareStatement(sql);
						stmt.setString(1, Change_Value__ChucVu);
					}
					else {
						sql = "SELECT * FROM NhanVien WHERE TrangThai = ? AND ChucVu = ? ";
						stmt =con.prepareStatement(sql);
						stmt.setString(1, Change_Value__TrangThai);
						stmt.setString(2, Change_Value__ChucVu);
					}
				}	
			}
			else {
				if (chucVu.equals("Tất cả")) {
					if (trangThai.equalsIgnoreCase("Tất cả")) {
						sql = "SELECT * FROM NhanVien WHERE MaNhanVien LIKE ? OR TenNhanVien LIKE ? OR SoDienThoai LIKE ? OR GhiChu LIKE ?";
						stmt =con.prepareStatement(sql);
			            stmt.setString(1, "%" + tuKhoa + "%");
			            stmt.setString(2, "%" + tuKhoa + "%");
			            stmt.setString(3, "%" + tuKhoa + "%");
			            stmt.setString(4, "%" + tuKhoa + "%");
					}
					else {
						sql = "SELECT * FROM NhanVien WHERE (  MaNhanVien LIKE ? OR TenNhanVien LIKE ?  OR SoDienThoai LIKE ? OR GhiChu LIKE ?  ) AND TrangThai = ?";
						stmt =con.prepareStatement(sql);
			            stmt.setString(1, "%" + tuKhoa + "%");
			            stmt.setString(2, "%" + tuKhoa + "%");
			            stmt.setString(3, "%" + tuKhoa + "%");
			            stmt.setString(4, "%" + tuKhoa + "%");
						stmt.setString(5, Change_Value__TrangThai);
					}
				}
				else {
					if (trangThai.equals("Tất cả")) {
						sql = "SELECT * FROM NhanVien WHERE  (  MaNhanVien LIKE ? OR TenNhanVien LIKE ?  OR SoDienThoai LIKE ? OR GhiChu LIKE ?  ) AND ChucVu = ? ";
						stmt =con.prepareStatement(sql);
			            stmt.setString(1, "%" + tuKhoa + "%");
			            stmt.setString(2, "%" + tuKhoa + "%");
			            stmt.setString(3, "%" + tuKhoa + "%");
			            stmt.setString(4, "%" + tuKhoa + "%");
						stmt.setString(5, Change_Value__ChucVu);
					}
					else {
						sql = "SELECT * FROM NhanVien WHERE   (  MaNhanVien LIKE ? OR TenNhanVien LIKE ?  OR SoDienThoai LIKE ? OR GhiChu LIKE ?  ) AND   (TrangThai = ? AND ChucVu = ? )";
						stmt =con.prepareStatement(sql);
			            stmt.setString(1, "%" + tuKhoa + "%");
			            stmt.setString(2, "%" + tuKhoa + "%");
			            stmt.setString(3, "%" + tuKhoa + "%");
			            stmt.setString(4, "%" + tuKhoa + "%");
						stmt.setString(5, Change_Value__TrangThai);
						stmt.setString(6, Change_Value__ChucVu);
					}
				}
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString("MaNhanVien");
				String ten = rs.getString("TenNhanVien");
				LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
				boolean gioiTinh = rs.getBoolean("GioiTinh");
				String soDienThoai = rs.getString("SoDienThoai");
				String matKhau = rs.getString("MatKhau");
				LocalDate ngayTao = rs.getDate("NgayTao").toLocalDate();
				String ghiChu = rs.getString("GhiChu");
				ChucVuNhanVien chucVu1 = rs.getString("ChucVu").equalsIgnoreCase("NHAN_VIEN") ? ChucVuNhanVien.NHAN_VIEN : ChucVuNhanVien.QUAN_LY;
				TrangThaiNhanVien trangthai = rs.getString("TrangThai").equals("DANG_HOAT_DONG") ? TrangThaiNhanVien.DANG_HOAT_DONG : TrangThaiNhanVien.NGUNG_HOAT_DONG;
				 NhanVien  nV = new NhanVien(ma, ten, ngaySinh, gioiTinh, soDienThoai, matKhau, ngayTao, ghiChu, chucVu1, trangthai);
				dsNhanVien4.add(nV);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return dsNhanVien4;
    }
}
