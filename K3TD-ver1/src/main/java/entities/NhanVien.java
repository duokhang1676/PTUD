package entities;

import java.time.LocalDate;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private LocalDate ngaySinh;
	private boolean gioiTinh;
	private String soDienThoai;
	private String matKhau;
	private LocalDate ngayTao;
	private String ghiChu;
	private ChucVuNhanVien chucVu;
	private TrangThaiNhanVien trangThaiNhanVien;
	
	public NhanVien(String maNhanVien, String tenNhanVien, LocalDate ngaySinh, boolean gioiTinh, String soDienThoai,
			String matKhau, LocalDate ngayTao, String ghiChu, ChucVuNhanVien chucVu,
			TrangThaiNhanVien trangThaiNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.matKhau = matKhau;
		this.ngayTao = ngayTao;
		this.ghiChu = ghiChu;
		this.chucVu = chucVu;
		this.trangThaiNhanVien = trangThaiNhanVien;
	}
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	
	public NhanVien(String maNhanVien, String tenNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
	}
	public NhanVien() {
		super();
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
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
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public LocalDate getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(LocalDate ngayTao) {
		this.ngayTao = ngayTao;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public ChucVuNhanVien getChucVu() {
		return chucVu;
	}
	public void setChucVu(ChucVuNhanVien chucVu) {
		this.chucVu = chucVu;
	}
	public TrangThaiNhanVien getTrangThaiNhanVien() {
		return trangThaiNhanVien;
	}
	public void setTrangThaiNhanVien(TrangThaiNhanVien trangThaiNhanVien) {
		this.trangThaiNhanVien = trangThaiNhanVien;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", soDienThoai=" + soDienThoai + ", matKhau=" + matKhau + ", ngayTao="
				+ ngayTao + ", ghiChu=" + ghiChu + ", chucVu=" + chucVu + ", trangThaiNhanVien=" + trangThaiNhanVien
				+ "]";
	}
	
	
	
}
