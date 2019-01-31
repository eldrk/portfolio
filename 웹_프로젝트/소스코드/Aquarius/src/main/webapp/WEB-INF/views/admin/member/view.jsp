<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<script>
$(function(){
	$('.delete-btn').click(function(e){
		e.preventDefault();
		var result=confirm('${member.userId}회원을 정말 삭제할까요?');
		if(result){
			location = $(this).attr('href');
		}
	})
});
</script>

<div class="row my-4">
	<div class="col-md-6 offset-md-3">
	<h1 class="my-5"><i class="fas fa-user-edit"></i>회원 정보 보기</h1>
	
		<div>
			<div class="row">
				<div class="col-md-2">아이디 : </div>
				<div class="col-md-10">${member.userId}</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">이름 : </div>
				<div class="col-md-10">${member.name}</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">권한 : </div>
				<div class="col-md-10">${member.userLevel}</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">전화번호 : </div>
				<div class="col-md-10">${member.phoneNumber}</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">닉네임 : </div>
				<div class="col-md-10">${member.nickName}</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">e-amil : </div>
				<div class="col-md-10">${member.email}</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">주소 : </div>
				<div class="col-md-10">${member.address}</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">등록일 : </div>
				<div class="col-md-10">
					<fmt:formatDate value="${member.regDate }"/>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">수정일 : </div>
				<div class="col-md-10">
					<fmt:formatDate value="${member.updateDate }"/>
				</div>
			</div>
			
			<div class="row mt-3">
				<div class="col-md-2"></div>
				<div class="col-md-10">
					<a href="../edit/${member.userId}?page=${param.page}"
						class="btn btn-dark-green">수정</a>
					<a href="../delete/${member.userId}?page=${param.page}"
						class="delete-btn btn btn-dark-green">삭제</a>
					<a href="../list?page=${param.page}"
						class="btn btn-dark-green">돌아가기</a>
				</div>
			</div>
			
			
		</div>
	
	</div>
</div>
