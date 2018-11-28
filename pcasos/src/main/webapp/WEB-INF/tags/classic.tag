<%@ tag description="Overall Page Template" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>CarpetaTIv_3</title>
		<spring:url value="/resources" var="css"/>
		<link rel="stylesheet" href="${css}/css/bootstrap.min.css">
		<link rel="stylesheet" href="${css}/css/solid.css">
		<link rel="stylesheet" href="${css}/css/fontawesome.css">
		<script src="${css}/js/jquery-3.3.1.min.js"></script>
		<script src="${css}/js/popper.min.js"></script>
		<script src="${css}/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$('[data-toggle="tooltip"]').tooltip()
			})
		</script>
	</head>
	<body>
		<div class="container-fluid">
			<jsp:include page="/WEB-INF/tags/header.jsp" />
		</div>
	
		<div id="body" class="container-fluid">
			<jsp:doBody></jsp:doBody>
		</div>
	
		<div class="container-fluid bg-dark">
			<jsp:include page="/WEB-INF/tags/footer.jsp" />
		</div>
	</body>
</html>