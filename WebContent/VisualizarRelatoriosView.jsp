<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="basic.model.Pedido" %>
	<%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatórios do mês</title>
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
</head>
<body>
	<h3>Aqui estão os relatórios buscados</h3>
	
	<div class = "col-md-2"></div>
	<div class = "col-md-8">
		<%  ArrayList<Pedido> pedidosPorMes = (ArrayList<Pedido>)request.getAttribute("listaDePedidosPorMes");
			for(Pedido pedido: pedidosPorMes)
			{
		%>
			<div>
				<ul>
					<li>
						<label><strong>Data do Pedido:</strong></label>
						<label><%=pedido.getDataDoPedido()%></label>
					</li>
					<li>
						<label><strong>Valor do Pedido:</strong></label>
						<label><%=pedido.getPrecoTotalDoPedido() %></label>
					</li>
					
				</ul>
			</div>
		
		<%}; %>
	
	</div>
	<div class = "col-md-2"></div>
</body>
</html>