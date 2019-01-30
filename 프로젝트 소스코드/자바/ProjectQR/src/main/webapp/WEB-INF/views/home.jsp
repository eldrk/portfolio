<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- data-ride="carousel" -->
<!--Carousel Wrapper-->
<div id="carousel-example-1z" class="carousel slide carousel-fade">

	<!--Indicators-->
	<ol class="carousel-indicators">
		<li data-target="#carousel-example-1z" data-slide-to="0"
			class="active"></li>
	</ol>
	<!--/.Indicators-->
	<div class="carousel-inner" role="listbox">

		<!--First slide-->
		<div class="carousel-item active">
			<!--Slides-->
			<div class="view">
				<!--Video source-->
				<img class="w-100 h-100" src="resources/bgSnoopy.jpg">

				<!-- Mask & flexbox options-->
				<div class="mask d-flex justify-content-center align-items-center">

					<!-- Content -->
					<div class="text-center white-text mx-5 wow fadeIn">
						<h1 class="mb-4">
							<strong>현재 총 기부금</strong>
						</h1>

						<h4>
							${Money} 원
						</h4>

						<a href="${context}/payment/pay"
							class="btn btn-outline-white btn-lg">기부 하러 가기<i class="fas fa-hands-helping"></i>
						</a>

					</div>
					<!-- Content -->
				</div>
				<!-- Mask & flexbox options-->
			</div>
		</div>
	</div>
</div>
<!--/.Carousel Wrapper-->
<!-- SCRIPTS -->
<!-- JQuery -->


