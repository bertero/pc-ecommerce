<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdicionarProcessador</title>
<link href="bootstrap.min.css" rel="stylesheet">
<link href="main.css" rel="stylesheet">
</head>
<body>
	<div class="col-md-2">
	</div>
	<div class="col-md-8">
	<h3>Coloque os dados do processador</h3>
	<form style="border-style:none" method="post" action="/First_Web/AlterarProcessadorController">
				<label for="modelo">Modelo: </label>
				<input name="modelo" type="text"></input><br>
				<label for="fabricante">Fabricante: </label>
				<input name="fabricante" type="text"></input><br>
				<label for="soquete">Nome Soquete: </label>
				<input name="soquete" type="text"></input><br>
				<label for="frequencia">Frequência: </label>
				<input name="frequencia" type="text"></input><br>
				<label for="preco">Preço: </label>
				<input name="preco" type="text"></input><br>
				<button class="btn btn-primary"  type ="submit">Adicionar</button>
			</form>
	</div>
	<div class="col-md-2">
	</div>
</body>
</html>