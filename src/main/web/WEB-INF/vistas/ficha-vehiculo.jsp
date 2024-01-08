<html>
	<head>
		<jsp:include page="common-in-heads.jsp"/>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<h2>Ficha de Vehiculo 
			<c:if test="${vehiculo.descatalogado}">
				<span style="color:red;">(descatalogado)</span>
			</c:if>
		</h2>
		<table class="ficha">	
			<tr>
				<th>Código</th>
				<td>${vehiculo.codigo}</td>
			</tr>
			<tr>
				<th>Nombre</th>
				<td>${vehiculo.nombre}</td>
			</tr>
			<tr>
				<th>Precio</th>
				<td>${vehiculo.precio}</td>
			</tr>
			<tr>
				<th>Fecha de Alta</th>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${vehiculo.fechaAlta}" /></td>
			</tr>
			<tr>
				<th>Categoría</th>
				<td>${vehiculo.categoria}</td>
			</tr>
			<tr>
				<th>Descripción</th>
				<td>${vehiculo.descripcion}</td>
			</tr>
		</table>
	</body>
</html>