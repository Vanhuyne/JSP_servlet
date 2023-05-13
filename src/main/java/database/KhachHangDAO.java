package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang>{

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> listKhachhang = new ArrayList<KhachHang>();
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM khachhang";
			PreparedStatement st = con.prepareStatement(sql);

			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maKhacHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hoten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String diaChiMuaHang = rs.getString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkynhantin");
				String anh = rs.getString("anh");

				KhachHang kh = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, diaChi, gioiTinh, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, email, ngaySinh, dangKyNhanBangTin, anh);
				listKhachhang.add(kh);
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return listKhachhang;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang khachHang = null;
		try {
			Connection con = JDBCUtil.getConnection();
		
			String sql = "SELECT * FROM khachhang WHERE makhachhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKH());
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maKhacHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hoten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String diaChiMuaHang = rs.getString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkynhantin");
				String maXacThuc = rs.getString("maxacthuc");
				Date thoigianhieuluc = rs.getDate("thoigianhieuluc");
				boolean trangThaiXacThuc = rs.getBoolean("trangthaixacthuc");
				


				khachHang = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, diaChi, gioiTinh, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, maXacThuc, thoigianhieuluc, trangThaiXacThuc);
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return khachHang;
	}

	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO khachhang VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKH());
			st.setString(2, t.getTenDangNhap());
			st.setString(3, t.getMatKhau());
			st.setString(4, t.getHoTen());
			st.setString(5, t.getGioiTinh());
			st.setString(6, t.getDiaChi());
			st.setString(7, t.getDiaChiNhanHang());
			st.setString(8, t.getDiaChiMuaHang());
			st.setDate(9, t.getNgaySinh());
			st.setString(10, t.getSDT());
			st.setString(11, t.getEmail());
			st.setBoolean(12, t.isDangkyNhanThongBao());
			st.setString(13, t.getMaXacThuc());
			st.setDate(14, t.getThoiGianHieuLucCuaMaXacThuc());
			st.setBoolean(15, t.isTrangThaiXacThuc());
			ketQua = st.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for (KhachHang khachHang : arr) {
			dem += this.insert(khachHang);
		}
		return dem;
	}

	@Override
	public int delete(KhachHang t) {
		int ketQua = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE from khachhang " + " WHERE makhachhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaKH());

			ketQua = st.executeUpdate();


			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for (KhachHang khachHang : arr) {
			dem += this.delete(khachHang);
		}
		return dem;
	}

	@Override
	public int update(KhachHang t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE khachhang " 
						+" SET " + " tendangnhap=?" + ", matkhau=?" + ", hoten=?" + ", gioitinh=?"
								 + ", diachi =?" + ", diachinhanhang =?" + ", diachimuahang =?" + ", ngaysinh =?" + ", sodienthoai =?"
								 + ", email =?" + ", dangkynhantin =?" 
						+" WHERE makhachhang =?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenDangNhap());
			st.setString(2, t.getMatKhau());
			st.setString(3, t.getHoTen());
			st.setString(4, t.getGioiTinh());
			st.setString(5, t.getDiaChi());
			st.setString(6, t.getDiaChiNhanHang());
			st.setString(7, t.getDiaChiMuaHang());
			st.setDate(8, t.getNgaySinh());
			st.setString(9, t.getSDT());
			st.setString(10, t.getEmail());
			st.setBoolean(11, t.isDangkyNhanThongBao());
			st.setString(12, t.getMaKH());

			
			ketQua = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}
	public boolean kiemtraDangnhap(String tenDangNhap) {
		boolean kq = false;
		Connection con = JDBCUtil.getConnection();
		try {
			
			
			PreparedStatement sq = con.prepareStatement("SELECT * FROM khachhang where tendangnhap = ?");
			sq.setString(1, tenDangNhap);
			
			ResultSet rs = sq.executeQuery();

			while (rs.next()) {
				kq = true;
				System.out.println("tồn tại");
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// co khachhang trong du lieu => insert false
		return kq;
	}
	public static void main(String[] args) {
		Connection con = JDBCUtil.getConnection();
		KhachHang kh1 = new KhachHang();
		kh1.setTenDangNhap("huy");
		kh1.setMatKhau("123");
		KhachHangDAO khdao = new KhachHangDAO();
		KhachHang kh =khdao.selectDangnhap(kh1);
		if (kh != null) {
			System.out.println("có huy");
		}else {
			System.out.println("no");
		}
	}
	public KhachHang selectDangnhap(KhachHang t) {
		KhachHang khachHang = null;
		try {
			Connection con = JDBCUtil.getConnection();
		
			String sql = "SELECT * FROM khachhang WHERE tendangnhap=? and matkhau =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenDangNhap());
			st.setString(2, t.getMatKhau());
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				System.out.println(1);
				String maKhacHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hoten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String diaChiMuaHang = rs.getString("diachimuahang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBangTin = rs.getBoolean("dangkynhantin");
				String maXacThuc = rs.getString("maxacthuc");
				Date thoigianhieuluc = rs.getDate("thoigianhieuluc");
				boolean trangThaiXacThuc = rs.getBoolean("trangthaixacthuc");
				

				khachHang = new KhachHang(maKhacHang, tenDangNhap, matKhau, hoVaTen, diaChi, gioiTinh, diaChiNhanHang, diaChiMuaHang, ngaySinh, soDienThoai, email, dangKyNhanBangTin, maXacThuc, thoigianhieuluc, trangThaiXacThuc);
			}

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return khachHang;
	}

	public boolean changePass(KhachHang t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE khachhang " 
						+" SET matkhau =? "
						+" WHERE makhachhang =?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMatKhau());
			st.setString(2, t.getMaKH());
			

			
			ketQua = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua > 0; // tra ve ket qua dung
}

	public static int updateInfo(KhachHang t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE khachhang " 
						+" SET " + " hoten=?" + ", gioitinh=?"
								 + ", diachi =?" + ", diachinhanhang =?" + ", diachimuahang =?" + ", ngaysinh =?" + ", sodienthoai =?"
								 + ", email =?" + ", dangkynhantin =?" 
						+" WHERE makhachhang =?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getHoTen());
			st.setString(2, t.getGioiTinh());
			st.setString(3, t.getDiaChi());
			st.setString(4, t.getDiaChiNhanHang());
			st.setString(5, t.getDiaChiMuaHang());
			st.setDate(6, t.getNgaySinh());	
			st.setString(7, t.getSDT());
			st.setString(8, t.getEmail());
			st.setBoolean(9, t.isDangkyNhanThongBao());
			st.setString(10, t.getMaKH());

			
			ketQua = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
		
	}

	public int updateVerifyInfo(KhachHang t) {
		int ketQua =0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE khachhang " + " SET " + " maxacthuc=?" + ", thoigianhieuluc=?" + ", trangthaixacthuc=?" +  " WHERE makhachhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaXacThuc());
			st.setDate(2, t.getThoiGianHieuLucCuaMaXacThuc());
			st.setBoolean(3, t.isTrangThaiXacThuc());
			st.setString(4, t.getMaKH());
			// Bước 3: thực thi câu lệnh SQL

			ketQua = st.executeUpdate();

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public int UpdateImg(KhachHang t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE khachhang " 
						+" SET anh =? "
						+" WHERE makhachhang =?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getAnh());
			st.setString(2, t.getMaKH());
			

			
			ketQua = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
		
	}
}
