package entities;

import java.time.LocalDateTime;

public class Ca {
	private String maCa;
	private String tenCa;
	private NhanVien nhanVien;
	private LocalDateTime thoiGianVaoCa;
	private LocalDateTime thoiGianKetCa;
	private double tongTien;
	private double tongTienThucTe;
	public Ca() {
		super();
	}
	public Ca(String maCa, String tenCa, NhanVien nhanVien, LocalDateTime thoiGianVaoCa, LocalDateTime thoiGianKetCa,
			double tongTien, double tongTienThucTe) {
		super();
		this.maCa = maCa;
		this.tenCa = tenCa;
		this.nhanVien = nhanVien;
		this.thoiGianVaoCa = thoiGianVaoCa;
		this.thoiGianKetCa = thoiGianKetCa;
		this.tongTien = tongTien;
		this.tongTienThucTe = tongTienThucTe;
	}
	public Ca(String maCa) {
		super();
		this.maCa = maCa;
	}
	public String getMaCa() {
		return maCa;
	}
	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}
	public String getTenCa() {
		return tenCa;
	}
	public void setTenCa(String tenCa) {
		this.tenCa = tenCa;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public LocalDateTime getThoiGianVaoCa() {
		return thoiGianVaoCa;
	}
	public void setThoiGianVaoCa(LocalDateTime thoiGianVaoCa) {
		this.thoiGianVaoCa = thoiGianVaoCa;
	}
	public LocalDateTime getThoiGianKetCa() {
		return thoiGianKetCa;
	}
	public void setThoiGianKetCa(LocalDateTime thoiGianKetCa) {
		this.thoiGianKetCa = thoiGianKetCa;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public double getTongTienThucTe() {
		return tongTienThucTe;
	}
	public void setTongTienThucTe(double tongTienThucTe) {
		this.tongTienThucTe = tongTienThucTe;
	}
	@Override
	public String toString() {
		return "Ca [maCa=" + maCa + ", tenCa=" + tenCa + ", nhanVien=" + nhanVien + ", thoiGianVaoCa=" + thoiGianVaoCa
				+ ", thoiGianKetCa=" + thoiGianKetCa + ", tongTien=" + tongTien + ", tongTienThucTe=" + tongTienThucTe
				+ "]";
	}
	
	
}
