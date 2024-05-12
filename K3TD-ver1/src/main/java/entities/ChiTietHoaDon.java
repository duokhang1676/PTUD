package entities;

public class ChiTietHoaDon {
	private HoaDon hoaDon;
	private LoHang loHang;
	private int soLuong;
	private double donGia;
	private DonViTinh donViTinh;
	public ChiTietHoaDon(HoaDon hoaDon, LoHang loHang, int soLuong, double donGia,
			DonViTinh donViTinh) {
		super();
		this.hoaDon = hoaDon;
		this.loHang = loHang;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.donViTinh = donViTinh;
	}
	public ChiTietHoaDon() {
		super();
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public LoHang getLoHang() {
		return loHang;
	}
	public void setLoHang(LoHang loHang) {
		this.loHang = loHang;
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
	public DonViTinh getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(DonViTinh donViTinh) {
		this.donViTinh = donViTinh;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", loHang=" + loHang
				+ ", soLuong=" + soLuong + ", donGia=" + donGia + ", donViTinh=" + donViTinh + "]";
	}
	public double tinhThanhTien() {
		return soLuong*donGia;
	}
	
}
