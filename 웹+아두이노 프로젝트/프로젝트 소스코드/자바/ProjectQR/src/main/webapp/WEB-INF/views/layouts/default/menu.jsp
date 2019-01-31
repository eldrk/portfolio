<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Navbar -->
<nav
	class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar">

	<!-- Brand -->
	<strong> <a class="navbar-brand" href="${context}/">Pote Roja </a></strong>

	<!-- Collapse -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<!-- Links -->
	<div class="collapse navbar-collapse" id="navbarSupportedContent">

		<!-- Left -->
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="${context}/">Home <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${context}/payment/pay">기부하기</a></li>
		</ul>

		<!-- Right -->
		<ul class="navbar-nav nav-flex-icons">
			<li class="nav-item"><a
				href="https://www.facebook.com/ChristmasKettle" class="nav-link">
					<i class="fab fa-facebook-f"></i>
			</a></li>
			<li class="nav-item"><a
				href="http://www.jasunnambi.or.kr/main/main.php" class="nav-link">
					<i class="fab fa-chrome"></i>
			</a></li>
		</ul>
	</div>
</nav>
<!-- Navbar -->