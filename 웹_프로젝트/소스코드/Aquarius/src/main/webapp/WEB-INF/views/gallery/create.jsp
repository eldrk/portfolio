<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row">
	<div class="col-md-6 offset-md-3">
		<h1 class="my-5"><i class="fas fa-images"></i>갤러리 추가</h1>
		<form:form commandName="gallery">
			<input type="hidden" name="owner" value="${USER.userId }"/>
			<div class="md-form">
				<label for="title">타이틀</label>
				<form:input path="title" class="form-control"/>
				<form:errors path="title" element="div" cssClass="error"/>
			</div>

			<div class="md-form">
				<label for="description">설명</label>
				<form:textarea path="description" class="form-control" rows="4"/>
			</div>
			
			<button class="btn btn-light-green" type="submit">추가</button>
			<button class="btn btn-light-green" type="reset">취소</button>
		</form:form>
	</div>
</div>