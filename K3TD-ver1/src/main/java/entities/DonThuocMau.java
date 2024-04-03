package entities;

import java.time.LocalDate;

public class DonThuocMau {
	private String maDonThuocMau;
	private String tenDonThuocMau;
	private LocalDate ngayBatDauApDung;
	private String ghiChu;
	private TrangThaiDonThuocMau trangThaiDonThuocMau;
	public DonThuocMau(String maDonThuocMau, String tenDonThuocMau, LocalDate ngayBatDauApDung, String ghiChu,
			TrangThaiDonThuocMau trangThaiDonThuocMau) {
		super();
		this.maDonThuocMau = maDonThuocMau;
		this.tenDonThuocMau = tenDonThuocMau;
		this.ngayBatDauApDung = ngayBatDauApDung;
		this.ghiChu = ghiChu;
		this.trangThaiDonThuocMau = trangThaiDonThuocMau;
	}
	public DonThuocMau(String maDonThuocMau) {
		super();
		this.maDonThuocMau = maDonThuocMau;
	}
	public DonThuocMau() {
		super();
	}
	public String getMaDonThuocMau() {
		return maDonThuocMau;
	}
	public void setMaDonThuocMau(String maDonThuocMau) {
		this.maDonThuocMau = maDonThuocMau;
	}
	public String getTenDonThuocMau() {
		return tenDonThuocMau;
	}
	public void setTenDonThuocMau(String tenDonThuocMau) {
		this.tenDonThuocMau = tenDonThuocMau;
	}
	public LocalDate getNgayBatDauApDung() {
		return ngayBatDauApDung;
	}
	public void setNgayBatDauApDung(LocalDate ngayBatDauApDung) {
		this.ngayBatDauApDung = ngayBatDauApDung;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public TrangThaiDonThuocMau getTrangThaiDonThuocMau() {
		return trangThaiDonThuocMau;
	}
	public void setTrangThaiDonThuocMau(TrangThaiDonThuocMau trangThaiDonThuocMau) {
		this.trangThaiDonThuocMau = trangThaiDonThuocMau;
	}
	@Override
	public String toString() {
		return "DonThuocMau [maDonThuocMau=" + maDonThuocMau + ", tenDonThuocMau=" + tenDonThuocMau
				+ ", ngayBatDauApDung=" + ngayBatDauApDung + ", ghiChu=" + ghiChu + ", trangThaiDonThuocMau="
				+ trangThaiDonThuocMau + "]";
	}
	
	
}
