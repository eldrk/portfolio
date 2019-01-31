<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
/* 	$(function() {
		$('#start').click(function() {
			alert("클릭했습니다.");
			var method = "post";
			
			var form = document.createElement("form");
			form.setAttribute("method",method);
			form.setAttribute("action", "http://70.12.242.45:8080");
			
			document.body.appendChild(form);
			form.submit();
			alert("서브밋 종료");
			location.href("${context}/");
		});
	}); */
</script>
<body>
	<img src="../resources/bgPay.png" id="bg" alt="">
	<div class="container">
		<div class="row my-5">
			<div class="col-md-7 offset-md-2">
				<div class="my-5">
					<h1>${SUM}원
						기부 완료 <i class="fas fa-hand-holding-usd"></i>
					</h1>
				</div>
				<div class="my-3">
					<p>
						<i class="far fa-grin-squint"></i> 참여 해주셔서 감사합니다!!! <i
							class="far fa-grin-squint"></i>
					</p>
				</div>
				<div class="my-3">
					<img src="../resources/ThankYou.gif">
				</div>
				<div class="my-3">
					<p>아트랙티브 아트를 시작하시려면 아래 버튼을 눌러주세요 :</p>
					<a  class="btn" href="http://70.12.242.45:8080" >시작하기 </a>
				</div>
			</div>
		</div>
	</div>
</body>