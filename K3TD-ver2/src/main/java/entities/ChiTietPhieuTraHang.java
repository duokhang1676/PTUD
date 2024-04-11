package entities;

public class ChiTietPhieuTraHang {
	private int maChiTietPhieuTraHang;
	private ChiTietHoaDon chiTietHoaDon;
	private PhieuTraHang phieuTraHang;
	private int soLuongTra;
	private String lyDoTra;
	public ChiTietPhieuTraHang(int maChiTietPhieuTraHang, ChiTietHoaDon chiTietHoaDon, PhieuTraHang phieuTraHang,
			int soLuongTra, String lyDoTra) {
		super();
		this.maChiTietPhieuTraHang = maChiTietPhieuTraHang;
		this.chiTietHoaDon = chiTietHoaDon;
		this.phieuTraHang = phieuTraHang;
		this.soLuongTra = soLuongTra;
		this.lyDoTra = lyDoTra;
	}
	public ChiTietPhieuTraHang(int maChiTietPhieuTraHang) {
		super();
		this.maChiTietPhieuTraHang = maChiTietPhieuTraHang;
	}
	public ChiTietPhieuTraHang() {
		super();
	}
	public int getMaChiTietPhieuTraHang() {
		return maChiTietPhieuTraHang;
	}
	public void setMaChiTietPhieuTraHang(int maChiTietPhieuTraHang) {
		this.maChiTietPhieuTraHang = maChiTietPhieuTraHang;
	}
	public ChiTietHoaDon getChiTietHoaDon() {
		return chiTietHoaDon;
	}
	public void setChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}
	public PhieuTraHang getPhieuTraHang() {
		return phieuTraHang;
	}
	public void setPhieuTraHang(PhieuTraHang phieuTraHang) {
		this.phieuTraHang = phieuTraHang;
	}
	public int getSoLuongTra() {
		return soLuongTra;
	}
	public void setSoLuongTra(int soLuongTra) {
		this.soLuongTra = soLuongTra;
	}
	public String getLyDoTra() {
		return lyDoTra;
	}
	public void setLyDoTra(String lyDoTra) {
		this.lyDoTra = lyDoTra;
	}
	@Override
	public String toString() {
		return "ChiTietPhieuTraHang [maChiTietPhieuTraHang=" + maChiTietPhieuTraHang + ", chiTietHoaDon="
				+ chiTietHoaDon + ", phieuTraHang=" + phieuTraHang + ", soLuongTra=" + soLuongTra + ", lyDoTra="
				+ lyDoTra + "]";
	}
	
	
}
