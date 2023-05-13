<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/7787f437d3.js"
	crossorigin="anonymous"></script>
	<style >
		#body {
			max-width: 800px;
		}
		.sao{
			color: red;
		}
	</style>
<title>Thông tin</title>
</head>
<body>
<%String url_local = request.getScheme()+"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>
	
<%
	Object object =session.getAttribute("kh1");
	KhachHang khachHang = null;
	if (object != null)
		khachHang = (KhachHang) object;
		if (khachHang == null){%>
		<h1>Bạn chưa đăng nhập .Vui lòng quay lại trang chủ! </h1>
		<script >
		setTimeout(() => {
			window.location.href = '../khachhang/signin.jsp';
		},1000);</script>
		
	</script>	
		<% }else{ %>
		
		<% String baoLoi = request.getAttribute("baoLoi")+"";
			baoLoi = (baoLoi.equals("null"))?"":baoLoi;
			
			
			String hoten = khachHang.getHoTen();
			
			String gioitinh = khachHang.getGioiTinh();

			String ngaysinh = khachHang.getNgaySinh().toString();
			
			String diachikhachhang = khachHang.getDiaChi();
			
			String diachimuahang = khachHang.getDiaChiMuaHang();
			
			String diachinhanhang = khachHang.getDiaChiNhanHang();
			
			String dienthoai = khachHang.getSDT();
			
			String email = khachHang.getEmail();
	
			boolean nhanGmail = khachHang.isDangkyNhanThongBao();

	
		%>
		<jsp:include page="<%=url_local %>/header.jsp"></jsp:include>
		<div class="container" id ="body">
		<h1 class="text-center mt-3">THAY ĐỔI THÔNG TIN</h1>
		<div class = "baoLoi" id= "baoLoi"> <%=baoLoi %>   </div>
		<form action ="../khach-hang" method ="post">
		<input type="hidden" name="hanhDong" value="doi-thong-tin" />
			<div class="mt-4 row ">
				<div class="col-sm-6">
					
					<h3>Thông tin tài khoản</h3>
					<div class="mb-3">
						<label for="hoten" class="form-label">Họ và tên <span
							class="sao">*</span>
						</label> <input type="text" class="form-control" id="hoten" name="hoten"
							required="required" value="<%=hoten%>">
					</div>
					<div class="mb-3">
						<label for="gioitinh" class="form-label">Giới tính </label> <select
							class="form-control" name="gioitinh" id="gioitinh" >
							<option value="Nam" <%= (gioitinh.equals("Nam "))?"selected='selected'":""%> >Nam</option>
							<option value="Nữ" <%= (gioitinh.equals("Nữ "))?"selected='selected'":"" %>> Nữ</option>
							<option value="Khác" <%= (gioitinh.equals("Khác "))?"selected='selected'":"" %> >Khác</option>
						</select>

					</div>
					<div class="mb-3">
						<label for="ngaysinh" class="form-label">Ngày sinh </label> <input
							type="date" class="form-control" id="ngaysinh" name="ngaysinh"
							required="required" value="<%=ngaysinh%>">
					</div>
					<div class="mb-3">
						<label for="dienthoai" class="form-label">Địện thoại </label> <input
							type="text" class="form-control" id="dienthoai" name="dienthoai" value="<%=dienthoai%>">
					</div>
				</div>

				<div class="col-sm-6">
					<h3>Địa chỉ</h3>
					<div class="mb-3">
						<label for="diachikhachhang" class="form-label">Địa chỉ
							khách hàng </label> <input type="text" class="form-control"
							id="diachikhachhang" name="diachikhachhang" value="<%=diachikhachhang%>">
					</div>
					<div class="mb-3">
						<label for="diachimuahang" class="form-label">Địa chỉ mua
							hàng </label> <input type="text" class="form-control" id="diachimuahang"
							name="diachimuahang" value="<%=diachimuahang%>">
					</div>
					<div class="mb-3">
						<label for="diachinhanhang" class="form-label">Địa chỉ
							nhận hàng </label> <input type="text" class="form-control"
							id="diachinhanhang" name="diachinhanhang" value="<%=diachinhanhang%>">
					</div>	
					<div class="mb-3">
						<label for="email" class="form-label">Email </label> <input
							type="email" class="form-control" id="email" name="email" value="<%=email%>">
					</div>

				</div>
					<div class="mb-3">
						<label for="nhanGmail" class="form-label ">Đồng ý nhận
							Email </label> <input type="checkbox" class="form-check-input ml-2"
							id="nhanGmail" name="nhanGmail" <%= (nhanGmail?"selected":"") %>>
					</div>
			</div>
			<div>
				<button type="submit" class="btn btn-primary form-control"
					name="submit" id="submit" >Lưu thông tin
					</button>
			</div>
		</form>
	</div>	
	<jsp:include page="../footer.jsp" />		
	<%} %>
	
</body>
</html>