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
			<spring:url value="/movactivos/save/upload" var="save"/>
			<spring:url value="/movactivos" var="regresar" />
			
			<form:form method="post" action="${save}" enctype="multipart/form-data" modelAttribute="movactivosFormUpload">				
				 
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="id">Id:</label>
					<div class="col-sm-10">
						<input type="text" id="id" name="id" class="form-control" value="${id}"  />
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 col-form-label" for="file">Evidencia PDF:</label>
					<div class="col-sm-10 input-group date">
						<%-- <form:input type="file" path="attachFileObj" id="attachFileObj" cssClass="form-control" /> --%>
						<input type="file" name="file"> 
					</div>
				</div>											
				
				<div>					
					<input type="submit" class="btn btn-md btn-success" value="Guardar" />					
					<a  class="btn btn-md btn-danger" href="${regresar}">Cancelar</a>
				</div>
				
			</form:form>			
		</jsp:body>
	</template:layout>
</template:classic>