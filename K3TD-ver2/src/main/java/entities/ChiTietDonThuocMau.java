package entities;

import java.time.LocalDate;

public class ChiTietDonThuocMau {
	private int maChiTietDonThuocMau;
	private DonThuocMau donThuocMau;
	private HangHoa hangHoa;
	private String lieuDung;
	private int soLuong;
	private DonViTinh donViTinh;
	public ChiTietDonThuocMau(int maChiTietDonThuocMau, DonThuocMau donThuocMau, HangHoa hangHoa, String lieuDung,
			int soLuong, DonViTinh donViTinh) {
		super();
		this.maChiTietDonThuocMau = maChiTietDonThuocMau;
		this.donThuocMau = donThuocMau;
		this.hangHoa = hangHoa;
		this.lieuDung = lieuDung;
		this.soLuong = soLuong;
		this.donViTinh = donViTinh;
	}
	public ChiTietDonThuocMau(int maChiTietDonThuocMau) {
		super();
		this.maChiTietDonThuocMau = maChiTietDonThuocMau;
	}
	public ChiTietDonThuocMau() {
		super();
	}
	public int getMaChiTietDonThuocMau() {
		return maChiTietDonThuocMau;
	}
	public void setMaChiTietDonThuocMau(int maChiTietDonThuocMau) {
		this.maChiTietDonThuocMau = maChiTietDonThuocMau;
	}
	public DonThuocMau getDonThuocMau() {
		return donThuocMau;
	}
	public void setDonThuocMau(DonThuocMau donThuocMau) {
		this.donThuocMau = donThuocMau;
	}
	public HangHoa getHangHoa() {
		return hangHoa;
	}
	public void setHangHoa(HangHoa hangHoa) {
		this.hangHoa = hangHoa;
	}
	public String getLieuDung() {
		return lieuDung;
	}
	public void setLieuDung(String lieuDung) {
		this.lieuDung = lieuDung;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public DonViTinh getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(DonViTinh donViTinh) {
		this.donViTinh = donViTinh;
	}
	@Override
	public String toString() {
		return "ChiTietDonThuocMau [maChiTietDonThuocMau=" + maChiTietDonThuocMau + ", donThuocMau=" + donThuocMau
				+ ", hangHoa=" + hangHoa + ", lieuDung=" + lieuDung + ", soLuong=" + soLuong + ", donViTinh="
				+ donViTinh + "]";
	}
	
	
}