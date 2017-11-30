<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
	<title>Deseja computador?</title>
</head>
<body>
	<div class="container-fluid">
		<div class="main_title">
			<h1>Montar Pedido - Peças selecionadas!</h1>
		</div>
		<div class="container-fluid">
			<div class="row">
			
				<div class="col-md-2">
				</div>
				
				<div class="col-md-8" id="main_div">
					<div>
						<h4>Deseja montar um computador com as peças selecionadas?</h4>
						(Taxa de montagem de R$0,00)
					</div><br>
					<div>
						<form role="form" method="get" action="/nao-montar">
							<button type="submit" class="btn btn-danger">
								Não, sem computador.
							</button>
							<button type="submit" class="btn btn-primary">
								Sim, montar computador.
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