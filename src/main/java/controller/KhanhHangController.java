package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.KhachHangDAO;
import model.KhachHang;
import security.Mahoa;

/**
 * Servlet implementation class KhanhHangController
 */
@WebServlet("/khach-hang")
public class KhanhHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhanhHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hanhDong = request.getParameter("hanhDong");
		if (hanhDong.equals("dang-nhap")) {
			dangNhap(request, response);
		}else if (hanhDong.equals("dang-xuat")) {
			dangXuat(request, response);
		}else if (hanhDong.equals("dang-ky")) {
			dangKy(request, response);
		}else if (hanhDong.equals("doi-mat-khau")) {
			doiMatkhau(request, response);
		}else if (hanhDong.equals("doi-thong-tin")) {
			thaydoiThongTin(request, response);
		}else if (hanhDong.equals("xac-thuc")) {
			xacthuc(request, response);
		}
	}

	private void xacthuc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String maKhachhang = request.getParameter("maKhachhang");
		String maXacthuc = request.getParameter("maXacthuc");
		
		KhachHangDAO khDao = new KhachHangDAO();
		KhachHang kh = new KhachHang();
		kh.setMaKH(maKhachhang);
		KhachHang khachHang = khDao.selectById(kh);
		
		String msg ="";
		if (khachHang != null) {
			// kiem tra ma xac thuc co giong khong?
			if (khachHang.getMaXacThuc().equals(maXacthuc)) {
				//thanh cong
				khachHang.setTrangThaiXacThuc(true);
				khDao.updateVerifyInfo(khachHang);
					msg = "Xác thực thành công";	
			}else {
					msg="Xác thực thất bại";
			}
			String url = "/khachhang/thongbao.jsp";
			request.setAttribute("baoLoi", msg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}
		
	}

	private void thaydoiThongTin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String hoten = request.getParameter("hoten");
		String gioitinh = request.getParameter("gioitinh");
		String ngaysinh = request.getParameter("ngaysinh");
		String diachikhachhang = request.getParameter("diachikhachhang");
		String diachimuahang = request.getParameter("diachimuahang");
		String diachinhanhang = request.getParameter("diachinhanhang");
		String dienthoai = request.getParameter("dienthoai");
		String email = request.getParameter("email");
		String nhanGmail = request.getParameter("nhanGmail");
		
		request.setAttribute("hoten", hoten);
		request.setAttribute("gioitinh", gioitinh);
		request.setAttribute("ngaysinh", ngaysinh);
		request.setAttribute("diachikhachhang", diachikhachhang);
		request.setAttribute("diachimuahang", diachimuahang);
		request.setAttribute("diachinhanhang", diachinhanhang);
		request.setAttribute("email", email);
		request.setAttribute("dienthoai", dienthoai);
		request.setAttribute("nhanGmail", nhanGmail);
		
		String url ="";
		String baoLoi="";
		KhachHangDAO khDAO = new KhachHangDAO();
		request.setAttribute("baoLoi", baoLoi);
		
		if (baoLoi.length() >0) {
			url= "/khachhang/register.jsp";
		}else {
			Object object = request.getSession().getAttribute("kh1");
			KhachHang khachHang = null;
			if (object!=null) {
				khachHang = (KhachHang) object;
				String maKH = khachHang.getMaKH();
				KhachHang kh = new KhachHang(maKH, "", "", hoten, gioitinh, diachikhachhang,diachinhanhang , diachimuahang,Date.valueOf(ngaysinh), dienthoai, email, nhanGmail !=null);
				KhachHangDAO.updateInfo(kh);
				KhachHang kh2 = khDAO.selectById(kh);
				request.getSession().setAttribute("kh1", kh2);
				url = "/khachhang/success.jsp";
			}
		}
		RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
		rq.forward(request, response);
		
	}

	private void doiMatkhau(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matkhau = request.getParameter("matkhau");
		String matkhaumoi = request.getParameter("matkhaumoi");
		String matkhaumoi2 = request.getParameter("matkhaumoi2");

		// ma hoa mat khau hien tai
		String matkhau_sha1 = Mahoa.toSHA1(matkhau);

		String loi = "";
		String url = "/khachhang/changepass.jsp";
		// kiem tra dang nhap truoc khi Doi mat khau
		HttpSession session = request.getSession();
		Object object = session.getAttribute("kh1"); // lay kh1 trong phien lam viec truoc
		KhachHang khachHang = null;
		if (object != null)
			khachHang = (KhachHang) object;
		if (khachHang == null) {
			loi = "Hãy đăng nhập !";
		} else { // nguoi dung da dang nhap
			if (!matkhau_sha1.equals(khachHang.getMatKhau())) { // kiem tra MK sang nhap co trung voi MK dang su dung
																// trong Session
				loi = "Mật khẩu hiện tại không đúng!";
			} else {
				if (matkhau.equals(matkhaumoi)) {
					loi = "Mật khẩu mới không được trùng với mật khẩu cũ!";
				} else if (!matkhaumoi2.equals(matkhaumoi)) {
					loi = "Mật khẩu nhập lại không khớp!";
				} else {
					String makhaumoi_sha1 = Mahoa.toSHA1(matkhaumoi);
					khachHang.setMatKhau(makhaumoi_sha1);
					KhachHangDAO khdao = new KhachHangDAO();
					if (khdao.changePass(khachHang)) {
						loi = "Đổi mật khẩu thành công.";
					} else {
						loi = "Lỗi hệ thống!";
					}
				}
			}
		}
		request.setAttribute("loi", loi);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

	private void dangKy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String tenDangnhap = request.getParameter("tenDangnhap");
		String matkhau = request.getParameter("matkhau");
		String matkhauhai = request.getParameter("matkhauhai");
		String hoten = request.getParameter("hoten");
		String gioitinh = request.getParameter("gioitinh");
		String ngaysinh = request.getParameter("ngaysinh");
		String diachikhachhang = request.getParameter("diachikhachhang");
		String diachimuahang = request.getParameter("diachimuahang");
		String diachinhanhang = request.getParameter("diachinhanhang");
		String dienthoai = request.getParameter("dienthoai");
		String email = request.getParameter("email");
		String nhanGmail = request.getParameter("nhanGmail");
		
		request.setAttribute("tenDangnhap", tenDangnhap);
		request.setAttribute("hoten", hoten);
		request.setAttribute("gioitinh", gioitinh);
		request.setAttribute("ngaysinh", ngaysinh);
		request.setAttribute("diachikhachhang", diachikhachhang);
		request.setAttribute("diachimuahang", diachimuahang);
		request.setAttribute("diachinhanhang", diachinhanhang);
		request.setAttribute("email", email);
		request.setAttribute("dienthoai", dienthoai);
		request.setAttribute("nhanGmail", nhanGmail);
		
		KhachHangDAO khDAO = new KhachHangDAO();
		String url = ""; // chuyen huong
		String thongBao = "";
		if (khDAO.kiemtraDangnhap(tenDangnhap)) {
			thongBao += "Tên đăng nhập tồn tại.<br>";
		}else {
			matkhau = Mahoa.toSHA1(matkhau);
		}
		
		request.setAttribute("baoLoi", thongBao); 
		if (thongBao.length() > 0) {
			url ="/khachhang/register.jsp";
		}else {
			// neu khong loi thi luu KhachHang vao data
//			matkhau = Mahoa.toSHA1(matkhau);
			Random random = new Random();
			String makhachhang = System.currentTimeMillis()+ random.nextInt(100) +"";
			KhachHang kh = new KhachHang(makhachhang, tenDangnhap, matkhau, hoten, diachikhachhang, gioitinh, diachinhanhang, diachimuahang, Date.valueOf(ngaysinh), makhachhang, email, nhanGmail != null);
			
			if(khDAO.insert(kh) > 0) {
				// day so xac thuc
				Random rd= new Random();
				String r1 = rd.nextInt(100)+"";	
				String r2 = rd.nextInt(100)+"";
				String soNgauNhien = r1 +r2;
				
				// quy dinh thoi gian hieu luc
				Date todayDate = new Date(new java.util.Date().getTime());
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(todayDate);
				calendar.add(Calendar.DATE, 1);
				Date thoiGianhieuluc = new Date(calendar.getTimeInMillis());
				
				// trang thai xac thuc
				boolean trangThaiXacthuc = false;
				
				kh.setMaXacThuc(soNgauNhien);
				kh.setThoiGianHieuLucCuaMaXacThuc(thoiGianhieuluc);
				kh.setTrangThaiXacThuc(trangThaiXacthuc);
				
				if (khDAO.updateVerifyInfo(kh) > 0) {
					// gui email cho khach hang
					security.email.sendEmail(kh.getEmail(),"Xac thuc nhanh", getNoidung(kh));
				}
			}
			url ="/khachhang/success.jsp";
		}
		RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
		rq.forward(request, response);	
		
	}

	

	private void dangXuat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// huy bo phien lam viec Session
		session.invalidate();
		
		String  url = request.getScheme() +"://"+ request.getServerName()+":"+ request.getServerPort() + request.getContextPath();
		
		response.sendRedirect(url+"/index.jsp"); // sau khi dang xuat huy phien session quay ve trang index
		
	}

	private void dangNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDangnhap = request.getParameter("tenDangnhap");
		String matkhau = request.getParameter("matkhau");
		matkhau = Mahoa.toSHA1(matkhau);
		
		KhachHang kh = new KhachHang();
		kh.setTenDangNhap(tenDangnhap);
		kh.setMatKhau(matkhau);
		
		KhachHangDAO khDAO = new KhachHangDAO();
		// goi phuong thuc DangNhap -> tra ve mot khachhang
		KhachHang kh1 = khDAO.selectDangnhap(kh);
		String url="";
		if (kh1!=null &&kh1.isTrangThaiXacThuc()) {
			HttpSession session = request.getSession(); // luu khachhang do vao phien lam viec session
			session.setAttribute("kh1", kh1);
			url = "/index.jsp";

		}else {
			request.setAttribute("baoLoi","Tên đăng nhập hoặc mật khẩu sai");
			url = "/khachhang/signin.jsp";
		}
		RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(url);
		rDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private static String getNoidung(KhachHang kh) {
		String link = "http://localhost:8080/StroreBook1/khach-hang?hanhDong=xac-thuc&maKhachhang="+kh.getMaKH()+"&maXacthuc="+kh.getMaXacThuc();
		String noidung = "<p>BookStore xin ch&agrave;o <strong>"+ kh.getHoTen()+"</strong></p>\r\n"
				+ "<p>Ma xac thuc la:<strong>"+ kh.getMaXacThuc()+"</strong></p>\r\n"
				+ 	"<p><a href=\""+link+"\">"+link+"</a></p>\r\n"
				+ "<p>Bạn đ&atilde; đăng k&yacute; th&agrave;nh c&ocirc;ng.</p>";
		return noidung;
	}
}
