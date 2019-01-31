<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  

	<h1 class="my-5 text-center"><i class="far fa-images"></i>${gallery.title}</h1>
			
			
			<p class="">${gallery.description}</p>
	
			
			<h4>이미지 파일 목록</h4>
			<ul>
				<c:forEach var="image" items="${gallery.list }">
					<li>
						<img src="../image/${image.imageId}" alt="${image.fileName }"><br>
						${image.title }
						<a href="../download/${image.imageId }">
							<i class="fas fa-download"></i></a>
					</li>
				</c:forEach>
			</ul>

	
