/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import entities.HangHoa;
import entities.KhachHang;
import entities.LoaiHang;
import entities.NhomHang;
import entities.TrangThaiHangHoa;

import java.sql.Connection;
import db.ConnectDB;
import entities.TrangThaiKhachHang;
import entities.TrangThaiNhanVien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */
public class KhachHang_DAO {
    ArrayList<entities.KhachHang> dsKhachHang;
    KhachHang kh;
    // chuyen chuoi thanh localdate
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
    public KhachHang_DAO(){
        dsKhachHang = new ArrayList<KhachHang>();
    }
    public KhachHang getKHbyMa(String maKH) {
    	ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "select * from KhachHang where MaKhachHang = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maKH);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			String tenKH = rs.getString("TenKhachHang");
			LocalDate ngaySinh = null;
			try {
				 ngaySinh = rs.getDate("NgaySinh").toLocalDate();
			} catch (Exception e) {
				// TODO: handle exception
				
			}
			
			Boolean gioiTinh = rs.getBoolean("GioiTinh");
			String sdt = rs.getString("SoDienThoai");
			Integer diem = rs.getInt("DiemThuong");
			LocalDate ngayTao = rs.getDate("NgayTao").toLocalDate();
			String ghiChu = rs.getString("GhiChu");
			TrangThaiKhachHang tt =  TrangThaiKhachHang.valueOf(rs.getString("TrangThai"));
			
			KhachHang khachHang = new KhachHang(maKH, tenKH, ngaySinh, gioiTinh, sdt, diem, ngayTao, ghiChu, tt);
			return khachHang;
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return null;
    }


    
    
    private TrangThaiKhachHang trangthaihoatdong(String trangthaikhachhang){
        if (trangthaikhachhang.equals("DANG_HOAT_DONG")) {
            return TrangThaiKhachHang.DANG_HOAT_DONG;
        }
        return TrangThaiKhachHang.NGUNG_HOAT_DONG;
    }
    
