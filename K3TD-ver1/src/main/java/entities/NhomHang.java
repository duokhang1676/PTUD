package entities;

public class NhomHang {
	private int maNhomHang;
	private String tenNhomHang;
	public NhomHang(int maNhomHang, String tenNhomHang) {
		super();
		this.maNhomHang = maNhomHang;
		this.tenNhomHang = tenNhomHang;
	}
	public NhomHang(int i) {
		super();
		this.maNhomHang = i;
	}
	
	public NhomHang(String tenNhomHang) {
		super();
		this.tenNhomHang = tenNhomHang;
	}
	public NhomHang() {
		super();
	}
	public int getMaNhomHang() {
		return maNhomHang;
	}
	public void setMaNhomHang(int maNhomHang) {
		this.maNhomHang = maNhomHang;
	}
	public String getTenNhomHang() {
		return tenNhomHang;
	}
	public void setTenNhomHang(String tenNhomHang) {
		this.tenNhomHang = tenNhomHang;
	}
	@Override
	public String toString() {
		return "NhomHang [maNhomHang=" + maNhomHang + ", tenNhomHang=" + tenNhomHang + "]";
	}
	
	
}
