<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<div class="row">
		<div class="col-md-8 offset-md-2">
			<h1 class="my-5"><i class="fas fa-camera"></i>갤러리</h1>
			
				<div class="text-right">
					<a href="create"><i class="fas fa-plus"></i>추가</a>
					
					/ 전체 : ${pagination.total }명
				</div>
				
				<br><br>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>타이틀</th>
							<th>소유자</th>
							<th>이미지#</th>
							<th>등록일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${list}" varStatus="status">
							<fmt:formatDate var="regDate" value="${item.regDate}" 
											pattern="yyyy-MM-dd"/>
							<tr>
								<td>${item.galleryId }</td>
								<td>
									<a href="view/${item.galleryId }?page=${pagination.page }">
										<c:if test="${not empty item.list[0] }">
											<img alt="" src="thumb/${item.list[0].imageId}" width="30">
										</c:if>
										${item.title }</a>
									<c:if test="${today==regDate }">
										<span class="badge badge-pill badge-danger">
										<i class="fas fa-tag"></i>New</span>
									</c:if>
								</td>
								<td>${item.owner }</td>
								<td>
									<%-- ${item.list[0].imageId}/ --%>
									${item.list.size() }
								</td>
								<td>${regDate }</td>
								<td>${item.readCnt }</td>
							</tr>
						</c:forEach>
				</table>
				
				<jsp:include page="/WEB-INF/views/common/pagination.jsp"/>
				
			</div>
		</div>
