<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="basic.model.Pedido" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
	<title>Gerar Relat�rios</title>
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
	
</head>

<body>

	<h3 style="padding:5px">Digite o m�s de refer�ncia para gerar os relat�rios</h3>
	
	<div class="col-md-2"></div>
	
	<div class="col-md-8" id ="main_div_relatorio">
		<form method="post" action="/PoC-MVC/GerarRelatorioController" style="padding:10px; border-style:solid;border-width:2px; border-color:gray; background-color:white">
			<div >
				
				<label for="mes">M�s:</label>
				<input style="border-radius:5px;border-style:solid; border-color:gray; background-color:white" 
					   type="text" name="mes" placeholder="Digite aqui o m�s">
			</div>
			<br>
			<button class="btn btn-primary" type ="submit" >Buscar relat�rios</button>
		</form>
		
	
	</div>

	<div class="col-md-2"></div>
</body>
</html>