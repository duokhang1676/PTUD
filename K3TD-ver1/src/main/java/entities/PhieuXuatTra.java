package entities;

import java.time.LocalDateTime;

import components.Formater;

public class PhieuXuatTra {
	private String maPhieuXuatTra;
	private LocalDateTime thoiGianTao;
	private String ghiChu;
	private String maHoaDonNCC;
	private NhaCungCap nhaCungCap;
	private double tongGiamGia;
	private double tongTienHang;
	private TrangThaiPhieuXuatTra trangThai;
	public PhieuXuatTra(String maPhieuXuatTra, LocalDateTime thoiGianTao, String ghiChu, String maHoaDonNCC,
			NhaCungCap nhaCungCap, double tongGiamGia, double tongTienHang, TrangThaiPhieuXuatTra trangThai) {
		super();
		this.maPhieuXuatTra = maPhieuXuatTra;
		this.thoiGianTao = thoiGianTao;
		this.ghiChu = ghiChu;
		this.maHoaDonNCC = maHoaDonNCC;
		this.nhaCungCap = nhaCungCap;
		this.tongGiamGia = tongGiamGia;
		this.tongTienHang = tongTienHang;
		this.trangThai = trangThai;
	}
	public PhieuXuatTra() {
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
	public double getTongGiamGia() {
		return tongGiamGia;
	}
	public void setTongGiamGia(double tongTienGiam) {
		this.tongGiamGia = tongTienGiam;
	}
	public double getTongTienHang() {
		return tongTienHang;
	}
	public void setTongTienHang(double tongTienHang) {
		this.tongTienHang = tongTienHang;
	}
	public TrangThaiPhieuXuatTra getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(TrangThaiPhieuXuatTra trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "PhieuXuatTra [maPhieuXuatTra=" + maPhieuXuatTra + ", thoiGianTao=" + thoiGianTao + ", ghiChu=" + ghiChu
				+ ", maHoaDonNCC=" + maHoaDonNCC + ", nhaCungCap=" + nhaCungCap + ", tongGiamGia=" + tongGiamGia
				+ ", tongTienHang=" + tongTienHang + ", trangThai=" + trangThai + "]";
	}
	public double tinhThanhTien() {
		return Formater.roundToNearest500(tongTienHang-tongGiamGia);
	}

	
	
}
