<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ attribute name="item" required="true" type="String" %>
<%@ attribute name="title" required="true" type="String" %>

<div class="row">
	<div class="col-md-2">${title}</div>
	<div class="col-md-10">${item}</div>
</div>