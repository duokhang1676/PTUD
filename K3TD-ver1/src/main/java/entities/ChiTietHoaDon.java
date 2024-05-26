package entities;

import java.util.List;
import java.util.Map;

public class ChiTietHoaDon {
	private HoaDon hoaDon;
	private int soLuong;
	private double donGia;
	private DonViTinh donViTinh;
	private Map<LoHang,Integer> danhSachLoHang;
	public ChiTietHoaDon(HoaDon hoaDon, int soLuong, double donGia,
			DonViTinh donViTinh) {
		super();
		this.hoaDon = hoaDon;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.donViTinh = donViTinh;
	}
	
	public ChiTietHoaDon(HoaDon hoaDon, int soLuong, double donGia, DonViTinh donViTinh,
			Map<LoHang, Integer> danhSachLoHang) {
		super();
		this.hoaDon = hoaDon;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.donViTinh = donViTinh;
		this.danhSachLoHang = danhSachLoHang;
	}



	public ChiTietHoaDon() {
		super();
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public DonViTinh getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(DonViTinh donViTinh) {
		this.donViTinh = donViTinh;
	}
	
	

	public Map<LoHang, Integer> getDanhSachLoHang() {
		return danhSachLoHang;
	}



	public void setDanhSachLoHang(Map<LoHang, Integer> danhSachLoHang) {
		this.danhSachLoHang = danhSachLoHang;
	}



	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", soLuong=" + soLuong + ", donGia=" + donGia + ", donViTinh="
				+ donViTinh + ", danhSachLoHang=" + danhSachLoHang + "]";
	}

	public double tinhThanhTien() {
		return soLuong*donGia;
	}
	
}
