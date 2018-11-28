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
			<spring:url value="/puestos/save" var="save"/>
			<spring:url value="/puestos" var="regresar" />
			<form:form method="POST" action="${save}" modelAttribute="respaldosForm">
				
				<spring:bind path="id">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="id">Id Folio: </label>
					<div class="col-sm-10">
						<form:input path="id" id="id" cssClass="form-control"  />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="idmes">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="idmes">Mes: </label>
					<div class="col-sm-10">
						<form:select path="idmes.id" cssClass="form-control" items="${listadeMeses}" itemValue="id" itemLabel="nombre"/>
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="fecha">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="fecha">Fecha: </label>
					<div class="col-sm-10">
						<form:input path="fecha" id="fecha"	cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="observaciones">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="observaciones">Observaciones: </label>
					<div class="col-sm-10">
						<form:input path="observaciones" id="observaciones" cssClass="form-control"  />
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