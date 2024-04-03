package entities;

import java.time.LocalDate;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private LocalDate ngaySinh;
	private boolean gioiTinh;
	private String soDienThoai;
	private int diemThuong;
	private LocalDate ngayTao;
	private TrangThaiKhachHang trangThaiKhachHang;
	public KhachHang(String maKhachHang, String tenKhachHang, LocalDate ngaySinh, boolean gioiTinh, String soDienThoai,
			int diemThuong, LocalDate ngayTao, TrangThaiKhachHang trangThaiKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diemThuong = diemThuong;
		this.ngayTao = ngayTao;
		this.trangThaiKhachHang = trangThaiKhachHang;
	}
	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}
	public KhachHang() {
		super();
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public int getDiemThuong() {
		return diemThuong;
	}
	public void setDiemThuong(int diemThuong) {
		this.diemThuong = diemThuong;
	}
	public LocalDate getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(LocalDate ngayTao) {
		this.ngayTao = ngayTao;
	}
	public TrangThaiKhachHang getTrangThaiKhachHang() {
		return trangThaiKhachHang;
	}
	public void setTrangThaiKhachHang(TrangThaiKhachHang trangThaiKhachHang) {
		this.trangThaiKhachHang = trangThaiKhachHang;
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", soDienThoai=" + soDienThoai + ", diemThuong=" + diemThuong
				+ ", ngayTao=" + ngayTao + ", trangThaiKhachHang=" + trangThaiKhachHang + "]";
	}
	
	
}
