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
		#container{
			max-width: 800px;
		}
	</style>
<title>Đăng Ký</title>
</head>
<body>
	<%String url_local = request.getScheme()+"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>

	<%@include file ="../header.jsp" %>
<%
	String baoLoi = request.getAttribute("baoLoi")+"";
	baoLoi = (baoLoi.equals("null"))?"":baoLoi;
	
	String tenDangnhap = request.getAttribute("tenDangnhap")+"";
	tenDangnhap = (tenDangnhap.equals("null"))?"":tenDangnhap;
	
	String hoten = request.getAttribute("hoten")+"";
	hoten = (hoten.equals("null"))?"":hoten;
	
	String gioitinh = request.getAttribute("gioitinh")+"";
	gioitinh = (gioitinh.equals("null"))?"":gioitinh;
	
	String ngaysinh = request.getAttribute("ngaysinh")+"";
	ngaysinh = (ngaysinh.equals("null"))?"":ngaysinh;
	
	String diachikhachhang = request.getAttribute("diachikhachhang")+"";
	diachikhachhang = (diachikhachhang.equals("null"))?"":diachikhachhang;
	
	String diachimuahang = request.getAttribute("diachimuahang")+"";
	diachimuahang = (diachimuahang.equals("null"))?"":diachimuahang;
	
	String diachinhanhang = request.getAttribute("diachinhanhang")+"";
	diachinhanhang = (diachinhanhang.equals("null"))?"":diachinhanhang;
	
	String dienthoai = request.getAttribute("dienthoai")+"";
	dienthoai = (dienthoai.equals("null"))?"":dienthoai;
	
	String email = request.getAttribute("email")+"";
	email = (email.equals("null"))?"":email;
	
	String nhanGmail = request.getAttribute("nhanGmail")+"";
	nhanGmail = (nhanGmail.equals("null"))?"":nhanGmail;
	

%>
	<div class=container id=container>
		<h1 class="text-center mt-5">ĐĂNG KÝ TÀI KHOẢN</h1>
		<div class = "baoLoi" id= "baoLoi"> <%=baoLoi %>   </div>
		<form action ="<%=url_local %>/khach-hang" method ="post">
			<input type="hidden" name="hanhDong" value="dang-ky"/>
			<div class="mt-4 row ">
				<div class="col-sm-6">
					<h3>Tài khoản</h3>
					<div class="mb-3">
						<label for="tenDangnhap" class="form-label">Tên đăng nhập
							<span class="sao">*</span>
						</label> <input type="text" class="form-control" id="tenDangnhap"
							name="tenDangnhap" required="required" value="<%=tenDangnhap%>">
					</div>
					<div class="mb-3">
						<label for="matkhau" class="form-label">Mật khẩu <span
							class="sao">*</span></label> <input type="password" class="form-control"
							id="matkhau" name="matkhau" required="required" onkeyup="checkMatkhauhai()" >
					</div>
					<div class="mb-3">
						<label for="matkhauhai" class="form-label">Nhập lại mật
							khẩu <span class="sao">* <span id="error"></span></span>
						</label> <input type="password" class="form-control" id="matkhauhai"
							name="matkhauhai" required="required" onkeyup="checkMatkhauhai()" >
					</div>
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
						<label for="dienthoai" class="form-label">Địện thoại </label> <input
							type="text" class="form-control" id="dienthoai" name="dienthoai" value="<%=dienthoai%>">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email </label> <input
							type="email" class="form-control" id="email" name="email" value="<%=email%>">
					</div>
					<div class="mb-3">
						<label for="dongY" class="form-label ">Bạn chấp nhận điều
							khoản </label> <input type="checkbox" class="form-check-input ml-2"
							id="dongY" name="dongY" onchange="chonDongY()">
					</div>
					<div class="mb-3">
						<label for="nhanGmail" class="form-label ">Đồng ý nhận
							Email </label> <input type="checkbox" class="form-check-input ml-2"
							id="nhanGmail" name="nhanGmail" value="1"<%= (nhanGmail.equals("1"))?"selected='selected'":"" %>>
					</div>
				</div>
			</div>
			<div>
				<button type="submit" class="btn btn-primary form-control"
					name="submit" id="submit" style="visibility: hidden;">Đăng
					ký</button>
			</div>
		</form>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
<script >
	function  checkMatkhauhai() {
		matkhau = document.getElementById("matkhau").value;
		matkhauhai = document.getElementById("matkhauhai").value;
		if (matkhau != matkhauhai) {
			document.getElementById("error").innerHTML = "Mật khẩu chưa khớp";
			return false;
		}else {
			document.getElementById("error").innerHTML = "";
			return true;
		}
	}
	function  chonDongY() {
		dongY = document.getElementById("dongY");
		if (dongY.checked == true) {
			document.getElementById("submit").style.visibility = "visible";
		}else {
			document.getElementById("submit").style.visibility="hidden";
		}
	}
</script>
</html>