package entities;

import java.time.LocalDateTime;

public class PhieuXuatTraNCC {
	private String maPhieuXuatTra;
	private LocalDateTime thoiGianTao;
	private String ghiChu;
	private String maHoaDonNCC;
	private NhaCungCap nhaCungCap;
	public PhieuXuatTraNCC(String maPhieuXuatTra, LocalDateTime thoiGianTao, String ghiChu, String maHoaDonNCC,
			NhaCungCap nhaCungCap) {
		super();
		this.maPhieuXuatTra = maPhieuXuatTra;
		this.thoiGianTao = thoiGianTao;
		this.ghiChu = ghiChu;
		this.maHoaDonNCC = maHoaDonNCC;
		this.nhaCungCap = nhaCungCap;
	}
	public PhieuXuatTraNCC(String maPhieuXuatTra) {
		super();
		this.maPhieuXuatTra = maPhieuXuatTra;
	}
	public PhieuXuatTraNCC() {
		super();
	}
	public String getMaPhieuXuatTra() {
		return maPhieuXuatTra;
	}
	public void setMaPhieuXuatTra(String maPhieuXuatTra) {
		this.maPhieuXuatTra = maPhieuXuatTra;
	}
	public LocalDateTime getThoiGianTao() {
		return thoiGianTao;
	}
	public void setThoiGianTao(LocalDateTime thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getMaHoaDonNCC() {
		return maHoaDonNCC;
	}
	public void setMaHoaDonNCC(String maHoaDonNCC) {
		this.maHoaDonNCC = maHoaDonNCC;
	}
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	@Override
	public String toString() {
		return "PhieuXuatTraNCC [maPhieuXuatTra=" + maPhieuXuatTra + ", thoiGianTao=" + thoiGianTao + ", ghiChu="
				+ ghiChu + ", maHoaDonNCC=" + maHoaDonNCC + ", nhaCungCap=" + nhaCungCap + "]";
	}
	
	
}
