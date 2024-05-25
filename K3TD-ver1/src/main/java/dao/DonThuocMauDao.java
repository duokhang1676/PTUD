/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import db.*;
import entities.DonThuocMau;
import entities.TrangThaiDonThuocMau;
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
}

