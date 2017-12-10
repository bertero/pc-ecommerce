<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
	<title>Montar Pedido</title>
</head>
<body>
	<div class="container-fluid">
		<div class="main_title">
			<h1>Montar Pedido</h1>
		</div>
		<div class="container-fluid">
			<div class="row">
			
				<div class="col-md-2">
				</div>
				
				<div class="col-md-8" id="main_div">
					<div>
						<h4>Para montar um pedido, informe o CPF do cliente que deseja fazer a compra.</h4>
					</div>
					<div>
						<form role="form" method="post" action="/First_Web/montar-pedido">
							<div class="form-group">
								<label for="cpfCliente">CPF do cliente</label>
								<input type="text" name="cpfCliente" class="form-control" placeholder="CPF do cliente" />
							</div>
							<button type="submit" class="btn btn-primary">
								Confirmar
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