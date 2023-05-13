package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonHang;
import model.KhachHang;

public class DonHangDAO implements DAOInterface<DonHang>{

	@Override
	public ArrayList<DonHang> selectAll() {
		ArrayList<DonHang> ketQua = new ArrayList<DonHang>();
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM donhang";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maDonHang = rs.getString("madonhang");
				String maKhachHang = rs.getString("makhachhang");
				String diaChiNguoiMua = rs.getString("diachimuahang");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String trangThai = rs.getString("trangthai");
				String hinhThucThanhToan = rs.getString("hinhthucthanhtoan");
				String trangThaiThanhToan = rs.getString("trangthaithanhtoan");
				double soTienDaThanhToan = rs.getDouble("sotienthanhtoan");
				double soTienConThieu = rs.getDouble("sothienconthieu");
				Date ngayDatHang = rs.getDate("ngaydathang");
				Date ngayGiaoHang = rs.getDate("ngaygiaohang");
				

				KhachHang kh = new KhachHang();
				kh.setMaKH(maKhachHang);
				
				KhachHang khachHang = new KhachHangDAO().selectById(kh);
				
				DonHang dh = new DonHang(maDonHang, khachHang, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang);

				ketQua.add(dh);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public DonHang selectById(DonHang t) {
		DonHang donHang = null;
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM donhang where madonhang = ?;";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maDonHang = rs.getString("madonhang");
				String maKhachHang = rs.getString("makhachhang");
				String diaChiNguoiMua = rs.getString("diachimuahang");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String trangThai = rs.getString("trangthai");
				String hinhThucThanhToan = rs.getString("hinhthucthanhtoan");
				String trangThaiThanhToan = rs.getString("trangthaithanhtoan");
				double soTienDaThanhToan = rs.getDouble("sotienthanhtoan");
				double soTienConThieu = rs.getDouble("sothienconthieu");
				Date ngayDatHang = rs.getDate("ngaydathang");
				Date ngayGiaoHang = rs.getDate("ngaygiaohang");

				KhachHang kh = new KhachHang();
				kh.setMaKH(maKhachHang);
				
				KhachHang khachHang = new KhachHangDAO().selectById(kh);
				
				 donHang = new DonHang(maDonHang, khachHang, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang);
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return donHang;
	}

	@Override
	public int insert(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "INSERT INTO donhang VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			st.setString(2, t.getKhachHang().getMaKH());
			st.setString(3, t.getDiachiMuahang());
			st.setString(4, t.getDiachiNhanhang());
			st.setString(5, t.getTrangThai());
			st.setString(6, t.getHinhThucThanhToan());
			st.setString(7, t.getTrangThaiThanhToan());
			st.setDouble(8, t.getSoTienDaThanhToan());
			st.setDouble(9, t.getSoTienConThieu());
			st.setDate(10, t.getNgayDatHang());
			st.setDate(11, t.getNgayGiaoHang());

			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int insertAll(ArrayList<DonHang> arr) {
		int kq = 0;
		for (DonHang donHang : arr) {
			kq += this.insert(donHang);
		}
		return kq;
	}

	@Override
	public int delete(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM donhang WHERE madonhang = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHang());
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int deleteAll(ArrayList<DonHang> arr) {
		int kq = 0;
		for (DonHang t : arr) {
			kq += this.delete(t);
		}
		return kq;
	}

	@Override
	public int update(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();

		String sql = "UPDATE donhang" + " SET " + "makhachhang=?" + ", diachimuahang=?" + ",diachinhanhang=?"
				+ ",trangthai=?" + ",hinhthucthanhtoan=?"+ ",sotienthanhtoan=?" + ",sothienconthieu=?" + ",trangthaithanhtoan=?" + ",ngaydathang=?"
				+ ",ngaygiaohang=?" + " WHERE madonhang=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, t.getKhachHang().getMaKH());
			st.setString(2, t.getDiachiMuahang());
			st.setString(3, t.getDiachiNhanhang());
			st.setString(4, t.getTrangThai());
			st.setString(5, t.getHinhThucThanhToan());
			st.setDouble(6, t.getSoTienDaThanhToan());
			st.setDouble(7, t.getSoTienConThieu());
			st.setString(8, t.getTrangThaiThanhToan());
			st.setDate(9, t.getNgayDatHang());
			st.setDate(10, t.getNgayGiaoHang());
			st.setString(10, t.getMaDonHang());

			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
}
