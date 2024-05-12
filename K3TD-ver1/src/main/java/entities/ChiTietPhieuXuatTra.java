package entities;

public class ChiTietPhieuXuatTra {
	private PhieuXuatTra phieuXuatTraNCC;
	private LoHang loHang;
	private DonViTinh donViTinh;
	private int soLuong;
	private double chietKhau;
	public ChiTietPhieuXuatTra(PhieuXuatTra phieuXuatTraNCC, LoHang loHang,
			DonViTinh donViTinh, int soLuong, double chietKhau) {
		super();
		this.phieuXuatTraNCC = phieuXuatTraNCC;
		this.loHang = loHang;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.chietKhau = chietKhau;
	}

	public ChiTietPhieuXuatTra() {
		super();
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
		return "ChiTietPhieuXuatTraNCC [phieuXuatTraNCC="
				+ phieuXuatTraNCC + ", loHang=" + loHang + ", donViTinh=" + donViTinh + ", soLuong=" + soLuong
				+ ", chietKhau=" + chietKhau + "]";
	}

	public double tinhThanhTien() {
		return soLuong*loHang.getGiaNhap()-soLuong*loHang.getGiaNhap()*chietKhau;
	}
	
}
