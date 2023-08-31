<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DONATION</h1>
	<p>ID: ${donation.id}</p>
	<p>Title Donation: ${donation.title}</p>
	<p>Img Banner: ${donation.urlImgBanner}</p>
	<p>Create Date: ${donation.createDate}</p>
	<p>Start Date: ${donation.startDate}</p>
	<p>End Date: ${donation.endDate}</p>
	<p>Total Money: ${donation.totalMoney}</p>
	<hr>
	<h1>DONATION - DETAIL</h1>
	<p>ID: ${donation.donationDetail.id}</p>
	<p>Title: ${donation.donationDetail.title}</p>
	<p>Contents: ${donation.donationDetail.contents}</p>
	<hr>
	<h1>LINK DONATE</h1>
	<a href="${pageContext.request.contextPath}/user/donate">Click Me to Donate</a>
	<hr>
	<h1>GO HOME</h1>
	<a href="${pageContext.request.contextPath}/trang-chu/">Go Home</a>
</body>
</html>