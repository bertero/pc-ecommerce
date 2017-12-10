<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="basic.model.DiscoRigido" %>
<%@ page import="basic.model.Memoria" %>
<%@ page import="basic.model.TipoDeMemoria" %>
<%@ page import="basic.model.PlacaMae" %>
<%@ page import="basic.model.Processador" %>
<%@ page import="basic.model.Soquete" %>
<%@ page import="basic.model.PecaDeComputador" %>
<%@ page import="basic.model.ItemDePedido" %>
<%@ page import="basic.model.Computador" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
	<title>Carrinho</title>
</head>
<body>
	<div class="container-fluid">
		<div class="main_title">
			<h1>Carrinho do Pedido</h1>
		</div>
		<div class="container-fluid">
			<div class="row">
			
				<div class="col-md-2">
				</div>
				
				<div class="col-md-8" id="main_div">
					<div>
						<h4>Itens adicionados ao pedido</h4>
					</div>					
					<div class="lista_produtos">
						<% 
							ArrayList<ItemDePedido> listaDeItens = (ArrayList<ItemDePedido>) request.getAttribute("listaDeItens");
							System.out.println("test1");
							for (ItemDePedido item : listaDeItens) {
								System.out.println("test2");
								if (item.getProduto() instanceof PecaDeComputador) {
									PecaDeComputador peca = (PecaDeComputador) item.getProduto();
									if (peca instanceof PlacaMae) {
										PlacaMae placaMae = (PlacaMae) peca;
						%>
						<div class="row">
							<div class="produto col-md-8">
								<h4>Placa Mãe</h4>
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
								<label>Quantidade</label>
								<%= item.getQuantidade() %>
							</div>
						</div><br>
						<%
									}
									else if (peca instanceof Processador) {
										Processador processador = (Processador) peca;
						%>
						<div class="row">
							<div class="produto col-md-8">
								<h4>Processador</h4>
								<label>Modelo</label><br>
								<%= processador.getModelo() %>
								<label>Fabricante</label><br>
								<%= processador.getFabricante() %>
								<label>Frequência</label><br>
								<%= processador.getFrequencia() %>
								<label>Soquete</label><br>
								<%= processador.getSoquete() %>
							</div>
							<div class="quantos col-md-2">
								<label>Preço</label><br>
								<%= processador.getPreco() %>
								<label>Quantidade</label>
								<%= item.getQuantidade() %>
							</div>
						</div><br>
						<%
									}
									else if (peca instanceof Memoria) {
										Memoria memoria = (Memoria) peca;
						 %>
						<div class="row">
							<div class="produto col-md-8">
								<h4>Memória</h4>
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
								<label>Quantidade</label>
								<%= item.getQuantidade() %>
							</div>
						</div><br>
						<%
									}
									else if (peca instanceof DiscoRigido) {
										DiscoRigido discoRigido = (DiscoRigido) peca;
						 %>
						<div class="row">
							<div class="produto col-md-8">
								<h4>Disco Rígido</h4>
								<label>Tipo</label><br>
								<%= discoRigido.getTipo() %>
								<label>Fabricante</label><br>
								<%= discoRigido.getFabricante() %>
								<label>Tamanho</label><br>
								<%= discoRigido.getTamanho() %>
							</div>
							<div class="quantos col-md-2">
								<label>Preço</label><br>
								<%= discoRigido.getPreco() %>
								<label>Quantidade</label>
								<%= item.getQuantidade() %>
							</div>
						</div><br>
						<%
									}
								}
								else if (item.getProduto() instanceof Computador) {
									Computador computador = (Computador) item.getProduto();
						 %>
						 <div class="row">
							<div class="produto col-md-8">
								<h4>Computador</h4>
								<label>Placa Mãe</label><br>
								<%= computador.getPm().getFabricante() %>
								<label>Memória</label><br>
								<%= computador.getMem1().getFabricante() %>
								<% System.out.println("oi"); %>
								<% if(computador.getMem2() != null) { %>
								<%= computador.getMem2().getFabricante() %>
								<% } %>
								<% if(computador.getMem3() != null) { %>
								<%= computador.getMem3().getFabricante() %>
								<% } %>
								<% if(computador.getMem3() != null) { %>
								<%= computador.getMem3().getFabricante() %>
								<% } %>
								<label>Disco Rígido</label><br>
								<%= computador.getHd1().getFabricante() %>
								<% if(computador.getHd2() != null) { %>
								<%= computador.getHd2().getFabricante() %>
								<% } %>
								<label>Processador</label><br>
								<%= computador.getProc().getFabricante() %>
							</div>
							<div class="quantos col-md-2">
								<label>Preço</label><br>
								<%= computador.calculaPreco() %>
								<label>Quantidade</label>
								<%= item.getQuantidade() %>
							</div>
						</div><br>
						<% 
								}
							}
						 %>
					</div>
					
					<div class="row" >
						<form role="form" method="get" action="/First_Web/pecas-avulsas" >
							<button type="submit" class="btn btn-primary">Adicionar mais peças</button>
						</form>
						<form role="form" method="get" action="/First_Web/placa-mae-select" >
							<button type="submit" class="btn btn-primary">Adicionar um computador</button>
						</form>
						<form role="form" method="get" action="/First_Web/confirmar-pedido" >
							<button type="submit" class="btn btn-primary">Finalizar pedido</button>
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