<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar processador</title>
<link href="bootstrap.min.css" rel="stylesheet">
<link href="main.css" rel="stylesheet">
</head>
<body>

<h3>Entre com o ID do processador desejado:</h3>

<div class = "col-md-2">
</div>

<div class = "col-md-8">
	<form method="post" action="/BuscarProcessadorController" >
		<label for="processador">ID Processador: </label>
		<input style="width:500px" name = "id" type = "text" placeholder = "Digite aqui o ID do processador desejado"></input>
		<br>
		<button class="btn btn-primary"  type ="submit">Procurar</button>
	</form>
</div>

<div class = "col-md-2">
</div>

</body>
</html>