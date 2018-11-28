<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<spring:url value="/" var="url1" />
<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm p-1 mb-3">
	<a class="navbar-brand" href="#">
		<img src='<spring:url value="/resources/images/pepsi.png"/>' width="35" height="45" class="d-inline-block align-top" alt="" />
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"	data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a></li>
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="ndm1" role="button" data-toggle="dropdown"	aria-haspopup="true" aria-expanded="false">Bitacoras </a>
				<div class="dropdown-menu bg-light" aria-labelledby="ndm1">
					<a class="dropdown-item badge badge-light" href="${url1}movactivos"><span class="fas fa-share-square"></span> Mov. de Activos</a> 
					<a class="dropdown-item badge badge-light" href="${url1}reparacion"><i class="fas fa-wrench"></i> Reparaciones</a> 
					<a class="dropdown-item badge badge-light" href="${url1}respaldos"><i class="fas fa-hdd"></i> Respaldos</a>
				</div>
			</li>
			<li class="nav-item"><a class="nav-link" href="#">Reportes</a></li>
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"	aria-haspopup="true" aria-expanded="false"> Catalogos </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item badge badge-light display-4" href="${url1}cedis"><i class="tex fas fa-building"></i> Cedis</a>
					<a class="dropdown-item badge badge-light" href="${url1}empleados"><i class="tex fas fa-address-book"></i> Empleados</a> 
					<a class="dropdown-item badge badge-light" href="${url1}status"><i class="tex fas fa-at"></i> Status</a> 
					<a class="dropdown-item badge badge-light" href="${url1}marcas"><i class="tex fas fa-boxes"></i> Marcas</a>
					<a class="dropdown-item badge badge-light" href="${url1}modelos"><i class="tex fas fa-desktop"></i> Modelos</a>
					<a class="dropdown-item badge badge-light" href="${url1}puestos"><i class="tex fas fa-clipboard-list"></i> Puestos</a> 
				</div>
			</li>
		</ul>
	</div>
</nav>