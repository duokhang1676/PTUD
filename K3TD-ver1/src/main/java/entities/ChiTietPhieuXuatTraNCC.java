package entities;

public class ChiTietPhieuXuatTraNCC {
	private int maChiTietPhieuXuatTraNCC;
	private PhieuXuatTraNCC phieuXuatTraNCC;
	private LoHang loHang;
	private int soLuong;
	private String lyDoTra;
	public ChiTietPhieuXuatTraNCC(int maChiTietPhieuXuatTraNCC, PhieuXuatTraNCC phieuXuatTraNCC, LoHang loHang,
			int soLuong, String lyDoTra) {
		super();
		this.maChiTietPhieuXuatTraNCC = maChiTietPhieuXuatTraNCC;
		this.phieuXuatTraNCC = phieuXuatTraNCC;
		this.loHang = loHang;
		this.soLuong = soLuong;
		this.lyDoTra = lyDoTra;
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
	public PhieuXuatTraNCC getPhieuXuatTraNCC() {
		return phieuXuatTraNCC;
	}
	public void setPhieuXuatTraNCC(PhieuXuatTraNCC phieuXuatTraNCC) {
		this.phieuXuatTraNCC = phieuXuatTraNCC;
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
	public String getLyDoTra() {
		return lyDoTra;
	}
	public void setLyDoTra(String lyDoTra) {
		this.lyDoTra = lyDoTra;
	}
	@Override
	public String toString() {
		return "ChiTietPhieuXuatTraNCC [maChiTietPhieuXuatTraNCC=" + maChiTietPhieuXuatTraNCC + ", phieuXuatTraNCC="
				+ phieuXuatTraNCC + ", loHang=" + loHang + ", soLuong=" + soLuong + ", lyDoTra=" + lyDoTra + "]";
	}
	
	
}
