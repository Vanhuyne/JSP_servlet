package model;

import java.sql.Date;

public class KhachHang {
	private String maKH;
	private String tenDangNhap;
	private String matKhau;
	private String hoTen;
	private String diaChi;
	private String gioiTinh;
	private String diaChiNhanHang;
	private String diaChiMuaHang;
	private Date ngaySinh;
	private String SDT;
	private String email;
	private boolean dangkyNhanThongBao;
	private String maXacThuc;
	private Date thoiGianHieuLucCuaMaXacThuc;
	private boolean trangThaiXacThuc;
	private String anh;
	public KhachHang() {
	}
	public KhachHang(String maKH, String tenDangNhap, String matKhau, String hoTen, String diaChi, String gioiTinh,
			String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String sDT, String email,
			boolean dangkyNhanThongBao) {
		this.maKH = maKH;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		SDT = sDT;
		this.email = email;
		this.dangkyNhanThongBao = dangkyNhanThongBao;
	}
	
	public KhachHang(String maKH, String tenDangNhap, String matKhau, String hoTen, String diaChi, String gioiTinh,
			String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String sDT, String email,
			boolean dangkyNhanThongBao, String maXacThuc, Date thoiGianHieuLucCuaMaXacThuc, boolean trangThaiXacThuc,
			String anh) {
		super();
		this.maKH = maKH;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		SDT = sDT;
		this.email = email;
		this.dangkyNhanThongBao = dangkyNhanThongBao;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLucCuaMaXacThuc = thoiGianHieuLucCuaMaXacThuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
		this.anh = anh;
	}
	public String getMaXacThuc() {
		return maXacThuc;
	}
	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}
	public Date getThoiGianHieuLucCuaMaXacThuc() {
		return thoiGianHieuLucCuaMaXacThuc;
	}
	public void setThoiGianHieuLucCuaMaXacThuc(Date thoiGianHieuLucCuaMaXacThuc) {
		this.thoiGianHieuLucCuaMaXacThuc = thoiGianHieuLucCuaMaXacThuc;
	}
	public boolean isTrangThaiXacThuc() {
		return trangThaiXacThuc;
	}
	public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
		this.trangThaiXacThuc = trangThaiXacThuc;
	}
	public KhachHang(String maKH, String tenDangNhap, String matKhau, String hoTen, String diaChi, String gioiTinh,
			String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String sDT, String email,
			boolean dangkyNhanThongBao, String maXacThuc, Date thoiGianHieuLucCuaMaXacThuc, boolean trangThaiXacThuc) {
		super();
		this.maKH = maKH;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		SDT = sDT;
		this.email = email;
		this.dangkyNhanThongBao = dangkyNhanThongBao;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLucCuaMaXacThuc = thoiGianHieuLucCuaMaXacThuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}
	public String getDiaChiMuaHang() {
		return diaChiMuaHang;
	}
	public void setDiaChiMuaHang(String diaChiMuaHang) {
		this.diaChiMuaHang = diaChiMuaHang;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isDangkyNhanThongBao() {
		return dangkyNhanThongBao;
	}
	public void setDangkyNhanThongBao(boolean dangkyNhanThongBao) {
		this.dangkyNhanThongBao = dangkyNhanThongBao;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
}
