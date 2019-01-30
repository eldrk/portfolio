<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PoteRoja.com</title>
<c:set var="context" value="${pageContext.request.contextPath}"
	scope="request" />
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<!-- Bootstrap core CSS -->
<link
	href="${context}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="${context}/resources/bower_components/MDBootstrap/css/mdb.min.css"
	rel="stylesheet">
<!-- Your custom styles (optional) -->
<link href="${context}/resources/css/style.css" rel="stylesheet">
<script type="text/javascript"
	src="${context}/resources/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript"
	src="${context}/resources/bower_components/popper.js/dist/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript"
	src="${context}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${context}/resources/bower_components/tinymce/tinymce.min.js"></script>
<link rel="stylesheet" href="${context}/resources/css/main.css" />
</head>
<body>

	<!--Main Navigation-->
	<header>
		<tiles:insertAttribute name = "menu"/>
	</header>
	<!--Main Navigation-->
	
	<!--Main layout-->
	<body>
	<!--Main container-->
		<tiles:insertAttribute name = "body"/>
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="js/mdb.min.js"></script>
  <!-- Initializations -->
  <script type="text/javascript">
    // Animations initialization
    new WOW().init();
  </script>
	</body>
	<!--Main layout-->

	<!--Footer-->
	<footer>
		<tiles:insertAttribute name = "footer"/>
	</footer>
	<!--Footer-->

</body>
<script type="text/javascript"
	src="${context}/resources/bower_components/MDBootstrap/js/mdb.min.js"></script>
</html>