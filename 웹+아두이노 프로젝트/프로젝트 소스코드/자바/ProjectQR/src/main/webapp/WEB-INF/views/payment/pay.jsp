<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot"%>

<script>
	$(function() {
		var sum = 0;
		var tempMoney = 0;
		var sum2 = 0;
		var totalSum = 0;

		var jb = $('input#sum').val();

		$('#money1000').change(function() {
			if ($("#money1000").is(":checked")) {
				sum += 1000;
				totalSum = Number(sum) + Number(sum2);
				$('input#sum').val(totalSum);
			} else {
				sum -= 1000;
				totalSum = Number(sum) + Number(sum2);
				$('input#sum').val(totalSum);
			}
		});

		$('#money5000').change(function() {
			if ($("#money5000").is(":checked")) {
				sum += 5000;
				totalSum = Number(sum) + Number(sum2);
				$('input#sum').val(totalSum);
			} else {
				sum -= 5000;
				totalSum = Number(sum) + Number(sum2);
				$('input#sum').val(totalSum);
			}
		});

		$('#money10000').change(function() {
			if ($("#money10000").is(":checked")) {
				sum += 10000;
				totalSum = Number(sum) + Number(sum2);
				$('input#sum').val(totalSum);
			} else {
				sum -= 10000;
				totalSum = Number(sum) + Number(sum2);
				$('input#sum').val(totalSum);
			}
		});

		$('#money50000').change(function() {
			if ($("#money50000").is(":checked")) {
				sum += 50000;
				totalSum = Number(sum) + Number(sum2);
				$('input#sum').val(totalSum);
			} else {
				sum -= 50000;
				totalSum = Number(sum) + Number(sum2);
				$('input#sum').val(totalSum);
			}
		});

		$('#cash1').blur(function() {
			var value = ($('#cash1').val());
			sum2 = value;
			totalSum = Number(sum) + Number(sum2);
			$('input#sum').val(totalSum);
		});

	});
</script>


<body>
	<img src="../resources/bgPay.png" id="bg" alt="">
	<div class="container">
		<div class="row my-5">
			<div class="col-md-6 offset-md-3">
				<div class="my-5">
					<h1>
						<i class="fas fa-hands-helping"></i> 기부 하기
					</h1>
				</div>
				<form:form commandName="money">
					<div class="my-3">
						<div class="custom-control custom-checkbox custom-control-inline">
							<input type="checkbox" class="custom-control-input" value="1000"
								name="money1000" id="money1000"> <label
								class="custom-control-label" for="money1000">천원</label>
						</div>

						<div class="custom-control custom-checkbox custom-control-inline">
							<input type="checkbox" class="custom-control-input" value="5000"
								name="money5000" id="money5000"> <label
								class="custom-control-label" for="money5000">오천원</label>
						</div>

						<div class="custom-control custom-checkbox custom-control-inline">
							<input type="checkbox" class="custom-control-input" value="10000"
								name="money10000" id="money10000"> <label
								class="custom-control-label" for="money10000">만원</label>
						</div>

						<div class="custom-control custom-checkbox custom-control-inline">
							<input type="checkbox" class="custom-control-input" value="50000"
								name="money50000" id="money50000"> <label
								class="custom-control-label" for="money50000">오만원</label>
						</div>
					</div>

					<!-- Small input -->
					<div class="my-3">
						<input class="form-control" type="text" id="cash1" name="cash1"
							placeholder="직접 입력">
					</div>

					<div class="my-3">
						총 결제 금액 : <input class="form-contol" type="text" id="sum"
							name="sum" value="0">
					</div>

					<button class="btn btn-blue-grey btn-block my-4" type="submit">결제하기</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
