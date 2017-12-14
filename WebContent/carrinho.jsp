<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="basic.model.DiscoRigido" %>
<%@ page import="basic.model.Memoria" %>
<%@ page import="basic.model.TipoDeMemoria" %>
<%@ page import="basic.model.PlacaMae" %>
<%@ page import="basic.model.Processador" %>
<%@ page import="basic.model.Soquete" %>
<%@ page import="basic.model.Pedido" %>
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
							Pedido pedido = (Pedido) request.getAttribute("pedido");
							ArrayList<ItemDePedido> listaDeItens = (ArrayList<ItemDePedido>) request.getAttribute("listaDeItens");
							if (!listaDeItens.isEmpty()) {
								for (ItemDePedido item : listaDeItens) {
									if (item.getProduto() instanceof PecaDeComputador) {
										PecaDeComputador peca = (PecaDeComputador) item.getProduto();
										if (peca instanceof PlacaMae) {
											PlacaMae placaMae = (PlacaMae) peca;
						%>
						<div class="row">
							<div class="produto col-md-8">
								<h4>Placa Mãe</h4>
								<p>
								<label>Modelo</label>
								<%= placaMae.getModelo() %>
								</p>
								<p>
								<label>Fabricante</label>
								<%= placaMae.getFabricante() %>
								</p>
								<p>
								<label>Tipo de memória</label>
								<%= placaMae.getTipoDeMemoria().getNome() %>
								</p>
								<p>
								<label>Slots</label>
								<%= placaMae.getSlots() %>
								</p>
							</div>
							<div class="quantos col-md-2">
								<p>
								<label>Preço</label>
								<%= placaMae.getPreco() %>
								</p>
								<p>
								<label>Quantidade</label>
								<%= item.getQuantidade() %>
								</p>
							</div>
						</div>
						<%
									}
									else if (peca instanceof Processador) {
										Processador processador = (Processador) peca;
						%>
						<div class="row">
							<div class="produto col-md-8">
								<h4>Processador</h4>
								<p>
								<label>Modelo</label>
								<%= processador.getModelo() %>
								</p>
								<p>
								<label>Fabricante</label>
								<%= processador.getFabricante() %>
								</p>
								<p>
								<label>Frequência</label>
								<%= processador.getFrequencia() %>
								</p>
								<p>
								<label>Soquete</label>
								<%= processador.getSoquete().getNome() %>
								</p>
							</div>
							<div class="quantos col-md-2">
								<p>
								<label>Preço</label>
								<%= processador.getPreco() %>
								</p>
								<p>
								<label>Quantidade</label>
								<%= item.getQuantidade() %>
								</p>
							</div>
						</div>
						<%
									}
									else if (peca instanceof Memoria) {
										Memoria memoria = (Memoria) peca;
						 %>
						<div class="row">
							<div class="produto col-md-8">
								<h4>Memória</h4>
								<p>
								<label>Fabricante</label>
								<%= memoria.getFabricante() %>
								</p>
								<p>
								<label>Tipo de memória</label>
								<%= memoria.getTipoDeMemoria().getNome() %>
								</p>
								<p>
								<label>Frequência</label>
								<%= memoria.getFrequencia() %>
								</p>
							</div>
							<div class="quantos col-md-2">
								<p>
								<label>Preço</label>
								<%= memoria.getPreco() %>
								</p>
								<p>
								<label>Quantidade</label>
								<%= item.getQuantidade() %>
								</p>
							</div>
						</div>
						<%
									}
									else if (peca instanceof DiscoRigido) {
										DiscoRigido discoRigido = (DiscoRigido) peca;
						 %>
						<div class="row">
							<div class="produto col-md-8">
								<h4>Disco Rígido</h4>
								<p>
								<label>Tipo</label>
								<%= discoRigido.getTipo() %>
								</p>
								<p>
								<label>Fabricante</label>
								<%= discoRigido.getFabricante() %>
								</p>
								<p>
								<label>Tamanho</label>
								<%= discoRigido.getTamanho() %>
								</p>
							</div>
							<div class="quantos col-md-2">
								<p>
								<label>Preço</label>
								<%= discoRigido.getPreco() %>
								</p>
								<p>
								<label>Quantidade</label>
								<%= item.getQuantidade() %>
								</p>
							</div>
						</div>
						<%
									}
								}
								else if (item.getProduto() instanceof Computador) {
									Computador computador = (Computador) item.getProduto();
						 %>
						 <div class="row">
							<div class="produto col-md-8">
								<h4>Computador</h4>
								<label>Placa Mãe</label>
								<%= computador.getPm().getFabricante() %>
								<label>Memória</label>
								<% if(computador.getMem1() != null) { %>
								<%= computador.getMem1().getFabricante() %>
								<% } if(computador.getMem2() != null) { %>
								<%= computador.getMem2().getFabricante() %>
								<% } if(computador.getMem3() != null) { %>
								<%= computador.getMem3().getFabricante() %>
								<% } if(computador.getMem3() != null) { %>
								<%= computador.getMem3().getFabricante() %>
								<% } %>
								<label>Disco Rígido</label>
								<% if(computador.getHd1() != null) { %>
								<%= computador.getHd1().getFabricante() %>
								<% } if(computador.getHd2() != null) { %>
								<%= computador.getHd2().getFabricante() %>
								<% } %>
								<label>Processador</label>
								<%= computador.getProc().getFabricante() %>
							</div>
							<div class="quantos col-md-2">
								<label>Preço</label>
								<%= computador.calculaPreco() %>
								<label>Quantidade</label>
								<%= item.getQuantidade() %>
							</div>
						</div>
						<% 
									}
								}
							} else {
						 %>
							<div class="row" >
							<div class="col-md-1"></div>
							<div class="col-md-10">
							Carrinho Vazio!
							</div>
							<div class="col-md-1"></div>
						</div>
					</div>
					
					<% } if (pedido != null) { %>
					<div class="row" >
						<div class="col-md-4"></div>
						<div class="col-md-4"></div>
						<div class="col-md-4">
						<p>
						<label>Desconto aplicado:</label>
						<%= 100 * pedido.getDesconto() %>%
						</p>
						<p>
						<label>Valor Total do Pedido:</label>
						R$ <%= pedido.getPrecoTotalDoPedido() %>
						</p>
						</div>
					</div>
					<% } %>
					
					<div class="row" >
						<div class="col-md-4">
							<form role="form" method="get" action="/First_Web/pecas-avulsas" >
							<button type="submit" class="btn btn-primary">Adicionar mais peças</button>
						</form>
						</div>
						<div class="col-md-4">
							<form role="form" method="get" action="/First_Web/placa-mae-select" >
							<button type="submit" class="btn btn-primary">Adicionar um computador</button>
						</form>
						</div>
						<div class="col-md-4">
							<form role="form" method="get" action="/First_Web/confirmar-pedido" >
							<button type="submit" class="btn btn-primary">Finalizar pedido</button>
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