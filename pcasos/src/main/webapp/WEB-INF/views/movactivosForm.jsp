<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>

<template:classic>
	<template:layout>
		<jsp:attribute name="header">${titulo}</jsp:attribute>
		<jsp:body>		
			<spring:url value="/movactivos/save" var="save"/>
			<spring:url value="/movactivos" var="regresar" />
			<form:form method="POST" action="${save}" modelAttribute="movactivosForm">
				
				<spring:bind path="id">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="id">Id</label>
					<div class="col-sm-10">
						<form:input path="id" id="id" cssClass="form-control"  />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="fecha">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="fecha">#fecha</label>
					<div class="col-sm-10">
						<form:input path="fecha" type="date" cssClass="form-control" required="true" />
						<form:errors path="fecha" class="control-label alert alert-warning" />
					</div>					
				</div>
				</spring:bind>
				
				<spring:bind path="origen">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="origen">origen</label>
					<div class="col-sm-10">						
						<form:select  path="origen.id" cssClass="form-control" items="${listadeCedis}" itemValue="id" itemLabel="nombre"/>
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="destino">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="destino">destino</label>
					<div class="col-sm-10">
						<form:select  path="destino.id" cssClass="form-control" items="${listadeCedis}" itemValue="id" itemLabel="nombre"/>
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="empleado">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="empleado">Empleado</label>
					<div class="col-sm-10">
						<form:select  path="empleado.id" cssClass="form-control" items="${listadeEmpleados}" itemValue="id" itemLabel="nombres" />							
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="activo">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="activo">Activo</label>
					<div class="col-sm-10">
						<form:textarea path="activo" cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="serie">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="serie">Serie</label>
					<div class="col-sm-10">
						<form:textarea path="serie" cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="modelo">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="modelo">modelo</label>
					<div class="col-sm-10">						
						<form:select  path="modelo.id" cssClass="form-control" items="${listadeModelos}" itemValue="id" itemLabel="nombre"/>
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="caracteristica">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="caracteristica">caracteristicas</label>
					<div class="col-sm-10 input-group date">
						<form:input path="caracteristica" cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
												
				<spring:bind path="observaciones">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="observaciones">Observaciones</label>
					<div class="col-sm-10">
						<form:textarea path="observaciones" cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="motivo">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="motivo">motivo</label>
					<div class="col-sm-10 input-group date">
						<form:input path="motivo" cssClass="form-control" />
					</div>
				</div>				
				</spring:bind>
				
				<%-- <spring:bind path="evidencia">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="evidencia">evidencia</label>
					<div class="col-sm-10 input-group date">
						<form:input path="evidencia" cssClass="form-control" />
					</div>
				</div>				
				</spring:bind> --%>
				
												
				
				<div>					
					<input type="submit" class="btn btn-md btn-success" value="Guardar" />					
					<a  class="btn btn-md btn-danger" href="${regresar}">Cancelar</a>
				</div>
				
			</form:form>			
		</jsp:body>
	</template:layout>
</template:classic>