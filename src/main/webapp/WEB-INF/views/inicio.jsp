<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Villa Arboleda</title>
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
		<h1 class="text-center display-5 fw-bold text-success">Villa Arboleda</h1>
		<h2 class="text-center fw-bold text-white sombra">¡Le damos la bienvenida a Villa Arboleda!</h2>

		<div class="text-center mt-4 fw-bold">
			<img
				src="https://img.freepik.com/premium-psd/wrinkled-transparent-overlay-effect_53876-197057.jpg"
				alt="Imagen descriptiva" class="imagenRelleno">
			<p class="fs-3 fw-bold mb-5 text-white sombra">En este portal podrás revisar 
			todas las propiedades y sus propietarios</p>
			
			<h5 class="fw-bold mb-5 text-white sombra">(Este sitio cuenta con API REST, por lo que 
			los propietarios y sus saldos pueden ser manipulados con herramientas de back-end como Postman)</h5>
		</div>
	</div>

	<!-- Footer -->
	<%@ include file='footer.jsp'%>

	<!-- Script -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
