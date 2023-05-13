<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	String url = request.getScheme()+"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
 %>
<nav class="navbar navbar-expand-lg bg-body">
		<div class="container-sm ">
			<a class="navbar-brand ms-4" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar nav ms-auto content-center">
					<li class="nav-item ms-3"><a class="nav-link text-dark"
						href="#">Home</a></li>
					<li class="nav-item ms-3"><a class="nav-link text-dark"
						href="#">About</a></li>
					<li class="nav-item ms-3"><a class="nav-link text-dark"
						href="#">Reviews</a></li>
					<li class="nav-item ms-3"><a class="nav-link text-dark">Blog</a>
					</li>
				</ul>
				<%
				Object obj = session.getAttribute("kh1");
				KhachHang khachHang = null;
				if (obj != null)
					khachHang = (KhachHang) obj;
				if (khachHang == null) {
				%>
				<div class="ms-auto me-3">
					<a href="khachhang/signin.jsp"><i class="w3-xlarge fa-solid fa-user"></i></a>
				</div>
				<%
				} else {
				%>
				<div class="dropdown ms-auto">
					<button class="btn btn-primary dropdown-toggle" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						aria-expanded="false">Tài khoản</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<li><a class="dropdown-item" href="<%=url%>/khachhang/changeInfo.jsp">Info</a></li>
						<li><a class="dropdown-item" href="<%=url%>/khachhang/changepass.jsp">Đổi mật khẩu</a></li>
						<li><a class="dropdown-item" href="<%=url%>/khach-hang?hanhDong=dang-xuat">Đăng xuất</a></li>
					</ul>
				</div>

				<%
				}	
				%>

			</div>
		</div>
	</nav>