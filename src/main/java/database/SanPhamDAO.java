package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import model.SanPham;
import model.TacGia;
import model.TheLoai;

public class SanPhamDAO implements DAOInterface<SanPham> {

	@Override
	public ArrayList<SanPham> selectAll() {
		ArrayList<SanPham> listSanPham = new ArrayList<>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM sanpham";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString("masanpham");
				String tenSanPham = rs.getString("tensanpham");
				String maTacGia = rs.getString("matacgia");
				int namXuatban = rs.getInt("namxuatban");
				Double giaNhap = rs.getDouble("gianhap");
				Double giaGoc = rs.getDouble("giagoc");
				Double giaBan = rs.getDouble("giaban");
				int soluong = rs.getInt("soluong");
				String maTheLoai = rs.getString("matheloai");
				String ngonngu = rs.getString("ngonngu");
				String mota = rs.getString("mota");

				TacGia tacGia = new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, "")); // lay ra ma TacGia
																								// trong lop DAOTacGia
				TheLoai theLoai = new TheLoaiDAO().selectById(new TheLoai(maTheLoai, ""));

				SanPham sanPham = new SanPham(maSanPham, tenSanPham, ngonngu, mota, namXuatban, soluong, giaNhap,
						giaGoc, namXuatban, theLoai, tacGia);
				listSanPham.add(sanPham);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();

		}

		// lay ra nhieu tac gia
		return listSanPham;
	}

	@Override
	public SanPham selectById(SanPham t) {
		SanPham sanPham = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM sanpham";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString("masanpham");
				String tenSanPham = rs.getString("tensanpham");
				String maTacGia = rs.getString("matacgia");
				int namXuatban = rs.getInt("namxuatban");
				Double giaNhap = rs.getDouble("gianhap");
				Double giaGoc = rs.getDouble("giagoc");
				Double giaBan = rs.getDouble("giaban");
				int soluong = rs.getInt("soluong");
				String maTheLoai = rs.getString("matheloai");
				String ngonngu = rs.getString("ngonngu");
				String mota = rs.getString("mota");

				TacGia tacGia = new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, "")); // lay ra ma TacGia
																								// trong lop DAOTacGia
				TheLoai theLoai = new TheLoaiDAO().selectById(new TheLoai(maTheLoai, ""));

				sanPham = new SanPham(maSanPham, tenSanPham, ngonngu, mota, namXuatban, soluong, giaNhap, giaGoc,
						namXuatban, theLoai, tacGia);
				break;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return sanPham;
	}

	@Override
	public int insert(SanPham t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO sanpham VALUES (?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, t.getMaSP());
			stm.setString(2, t.getTenSP());
			stm.setString(3, t.getTacGia().getMaTacGia());
			stm.setInt(4, t.getNamXuatBan());
			stm.setDouble(5, t.getGiaNhap());
			stm.setDouble(6, t.getGiaGoc());
			stm.setDouble(7, t.getGiaBan());
			stm.setInt(8, t.getSoLuong());
			stm.setString(9, t.getTheLoai().getMaTheLoai());
			stm.setString(10, t.getNgonNgu());
			stm.setString(11, t.getMoTa());

			ketQua = stm.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<SanPham> arr) {
		int dem = 0;
		for (SanPham sanPham : arr) {
			dem += this.insert(sanPham);
		}
		return dem;
	}

	@Override
	public int delete(SanPham t) {
		int dem = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "DELETE FROM sanpham WHERE masanpham = ? ";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, t.getMaSP());
			dem = stm.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteAll(ArrayList<SanPham> arr) {
		int dem = 0;
		for (SanPham sanPham : arr) {
			dem += this.delete(sanPham);
		}
		return dem;
	}

	@Override
	public int update(SanPham t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE sanpham "
					+ "SET tensanpham = ?, matacgia = ?, namxuatban = ?, gianhap = ?, giagoc = ?, giaban = ?, soluong = ?, matheloai = ?, ngonngu = ?, mota = ?"
					+ " WHERE masanpham =?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenSP());
			st.setString(2, t.getTacGia().getMaTacGia());
			st.setInt(3, t.getNamXuatBan());
			st.setDouble(4, t.getGiaNhap());
			st.setDouble(5, t.getGiaGoc());
			st.setDouble(6, t.getGiaBan());
			st.setInt(7, t.getSoLuong());
			st.setString(8, t.getTheLoai().getMaTheLoai());
			st.setString(9, t.getNgonNgu());
			st.setString(10, t.getMoTa());
			st.setString(11, t.getMaSP());

			System.out.println(sql);
			ketQua = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

}