    public boolean create(KhachHang kh){
        Connection con  = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        int n =0;
        try {
            stmt = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, kh.getMaKhachHang());
            stmt.setString(2,kh.getTenKhachHang());
 
            // chuyen doi 
            LocalDate ngaySinh2 = kh.getNgaySinh();
            java.sql.Date ngaySinhSQL =  java.sql.Date.valueOf(ngaySinh2);
            stmt.setDate(3, ngaySinhSQL);
            //
            stmt.setBoolean(4, kh.isGioiTinh());
            stmt.setString(5,kh.getSoDienThoai());
            stmt.setInt(6, kh.getDiemThuong());
            
            java.sql.Date ngayTaoSQL = java.sql.Date.valueOf(kh.getNgayTao());
            stmt.setDate(7, ngayTaoSQL);
            
            stmt.setString(8, kh.getGhiChu());
            stmt.setString(9, kh.getTrangThaiKhachHang().toString());
            n =stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n >0;
    }
    public ArrayList<ArrayList<Object>> timKiem_tuKhoa_TrangThai(String tuKhoa, String trangThai){
    	ArrayList<ArrayList<Object>> dsTamThoi = new ArrayList<>();
    	ArrayList<Object> doituong = new ArrayList<>();
		String Change_Value__TrangThai = trangThai.equals("Đang hoạt động") ? "DANG_HOAT_DONG" : "NGUNG_HOAT_DONG";
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql;
			PreparedStatement stmt;
			if (tuKhoa.trim().isEmpty() ) {
				if (trangThai.equalsIgnoreCase("Tất cả")) {
					sql ="SELECT dbo.KhachHang.MaKhachHang,dbo.KhachHang.TenKhachHang,KhachHang.SoDienThoai,KhachHang.GhiChu,KhachHang.TrangThai,Sum(HoaDon.ThanhTien) AS tongtien FROM KhachHang JOIN HoaDon ON KhachHang.MaKhachHang = HoaDon.MaKhachHang\r\n"
							+ "Group by KhachHang.MaKhachHang, dbo.KhachHang.TenKhachHang, KhachHang.SoDienThoai,KhachHang.GhiChu,KhachHang.TrangThai";
					stmt =con.prepareStatement(sql);
				
				}
				else {
					sql = "SELECT dbo.KhachHang.MaKhachHang,dbo.KhachHang.TenKhachHang,KhachHang.SoDienThoai,KhachHang.GhiChu,KhachHang.TrangThai,Sum(HoaDon.ThanhTien) AS tongtien FROM KhachHang JOIN HoaDon ON KhachHang.MaKhachHang = HoaDon.MaKhachHang\r\n"
							+ "WHERE dbo.KhachHang.TrangThai = '"+Change_Value__TrangThai+"' \r\n"
							+ "Group by KhachHang.MaKhachHang, dbo.KhachHang.TenKhachHang, KhachHang.SoDienThoai,KhachHang.GhiChu,KhachHang.TrangThai";
					stmt = con.prepareStatement(sql);
				}	
			}
			else {
				if (trangThai.equalsIgnoreCase("Tất cả")) {
					sql = "SELECT dbo.KhachHang.MaKhachHang,\r\n"
							+ "dbo.KhachHang.TenKhachHang,\r\n"
							+ "KhachHang.SoDienThoai,KhachHang.GhiChu,\r\n"
							+ "KhachHang.TrangThai,\r\n"
							+ "Sum(HoaDon.ThanhTien) AS tien \r\n"
							+ "FROM KhachHang JOIN HoaDon ON KhachHang.MaKhachHang = HoaDon.MaKhachHang\r\n"
							+ "WHERE dbo.KhachHang.MaKhachHang LIKE ? OR\r\n"
							+ "dbo.KhachHang.TenKhachHang LIKE ?  OR\r\n"
							+ "dbo.KhachHang.SoDienThoai LIKE ? OR\r\n"
							+ "dbo.KhachHang.GhiChu LIKE ? \r\n"
							+ "Group by KhachHang.MaKhachHang, dbo.KhachHang.TenKhachHang, KhachHang.SoDienThoai,KhachHang.GhiChu,KhachHang.TrangThai\r\n"
							+ "";
					stmt = con.prepareStatement(sql);
		            stmt.setString(1, "%" + tuKhoa + "%");
		            stmt.setString(2, "%" + tuKhoa + "%");
		            stmt.setString(3, "%" + tuKhoa + "%");
		            stmt.setString(4, "%" + tuKhoa + "%");
				}
				else {
					sql = "\r\n"
							+ "SELECT dbo.KhachHang.MaKhachHang,\r\n"
							+ "dbo.KhachHang.TenKhachHang,\r\n"
							+ "KhachHang.SoDienThoai,KhachHang.GhiChu,\r\n"
							+ "KhachHang.TrangThai,\r\n"
							+ "Sum(HoaDon.ThanhTien) AS tien \r\n"
							+ "FROM KhachHang JOIN HoaDon ON KhachHang.MaKhachHang = HoaDon.MaKhachHang\r\n"
							+ "WHERE (dbo.KhachHang.MaKhachHang LIKE ? OR\r\n"
							+ "dbo.KhachHang.TenKhachHang LIKE ?  OR\r\n"
							+ "dbo.KhachHang.SoDienThoai LIKE ? OR\r\n"
							+ "dbo.KhachHang.GhiChu LIKE ? ) AND \r\n"
							+ "dbo.KhachHang.TrangThai = ? \r\n"
							+ "Group by KhachHang.MaKhachHang, dbo.KhachHang.TenKhachHang, KhachHang.SoDienThoai,KhachHang.GhiChu,KhachHang.TrangThai\r\n"
							+ "";
					stmt = con.prepareStatement(sql);
		            stmt.setString(1, "%" + tuKhoa + "%");
		            stmt.setString(2, "%" + tuKhoa + "%");
		            stmt.setString(3, "%" + tuKhoa + "%");
		            stmt.setString(4, "%" + tuKhoa + "%");
		            stmt.setString(5, Change_Value__TrangThai);
				}
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String ma = rs.getString("MaKhachHang");
				String ten  = rs.getString("TenKhachHang");
				String sdt = rs.getString("SoDienThoai");
				String ghiChu = rs.getString("GhiChu");
				double tongTien = rs.getFloat(6);
				TrangThaiKhachHang ttKh = rs.getString("TrangThai").equals("DANG_HOAT_DONG") ? TrangThaiKhachHang.DANG_HOAT_DONG : TrangThaiKhachHang.NGUNG_HOAT_DONG;
				doituong.add(ma);
				doituong.add(ten);
				doituong.add(tongTien);
				doituong.add(sdt);
				doituong.add(ghiChu);
				doituong.add(ttKh);
				dsTamThoi.add(doituong);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsTamThoi;
    }
    
    
    public void loadDataNV(DefaultTableModel table_model) {
  		// TODO Auto-generated method stub
      	int n = 0;
          String sql = "SELECT dbo.KhachHang.MaKhachHang,dbo.KhachHang.TenKhachHang,KhachHang.SoDienThoai,KhachHang.GhiChu,KhachHang.TrangThai,Sum(HoaDon.ThanhTien) AS tongtien FROM KhachHang JOIN HoaDon ON KhachHang.MaKhachHang = HoaDon.MaKhachHang\r\n"
          		+ "Group by KhachHang.MaKhachHang, dbo.KhachHang.TenKhachHang, KhachHang.SoDienThoai,KhachHang.GhiChu,KhachHang.TrangThai\r\n"
          		+ "  ";
          table_model.setRowCount(0);
              try {
              Connection conn = ConnectDB.getInstance().getConnection();
              PreparedStatement stmt = null;
              stmt  =conn.prepareStatement(sql);
              ResultSet rs = stmt.executeQuery();
              
//              ResultSetMetaData rsmd = rs.getMetaData();
//              int columnCount = rsmd.getColumnCount(); // kiem tra ten cot
//              for (int i = 1; i <= columnCount; i++) {
//              System.out.println(rsmd.getColumnName(i));
//              
  //}
              int n1  = 1 ;
                  while (rs.next()) {
                      String ma =rs.getString("MaKhachHang"); 
                      String ten = rs.getString("TenKhachHang"); 
                      String sodienThoai = rs.getString("SoDienThoai"); 
                      String ghichu = rs.getString("GhiChu");
                      String trangthai = rs.getString("TrangThai");
                      double TongTien = rs.getDouble("tongtien");
                      table_model.addRow(new Object[]{
                          n1,
                          ma,
                          ten,   
                          TongTien,
                          sodienThoai,
                          ghichu,
                          trangthai.equals(TrangThaiNhanVien.DANG_HOAT_DONG.toString()) ? " Đang hoạt động" : "Ngừng hoạt động"
                      });
                      n1++;
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }
          
  }
   
    
    
    
}
