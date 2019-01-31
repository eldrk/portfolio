<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath }"
	scope="request" />
<!--Navbar-->
<nav class="navbar navbar-expand-lg navbar-dark light-green darken-4">
	<!-- Navbar brand -->
	<a class="navbar-brand" href="#">Navbar</a>
	<!-- Collapse button -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#basicExampleNav" aria-controls="basicExampleNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!-- Collapsible content -->
	<div class="collapse navbar-collapse" id="basicExampleNav">
		<ul class="navbar-nav mr-auto">

			<li class="nav-item active"><a class="nav-link"
				href="${context}/">Home <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${context}/board/list">게시판</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${context}/gallery/list">갤러리</a></li>

			<!-- Dropdown 
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdownMenuLink"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
						<div class="dropdown-menu dropdown-primary"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a> <a
								class="dropdown-item" href="#"> Something else here</a>
						</div></li> -->

			<c:if test="${USER.userLevel == 'ADMIN' }">
				<li class="nav-item"><a class="nav-link"
					href="${context }/admin/member/list"> 회원관리</a></li>
			</c:if>
		</ul>

		<ul class="navbar-nav">
			<!-- 로그인 사용자 -->
			<c:if test="${not empty USER }">
				<li class="nav-item"><a class="nav-link"
					href="${context}/member/view"> <img
						src="${context}/member/avata/${USER.userId}"
						class="rounded-circle avata-sm"> ${USER.userId}
				</a></li>
				<li class="nav-item "><a class="nav-link"
					href="${context }/account/logout"> <i
						class="fas fa-sign-out-alt"></i>로그아웃
				</a></li>
			</c:if>

			<c:if test="${empty USER }">
				<li class="nav-item "><a class="nav-link"
					href="${context }/account/login"> <i class="fas fa-sign-in-alt"></i>로그인
				</a></li>
				<li class="nav-item "><a class="nav-link"
					href="${context }/account/join"> <i class="fas fa-user-plus"></i>회원가입
				</a></li>
			</c:if>
		</ul>
	</div>
	<!-- Collapsible content -->
</nav>
