package entities;

public class ChiTietPhieuXuatTraNCC {
	private int maChiTietPhieuXuatTraNCC;
	private PhieuXuatTra phieuXuatTraNCC;
	private LoHang loHang;
	private DonViTinh donViTinh;
	private int soLuong;
	private double chietKhau;
	public ChiTietPhieuXuatTraNCC(int maChiTietPhieuXuatTraNCC, PhieuXuatTra phieuXuatTraNCC, LoHang loHang,
			DonViTinh donViTinh, int soLuong, double chietKhau) {
		super();
		this.maChiTietPhieuXuatTraNCC = maChiTietPhieuXuatTraNCC;
		this.phieuXuatTraNCC = phieuXuatTraNCC;
		this.loHang = loHang;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.chietKhau = chietKhau;
	}
	public ChiTietPhieuXuatTraNCC(int maChiTietPhieuXuatTraNCC) {
		super();
		this.maChiTietPhieuXuatTraNCC = maChiTietPhieuXuatTraNCC;
	}
	public ChiTietPhieuXuatTraNCC() {
		super();
	}
	public int getMaChiTietPhieuXuatTraNCC() {
		return maChiTietPhieuXuatTraNCC;
	}
	public void setMaChiTietPhieuXuatTraNCC(int maChiTietPhieuXuatTraNCC) {
		this.maChiTietPhieuXuatTraNCC = maChiTietPhieuXuatTraNCC;
	}
	public PhieuXuatTra getPhieuXuatTraNCC() {
		return phieuXuatTraNCC;
	}
	public void setPhieuXuatTraNCC(PhieuXuatTra phieuXuatTraNCC) {
		this.phieuXuatTraNCC = phieuXuatTraNCC;
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
		return "ChiTietPhieuXuatTraNCC [maChiTietPhieuXuatTraNCC=" + maChiTietPhieuXuatTraNCC + ", phieuXuatTraNCC="
				+ phieuXuatTraNCC + ", loHang=" + loHang + ", donViTinh=" + donViTinh + ", soLuong=" + soLuong
				+ ", chietKhau=" + chietKhau + "]";
	}

	
	
}
