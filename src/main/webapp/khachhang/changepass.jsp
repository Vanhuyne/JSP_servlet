<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<title>Đổi mật khẩu</title>
<style>
.container {
	max-width: 700px;
}
.green{
	color: green;
	}
.sao {
	color: red;
}
</style>
</head>
<body >
<%String url_local = request.getScheme()+"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>
<jsp:include page="../header.jsp" />
<div class="container">
	<%
	Object object = session.getAttribute("kh1"); // lay kh1 trong phien lam viec truoc
	KhachHang khachHang = null;
	if (object != null) {
		khachHang = (KhachHang) object;
	}
	if (khachHang == null) {
	%>
	<h2 class="mt-4">Bạn chưa đăng nhập. Hãy quay lại trang chủ!</h2>
	<script>
	setTimeout(() => {
		window.location.href = '../khachhang/signin.jsp';
	},1000);
	</script>
	<%
	} else {
	String loi = request.getAttribute("loi") + "";
	if (loi.equals("null")) {
		loi = "";
	}
	%>
	<h1 class="text-center mt-4">Đổi mật khẩu</h1>
	<form action="<%=url_local %>/khach-hang" method=post>
	<input type="hidden" name="hanhDong" value="doi-mat-khau" />
		<div class="mb-3">
			<label for="matkhau" class="form-label">Mật khẩu hiện tại</label> <input
				type="password" class="form-control" id="matkhau" name="matkhau">
			<div class="mb-3">
				<label for="matkhaumoi" class="form-label">Mật khẩu mới</label> <input
					type="password" class="form-control" id="matkhaumoi"
					name="matkhaumoi">
			</div>
			<div class="mb-3">
				<label for="matkhaumoi2" class="form-label">Nhập lại mật
					khẩu</label> <input type="password" class="form-control" id="matkhaumoi2"
					name="matkhaumoi2">
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Bạn đồng
					ý</label>
			</div>
			<button type="submit" class="btn btn-primary form-control">Đổi
				mật khẩu</button>
	</form>
	<div class="sao mt-3" id="thongbao"><%=loi%></div>
</div>
	<%
	if (loi.equals("Đổi mật khẩu thành công.")) {
	%>
		<script>
		document.getElementById("thongbao").setAttribute("class", "green");
		setTimeout(() => {
			window.location.href = 'khachhang/signin.jsp';
		},1500);
		</script>
	<%
	}
	%>
	<%
	}
	%>
	
	<jsp:include page="../footer.jsp" />
</body>
</html>