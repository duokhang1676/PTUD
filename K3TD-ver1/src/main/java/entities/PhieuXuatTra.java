package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PhieuXuatTra {
	private String maPhieuXuatTra;
	private LocalDate thoiGianTao;
	private String ghiChu;
	private String maHoaDonNCC;
	private NhaCungCap nhaCungCap;
	private double tongTienGiam;
	private TrangThaiPhieuXuatTra trangThai;
	public PhieuXuatTra(String maPhieuXuatTra, LocalDate thoiGianTao, String ghiChu, String maHoaDonNCC,
			NhaCungCap nhaCungCap, double tongTienGiam, TrangThaiPhieuXuatTra trangThai) {
		super();
		this.maPhieuXuatTra = maPhieuXuatTra;
		this.thoiGianTao = thoiGianTao;
		this.ghiChu = ghiChu;
		this.maHoaDonNCC = maHoaDonNCC;
		this.nhaCungCap = nhaCungCap;
		this.tongTienGiam = tongTienGiam;
		this.trangThai = trangThai;
	}
	public PhieuXuatTra(String maPhieuXuatTra) {
		super();
		this.maPhieuXuatTra = maPhieuXuatTra;
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
	public LocalDate getThoiGianTao() {
		return thoiGianTao;
	}
	public void setThoiGianTao(LocalDate thoiGianTao) {
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
	public double getTongTienGiam() {
		return tongTienGiam;
	}
	public void setTongTienGiam(double tongTienGiam) {
		this.tongTienGiam = tongTienGiam;
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
				+ ", maHoaDonNCC=" + maHoaDonNCC + ", nhaCungCap=" + nhaCungCap + ", tongTienGiam=" + tongTienGiam
				+ ", trangThai=" + trangThai + "]";
	}

	
	
}
