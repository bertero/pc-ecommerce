<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar processador</title>
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
</head>
<body>
	
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<h3>Processador encontrado. Selecione o que deseja fazer com a peça:</h3>
			
			<div class="row">
				<div class="col-md-6" >
					<form style="border-style:none"  method="post" action="/First_Web/EditarProcessadorController">
						<button style="width:100%" type="submit"  type ="submit">Editar Dados da Peça</button>
					</form> 
				</div>
				<div class="col-md-6">
					<form style="border-style:none" method = "post" action="/First_Web/RemoverProcessadorController">
						<button style="width:100%" type="submit"  type ="submit">Remover Processador</button>
					</form>
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
	
</body>
</html>