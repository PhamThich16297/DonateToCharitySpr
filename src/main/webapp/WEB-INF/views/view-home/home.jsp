<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page import="com.thichpham.dtc.sercurity.SecurityUtil"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">

<link rel="stylesheet" href='<c:url value="/css/style-home.css"/>' />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>



<title>Trang Chủ</title>
</head>
<body>
	<!-- header  -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark p-0 fixed-top">
		<div class="container ps-0">
			<a class="navbar-brand me-auto" href="#"> <img
				src='<c:url value="/image/logo.png"/>'></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarHome"
				aria-controls="navbarHome" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarHome">
				<form class="d-flex w-50 mx-auto">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Tìm kiếm..."
							aria-label="Recipient's username"
							aria-describedby="button-addon2">
						<button class="btn btn-primary" type="button" id="button-addon2">
							<i class="bi bi-search"></i>
						</button>
					</div>
				</form>

				<!-- Login - signup -->
				<c:if test="${pageContext.request.userPrincipal.name == null}">
					<ul class="navbar-nav m-2 me-5">
						<li class="nav-item mx-auto"><a class="nav-link me-lg-3"
							href="${pageContext.request.contextPath}/trang-chu/dang-ky">
								Đăng Ký </a></li>
						<li class="nav-item mx-auto"><a class="nav-link"
							href="${pageContext.request.contextPath}/dang-nhap">
								Đăng Nhập </a></li>
					</ul>
				</c:if>

				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<div class="d-flex ms-auto">
						<p class="m-auto" style="color: white;">
							<%=SecurityUtil.getPrincipal().getFullName()%>
						</p>
						<ul class="navbar-nav m-auto mb-lg-0">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-bs-toggle="dropdown" aria-expanded="false">
									<i class="bi bi-person-fill"></i>
							</a>
								<ul class="dropdown-menu dropdown-menu-end"
									aria-labelledby="navbarDropdown">
									<security:authorize access="hasRole('ADMIN')">
									<li><a class="dropdown-item"
										href="${pageContext.request.contextPath}/admin/admin-home"> Quản Lí
									</a></li>
									</security:authorize>

									<li><a class="dropdown-item" href="#">Xem thông tin</a></li>
									<li><a class="dropdown-item" href="#">Thay đổi MK</a></li>
									<li>
										<hr class="dropdown-divider">
									</li>
									<li><form:form
											action="${pageContext.request.contextPath}/logout"
											method="POST">
											<input class="dropdown-item" type="submit" value="Đăng Xuất" />
										</form:form></li>
								</ul></li>
						</ul>
					</div>
				</c:if>
			</div>
		</div>
	</nav>
	<!-- End header -->

	<!-- slideshow - Banner -->
	<div id="demo" class="carousel slide" data-bs-ride="carousel">
		<!-- Indicators/dots -->
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#demo" data-bs-slide-to="0"
				class="active"></button>
			<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
			<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
		</div>

		<!-- The slideshow/carousel -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src='<c:url value="/image/bannertrangchu.png"/>' alt=""
					class="d-block" style="width: 100%; margin-top: 60px;">
			</div>
			<div class="carousel-item">
				<img src='<c:url value="/image/banner2.png"/>' alt=""
					class="d-block" style="width: 100%; margin-top: 60px;">
			</div>
			<div class="carousel-item">
				<img src='<c:url value="/image/banner3.png"/>' alt=""
					class="d-block" style="width: 100%; margin-top: 60px;">
			</div>
		</div>

		<!-- Left and right controls/icons -->
		<button class="carousel-control-prev" type="button"
			data-bs-target="#demo" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#demo" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>
	</div>

	<!-- End slideshow - Banner -->
	
	<!-- Body -->
	<div class="body-home">
		<div class="container">
			<div class="body-home-title">
				<h1>SỰ KIỆN</h1>
			</div>
			<div class="row">
				<c:forEach items="${listDonations}" var="d">
					<div class="col-lg-4 col-md-6 col-sm-12 mb-3">
						<div class="body-home-content">
							<img src="${d.urlImgBanner}" alt="test">
							<div class="body-home-content-col">
								<a href="${pageContext.request.contextPath}/trang-chu/donation-detail?id=${d.id}">${d.title}</a>
								<div class="row px-2">
									<div class="col-2 p-0 my-auto">
										<img
											style="border: 1px solid black; width: 50px; height: 50px"
											src="${d.org.organizationDetail.urlImgLogo }" alt="">
									</div>
									<div class="col-7 my-auto">
										<p class="mb-0" style="font-size: 15px;">${d.org.name}</p>
									</div>
									<div class="col-3 p-0 my-auto">

										<%-- <c:if test="${dqg.tgConLai <= 0}" var="tg">
											<p class="mb-0 time p-1" style="color: red">Đã Kết Thúc</p>
										</c:if>
										<c:if test="${!tg}">
											<p class="mb-0 time p-1">Còn ${dqg.tgConLai} ngày</p>
										</c:if> --%>

									</div>
								</div>
								<%-- <c:set var="tiendaQG" value="${dqg.tienDaQuyenGop}" /> --%>
								<%-- <fmt:formatNumber var="VNDdaQG" type="number"
									value="${tiendaQG}" /> --%>

								<c:set var="tien" value="${d.totalMoney}" />
								<fmt:formatNumber var="VND" type="number" value="${tien}" />
								<p class="my-2 ">Tiến Trình: 0 / ${VND} VNĐ</p>
								<div class="row">
									<div class="col-6">
										<p class="mb-0" style="text-align: center; font-size: 14px;">Lượt
											Quyên Góp</p>
										<%-- <p style="text-align: center; font-weight: bold;">${dqg.luotQuyenGop }</p> --%>
									</div>
									<div class="col-6 my-auto">
										<a href="ChiTietDotQuyenGop?madot=${dqg.maDot}"
											class="mb-0 p-2 quyengop">Quyên Góp</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- End Body -->
	
	<!-- Footer -->
	<h1>FOOTER</h1>
	<a href="${pageContext.request.contextPath}/trang-chu/test-view-admin">Test View Admin</a>
	<!-- End Footer -->

</body>
</html>