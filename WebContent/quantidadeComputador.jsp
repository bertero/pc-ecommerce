<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
	<title>Finalizar Computador</title>
</head>
<body>
	<div class="container-fluid">
		<div class="main_title">
			<h1>Montar Computador - Quantidade desejada</h1>
		</div>
		<div class="container-fluid">
			<div class="row">
			
				<div class="col-md-2">
				</div>
				
				<div class="col-md-8" id="main_div">
					<div>
						<h4>Deseja montar quantos computadores com essas configurações?</h4>
						(Taxa de montagem de R$0,00)
					</div><br>
					<div>
						<form role="form" method="post" action="/PoC-MVC/computador-quant-select">
							<label for="quantidadeComputador">Quantidade</label>
							<input type="text" name="quantidadeComputador" class="form-control" />
							<button type="submit" class="btn btn-primary">
								Finalizar computador
							</button>
						</form>
						<form role="form" method="get" action="/confirmar-pedido">
							<button type="submit" class="btn btn-danger">
								Cancelar
							</button>
						</form>
					</div>
				</div>
				
				<div class="col-md-2">
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>