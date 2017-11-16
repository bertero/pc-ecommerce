<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="basic.model.Processador" %>
<%@ page import="basic.model.Soquete" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><p>Olá, aqui temos todos nossos processadores:</p></div>
<% 
	ArrayList<Processador> listaDeProcessador = (ArrayList<Processador>) request.getAttribute("lista"); 
	
	for (Processador processador : listaDeProcessador) { 
		Soquete soquete = processador.getSoquete();
%>
	<div>
		<ul>
			<li>
				<label><strong>ID:</strong></label>
				<label><%= processador.getId() %></label>
			</li>
			<li>
				<label><strong>Modelo:</strong></label>
				<label><%= processador.getModelo() %></label>
			</li>
			<li>
				<label><strong>Frequencia:</strong></label>
				<label><%= processador.getFrequencia() %></label>
			</li>
			<li>
				<label><strong>Soquete:</strong></label>
				<label><%= soquete.getNome() %></label>
			</li>
		</ul>
	</div>
<% }; %>	

</body>
</html>