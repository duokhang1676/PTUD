package dao;

import java.sql.Connection;
import java.sql.Date;
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
	public List<LoHang> getDSLoHetHSD(){
		List<LoHang> dsLoHang = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from LoHang\r\n"
					+ "where HanSuDung < GETDATE()";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
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
