<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
	<title>Selecionar Peças</title>
</head>
<body>
	<div class="container-fluid">
		<div class="main_title">
			<h1>Montar Pedido - Selecionar Peças</h1>
		</div>
		<div class="container-fluid">
			<div class="row">
			
				<div class="col-md-2">
				</div>
				
				<div class="col-md-8" id="main_div">
					<div>
						<h4>Selecione as peças para adicionar ao pedido</h4>
					</div>
					
					<form role="form">
						<div class="lista_produtos">
							<h4>Placa Mãe</h4>
							<% 
								ArrayList<PlacaMae> listaDePlacaMae = (ArrayList<PlacaMae>) request.getAttribute("lista"); 
								
								for (PlacaMae placaMae : listaDePlacaMae) { 
									TipoDeMemoria tipoDeMemoria = placaMae.getTipoDeMemoria();
							%>
							<div class="produto">
								<label>Modelo</label><br>
								<%= placaMae.getModelo() %>
								<label>Fabricante</label><br>
								<%= placaMae.getFabricante() %>
								<label>Tipo de memória</label><br>
								<%= placaMae.getTipoDeMemoria() %>
								<label>Slots</label><br>
								<%= placaMae.getSlots() %>
								<label>Preço</label><br>
								<%= placaMae.getPreco() %>
							</div><br>
							<% }; %>
						</div>
						
						<div class="lista_produtos">
							<h4>Processador</h4>
							<% 
								ArrayList<Processador> listaDeProcessador = (ArrayList<Processador>) request.getAttribute("lista"); 
								
								for (Processador processador : listaDeProcessador) { 
									Soquete soquete = processador.getSoquete();
							%>
							<div class="produto">
								<label>Modelo</label><br>
								<%= processador.getModelo() %>
								<label>Fabricante</label><br>
								<%= processador.getFabricante() %>
								<label>Frequência</label><br>
								<%= processador.getFrequencia() %>
								<label>Soquete</label><br>
								<%= processador.getSoquete() %>
								<label>Preço</label><br>
								<%= processador.getPreco() %>
							</div><br>
							<% }; %>
						</div>
						
						<div class="lista_produtos">
							<h4>Memória</h4>
							<% 
								ArrayList<Memoria> listaDeMemoria = (ArrayList<Memoria>) request.getAttribute("lista"); 
								
								for (Memoria memoria : listaDeMemoria) { 
									TipoDeMemoria tipoDeMemoria = memoria.getTipoDeMemoria();
							%>
							<div class="produto">
								<label>Modelo</label><br>
								<%= memoria.getModelo() %>
								<label>Fabricante</label><br>
								<%= memoria.getFabricante() %>
								<label>Tipo de memória</label><br>
								<%= memoria.getTipoDeMemoria() %>
								<label>Frequência</label><br>
								<%= memoria.getFrequencia() %>
								<label>Preço</label><br>
								<%= memoria.getPreco() %>
							</div><br>
							<% }; %>
						</div>
						
						<div class="lista_produtos">
							<h4>Disco Rígido</h4>
							<% 
								ArrayList<DiscoRigido> listaDeDiscoRigido = (ArrayList<DiscoRigido>) request.getAttribute("lista"); 
								
								for (DiscoRigido discoRigido : listaDeDiscoRigido) { 
							%>
							<div class="produto">
								<label>Tipo</label><br>
								<%= discoRigido.getTipo() %>
								<label>Fabricante</label><br>
								<%= discoRigido.getFabricante() %>
								<label>Tamanho</label><br>
								<%= discoRigido.getTamanho() %>
								<label>Preço</label><br>
								<%= discoRigido.getPreco() %>
							</div><br>
							<% }; %>
						</div>
				</form>
					
				<div class="col-md-2">
				</div>
					
			</div>
		</div>
	</div>
</body>
</html>