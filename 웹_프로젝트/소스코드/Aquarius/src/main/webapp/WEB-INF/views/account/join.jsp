<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
	$("#id-check").click(function(){
		var userId=$('#userId').val();
		// 브라우저에서 실행하므로 루트를 신경써야함
		if(!userId){
			return alert('사용자 ID를 입력하세요');
		}
		
		var url = '${context}/account/idcheck';
		var params={
			userId : userId
		};
		
		$.get(url,params,function(data){
			if(data=="ok"){	//아이디가 중복 아님
				$('.check-result').text('사용 가능한 ID 입니다.')
								.removeClass('error')
								.addClass('text-success');
				$('[type=submit]').prop('disabled',false);
			}else{	// 아이디가 중복
				$('.check-result').text('이미 사용중인 ID 입니다.')
								  .addClass('error');
				$('[type=submit]').prop('disabled',true);
			}
		});
	});
	
	$('#userId').keyup(function(){
		$('.check-result').text('ID 중복검사를 하세요.')
						  .removeClass('error');
		$('[type=submit]').prop('disabled',true);
	});
	
	$('form').submit(function(e){
		e.preventDefault();
		
		//	비밀번호 확인.
		var password=$('[name=password]').val();
		var password2=$('[name=password2]').val();
		if(password!=password2){
			alert('비밀번호가 일치하지 않습니다.');
			$('[name=password]').focus();
			return;
		}
		this.submit();
		
	});
	
});
</script>

<div class="row">
	<div class="col-md-6 offset-md-3">
		<h1 class="my-5">회원가입</h1>
		<form:form commandName="member" enctype="multipart/form-data">
			<div class="md-form">
				<label for="userId">사용자 ID</label>
				<form:input path="userId" class="form-control"/>
				<form:errors path="userId" element="div" cssClass="error"/>
			</div>
			
			<p>
				<button type="button" id="id-check">ID 중복 검사</button>
				<span class="check-result">ID중복검사를 하세요.</span>
			</p>
			
			<div class="md-form">
				<label for="password">비밀번호</label>
				<form:password path="password" class="form-control"/>
				<form:errors path="password" element="div" cssClass="error"/>
			</div>
			
			<div class="md-form">
				<label for="password">비밀번호 확인</label>
				<input type="password" id="password2" name="password2"/>
			</div>
			
			<div class="md-form">
				<label for="name">이름</label>
				<form:input path="name" class="form-control"/>
				<form:errors path="name" element="div" cssClass="error"/>
			</div>
			
			<div class="mb-3">
				<label for="avata">아바타 이미지</label>
				<input type="file" name="avata"/>
			</div>
			
			<div class="md-form">
				<label for="phoneNumber">전화번호</label>
				<form:input path="phoneNumber" class="form-control validate"/>
				<form:errors path="phoneNumber" element="div" cssClass="error"/>
			</div>
			<div class="md-form">
				<label for="nickName">닉네임</label>
				<form:input path="nickName" class="form-control validate"/>
			</div>
			<div class="md-form">
				<label for="email">e-mail</label>
				<form:input path="email" class="form-control validate"/>
				<form:errors path="email" element="div" cssClass="error"/>
			</div>
			<div class="md-form">
				<label for="address">주소</label>
				<form:input path="address" class="form-control validate"/>
				<form:errors path="address" element="div" cssClass="error"/>
			</div>
			<button class="btn btn-outline-success waves-effect btn-block my-4" type="submit">회원가입</button>
		</form:form>
	</div>
</div>