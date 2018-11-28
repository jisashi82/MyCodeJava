<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<spring:url value="/resources" var="css" />
<link rel="stylesheet" href="${css}/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${css}/css/solid.css"/>
<link rel="stylesheet" href="${css}/css/fontawesome.css"/>
<link rel="stylesheet" href="${css}/css/login.css" />
<script src="${css}/js/jquery-3.3.1.min.js"></script>
<script src="${css}/js/popper.min.js"></script>
<script src="${css}/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="mainWrapper">
		<div class="login-container">
			<div class="login-card">
				<div class="login-form">
					<c:url var="loginUrl" value="/login" />
					<form action="${loginUrl}" method="post" class="form-horizontal">
						<c:if test="${param.error != null}">
							<div class="alert alert-danger">
								<p>Invalid username and password.</p>
							</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert alert-success">
								<p>You have been logged out successfully.</p>
							</div>
						</c:if>
						<div class="input-group mb-2">
							<div class="input-group-prepend">
								<div class="input-group-text"><i class="fa fa-user"></i></div> 
							</div>
							<input type="text" class="form-control"	id="username" name="username" placeholder="Enter Username" required>
						</div>
						<div class="input-group mb-2 input-sm">
							<div class="input-group-prepend">
								<div class="input-group-text"><i class="fa fa-lock"></i></div>
							</div> 
							<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

						<div class="form-actions">
							<input type="submit" class="btn btn-block btn-primary btn-default" value="Log in">
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>