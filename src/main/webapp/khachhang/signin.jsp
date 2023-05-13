<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>

<%String url_local = request.getScheme()+"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>
<!-- Custom styles for this template -->
<link rel="stylesheet" href="<%=url_local%>/css/style.css">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.form-signin {
	max-width: 500px;
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}


</style>

<title>Đăng nhập</title>
</head>
<body class="text-center">
	<main class="form-signin w-100 m-auto">
		<form action="<%=url_local %>/khach-hang" method="post">
		<input type="hidden" name="hanhDong" value="dang-nhap" />
			<img class="mb-4" src="<%=url_local%>/img/logo.png" alt="" width="72" height="57">
			<h1 class="h3 mb-3 fw-normal">ĐĂNG NHẬP</h1>
			<%
			String baoLoi = request.getAttribute("baoLoi") + "";
			if (baoLoi.equals("null"))
				baoLoi = "";
			%>
			<div class="mb-3 sao"><%=baoLoi%></div>
			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="tenDangnhap"
					name="tenDangnhap" placeholder="Tên đăng nhập"> <label
					for="tenDangnhap" name="tenDangnhap">Tên đăng nhập</label>
			</div>
			<div class="form-floating mb-3">
				<input type="password" class="form-control" id="matkhau"
					name="matkhau" placeholder="Mật khẩu"> <label for="matkhau"
					name="matkhau">Mật khẩu</label>
			</div>

			<div class="checkbox mb-3">
				<label class=""> <input type="checkbox" class="remember-me"
					value="remember-me"> Remember me
				</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Đăng
				nhập</button>
			<div class="mt-3 ">
				<a href="<%=url_local %>/khachhang/register.jsp">Đăng ký tài khoản</a>
			</div>
			<p class="mt-5 mb-3 text-muted">&copy; 2020–2024</p>

		</form>
	</main>
</body>
</html>