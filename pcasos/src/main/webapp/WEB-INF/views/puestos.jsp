<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>

<template:classic>

	<div class="card clearfix">

		<div class="card-header">
			<h3 class="float-left">Catalogo de Puestos</h3>
			<spring:url value="/puestos/add" var="add"></spring:url>
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


			<spring:url value="/puestos/search" var="search" />
			<form:form action="${search}">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Buscar</label>
					<div class="col-sm-8">
						<input type="text" name="txtSearch" id="txtSearch"
							class="form-control">
					</div>
					<button type="submit" class="btn btn-info" data-toggle="tooltip" data-placement="top" title="Buscar x nombre"><span class="fas fa-search"></span></button>
				</div>
			</form:form>

			<display:table name="lista" id="lista" pagesize="10"
				requestURI="/puestos"
				class="table table-sm table-striped table-borderless table-hover">

				<display:column property="id" headerClass="table-secondary" />
				<display:column property="nombre" headerClass="table-secondary" />
				<display:column title="Acciones" headerClass="table-secondary">
					<spring:url value="/puestos/delete/${lista.id}" var="delete" />
					<spring:url value="/puestos/edit/${lista.id}" var="edit" />
					<a href="${delete}" class="btn btn-sm btn-danger"
						data-toggle="tooltip" data-placement="top"
						title="Eliminar Registro"><span class="fas fa-trash"></span></a>
					<a href="${edit}" class="btn btn-sm btn-primary"
						data-toggle="tooltip" data-placement="top" title="Editar Registro">
						<span class="fas fa-edit"></span>
					</a>
				</display:column>

				<display:setProperty name="paging.banner.full">
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