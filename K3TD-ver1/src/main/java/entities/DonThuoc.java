package entities;

public class DonThuoc {
	private String maDonThuoc;
	private HoaDon hoaDon;
	
	public DonThuoc(String maDonThuoc, HoaDon hoaDon) {
		super();
		this.maDonThuoc = maDonThuoc;
		this.hoaDon = hoaDon;
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
	
	@Override
	public String toString() {
		return "DonThuoc [maDonThuoc=" + maDonThuoc + ", hoaDon=" + hoaDon  + "]";
	}
	
	
}
