<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="basic.model.Processador" %>
<%@ page import="basic.model.Soquete" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	Processador processador = (Processador) request.getAttribute("processador"); 
	Soquete soquete         = processador.getSoquete();
%>
	<div>
		<p>Olá, aqui está o Processador procurado:</p>
		<ul>
			<li>
				<label><strong>ID:</strong></label>
				<label> ${processador.id} </label>
			</li>
			<li>
				<label><strong>Modelo:</strong></label>
				<label> ${processador.modelo} </label>
			</li>
			<li>
				<label><strong>Frequencia:</strong></label>
				<label> ${processador.frequencia} </label>
			</li>
			<li>
				<label><strong>Soquete:</strong></label>
				<label> ${soquete.nome} </label>
			</li>
		</ul>
	</div>
</body>
</html>