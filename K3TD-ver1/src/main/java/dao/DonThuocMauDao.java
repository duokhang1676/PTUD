/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import db.*;
import entities.ChiTietDonThuocMau;
import entities.DonThuocMau;
import entities.DonViTinh;
import entities.TrangThaiDonThuocMau;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class DonThuocMauDao {
    private ArrayList<entities.DonThuocMau> dsDonThuocMau ;
    public ArrayList<entities.DonThuocMau> getDonThuocMau(){
        
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM DonThuocMau";
            PreparedStatement stmt = null;
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            dsDonThuocMau = new ArrayList<entities.DonThuocMau>();
            while(rs.next()){
                String ma = rs.getString("MaDonThuocMau");
                String tenDonThuoc = rs.getString("TenDonThuocMau");
                LocalDate ngayBatdau = rs.getDate("NgayBatDauApDung").toLocalDate();
                String ghichu = rs.getString("GhiChu");
                TrangThaiDonThuocMau trangthai = rs.getString("TrangThai").equals("DANG_BAN") ? TrangThaiDonThuocMau.DANG_BAN : TrangThaiDonThuocMau.TAM_DUNG;
                entities.DonThuocMau donthuocmau = new DonThuocMau(ma, tenDonThuoc, ngayBatdau, ghichu, trangthai);
                dsDonThuocMau.add(donthuocmau);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonThuocMauDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsDonThuocMau;
}
    public DonThuocMau getDonThuocMau_theoMa(String ma1) {
        DonThuocMau donthuocmau = null;
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM DonThuocMau WHERE MaDonThuocMau = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ma1);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String ma = rs.getString("MaDonThuocMau");
                String tenDonThuoc = rs.getString("TenDonThuocMau");
                LocalDate ngayBatdau = rs.getDate("NgayBatDauApDung").toLocalDate();
                String ghichu = rs.getString("GhiChu");
                String trangThaiString = rs.getString("TrangThai");
                TrangThaiDonThuocMau trangthai = trangThaiString.equals("DANG_BAN") ? TrangThaiDonThuocMau.DANG_BAN : TrangThaiDonThuocMau.TAM_DUNG;
                donthuocmau = new DonThuocMau(ma, tenDonThuoc, ngayBatdau, ghichu, trangthai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonThuocMauDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return donthuocmau;
    }
    public DonThuocMau CreateDonThuocMau(DonThuocMau dtm){
        PreparedStatement stmt = null;      
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            String sql = "INSERT INTO DonThuocMau(TenDonThuocMau,NgayBatDauApDung,GhiChu,TrangThai) VALUES (?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, dtm.getTenDonThuocMau());
            stmt.setDate(2, Date.valueOf(dtm.getNgayBatDauApDung()));
            stmt.setString(3, dtm.getGhiChu());
            stmt.setString(4, dtm.getTrangThaiDonThuocMau().toString());
            ResultSet rs = stmt.executeQuery();
    		while (rs.next()) {
    			dtm.setMaDonThuocMau(rs.getString("madonthuocmau"));
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
            return dtm;
    }
    public List<ChiTietDonThuocMau> getChiTietDonThuocMau(String maDonThuocMau){
    	List<ChiTietDonThuocMau> dsChiTietDonThuocMau = new ArrayList<>();
    	PreparedStatement stmt = null;
    	Connection  con = ConnectDB.getInstance().getConnection(); 
    	String sql = "SELECT * FROM dbo.ChiTietDonThuocMau \r\n"
    			+ "Where dbo.ChiTietDonThuocMau.MaDonThuocMau =  ? ";
    	DonThuocMauDao dtm_dao = new DonThuocMauDao();
    	DonViTinhDao dvt_dao = new DonViTinhDao();
    	try {
    		stmt = con.prepareStatement(sql);
    		stmt.setString(1, maDonThuocMau);
    		ResultSet rs = stmt.executeQuery();
    		while (rs.next()) {
				DonThuocMau donThuocMau = dtm_dao.getDonThuocMau_theoMa(rs.getString("MaDonThuocMau"));
				String lieuDung = rs.getString("LieuDung");
				int soLuong = rs.getInt("SoLuong");
				DonViTinh dvt = dvt_dao.timDVTTheoMa(rs.getInt("MaDonViTinh"));
				ChiTietDonThuocMau ct = new ChiTietDonThuocMau(donThuocMau, lieuDung, soLuong, dvt);
				
				dsChiTietDonThuocMau.add(ct);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//    	System.out.println(dsChiTietDonThuocMau);
    	return dsChiTietDonThuocMau;
    }
    public boolean xoaChiTietDonThuocMau ( String maDonThuocMau , int MaDonViTinh) {
    	Connection con  = ConnectDB.getInstance().getConnection();
    	String sql = "DELETE FROM dbo.ChiTietDonThuocMau WHERE MaDonThuocMau = '"+maDonThuocMau+"'  AND MaDonViTinh = ? " ;
    	DonThuocMauDao dtm_dao = new DonThuocMauDao();
    	PreparedStatement stmt  = null;
    	int n = 0;
    	try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, MaDonViTinh);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return n >0;
    }
    public boolean getONEChiTietDonThuocMau ( String maDonThuocMau , int MaDonViTinh) {
    	Connection con  = ConnectDB.getInstance().getConnection();
    	String sql = "SELECT * FROM dbo.ChiTietDonThuocMau WHERE MaDonThuocMau = ?  AND MaDonViTinh = ? " ;
    	DonThuocMauDao dtm_dao = new DonThuocMauDao();
    	PreparedStatement stmt  = null;
    	int n = 0;
    	try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maDonThuocMau);
			stmt.setInt(2, MaDonViTinh);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return n >0;
    }
    public boolean updateDonThuocMau(DonThuocMau dtm) {
    	int n =0;
    	Connection con = ConnectDB.getInstance().getConnection();
    	String sql = "UPDATE DonThuocMau SET TenDonThuocMau = ? , NgayBatDauApDung = ?, GhiChu = ? , TrangThai = ?  ";
    	PreparedStatement stmt = null;
    	try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, dtm.getTenDonThuocMau());
			stmt.setDate(2, Date.valueOf(dtm.getNgayBatDauApDung()));
			stmt.setString(3, dtm.getGhiChu());
			stmt.setString(4, dtm.getTrangThaiDonThuocMau().toString());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return n > 0;
    			
    }
    public String getmaDonThuocMauGanDayNhat() {
    	Connection con = ConnectDB.getInstance().getConnection();
    	String sql = "SELECT MAX(MaDonThuocMau) as madonthuoc FROM DonThuocMau";
    	PreparedStatement stmt = null;
    	String maDonThuocMau = "";
    	try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			maDonThuocMau = rs.getString("madonthuoc");
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return maDonThuocMau;
    }
    public DonThuocMau getDonThuocMauGanDayNhat() {
    	Connection con = ConnectDB.getInstance().getConnection();
    	String sql = "SELECT top 1 * FROM DonThuocMau \r\n"
    			+ "order by dbo.DonThuocMau.MaDonThuocMau DESC";
    	PreparedStatement stmt = null;
    	DonThuocMau dtm = null ;
    	try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			String	maDonThuocMau = rs.getString("MaDonThuocMau");
			String tenDonThuocMau = rs.getString("TenDonThuocMau");
			LocalDate ngaybatdauApDung = rs.getDate("NgayBatDauApDung").toLocalDate();
			String ghiChu = rs.getString("GhiChu");
			TrangThaiDonThuocMau tt = rs.getString("TrangThai").equals(TrangThaiDonThuocMau.DANG_BAN.toString()) ? TrangThaiDonThuocMau.DANG_BAN  : TrangThaiDonThuocMau.TAM_DUNG;
			dtm = new DonThuocMau(maDonThuocMau, tenDonThuocMau, ngaybatdauApDung, ghiChu, tt);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return dtm;
    }
    
    public boolean  createChiTietDonThuocMau(ChiTietDonThuocMau ctdtm) {
    	Connection con = ConnectDB.getInstance().getConnection();
    	String sql = " INSERT INTO ChiTietDonThuocMau(MaDonThuocMau,MaDonViTinh,LieuDung,SoLuong) VALUES (?,?,?,?) ";
    	PreparedStatement stmt = null;
    	int n = 0;
    	try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ctdtm.getDonThuocMau().getMaDonThuocMau());
			stmt.setInt(2, ctdtm.getDonViTinh().getMaDonViTinh());
			stmt.setString(3, ctdtm.getLieuDung());
			stmt.setInt(4, ctdtm.getSoLuong());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return  n > 0;
    }
}

