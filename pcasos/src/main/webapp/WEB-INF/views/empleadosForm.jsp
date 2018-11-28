<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>

<template:classic>
	<template:layout>
		<jsp:attribute name="header">${titulo}</jsp:attribute>
		<jsp:body>		
			<spring:url value="/empleados/save" var="save"/>
			<spring:url value="/empleados" var="regresar" />
			<form:form method="POST" action="${save}" modelAttribute="empleadosForm">
				
				<spring:bind path="id">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="id">Id</label>
					<div class="col-sm-10">
						<form:input path="id" id="id" cssClass="form-control"  />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="numempleado">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="numempleado">#Nomina</label>
					<div class="col-sm-10">
						<form:input path="numempleado" cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="nombre">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="nombre">Nombre</label>
					<div class="col-sm-10">
						<form:input path="nombre" cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="apellidos">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="apellidos">Apellidos</label>
					<div class="col-sm-10">
						<form:input path="apellidos" cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="email">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="email">Email</label>
					<div class="col-sm-10">
						<form:input path="email" cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="telefono">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="telefono">Telefono</label>
					<div class="col-sm-10">
						<form:input path="telefono" cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
								
				<spring:bind path="puesto">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="puesto">Puesto</label>
					<div class="col-sm-10">
						<form:select  path="puesto.id" cssClass="form-control" items="${listadePuestos}" itemValue="id" itemLabel="nombre"/>
					</div>
				</div>
				</spring:bind>
								
				<spring:bind path="username">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="username">usuario</label>
					<div class="col-sm-10">
						<form:input path="username" cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="password">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="password">Password</label>
					<div class="col-sm-10">
						<form:input path="password" cssClass="form-control" />
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