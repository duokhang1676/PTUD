package entities;

public class ChiTietPhieuNhapHang {
	private int maChiTietPhieuNhapHang;
	private PhieuNhapHang phieuNhapHang;
	private LoHang loHang;
	private DonViTinh donViTinh;
	private int soLuong;
	private double chietKhau;
	public ChiTietPhieuNhapHang(int maChiTietPhieuNhapHang, PhieuNhapHang phieuNhapHang, LoHang loHang,
			DonViTinh donViTinh, int soLuong, double chietKhau) {
		super();
		this.maChiTietPhieuNhapHang = maChiTietPhieuNhapHang;
		this.phieuNhapHang = phieuNhapHang;
		this.loHang = loHang;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.chietKhau = chietKhau;
	}
	public ChiTietPhieuNhapHang(int maChiTietPhieuNhapHang) {
		super();
		this.maChiTietPhieuNhapHang = maChiTietPhieuNhapHang;
	}
	public ChiTietPhieuNhapHang() {
		super();
	}
	public int getMaChiTietPhieuNhapHang() {
		return maChiTietPhieuNhapHang;
	}
	public void setMaChiTietPhieuNhapHang(int maChiTietPhieuNhapHang) {
		this.maChiTietPhieuNhapHang = maChiTietPhieuNhapHang;
	}
	public PhieuNhapHang getPhieuNhapHang() {
		return phieuNhapHang;
	}
	public void setPhieuNhapHang(PhieuNhapHang phieuNhapHang) {
		this.phieuNhapHang = phieuNhapHang;
	}
	public LoHang getLoHang() {
		return loHang;
	}
	public void setLoHang(LoHang loHang) {
		this.loHang = loHang;
	}
	public DonViTinh getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(DonViTinh donViTinh) {
		this.donViTinh = donViTinh;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getChietKhau() {
		return chietKhau;
	}
	public void setChietKhau(double chietKhau) {
		this.chietKhau = chietKhau;
	}
	@Override
	public String toString() {
		return "ChiTietPhieuNhapHang [maChiTietPhieuNhapHang=" + maChiTietPhieuNhapHang + ", phieuNhapHang="
				+ phieuNhapHang + ", loHang=" + loHang + ", donViTinh=" + donViTinh + ", soLuong=" + soLuong
				+ ", chietKhau=" + chietKhau + "]";
	}
	
	
}
