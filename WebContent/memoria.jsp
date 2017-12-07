<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="basic.model.Memoria" %>
<%@ page import="basic.model.TipoDeMemoria" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
	<title>Memória</title>
</head>
<body>
	<div class="container-fluid">
		<div class="main_title">
			<h1>Montar Computador - Selecionar Memória</h1>
		</div>
		<div class="container-fluid">
			<div class="row">
			
				<div class="col-md-2">
				</div>
				
				<div class="col-md-8" id="main_div">
					<div>
						<h4>Selecione até 4 memórias para adicionar ao pedido</h4>
					</div>
					
					<form role="form" method="post" action="/memoria-select">
						<div class="lista_produtos">
							<h4>Memória</h4>
							<% 
								ArrayList<Memoria> listaDeMemoria = (ArrayList<Memoria>) request.getAttribute("listaMemorias"); 
								
								for (Memoria memoria : listaDeMemoria) { 
									TipoDeMemoria tipoDeMemoria = memoria.getTipoDeMemoria();
							%>
							<div class="row">
								<div class="produto col-md-8">
									<label>Fabricante</label><br>
									<%= memoria.getFabricante() %>
									<label>Tipo de memória</label><br>
									<%= memoria.getTipoDeMemoria() %>
									<label>Frequência</label><br>
									<%= memoria.getFrequencia() %>
								</div>
								<div class="quantos col-md-2">
									<label>Preço</label><br>
									<%= memoria.getPreco() %>
									<label for="memoria<%= memoria.getId() %>">Quantidade:</label>
									<input type="text" name="memoria<%= memoria.getId() %>" class="form_control" style="width:30px" />
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