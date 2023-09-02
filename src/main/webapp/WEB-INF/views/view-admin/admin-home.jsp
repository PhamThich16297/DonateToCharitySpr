<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.thichpham.dtc.sercurity.SecurityUtil" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">

<link rel="stylesheet" href='<c:url value="/css/style-admin.css"/>'>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<title>HOME - ADMIN</title>
</head>
<body>
	<!-- start - navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container-fluid">
			<button class="navbar-toggler me-3" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample"
				aria-controls="offcanvasExample">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand me-auto" href="#"> <img
				src='<c:url value="/image/img-admin.png"/>' />
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarAdmin"
				aria-controls="navbarAdmin" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarAdmin">
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
								<li><a class="dropdown-item" href="#"> Xem thông tin </a></li>
								<li><a class="dropdown-item" href="#"> Thay đổi MK </a></li>
								<li><hr class="dropdown-divider"></li>
								<li><form:form
										action="${pageContext.request.contextPath}/logout"
										method="POST">
										<input class="dropdown-item" type="submit" value="Đăng Xuất" />
									</form:form></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<!-- end - navbar -->

	<!-- start - offcanvas -->
	<div class="offcanvas offcanvas-start sidebar-nav bg-dark"
		tabindex="-1" id="offcanvasExample">
		<div class="container mt-3">
			<div class="dashboard">
				<a href="#"> <i class="bi bi-speedometer2"></i> <span>Quản
						Lý</span>
				</a>
			</div>

			<hr class="bg-light" />

			<div id="accordion">
				<ul class="dashboard-menu">
					<li><a href="QuanTri.jsp">Giao Diện Người Dùng</a></li>
					<li><a class="d-flex" data-bs-toggle="collapse"
						href="#dotquyengop"> Đợt Quyên Góp <span
							class="ms-auto right-icon"> <i class="bi bi-chevron-down"></i>
						</span>
					</a>
						<div id="dotquyengop" class="collapse" data-bs-parent="#accordion">
							<ul>
								<li><a href="#">Thêm</a></li>
								<li><a
									href="${pageContext.request.contextPath}/admin/ds-dot-quyen-gop">Xem
										Tất Cả</a></li>
							</ul>
						</div></li>
					<li><a class="d-flex" data-bs-toggle="collapse" href="#dvtn">
							Đơn Vị Tiếp Nhận <span class="ms-auto right-icon"> <i
								class="bi bi-chevron-down"></i>
						</span>
					</a>
						<div id="dvtn" class="collapse" data-bs-parent="#accordion">
							<ul>
								<li><a href="Them_DVTN">Thêm</a></li>
								<li><a href="XemDS_DVTN">Xem All</a></li>
							</ul>
						</div></li>
					<li><a class="d-flex" data-bs-toggle="collapse"
						href="#nguoidung"> Người Dùng <span class="ms-auto right-icon">
								<i class="bi bi-chevron-down"></i>
						</span>
					</a>
						<div id="nguoidung" class="collapse" data-bs-parent="#accordion">
							<ul>
								<li><a href="#">Thêm</a></li>
								<li><a
									href="${pageContext.request.contextPath}/admin/danh-sach-nguoi-dung">Xem
										Tất Cả</a></li>
							</ul>
						</div></li>
					<li><a class="d-flex" data-bs-toggle="collapse"
						href="#thongke"> Thống Kê <span class="ms-auto right-icon">
								<i class="bi bi-chevron-down"></i>
						</span>
					</a>
						<div id="thongke" class="collapse" data-bs-parent="#accordion">
							<ul class="sub-menu">
								<li><a href="ThongKe_DQG">Đợt Quyên Góp</a></li>
								<li><a href="ThongKe_TK">Người Dùng</a></li>
							</ul>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- end - offcanvas -->
</body>
</html>