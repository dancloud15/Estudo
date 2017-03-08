<%@page import="br.com.nakabar.DB.Categoria"%>
<%@page import="br.com.nakabar.DB.CategoriaDAO"%>
<%@page import="br.com.nakabar.DB.Cliente"%>
<%@page import="br.com.nakabar.DB.ClienteDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Cliente</title>
</head>
<body>
<%
	Cliente cliente = null;

	if(request.getParameter("id") != null){
		ClienteDAO dao = new ClienteDAO();
		cliente = dao.getById(Integer.parseInt(request.getParameter("id")));
	}else{
		response.sendRedirect("index.jsp");
	}


%>


<form action="http://localhost:8080/Hibernate/Cliente?update=<%=cliente.getId() %>" method="POST">
	Nome: <br/><input type="text" name="txtNome" value="<%=cliente.getNome()%>"><br>
	Sobrenome: <br/><input type="text" name="txtSobrenome" value="<%=cliente.getSobrenome()%>">
	<br>
	Categoria: <br>
	
	<select name="cbCat">
		<option value ="0"> --  Selecione -- </option>
		<%
		CategoriaDAO dao = new CategoriaDAO();
		for(Categoria cat: dao.exibir()){		
		%>
			<option <%if (cliente.getCat().getId() == cat.getId()){
				out.println("selected ='selected'");
			}
			
			%>value="<%=cat.getId()%>"><%=cat.getNome() %></option>
	
		<%
		}
		%>
	
	</select>
	
	
	<input type="submit" value="Atualizar">




</form>

</body>
</html>