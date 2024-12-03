<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CDN Bootstrap -->
<title>Villa Arboleda</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-success">
			<div class="container-fluid">
				<a class="navbar-brand fw-semibold fs-4"
					href="${pageContext.request.contextPath}/">Villa Arboleda</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/">Inicio</a></li>
						<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/propietarios/listar">Listar Propietarios</a></li>		
						<span class="d-inline-block" tabindex="0" data-bs-toggle="popover" data-bs-trigger="hover focus" 
						data-bs-content="Redirecciona a la vista JSON" data-bs-placement="bottom">
							<li class="nav-item"><a class="nav-link text-white"
							href="${pageContext.request.contextPath}/api/propietarios">Api Propietarios</a></li>
						</span>
						<span class="d-inline-block" tabindex="0" data-bs-toggle="popover" data-bs-trigger="hover focus" 
						data-bs-content="Redirecciona a la vista JSON" data-bs-placement="bottom">
							<li class="nav-item"><a class="nav-link text-white"
								href="${pageContext.request.contextPath}/api/saldos">Api Saldos</a></li>
						</span>
					</ul>
				</div>
				

			</div>
		</nav>
	</header>
	
	<!-- Popper -->
	<script src="https://cdn.jsdelivr.net/npm/@floating-ui/core@1.6.8"></script>
	<script src="https://cdn.jsdelivr.net/npm/@floating-ui/dom@1.6.12"></script>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/res/js/app.js"></script>
</body>
</html>

