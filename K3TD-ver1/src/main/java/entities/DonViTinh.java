package entities;

public class DonViTinh {
	private int maDonViTinh;
	private String tenDonViTinh;
	private HangHoa hangHoa;
	private int quyDoi;
	private double giaBan;
	private TrangThaiDonViTinh trangThaiDonViTinh;
	public DonViTinh(int maDonViTinh, String tenDonViTinh, HangHoa hangHoa, int quyDoi, double giaBan,
			TrangThaiDonViTinh trangThaiDonViTinh) {
		super();
		this.maDonViTinh = maDonViTinh;
		this.tenDonViTinh = tenDonViTinh;
		this.hangHoa = hangHoa;
		this.quyDoi = quyDoi;
		this.giaBan = giaBan;
		this.trangThaiDonViTinh = trangThaiDonViTinh;
	}
	
	public DonViTinh(String tenDonViTinh, HangHoa hangHoa, int quyDoi, double giaBan,
			TrangThaiDonViTinh trangThaiDonViTinh) {
		super();
		this.tenDonViTinh = tenDonViTinh;
		this.hangHoa = hangHoa;
		this.quyDoi = quyDoi;
		this.giaBan = giaBan;
		this.trangThaiDonViTinh = trangThaiDonViTinh;
	}

	public DonViTinh(int maDonViTinh) {
		super();
		this.maDonViTinh = maDonViTinh;
	}
	public DonViTinh() {
		super();
	}
	public int getMaDonViTinh() {
		return maDonViTinh;
	}
	public void setMaDonViTinh(int maDonViTinh) {
		this.maDonViTinh = maDonViTinh;
	}
	public String getTenDonViTinh() {
		return tenDonViTinh;
	}
	public void setTenDonViTinh(String tenDonViTinh) {
		this.tenDonViTinh = tenDonViTinh;
	}
	public HangHoa getHangHoa() {
		return hangHoa;
	}
	public void setHangHoa(HangHoa hangHoa) {
		this.hangHoa = hangHoa;
	}
	public int getQuyDoi() {
		return quyDoi;
	}
	public void setQuyDoi(int quyDoi) {
		this.quyDoi = quyDoi;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public TrangThaiDonViTinh getTrangThaiDonViTinh() {
		return trangThaiDonViTinh;
	}
	public void setTrangThaiDonViTinh(TrangThaiDonViTinh trangThaiDonViTinh) {
		this.trangThaiDonViTinh = trangThaiDonViTinh;
	}
	@Override
	public String toString() {
		return "DonViTinh [maDonViTinh=" + maDonViTinh + ", tenDonViTinh=" + tenDonViTinh + ", hangHoa=" + hangHoa
				+ ", quyDoi=" + quyDoi + ", giaBan=" + giaBan + ", trangThaiDonViTinh=" + trangThaiDonViTinh + "]";
	}
	
	
}
