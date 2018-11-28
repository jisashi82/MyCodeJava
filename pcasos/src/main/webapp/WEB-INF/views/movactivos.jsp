<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>

<template:classic>

	<div class="card clearfix">

		<div class="card-header">
			<h3 class="float-left">Catalogo de Movimientos de Activos Fijos</h3>
			<spring:url value="/movactivos/add" var="add"></spring:url>
			<a class="btn btn-md btn btn-success float-right shadow"
				href="${add}"> <span class="fas fa-plus-square"></span>
			</a>
		</div>

		<div class="card-body">
	
			<c:if test="${ not empty msg}">
				<div class="alert alert-${css} alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<strong>${msg}</strong>
				</div>
			</c:if>
			
			<spring:url value="/movactivos/search" var="search" />
			<form:form action="${search}" method="GET">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Buscar</label>
					<div class="col-sm-8">
						<input type="text" name="txtSearch" id="txtSearch"
							class="form-control">
					</div>
					<button type="submit" class="btn btn-info" data-toggle="tooltip" data-placement="top" title="Buscar x nombre"><span class="fas fa-search"></span></button>
				</div>
			</form:form>

			<display:table name="lista" id="lista" pagesize="10" requestURI="${URI}"
				class="table table-sm table-striped table-borderless table-hover">

				<display:column property="id" headerClass="table-secondary" />
				<display:column property="fecha" headerClass="table-secondary" />
				<display:column property="destino.nombre" title="Destino" headerClass="table-secondary" />
				<display:column property="serie" title="Serie" headerClass="table-secondary" />
				<display:column property="activo" title="Activo" headerClass="table-secondary" />
				<display:column property="modelo.nombre" title="Modelo" headerClass="table-secondary" />
				<display:column property="observaciones" title="Observaciones" headerClass="table-secondary" />
				
				<display:column title="Acciones" headerClass="table-secondary col-sm-2">
					<spring:url value="/movactivos/delete/${lista.id}" var="delete" />
					<spring:url value="/movactivos/edit/${lista.id}" var="edit" />
					<spring:url value="/movactivos/evidencia/${lista.id}" var="evidencia" />
					<spring:url value="/movactivos/formato/${lista.id}" var="formato" />
					<spring:url value="/movactivos/upload/${lista.id}" var="upload" />
					<a href="${delete}" class="btn btn-sm btn-danger" data-toggle="tooltip" data-placement="top" title="Eliminar Registro"><span class="fas fa-trash"></span></a>
					<a href="${edit}" class="btn btn-sm btn-primary" data-toggle="tooltip" data-placement="top" title="Editar Registro"><span class="fas fa-edit"></span></a>
					<a href="${evidencia}" class="btn btn-sm btn-light" data-toggle="tooltip" data-placement="top" title="Ver Evidencia"><span class="fas fa-file-pdf"></span></a>
					<a href="${formato}" class="btn btn-sm btn-warning" data-toggle="tooltip" data-placement="top" title="Ver Formato"><span class="fas fa-file-alt"></span></a>
					<a href="${upload}" class="btn btn-sm btn-warning" data-toggle="tooltip" data-placement="top" title="Upload"><span class="fas fa-file-alt"></span></a>
				</display:column>
				<display:setProperty  name="paging.banner.full">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="{1}">First</a></li>
                        <li class="page-item"><a class="page-link" href="{2}">Prev</a></li>
                        <li class="page-item page-link">{0}</li>
                        <li class="page-item"><a class="page-link" href="{3}">Next</a></li>
                        <li class="page-item"><a class="page-link" href="{4}">Last</a></li>
                    </ul>  
				</display:setProperty>

				<display:setProperty name="paging.banner.first">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="{3}">Next</a></li>
						<li class="page-item page-link">{0}</li>
						<li class="page-item"><a class="page-link" href="{4}">Last</a></li>
					</ul>
				</display:setProperty>

				<display:setProperty name="paging.banner.last">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="{1}">First</a></li>
						<li class="page-item page-link">{0}</li>
						<li class="page-item"><a class="page-link" href="{2}">Prev</a></li>
					</ul>
				</display:setProperty>

			</display:table>

		</div>

		<div class="card-footer my-1"></div>
	</div>

</template:classic>