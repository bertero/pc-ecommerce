<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="basic.model.Processador" %>
<%@ page import="basic.model.Soquete" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
	<title>Processador</title>
</head>
<body>
	<div class="container-fluid">
		<div class="main_title">
			<h1>Montar Computador - Selecionar Processador</h1>
		</div>
		<div class="container-fluid">
			<div class="row">
			
				<div class="col-md-2">
				</div>
				
				<div class="col-md-8" id="main_div">
					<div>
						<h4>Selecione um processador para adicionar ao computador</h4>
					</div>
					
					<form role="form" method="post" action="/processador-select">
						<div class="lista_produtos">
							<h4>Processador</h4>
							<% 
								ArrayList<Processador> listaDeProcessador = (ArrayList<Processador>) request.getAttribute("listaProcessadores"); 
								
								for (Processador processador : listaDeProcessador) { 
									Soquete soquete = processador.getSoquete();
							%>
							<div class="row">
								<div class="produto col-md-8">
									<label>Modelo</label><br>
									<%= processador.getModelo() %>
									<label>Fabricante</label><br>
									<%= processador.getFabricante() %>
									<label>Frequ�ncia</label><br>
									<%= processador.getFrequencia() %>
									<label>Soquete</label><br>
									<%= processador.getSoquete() %>
								</div>
								<div class="quantos col-md-2">
									<label>Pre�o</label><br>
									<%= processador.getPreco() %>
									<label for="processador<%= processador.getId() %>">Quantidade:</label>
									<input type="text" name="processador<%= processador.getId() %>" class="form_control" style="width:30px" />
								</div>
							</div><br>
							<% }; %>
						</div>
						
						<button type="submit" class="btn btn-primary">
							Pr�ximo
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