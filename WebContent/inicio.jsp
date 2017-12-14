<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
	<title>Início</title>
</head>
<body>
	<div class="container-fluid">
		<div class="main_title">
			<h1>Início</h1>
		</div>
		<div class="container-fluid">
			<div class="row">
			
				<div class="col-md-2">
				</div>
				
				<div class="col-md-8" id="main_div">
					<div class="row" >
						<div class="col-md-4">
							<form role="form" method="get" action="/First_Web/montar-pedido" >
							<button type="submit" class="btn btn-primary">Montar pedido</button>
						</form>
						</div>
						<div class="col-md-4">
							<form role="form" method="get" action="/First_Web/EditarProcessadorController" >
							<button type="submit" class="btn btn-primary">Pesquisar processador</button>
						</form>
						</div>
						<div class="col-md-4">
							<form role="form" method="get" action="/First_Web/GerarRelatorioController" >
							<button type="submit" class="btn btn-primary">Gerar relatório</button>
						</form>
						</div>
					</div>					
				</div>
				
				<div class="col-md-2">
				</div>
					
			</div>
		</div>
	</div>
</body>
</html>