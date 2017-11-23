<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="basic.model.PlacaMae" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Placa Mãe</h1>
	<h4>Informações da placa mãe</h4>
	
	<% PlacaMae placaMae = (PlacaMae) request.getAttribute("placaMae"); %>
	<ul>
		<li>
			<label>ID:</label>
			<label>${placaMae.id}</label>
		</li>
		<li>
			<label>Modelo:</label>
			${placaMae.id}
		</li>
		<li>
			<label>Quantidade de slots:</label>
			${placaMae.slots}
		</li>
		<li>
			<label>Tipo:</label>
			${placaMae.tipo}
		</li>
	</ul>
</body>
</html>