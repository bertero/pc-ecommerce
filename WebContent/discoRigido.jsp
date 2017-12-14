<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="basic.model.DiscoRigido" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
	<title>Disco R�gido</title>
</head>
<body>
	<div class="container-fluid">
		<div class="main_title">
			<h1>Montar Computador - Selecionar Disco R�gido</h1>
		</div>
		<div class="container-fluid">
			<div class="row">
			
				<div class="col-md-2">
				</div>
				
				<div class="col-md-8" id="main_div">
					<div>
						<h4>Selecione at� 2 discos r�gidos para adicionar ao computador</h4>
					</div>
					
					<form role="form" method="post" action="/PoC-MVC/disco-rigido-select">
						<div class="lista_produtos">
							<h4>Disco R�gido</h4>
							<% 
								ArrayList<DiscoRigido> listaDeDiscoRigido = (ArrayList<DiscoRigido>) request.getAttribute("listaDiscosRigidos"); 
								
								for (DiscoRigido discoRigido : listaDeDiscoRigido) { 
							%>
							<div class="row">
								<div class="produto col-md-8">
									<label>Tipo</label><br>
									<%= discoRigido.getTipo() %>
									<label>Fabricante</label><br>
									<%= discoRigido.getFabricante() %>
									<label>Tamanho</label><br>
									<%= discoRigido.getTamanho() %>
								</div>
								<div class="quantos col-md-2">
									<label>Pre�o</label><br>
									<%= discoRigido.getPreco() %>
									<label for="discoRigido<%= discoRigido.getId() %>">Quantidade:</label>
									<input type="text" name="discoRigido<%= discoRigido.getId() %>" class="form_control" style="width:30px" />
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