
// 날짜 출력
Date.prototype.formatDate= function() { 
	var year = this.getFullYear(); 
	var month = this.getMonth()+1; 
	var date = this.getDate(); 
	
	month = (month < 10) ? '0' + month : month; 
	date = (date < 10) ? '0' + date : date; 
	return `${year}-${month}-${date}`; 
} 


// 폼 데이터를 JS 객체로 변환
function formToObject(form) { 
	var arr = $(form).serializeArray(); 
	var obj = {} 
	for(entry of arr) { 
		obj[entry.name] = entry.value; 
		} 
	return obj; 

}

// ajax 에러 처리 핸들러
function error(xhr){ 
	alert(`요청 처리 실패(${xhr.status}) : ${xhr.responseText}`); 
}

// ajax 호출 메서드
function replyAjax(obj) {
	$.ajax({ 
		url : obj.url,
		type : obj.type,
		contentType: 'application/json',
		data : obj.data,
		dataType : 'json',
		success : obj.success,
		error : error
	});
}

// 댓글 템플릿 생성 함수
function addReply(reply) { 
	return ` 
		<div class="media my-3" 
			style="margin-left:${50*(reply.level-1)}px" 
			data-reply-id="${reply.replyId}" 
			data-board-id="${reply.boardId}" 
			data-writer="${user}" 
			data-parent="${reply.replyId}" 
			data-level="${reply.level}"> 
			
			<img src="${context}/member/avata/${reply.writer}" 
				class="rounded-circle avata-md">
			<div class="media-body ml-3"> 
				<div class="button-group float-right"> 
				작성일 : 
				<span class="update-date"> 
					${reply.updateDate.formatDate()} 
				</span> 
				<button class="reply-add-show"> 
					<i class="fa fa-reply"></i>
				</button> 
				<button class="reply-edit-show"> 
					<i class="fa fa-edit"></i>
				</button> 
				<button class="reply-delete-show"> 
					<i class="fa fa-trash"></i>
				</button> </div> 
				<h5>${reply.writer}</h5> 
					<div class="reply-content"> 
					${reply.content} </div> 
				<div class="reply-work"></div> 
			</div> 
		</div>`; 
	}

function replyForm(method, content){
	var template = `
		<div class = "card card=body mp-3">`;
	if(method != 'delete'){
		template += `
			<textarea class="reply-edit-content" style="width:100%">${content?content:''}</textarea>`;
	}
	
	template += `
		<div class="text-right mt-2">
			비밀번호:
			<input type="password" name="password">
			<buttton type="button" class="reply-${method}">확인</button>
			<buttton type="button" class="reply-cancel">취소</button>
		</div>
	</div>`;
	return template;
}
function disableButtons(parent){
	parent.find('.button-group button')
		  .prop("disabled",true);
}

function enableButtons(parent){
	parent.find('.button-group button')
		  .prop("disabled",false);
}

//댓글 작업 UI생성 및 화면에 보이기
function setReplyWork(method, content){
	var form = replyForm(method, content);
	var body = $(this).closest('.media-body');
	body.find('.reply-work')
		.append(form);
	disableButtons(body);
	
}

//현재 댓글 내용 얻기 - 댓글 수정시 사용
function getContent(target){
	
	return $(target).closest('.media-body')
					.find('.reply-content')
					.hide()
					.text().trim();
}

//댓글 정보 추출
function getReply(target){
	var media = $(target).closest('.media');
	return {
		replyId : media.data('reply-id'),
		boardId : media.data('board-id'),
		writer  : user,
		parent  : media.data('parent'),
		level   : media.data('level'),
		password: media.find(':password').val(),
		content : media.find('textarea').val()
	}
}

//댓글의 유효성검사
//비밀번호와 내용입력 여부검사
//정상인 경우 reply객체리턴
//아닌경우 undefiend객체리턴
function checkReply(target,contentCheck){
	var reply = getReply(target);
	if(reply.password ==''){
		return alert('비밀번호를 입력하세요');
	}
	if(contentCheck && reply.content ==''){
		return alert('내용을 입력하세요');
	}
	return reply;
}



// 최상위 댓글 달기 jQuery플러그인
$.fn.replyForm = function(listPanel) {
	var self = this; //선택자this
//	console.log(this);
	
	self.submit(function(e) {
		e.preventDefault();
		//console.log(this);
		var reply = formToObject(this);//javascript this
		//console.log(reply);
		
	
		replyAjax({
			url : $(this).attr("action"),
			type: 'post',
			data: JSON.stringify(reply),
			success : function(result){
				//console.log(result);
				//self[0].reset(); // 폼 리셋
				result.updateDate = new Date(result.updateDate);
				result.level = 1;
				listPanel.prepend(addReply(result));//ajax this
				self[0].reset();
			}
		});
	});
	return self;
}
// 댓글 목록 관리 jQuery플러그인
$.fn.replyList = function(boardId) {

	var self = this; //이벤트 핸들러에서 사용할 클로저 변수
	//ajax 처리 기본 url
	var baseurl = context+"/board/reply/" + boardId;
	
	//댓글 추가, 수정, 삭제 버튼 이벤트 핸들러 설정
	
	self.on('click','.reply-add-show',e=>setReplyWork.call(e.target,'post'));//this 지정
	self.on('click','.reply-edit-show',e=>setReplyWork.call(e.target,'put',
													getContent(e.target)));
	self.on('click','.reply-delete-show',e=>setReplyWork.call(e.target,'delete'));
	
	self.on('click','.reply-cancel',function(){
		var body = $(this).closest('.media-body')
		body.find('.reply-work').empty(); //작업영역제거
		body.find('.reply-content').show(); //컨텐츠영역 복원
		enableButtons(body);
	});
	
	self.on('click','.reply-post',function(){
		var reply = checkReply(this,true);
		if(!reply) return;
		
		var media = $(this).closest('.media');
		var body = $(this).closest('.media-body');
		//console.log(reply)
		replyAjax({
			url : baseurl,
			type:'post',
			data:JSON.stringify(reply),
			success:function(result){
				body.find('.reply-work').empty();
				result.updateDate = new Date(result.updateDate);
				result.level= reply.level+1;
				media.after(addReply(result));
				enableButtons(body);
			}
		});
	});
	//댓글 수정
	self.on('click','.reply-put',function(){
		var reply = checkReply(this,true);
		if(!reply) return;
		
		var body = $(this).closest('.media-body');
		replyAjax({
			url : baseurl +  "/" + reply.replyId,
			type:'put',
			data:JSON.stringify(reply),
			success:function(result){
				
				body.find('.reply-work').empty(); //작업영역제거
				result.updateDate = new Date(result.updateDate);
				console.log(result);
				
				body.find('.update-date')         //수정일갱신
				    .text(result.updateDate.formatDate());
		
				body.find('.reply-content').text(result.content); //내용
				body.find('.reply-content').show();
				enableButtons(body);
			}
		})
	});
	self.on('click','.reply-delete',function(){
		var reply = checkReply(this);
		if(!reply) return;
		if(!confirm('해당 댓글을 삭제할까요?')) return;
		
		var body = $(this).closest('.media-body');
		var url = baseurl+"/"+reply.replyId + "?password=" +reply.password;
		replyAjax({
			url : url,
			type:'delete',
			success:function(result){
				body.find('.reply-content').text('삭제된 글입니다.'); //내용
				body.find('.reply-work').empty();
				body.find('.button-group').empty();
				body.find('.reply-content').show();
				enableButtons(body);
				
			}
		})
	});
	
	
	
	
	
	
	
	
}