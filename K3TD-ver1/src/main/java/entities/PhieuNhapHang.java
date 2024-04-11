package entities;

import java.time.LocalDateTime;

public class PhieuNhapHang {
	private String maPhieu;
	private LocalDateTime thoiGianTao;
	private String ghiChu;
	private String maHoaDonNCC;
	private NhaCungCap nhaCungCap;
	private double tongGiamGia;
	private TrangThaiPhieuNhapHang trangThai;
	
	public PhieuNhapHang(String maPhieu, LocalDateTime thoiGianTao, String ghiChu, String maHoaDonNCC,
			NhaCungCap nhaCungCap, double tongGiamGia, TrangThaiPhieuNhapHang trangThai) {
		super();
		this.maPhieu = maPhieu;
		this.thoiGianTao = thoiGianTao;
		this.ghiChu = ghiChu;
		this.maHoaDonNCC = maHoaDonNCC;
		this.nhaCungCap = nhaCungCap;
		this.tongGiamGia = tongGiamGia;
		this.trangThai = trangThai;
	}
	public PhieuNhapHang(String maPhieu) {
		super();
		this.maPhieu = maPhieu;
	}
	public PhieuNhapHang() {
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
	public double getTongGiamGia() {
		return tongGiamGia;
	}
	public void setTongGiamGia(double tongGiamGia) {
		this.tongGiamGia = tongGiamGia;
	}
	public TrangThaiPhieuNhapHang getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(TrangThaiPhieuNhapHang trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "PhieuNhapHang [maPhieu=" + maPhieu + ", thoiGianTao=" + thoiGianTao + ", ghiChu=" + ghiChu
				+ ", maHoaDonNCC=" + maHoaDonNCC + ", nhaCungCap=" + nhaCungCap + ", tongGiamGia=" + tongGiamGia
				+ ", trangThai=" + trangThai + "]";
	}

	
	
}
