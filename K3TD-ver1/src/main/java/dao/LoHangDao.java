package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entities.HangHoa;
import entities.LoHang;
import entities.LoaiHang;
import entities.NhomHang;
import entities.TrangThaiHangHoa;

public class LoHangDao {
	public LoHangDao() {
		// TODO Auto-generated constructor stub
	}
	public List<LoHang> getDSLoTheoHSD(LocalDate hsd){
		List<LoHang> dsLoHang = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from LoHang\r\n"
					+ "where HanSuDung < ?";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(hsd));
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String soLo = rs.getString("SoLo");
				HangHoa hangHoa = new HangHoaDao().timHangHoaTheoMa(rs.getString("MaHangHoa"));
				int soLuong = rs.getInt("SoLuong");
				LocalDate hanSuDung = rs.getDate("HanSuDung").toLocalDate();
				
				
				LoHang loHang = new LoHang(soLo, hangHoa, soLuong, null, hanSuDung, 0, null);
				
				dsLoHang.add(loHang);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsLoHang;
	}
	public List<LoHang> getDSLoSapHetHSD(LocalDate hsd){
		List<LoHang> dsLoHang = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from LoHang\r\n"
					+ "where HanSuDung < ? AND HanSuDung > GETDATE()";
			PreparedStatement stmt = null;
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(hsd));
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String soLo = rs.getString("SoLo");
				HangHoa hangHoa = new HangHoaDao().timHangHoaTheoMa(rs.getString("MaHangHoa"));
				int soLuong = rs.getInt("SoLuong");
				LocalDate hanSuDung = rs.getDate("HanSuDung").toLocalDate();
				
				
				LoHang loHang = new LoHang(soLo, hangHoa, soLuong, null, hanSuDung, 0, null);
				
				dsLoHang.add(loHang);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsLoHang;
	}
}
