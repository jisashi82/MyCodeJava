<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax"%>

<template:classic>
	<spring:url value="/puestos2/searchajax" var="searchajax" />
	<spring:url value="/puestos2/searchnormal" var="searchnormal" />
	<script type="text/javascript">
		$(document).ready(function() {
			$('#botonDemo1').click(function() {
				alert('Demo 1');
			});

			/* $('#botonDemo2').click(function(){
				
				$.ajax({
					type:'GET',
					url:'${searchajax}',
					data:"separam="+$('#separam').val(),
				})
				.done(function(msg){
					$('#result1').html(msg);
				});
			}); */

			/* $('#botonDemo2').click(function(){
				var u="/puestos2/searchajax/JEFE";
							
				function doSearch() {
					$.getJSON("/puestos2/searchajax",{CHARS:$('#separam').val()},function(data){
						alert('response data: '+data)	
						
					});
				}
			
			}); */

		});
	</script>
	<script type="text/javascript">
		function doSearch() {
			var jqxhr = $.getJSON("${searchajax}", {
				CHARS : $('#separam').val()
			}, function(data) {
				console.log("success" + data);
				$('#results').text(data);
				$('#mydisplay').html("name", data);

			});
		}

		function doSearch2() {
			var p = $('#separam').val();
			$.ajax({
				url : "${searchnormal}",
				data : "separam=" + p,
				success : function(r) {
					console.log("success searchnormal" + r);
					//$('#tabla').html(res);
					$('#tabla').html(e);
				}
			});
		}
	</script>

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

			<spring:url value="/puestos2/search" var="search" />
			<form:form action="${search}">
				<label>Name</label>
				<input type="text" name="txtSearch" id="txtSearch">
				<button type="submit">Search</button>
			</form:form>
			<button id="botonDemo" onclick="doSearch2();">Demo</button>

			<input type="text" id="separam" name="separam" />
			<div id="results">aqui va el resultado</div>



			<ajax:displayTag id="displayTagFrame">
				<div id="tabla">
					<display:table htmlId="mydisplay" name="lista" id="lista"
						pagesize="10" requestURI="/puestos2"
						class="table table-sm table-striped table-borderless table-hover"
						excludedParams="ajax">

						<display:column property="id" headerClass="table-secondary" />
						<display:column property="nombre" headerClass="table-secondary" />

						<display:column title="Acciones" headerClass="table-secondary">
							<spring:url value="/puestos/delete/${lista.id}" var="delete" />
							<spring:url value="/puestos/edit/${lista.id}" var="edit" />
							<a href="${delete}" class="btn btn-sm btn-danger"
								data-toggle="tooltip" data-placement="top"
								title="Eliminar Registro"><span class="fas fa-trash"></span></a>
							<a href="${edit}" class="btn btn-sm btn-primary"
								data-toggle="tooltip" data-placement="top"
								title="Editar Registro"> <span class="fas fa-edit"></span></a>
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
			</ajax:displayTag>



		</div>
		<div class="card-footer my-1"></div>
	</div>
</template:classic>