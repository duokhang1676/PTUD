package entities;

public class ChiTietPhieuTraHang {
	private PhieuTraHang phieuTraHang;
	private int soLuongTra;
	private double donGia;
	private DonViTinh donViTinh;
	private String lyDoTra;
	public ChiTietPhieuTraHang(PhieuTraHang phieuTraHang, int soLuongTra, double donGia,
			DonViTinh donViTinh, String lyDoTra) {
		super();
		this.phieuTraHang = phieuTraHang;
		this.soLuongTra = soLuongTra;
		this.donGia = donGia;
		this.donViTinh = donViTinh;
		this.lyDoTra = lyDoTra;
	}
	public ChiTietPhieuTraHang() {
		super();
	}
	public PhieuTraHang getPhieuTraHang() {
		return phieuTraHang;
	}
	public void setPhieuTraHang(PhieuTraHang phieuTraHang) {
		this.phieuTraHang = phieuTraHang;
	}
	public int getSoLuongTra() {
		return soLuongTra;
	}
	public void setSoLuongTra(int soLuongTra) {
		this.soLuongTra = soLuongTra;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public DonViTinh getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(DonViTinh donViTinh) {
		this.donViTinh = donViTinh;
	}
	public String getLyDoTra() {
		return lyDoTra;
	}
	public void setLyDoTra(String lyDoTra) {
		this.lyDoTra = lyDoTra;
	}
	@Override
	public String toString() {
		return "ChiTietPhieuTraHang [phieuTraHang=" + phieuTraHang +  ", soLuongTra=" + soLuongTra
				+ ", donGia=" + donGia + ", donViTinh=" + donViTinh + ", lyDoTra=" + lyDoTra + "]";
	}
	
	public double tinhThanhTien() {
		return soLuongTra*donGia;
	}
	
}
