package entities;

public class HangHoa {
	private String maHangHoa;
	private String tenHangHoa;
	private LoaiHang loaiHang;
	private String soDangKy;
	private NhomHang nhomHang;
	private String nuocSanXuat;
	private String hangSanXuat;
	private String hoatChatChinh;
	private String hamLuong;
	private String quyCachDongGoi;
	private String moTa;
	private double thue;
	private int soLuongDinhMuc;
	private int soLuongCanhBao;
	private TrangThaiHangHoa trangThaiHangHoa;
	public HangHoa(String maHangHoa, String tenHangHoa, LoaiHang loaiHang, String soDangKy, NhomHang nhomHang,
			String nuocSanXuat, String hangSanXuat, String hoatChatChinh, String hamLuong, String quyCachDongGoi,
			String moTa, double thue, int soLuongDinhMuc, int soLuongCanhBao, TrangThaiHangHoa trangThaiHangHoa) {
		super();
		this.maHangHoa = maHangHoa;
		this.tenHangHoa = tenHangHoa;
		this.loaiHang = loaiHang;
		this.soDangKy = soDangKy;
		this.nhomHang = nhomHang;
		this.nuocSanXuat = nuocSanXuat;
		this.hangSanXuat = hangSanXuat;
		this.hoatChatChinh = hoatChatChinh;
		this.hamLuong = hamLuong;
		this.quyCachDongGoi = quyCachDongGoi;
		this.moTa = moTa;
		this.thue = thue;
		this.soLuongDinhMuc = soLuongDinhMuc;
		this.soLuongCanhBao = soLuongCanhBao;
		this.trangThaiHangHoa = trangThaiHangHoa;
	}
	public HangHoa() {
		super();
	}
	public String getMaHangHoa() {
		return maHangHoa;
	}
	public void setMaHangHoa(String maHangHoa) {
		this.maHangHoa = maHangHoa;
	}
	public String getTenHangHoa() {
		return tenHangHoa;
	}
	public void setTenHangHoa(String tenHangHoa) {
		this.tenHangHoa = tenHangHoa;
	}
	public LoaiHang getLoaiHang() {
		return loaiHang;
	}
	public void setLoaiHang(LoaiHang loaiHang) {
		this.loaiHang = loaiHang;
	}
	public String getSoDangKy() {
		return soDangKy;
	}
	public void setSoDangKy(String soDangKy) {
		this.soDangKy = soDangKy;
	}
	public NhomHang getNhomHang() {
		return nhomHang;
	}
	public void setNhomHang(NhomHang nhomHang) {
		this.nhomHang = nhomHang;
	}
	public String getNuocSanXuat() {
		return nuocSanXuat;
	}
	public void setNuocSanXuat(String nuocSanXuat) {
		this.nuocSanXuat = nuocSanXuat;
	}
	public String getHangSanXuat() {
		return hangSanXuat;
	}
	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
	public String getHoatChatChinh() {
		return hoatChatChinh;
	}
	public void setHoatChatChinh(String hoatChatChinh) {
		this.hoatChatChinh = hoatChatChinh;
	}
	public String getHamLuong() {
		return hamLuong;
	}
	public void setHamLuong(String hamLuong) {
		this.hamLuong = hamLuong;
	}
	public String getQuyCachDongGoi() {
		return quyCachDongGoi;
	}
	public void setQuyCachDongGoi(String quyCachDongGoi) {
		this.quyCachDongGoi = quyCachDongGoi;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public double getThue() {
		return thue;
	}
	public void setThue(double thue) {
		this.thue = thue;
	}
	public int getSoLuongDinhMuc() {
		return soLuongDinhMuc;
	}
	public void setSoLuongDinhMuc(int soLuongDinhMuc) {
		this.soLuongDinhMuc = soLuongDinhMuc;
	}
	public int getSoLuongCanhBao() {
		return soLuongCanhBao;
	}
	public void setSoLuongCanhBao(int soLuongCanhBao) {
		this.soLuongCanhBao = soLuongCanhBao;
	}
	public TrangThaiHangHoa getTrangThaiHangHoa() {
		return trangThaiHangHoa;
	}
	public void setTrangThaiHangHoa(TrangThaiHangHoa trangThaiHangHoa) {
		this.trangThaiHangHoa = trangThaiHangHoa;
	}
	@Override
	public String toString() {
		return "HangHoa [maHangHoa=" + maHangHoa + ", tenHangHoa=" + tenHangHoa + ", loaiHang=" + loaiHang
				+ ", soDangKy=" + soDangKy + ", nhomHang=" + nhomHang + ", nuocSanXuat=" + nuocSanXuat
				+ ", hangSanXuat=" + hangSanXuat + ", hoatChatChinh=" + hoatChatChinh + ", hamLuong=" + hamLuong
				+ ", quyCachDongGoi=" + quyCachDongGoi + ", moTa=" + moTa + ", thue=" + thue + ", soLuongDinhMuc="
				+ soLuongDinhMuc + ", soLuongCanhBao=" + soLuongCanhBao + ", trangThaiHangHoa=" + trangThaiHangHoa
				+ "]";
	}
	
}
