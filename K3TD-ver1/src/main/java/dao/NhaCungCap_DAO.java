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
     public ArrayList<NhaCungCap> timtheo_TUKHOA(String tuKhoa){
         ArrayList<NhaCungCap> dsNhaCungCap = new ArrayList<NhaCungCap>();
         try {
             Connection con = ConnectDB.getInstance().getConnection();
             String sql = "SELECT * FROM NhaCungCap WHERE MaNhaCungCap LIKE ? OR TenNhaCungCap LIKE ? OR SoDienThoai LIKE ? OR DiaChi LIKE ? OR Email LIKE ? OR GhiChu LIKE ? TrangThai LIKE ?";
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, "%" + tuKhoa + "%");
             stmt.setString(2, "%" + tuKhoa + "%");
             stmt.setString(3, "%" + tuKhoa + "%");
             stmt.setString(4, "%" + tuKhoa + "%");
             stmt.setString(5, "%" + tuKhoa + "%");
             stmt.setString(6, "%" + tuKhoa + "%");
             stmt.setString(7, "%" + tuKhoa + "%");
             ResultSet rs = stmt.executeQuery();
             while(rs.next()){
                 String ma = rs.getString(1);
                 String ten = rs.getString(2);
                 String sdt = rs.getString(3);
                 String diachi = rs.getString(4);
                 String email = rs.getString(5);
                 String ghichu = rs.getString(6);
                 TrangThaiNCC ttNCC = trangThaiHoatDong(rs.getString(7));
                 NhaCungCap nCC = new NhaCungCap(ma, ten, sdt, diachi, email, ghichu, ttNCC);
                 dsNhaCungCap.add(nCC);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return dsNhaCungCap;
     }
}
