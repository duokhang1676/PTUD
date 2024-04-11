package entities;

import java.time.LocalDateTime;

public class PhieuTraHang {
	private String maPhieu;
	private LocalDateTime thoiGianTao;
	private HoaDon hoaDon;
	private String ghiChu;
	private Ca ca;
	private TrangThaiPhieuTraHang trangThai;
	public PhieuTraHang(String maPhieu, LocalDateTime thoiGianTao, HoaDon hoaDon, String ghiChu, Ca ca,
			TrangThaiPhieuTraHang trangThai) {
		super();
		this.maPhieu = maPhieu;
		this.thoiGianTao = thoiGianTao;
		this.hoaDon = hoaDon;
		this.ghiChu = ghiChu;
		this.ca = ca;
		this.trangThai = trangThai;
	}
	public PhieuTraHang(String maPhieu) {
		super();
		this.maPhieu = maPhieu;
	}
	public PhieuTraHang() {
		super();
	}
	public String getMaPhieu() {
		return maPhieu;
	}
	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}
	public LocalDateTime getThoiGianTao() {
		return thoiGianTao;
	}
	public void setThoiGianTao(LocalDateTime thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public Ca getCa() {
		return ca;
	}
	public void setCa(Ca ca) {
		this.ca = ca;
	}
	public TrangThaiPhieuTraHang getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(TrangThaiPhieuTraHang trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "PhieuTraHang [maPhieu=" + maPhieu + ", thoiGianTao=" + thoiGianTao + ", hoaDon=" + hoaDon + ", ghiChu="
				+ ghiChu + ", ca=" + ca + ", trangThai=" + trangThai + "]";
	}

	
	
}
