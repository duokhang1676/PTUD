package entities;

public class ChiTietPhieuXuatTra {
	private PhieuXuatTra phieuXuatTraNCC;
	private LoHang loHang;
	private DonViTinh donViTinh;
	private int soLuong;
	private double donGia;
	private double chietKhau;

	public ChiTietPhieuXuatTra(PhieuXuatTra phieuXuatTraNCC, LoHang loHang, DonViTinh donViTinh, int soLuong,
			double donGia, double chietKhau) {
		super();
		this.phieuXuatTraNCC = phieuXuatTraNCC;
		this.loHang = loHang;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.donGia = donGia;
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

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getChietKhau() {
		return chietKhau;
	}

	public void setChietKhau(double chietKhau) {
		this.chietKhau = chietKhau;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuXuatTra [phieuXuatTraNCC=" + phieuXuatTraNCC + ", loHang=" + loHang + ", donViTinh="
				+ donViTinh + ", soLuong=" + soLuong + ", donGia=" + donGia + ", chietKhau=" + chietKhau + "]";
	}

	public double tinhThanhTien() {
		return soLuong * donGia - soLuong * donGia * chietKhau / 100;
	}

}
