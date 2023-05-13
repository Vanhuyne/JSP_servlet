package model;

public class SanPham {
	private String maSP;
	private String tenSP;
	private String ngonNgu;
	private String moTa;
	private int namXuatBan;
	private int soLuong;
	private double giaNhap;
	private double giaGoc;
	private double giaBan;
	private TheLoai theLoai;
	private TacGia tacGia;
	public SanPham() {
	}
	public SanPham(String maSP, String tenSP, String ngonNgu, String moTa, int namXuatBan, int soLuong, double giaNhap, 
					double giaGoc, double giaBan, TheLoai theLoai, TacGia tacGia) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.ngonNgu = ngonNgu;
		this.moTa = moTa;
		this.namXuatBan = namXuatBan;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.theLoai = theLoai;
		this.tacGia = tacGia;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getNgonNgu() {
		return ngonNgu;
	}
	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public double getGiaGoc() {
		return giaGoc;
	}
	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public TheLoai getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}
	public TacGia getTacGia() {
		return tacGia;
	}
	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}
	
	
}
