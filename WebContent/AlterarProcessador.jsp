<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="basic.model.Processador" %>
    <%@ page import="basic.model.Soquete" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Processador</title>
	<link href="bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet">
</head>
<body>
	
	<div class="row">
		<div class="col-md-1">
		</div>
		<div class="col-md-5">
			<%  Processador pS = (Processador)request.getAttribute("processadorProcurado");
				Soquete soq = pS.getSoquete();
			%>
			<h4>Dados atuais do processador</h4>
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
		<div class="col-md-5">
			<h4>Cadastrar novos dados</h4>
			<form style="border-style:none"" method="post" action="/First_Web/AlterarProcessadorController">
				<label for="ID">Novo ID: </label>
				<input  name="ID" type = "text"></input><br>
				<label for="modelo">Novo modelo: </label>
				<input name="modelo" type="text"></input><br>
				<label for="fabricante">Novo fabricante: </label>
				<input name="fabricante" type="text"></input><br>
				<label for="soquete">Novo soquete: </label>
				<input name="soquete" type="text"></input><br>
				<label for="frequencia">Nova frequência: </label>
				<input name="frequencia" type="text"></input><br>
				<label for="preco">Novo preço: </label>
				<input name="preco" type="text"></input><br>
				<button class="btn btn-primary"  type ="submit">Alterar</button>
			</form>
		
		</div>
		<div class="col-md-1">
		</div>
	</div>


</body>
</html>