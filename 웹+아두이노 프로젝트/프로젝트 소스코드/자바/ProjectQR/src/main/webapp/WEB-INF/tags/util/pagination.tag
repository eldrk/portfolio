<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<ul class="pagination pagination-circle pg-blue justify-content-center">
	<c:if test="${pagination.currentBlock>1}">
		<li class="page-item"><a class="page-link" href="?page=1"> <i
				class="fas fa-angle-left"></i> 처음
		</a></li>
		<li class="page-item"><a class="page-link"
			href="?page=${pagination.prevBlockPage}">◀</a></li>
	</c:if>

	<c:forEach var="cnt" begin="${pagination.startPage}"
		end="${pagination.endPage}">
		<li class="page-item <c:if test="${pagination.page==cnt}">active</c:if>"><a
			class="page-link" href="?page=${cnt}">${cnt}</a></li>
	</c:forEach>

	<c:if test="${pagination.currentBlock < pagination.totalBlock}">
		<li class="page-item"><a class="page-link"
			href="?page=${pagination.nextBlockPage}">▶</a></li>
		<li class="page-item"><a class="page-link"
			href="?page=${pagination.totalPage}">마지막</a></li>
	</c:if>
</ul>
<%@ tag language="java" pageEncoding="UTF-8"%>
