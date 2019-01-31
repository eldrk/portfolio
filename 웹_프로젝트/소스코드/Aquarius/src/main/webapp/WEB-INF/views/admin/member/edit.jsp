<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  

<script>
	
</script>

<div class="row">
	<div class="col-md-6 offset-md-3">
	<h1 class="my-5">회원 정보 수정</h1>
	<br>
	<br>
	<form:form commandName="member">
		<form:hidden path="userId" />
		<form:hidden path="name" />

			<div class="row">
				<div class="col-md-2">사용자 ID: </div>
				<div class="col-md-10">${member.userId}</div>
			</div>
		
			<div class="row">
				<div class="col-md-2">이름 : </div>
				<div class="col-md-10">${member.name}</div>
			</div>
	
		<label for="userLevel">권한</label>
		<form:select path="userLevel" items="${userLevels}" />


		<div class="md-form">
			<label for="phoneNumber">전화번호</label>
			<form:input path="phoneNumber" class="form-control" />
			<form:errors path="phoneNumber" cssClass="error" />
		</div>

		<div class="md-form">
			<label for="nickName">닉네임</label>
			<form:input path="nickName" class="form-control" />
		</div>

		<div class="md-form">
			<label for="email">e-mail</label>
			<form:input path="email" class="form-control" />
			<form:errors path="email" cssClass="error" />
		</div>

		<div class="md-form">
			<label for="address">주소</label>
			<form:input path="address" class="form-control" />
		</div>
		
		<div class="md-form">
			<label for="password">관리자 비밀번호</label>
			<form:password path="password" class="form-control" />
			<form:errors cssClass="error" />

		</div>

		<div class="row">
			<div class="col-md-2">등록일 :</div>
			<div class="col-md-10">
				<fmt:formatDate value="${member.regDate }" />
			</div>
		</div>

		<div class="row">
			<div class="col-md-2">수정일 :</div>
			<div class="col-md-10">
				<fmt:formatDate value="${member.updateDate }" />
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-2"></div>
			<div class="col-md-10">
				<button class="btn btn-outline-success waves-effect my-4"
					type="submit">확인</button>
				<a href="view"
					class="btn btn-outline-success waves-effect my-4">돌아가기</a>
			</div>
		</div>
	
	</form:form>
	</div>
</div>