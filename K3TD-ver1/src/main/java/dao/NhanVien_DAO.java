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
                String ma = rs.getString(1);
                String ten  = rs.getString(2);
                LocalDate ngaySinh = rs.getDate(3).toLocalDate();
                boolean gioitinh = rs.getBoolean(4);
                String sdt = rs.getString(5);
                String matKhau = rs.getString(6);
                LocalDate ngayTao = rs.getDate(7).toLocalDate();
                String ghiChu = rs.getString(8);
                String chucVu = rs.getString(9);
                ChucVuNhanVien cvNhanVien =  chucvuNhanVien(chucVu);
                String trangThai = rs.getString(10);
                TrangThaiNhanVien ttNhanVien = trangthaiNhanVien(trangThai);
                
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
            stmt = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,nv.getMaNhanVien());
            stmt.setString(2, nv.getTenNhanVien());
            stmt.setDate(3,java.sql.Date.valueOf(nv.getNgaySinh()));
            stmt.setBoolean(4, nv.isGioiTinh());
            stmt.setString(5, nv.getSoDienThoai());
            stmt.setString(6, nv.getMatKhau());
            stmt.setDate(7, java.sql.Date.valueOf(nv.getNgayTao()));
            stmt.setString(8,nv.getTrangThaiNhanVien().toString());
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
			rs.next();
			
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
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return null;
    }
}
