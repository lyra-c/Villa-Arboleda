<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Listar Propietarios</title>
<!-- CDN Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Hoja de estilos -->	
<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/estilo.css">
</head>
<body>
	<%@ include file='navbar.jsp'%>
	<div class="container mt-5">
		<h1 class="text-center mb-4 fw-bold text-danger-subtle">Listado de Propietarios Registrados</h1>
		<table class="table table-striped">
			<div class="row">
				<div class="col-md-4">
					<label class="form-label fw-bold fs-2 text-success sombra-2">Filtrar por:</label>
					<div class="mb-3">
  						<label for="InputNombre" class="form-label fw-bold fs-5">Propietario</label>
  						<input class="form-control" id="propietarioNombre" placeholder="Nombre del Propietario">
					</div>
				</div>
				<div class="col-md-4">
					<div class="mb-3" style="padding-top: 3.5rem;">
  						<label for="InputEstado" class="form-label fw-bold fs-5">Estado</label>
  						<select id="estadoPropietario" class="form-select" aria-label="Default select example">
  							<option value="">Todos los propietarios</option>
  							<option value="0">Vigente</option>
  							<option value="1">Moroso</option>
						</select>
					</div>
				</div>
			</div>
			<button type="button" class="btn btn-success mb-3" onclick="filtrarPropietarios()">Buscar</button>
			
			<thead>
				<tr>
					<th>RUT</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Teléfono</th>
					<th>Estado</th>
				</tr>
			</thead>
			<tbody id="tablaPropietarios">
				<c:forEach var="propietario" items="${propietarios}">
					<tr class="propietario-row">
						<td>${propietario.saldos_idsaldos.rut}</td>
						<td>${propietario.nombre}</td>
						<td>${propietario.apellido}</td>
						<td>${propietario.correo}</td>
						<td>${propietario.telefono}</td>
						<td class="estado">
							<c:if test="${propietario.saldos_idsaldos.estado == 0}">
								<span class="text-success">Vigente</span>
							</c:if>
							<c:if test="${propietario.saldos_idsaldos.estado == 1}">
								<span class="text-danger">Moroso</span>
							</c:if>
						</td>
					</tr>
				</c:forEach>

				<c:if test="${empty propietarios}">
					<tr>
						<td colspan="6" class="text-center">No hay propietarios registrados</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
	
	<%@ include file='footer.jsp'%>

	<!-- Script para el listado de propietarios -->
	<script src="${pageContext.request.contextPath}/res/js/app.js"></script>
</body>

</html>

