<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>

<template:classic>
	<template:layout>
		<jsp:attribute name="header">${titulo}</jsp:attribute>
		<jsp:body>		
			<spring:url value="/cedis/save" var="save"/>
			<spring:url value="/cedis" var="regresar" />
			<form:form method="POST" action="${save}" modelAttribute="cedisForm">
				
				<spring:bind path="id">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="id">Id</label>
					<div class="col-sm-10">
						<form:input path="id" id="id" cssClass="form-control"  />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="nombre">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="nombre">Nombre</label>
					<div class="col-sm-10">
						<form:input path="nombre" cssClass="form-control" placeholder="Introduce el nombre del cedis" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="uop">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="uop">UOP</label>
					<div class="col-sm-10">
						<form:input path="uop" cssClass="form-control" placeholder="Introduce el numero de cedis ej.372" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="domicilio">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="domicilio">Domicilio</label>
					<div class="col-sm-10">
						<form:input path="domicilio" cssClass="form-control" placeholder="Introduce el domicilio" />
					</div>
				</div>
				</spring:bind>
				
				<div>					
					<input type="submit" class="btn btn-md btn-success" value="Guardar" />
					
					<a  class="btn btn-md btn-danger" href="${regresar}">Cancelar</a>
				</div>
				
			</form:form>			
		</jsp:body>
	</template:layout>
</template:classic>