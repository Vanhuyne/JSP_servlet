package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia> {

	@Override
	// lay ra list tac gia
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> listTacgia = new ArrayList<>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM tacgia";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				String maTacgia = rs.getString("matacgia");
				String hoten = rs.getString("hoten");
				Date ngaysinh = rs.getDate("ngaysinh");
				String tieusu = rs.getString("tieusu");

				TacGia tacGia = new TacGia(maTacgia, hoten, ngaysinh, tieusu);

				listTacgia.add(tacGia);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();

		}

		// lay ra nhieu tac gia
		return listTacgia;
	}

	@Override
	// lay ra TacGia theo ma
	public TacGia selectById(TacGia t) {
		TacGia tacGia = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM tacgia WHERE matacgia = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, t.getMaTacGia());

			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				String maTacgia = rs.getString("matacgia");
				String hoten = rs.getString("hoten");
				Date ngaysinh = rs.getDate("ngaysinh");
				String tieusu = rs.getString("tieusu");

				tacGia = new TacGia(maTacgia, hoten, ngaysinh, tieusu);
				break;
			}
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tacGia;
	}

	@Override
	public int insert(TacGia t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO tacgia VALUES (?,?,?,?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, t.getMaTacGia());
			stm.setString(2, t.getHoTen());
			stm.setDate(3, t.getNgaySinh());
			stm.setString(4, t.getTieuSu());

			ketQua = stm.executeUpdate();
			if (ketQua > 0) {
				System.out.println("Đã thêm: " + ketQua);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<TacGia> arr) {
		int ketQua = 0;
		for (TacGia tacGia : arr) {
			ketQua += this.insert(tacGia);
		}
		return ketQua;
	}

	@Override
	// xoa theo maTacGia
	public int delete(TacGia t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from tacgia WHERE matacgia = ? ";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTacGia());

			// Bước 3: thực thi câu lệnh SQL
//			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	// xoa all
	public int deleteAll(ArrayList<TacGia> arr) {
		int ketQua = 0;
		for (TacGia tacGia : arr) {
			ketQua += this.delete(tacGia);
		}
		return ketQua;
	}

	@Override
	public int update(TacGia t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE tacgia " + "SET hoten = ?, ngaysinh = ? ,tieusu = ?"
					+ "WHERE matacgia = ?";

			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, t.getHoTen());
			stm.setDate(2, t.getNgaySinh());
			stm.setString(3, t.getTieuSu());
			stm.setString(4, t.getMaTacGia());
			ketQua = stm.executeUpdate();
			if (ketQua > 0) {
				System.out.println("update thanh cong");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ketQua;
	}
}
