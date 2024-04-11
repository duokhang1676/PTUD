package entities;

public class DonThuoc {
	private String maDonThuoc;
	private HoaDon hoaDon;
	private String linkHinh;
	public DonThuoc(String maDonThuoc, HoaDon hoaDon, String linkHinh) {
		super();
		this.maDonThuoc = maDonThuoc;
		this.hoaDon = hoaDon;
		this.linkHinh = linkHinh;
	}
	public DonThuoc(String maDonThuoc) {
		super();
		this.maDonThuoc = maDonThuoc;
	}
	public DonThuoc() {
		super();
	}
	public String getMaDonThuoc() {
		return maDonThuoc;
	}
	public void setMaDonThuoc(String maDonThuoc) {
		this.maDonThuoc = maDonThuoc;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public String getLinkHinh() {
		return linkHinh;
	}
	public void setLinkHinh(String linkHinh) {
		this.linkHinh = linkHinh;
	}
	@Override
	public String toString() {
		return "DonThuoc [maDonThuoc=" + maDonThuoc + ", hoaDon=" + hoaDon + ", linkHinh=" + linkHinh + "]";
	}
	
	
}
