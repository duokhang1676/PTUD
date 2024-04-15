package entities;

public class NhaCungCap {
	private String maNhaCungCap;
	private String tenNhaCungCap;
	private String soDienThoai;
	private String diaChi;
	private String email;
	private String ghiChu;
	private TrangThaiNCC trangThaiNCC;
	public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String soDienThoai, String diaChi, String email,
			String ghiChu, TrangThaiNCC trangThaiNCC) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.email = email;
		this.ghiChu = ghiChu;
		this.trangThaiNCC = trangThaiNCC;
	}
	public NhaCungCap(String maNhaCungCap) {
		super();
		this.maNhaCungCap = maNhaCungCap;
	}
	
	public NhaCungCap(String maNhaCungCap, String tenNhaCungCap) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
	}
	public NhaCungCap() {
		super();
	}
	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}
	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}
	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}
	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public TrangThaiNCC getTrangThaiNCC() {
		return trangThaiNCC;
	}
	public void setTrangThaiNCC(TrangThaiNCC trangThaiNCC) {
		this.trangThaiNCC = trangThaiNCC;
	}
	@Override
	public String toString() {
		return "NhaCungCap [maNhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", soDienThoai="
				+ soDienThoai + ", diaChi=" + diaChi + ", email=" + email + ", ghiChu=" + ghiChu + ", trangThaiNCC="
				+ trangThaiNCC + "]";
	}
	
	
}
