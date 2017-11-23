<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="basic.model.PlacaMae" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de Placas Mãe</h1>
	
	<% ArrayList<PlacaMae> lista = (ArrayList<PlacaMae>) request.getAttribute("listaDePlacaMae"); %>
	
	<table>
		<tr>
			<td>ID</td>
			<td>Modelo</td>
		</tr>
		<% for (PlacaMae placaMae: lista) { %>
		<tr>
			<td>${placaMae.id}</td>
			<td>${placaMae.modelo}</td>
		</tr>
		<% }; %>
	</table>
	
</body>
</html>