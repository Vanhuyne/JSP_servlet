package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TheLoai;
import model.TheLoai;
import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai> {

	@Override
	public ArrayList<TheLoai> selectAll() {
		ArrayList<TheLoai> listTheloai = new ArrayList<>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM theloai";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				String maTheloai = rs.getString("matheloai");
				String tenTheloai = rs.getString("tentheoloai");

				TheLoai TheLoai = new TheLoai(maTheloai, tenTheloai);

				listTheloai.add(TheLoai);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();

		}

		// lay ra nhieu tac gia
		return listTheloai;
	}

	@Override
	public TheLoai selectById(TheLoai t) {
		TheLoai TheLoai = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM TheLoai WHERE matheloai = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, t.getMaTheLoai());

			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				String maTheLoai = rs.getString("maTheLoai");
				String tenTheloai = rs.getString("hoten");

				TheLoai = new TheLoai(maTheLoai, tenTheloai);
				break;
			}
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return TheLoai;
	}

	@Override
	public int insert(TheLoai t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO TheLoai VALUES (?,?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, t.getMaTheLoai());
			stm.setString(2, t.getTenTheLoai());

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
	public int insertAll(ArrayList<TheLoai> arr) {
		int ketQua = 0;
		for (TheLoai TheLoai : arr) {
			ketQua += this.insert(TheLoai);
		}
		return ketQua;
	}

	@Override
	public int delete(TheLoai t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from theloai WHERE matheloai = ? ";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaTheLoai());

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
	public int deleteAll(ArrayList<TheLoai> arr) {
		int ketQua = 0;
		for (TheLoai TheLoai : arr) {
			ketQua += this.delete(TheLoai);
		}
		return ketQua;
	}

	@Override
	public int update(TheLoai t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE TheLoai " + "SET tentheloai = ?" + "WHERE maTheLoai = ?";

			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, t.getTenTheLoai());
			stm.setString(2, t.getMaTheLoai());

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
