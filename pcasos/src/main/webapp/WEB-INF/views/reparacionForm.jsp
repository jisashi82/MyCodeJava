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
			<spring:url value="/reparacion/save" var="save"/>
			<spring:url value="/reparacion" var="regresar" />
			<form:form method="POST" action="${save}" modelAttribute="reparacionForm">
				
				<spring:bind path="id">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="id">Id</label>
					<div class="col-sm-10">
						<form:input path="id" id="id" cssClass="form-control"  />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="serie">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="serie">#Serie</label>
					<div class="col-sm-10">
						<form:input path="serie" cssClass="form-control" required="true" />
						<form:errors path="serie" class="control-label alert alert-warning" />
					</div>					
				</div>
				</spring:bind>
				
				<spring:bind path="modelo">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="modelo">Modelo</label>
					<div class="col-sm-10">						
						<form:select  path="modelo.id" cssClass="form-control" items="${listadeModelos}" itemValue="id" itemLabel="nombre"/>
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="cedis">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="cedis">Cedis</label>
					<div class="col-sm-10">
						<form:select  path="cedis.id" cssClass="form-control" items="${listadeCedis}" itemValue="id" itemLabel="nombre"/>
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
				
				<spring:bind path="tipoproblema">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="tipoproblema">Tipo problema</label>
					<div class="col-sm-10">
						<form:select  path="tipoproblema.id" cssClass="form-control" items="${listadeStatus}" itemValue="id" itemLabel="descripcion"/>
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="acta">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="acta">Acta Hechos</label>
					<div class="col-sm-10">
						<form:select  path="acta.id" cssClass="form-control" items="${listadeStatus}" itemValue="id" itemLabel="descripcion"/>
					</div>
				</div>
				</spring:bind>
								
				<spring:bind path="descuento">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="descuento">Descuento</label>
					<div class="col-sm-10">
						<form:select  path="descuento.id" cssClass="form-control" items="${listadeStatus}" itemValue="id" itemLabel="descripcion"/>
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
				
				<spring:bind path="falla">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="falla">Detalle de la falla</label>
					<div class="col-sm-10">
						<form:textarea path="falla" cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="status">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="status">Status  del Equipo</label>
					<div class="col-sm-10">
						<form:select  path="status.id" cssClass="form-control" items="${listadeStatus}" itemValue="id" itemLabel="descripcion"/>
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="fecinitramite">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="fecinitramite">Fecha de Tramite</label>
					<div class="col-sm-10">
						<form:input path="fecinitramite" type="date" cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="fecenvio">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="fecenvio">Fecha de Envio</label>
					<div class="col-sm-10 input-group date">
						<form:input path="fecenvio" type="date" cssClass="form-control" />
					</div>
				</div>
				</spring:bind>
				
				<spring:bind path="fecretorno">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="fecretorno">Fecha de Retorno</label>
					<div class="col-sm-10 input-group date">
						<form:input path="fecretorno" type="date" cssClass="form-control" />
					</div>
				</div>				
				</spring:bind>
				
				<spring:bind path="ro">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="ro">#RO</label>
					<div class="col-sm-10">
						<form:input path="ro" cssClass="form-control" />
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