<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/7787f437d3.js"
	crossorigin="anonymous"></script>
<title>Bookstore</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="UTF-8">
<title>Home</title>
<style>
img {
    max-width: 100%;
    height: auto;
}
</style>
</head>
<body>
<%String url_local = request.getScheme()+"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>
	<!--header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- slieshow-->
	<div id="carouselExampleCaptions" class="carousel slide">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="./img/banner.jpg" class="d-block w-100" alt="...">
				<div class="carousel-caption d-none d-md-block">
					<h5>First slide label</h5>
					<p>Some representative placeholder content for the first slide.</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="./img/table.png" class="d-block w-100" alt="img">
				<div class="carousel-caption d-none d-md-block">
					<h5>Second slide label</h5>
					<p>Some representative placeholder content for the second
						slide.</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="" class="d-block w-100" alt="img">
				<div class="carousel-caption d-none d-md-block">
					<h5>Third slide label</h5>
					<p>Some representative placeholder content for the third slide.</p>
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	<!-- body-->
	<div class="container mt-3">
		<div class="row">
			<div class="col-sm "><img alt="" src="<%=url_local%>/img/arrival_1.jpg"></div>
			<div class="col-sm"><img alt="" src="<%=url_local%>/img/arrival_2.jpg"></div>
			<div class="col-sm"><img alt="" src="<%=url_local%>/img/arrival_3.jpg"></div>
			<div class="col-sm"><img alt="" src="<%=url_local%>/img/arrival_4.jpg"></div>
		</div>
	</div>
	<div class="container mt-3">
		<div class="row">
			<div class="col-sm "><img alt="" src="<%=url_local%>/img/arrival_5.jpg"></div>
			<div class="col-sm"><img alt="" src="<%=url_local%>/img/arrival_6.jpg"></div>
			<div class="col-sm"><img alt="" src="<%=url_local%>/img/arrival_7.jpg"></div>
			<div class="col-sm"><img alt="" src="<%=url_local%>/img/arrival_9.jpg"></div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>