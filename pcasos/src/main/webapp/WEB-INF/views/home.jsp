<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link href='<spring:url value="/resources/css/style.css"/>'	rel="stylesheet">
<script type="text/javascript" src='<spring:url value="/resources/js/app.js"/>'></script>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	
	
<h1 id="title" class="color1">Spring MVC</h1>
<button onclick="changeColor()">Change</button>
	
</body>
</html>
