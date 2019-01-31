<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${context}/resources/js/reply.js"></script>

<script>
	var context = '${context}';
	var user = '${USER.userId}';

	$(function() {

		$('#delete-btn').click(function(e) {
			e.preventDefault();
			$('.password-panel').show();
		});

		$('#delete-cancel').click(function() {
			$('#password').val('');
			$('.password-panel').hide();
		})

		$('#delete-confirm').click(function() {

			var password = $('#password').val();
			var boardId = $(this).data('target');
			if (password == '') {
				alert('비밀번호를 입력하세요');
				$('#password').focus();
				return;
			}
			var result = confirm("게시글을 삭제할까요?");
			console.log(password, boardId);
			var url = '../delete';
			var params = {
				boardId : boardId,
				password : password
			};

			$.get(url, params, function(result) {
				//결과 응답데이터는 result로 전달됨

				if (result == 'ok') {
					console.log(result);
					location = '../list';
				} else {
					alert('삭제 실패 : ' + result);
				}
			});
		});

		$('#reply-form').replyForm($('#reply-list'));
		$('#reply-list').replyList('${board.boardId}');

	})
</script>

<div class="container">
	<h2 class="mt-5 mb-4">게시글 보기</h2>

	<div class="row">
		<div class="col-md-2">제목</div>
		<div class="col-md-10">${board.title }</div>
	</div>

	<div class="row">
		<div class="col-md-2">작성자</div>
		<div class="col-md-10">${board.writer }</div>
	</div>

	<div class="row">
		<div class="col-md-2">조회수</div>
		<div class="col-md-10">${board.readCnt }</div>
	</div>

	<div class="row">
		<div class="col-md-2">내용</div>
		<div class="col-md-10">${board.content }</div>
	</div>


	<div class="row">
		<div class="col-md-2">첨부파일</div>
		<div class="col-md-10">
			<c:forEach var="file" items="${board.attachList}">
				<div>
					<a href="../download/${file.attachmentId}"> <i
						class="fa fa-download"></i>${file.fileName}
					</a>
				</div>
			</c:forEach>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2">등록일</div>
		<div class="col-md-10">
			<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" />
		</div>
	</div>

	<div class="row">
		<div class="col-md-2">수정일</div>
		<div class="col-md-10">
			<fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd" />
		</div>
	</div>
	
	<c:if test="${not empty USER }">
		<jsp:include page="reply-form.jsp" />
	</c:if>

	<div id="reply-list" class="mt-5">
		<jsp:include page="reply-list.jsp" />
	</div>

	<div class="text-center">
		<c:if test="${USER.userId == board.writer }">
			<a href="../edit/${board.boardId}?page=${param.page}"
				class="btn btn-dark-green"> <i class="fa fa-edit mr-2"></i>수정
			</a>
			<a href="#" id="delete-btn" class="btn btn-dark-green"> <i
				class="fa fa-trash mr-2"></i>삭제
			</a>
		</c:if>
		<a href="../list?page=${param.page}" class="btn btn-dark-green">돌아가기</a>
	</div>

	<div class="password-panel text-center my-3" style="display: none">
		삭제비밀번호 : <input type="password" id="password">
		<button type="button" id="delete-confirm"
			data-target="${board.boardId }">확인</button>
		<button type="button" id="delete-cancel">취소</button>
	</div>
</div>