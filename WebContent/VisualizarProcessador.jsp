<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="basic.model.Processador" %>
    <%@ page import="basic.model.Soquete" %>
	<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizar processador</title>

	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
</head>

<body>
	
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<%  Processador pS = (Processador)request.getAttribute("processadorProcurado");
				Soquete soq = pS.getSoquete();
			%>
			
			<h4>Dados do processador selecionado</h4>
			<ul>
				<li>
					<label><strong>ID: </strong></label>
					<label><%=pS.getId()%></label>
				</li>
				<li>
					<label><strong>Modelo: </strong></label>
					<label><%=pS.getModelo()%></label>
				</li>
				<li>
					<label><strong>Fabricante: </strong></label>
					<label><%=pS.getFabricante()%></label>
				</li>
				<li>
					<label><strong>Soquete: </strong></label>
					<label><%=soq. getNome()%></label>
				</li>
				<li>
					<label><strong>Frequência: </strong></label>
					<label><%=pS.getFrequencia()%></label>
				</li>
				
				<li>
					<label><strong>Preço: </strong></label>
					<label><%=pS.getPreco()%></label>
				</li>
			</ul>
		</div>
		
		<div class="col-md-2"></div>
		</div>
	
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			
			
		</div>
		<div class="col-md-1"></div>
	</div>
	
</body>

</html>