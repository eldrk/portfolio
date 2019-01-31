<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<div class="container">
	<div class="row my-4">
		<div class="col md-4">
			<h1><i class="fas fa-user-friends"></i>회원검색</h1>
			
				<div class="text-right">전체 : ${list.size()}명</div>
				
				<br><br>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>ID</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>email</th>
							<th>등록일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${list}" varStatus="status">
							<fmt:formatDate var="regDate" value="${item.regDate}" 
											pattern="yyyy-MM-dd"/>
							<tr>
								<td>${status.index+1 }</td>
								<td>
									<a href="view/${item.userId }?page=${pagination.page}">${item.userId}</a>
									<c:if test="${today == regDate }">
										<span class="badge badge-pill badge-danger">
										<i class="fas fa-tag"></i>New</span>
									</c:if>
								</td>
								<td>${item.name }</td>
								<td>${item.phoneNumber}</td>
								<td>${item.email }</td>
								<td>${regDate }</td>
							</tr>
						</c:forEach>
				</table>
				
				
				<div class="text-center">
					<form action="search">
						검색 : 
						<select name="category">
							<option value = "user_id">사용자 ID</option>
							<option value = "name">이름</option>
							<option value = "email">email</option>
						</select>
						
						<input type="text" name="keyword" required>
						<button type="submit"><i class="fas fa-search"></i></button>
					</form>
				</div>
			</div>
		</div>
	</div>