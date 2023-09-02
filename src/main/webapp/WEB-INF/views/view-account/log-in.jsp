<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href='<c:url value="/css/style-login.css"/>' />
<title>Đăng Nhập</title>
</head>

<body>
	<div class="login-box">
		<img src='<c:url value="/image/man.png"/>' />
		<form:form
			action="${pageContext.request.contextPath}/authenticateTheUser"
			method="POST">

			<c:if test="${param.error != null}">
				<div class="alert alert-danger col-xs-offset-1 col-xs-10">
					Tài Khoản không đúng !!!
				</div>
			</c:if>

			<div class="user-box">
				<label for="username">Tên Đăng Nhập</label>
				<input type="text" id="username" name="username" value="">
			</div>
			<div class="user-box">
				<label for="password">Mật Khẩu</label>
				<input type="password" id="password" name="password" value="">
			</div>

			<div class="user-checkbox">
				<input type="checkbox" id="remember-me" name="remember-me">
				<label for="remember-me">Nhớ Mật Khẩu</label>
				<br>
			</div>
			<div class="login" style="margin-left: 80px;">
				<button type="submit">
					<span></span> <span></span> <span></span> <span></span> ĐĂNG NHẬP
				</button>
			</div>
		</form:form>

		<div class="footer">
			<a href="${pageContext.request.contextPath}/trang-chu/"><button>Trang Chủ</button></a>
			<div class="right">
				<a href="#">Quên Mật Khẩu?</a>
			</div>

		</div>
	</div>
</body>
</html>