<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="basic.model.TipoDeMemoria" %>
<%@ page import="basic.model.PlacaMae" %>
<%@ page import="basic.model.Soquete" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
	<title>Placa Mãe</title>
</head>
<body>
	<div class="container-fluid">
		<div class="main_title">
			<h1>Montar Computador - Selecionar Placa Mãe</h1>
		</div>
		<div class="container-fluid">
			<div class="row">
			
				<div class="col-md-2">
				</div>
				
				<div class="col-md-8" id="main_div">
					<div>
						<h4>Selecione uma placa mãe para adicionar ao computador</h4>
					</div>
					
					<form role="form" method="post" action="/First_Web/placa-mae-select">
						<div class="lista_produtos">
							<h4>Placa Mãe</h4>
							<% 
								ArrayList<PlacaMae> listaDePlacaMae = (ArrayList<PlacaMae>) request.getAttribute("listaPlacasMae"); 
								
								for (PlacaMae placaMae : listaDePlacaMae) { 
									TipoDeMemoria tipoDeMemoria = placaMae.getTipoDeMemoria();
							%>
							<div class="row">
								<div class="produto col-md-8">
									<label>Modelo</label><br>
									<%= placaMae.getModelo() %>
									<label>Fabricante</label><br>
									<%= placaMae.getFabricante() %>
									<label>Tipo de memória</label><br>
									<%= placaMae.getTipoDeMemoria() %>
									<label>Slots</label><br>
									<%= placaMae.getSlots() %>
								</div>
								<div class="quantos col-md-2">
									<label>Preço</label><br>
									<%= placaMae.getPreco() %>
									<label for="placaMae<%= placaMae.getId() %>">Quantidade:</label>
									<input type="text" name="placaMae<%= placaMae.getId() %>" class="form_control" style="width:30px" />
								</div>
							</div><br>
							<% }; %>
						</div>
						
						<button type="submit" class="btn btn-primary">
							Próximo
						</button>
					</form>
				</div>
				
				<div class="col-md-2">
				</div>
					
			</div>
		</div>
	</div>
</body>
</html>