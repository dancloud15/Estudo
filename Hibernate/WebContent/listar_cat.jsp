<%@page import="br.com.nakabar.DB.Categoria"%>
<%@page import="br.com.nakabar.DB.CategoriaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function apagar(id) {
		if (window.confirm ("Deseja realmente apagar essa categoria?")){
			window.location = 'http://localhost:8080/Hibernate/Categoria?delete=' +id;
		}
		
	}

</script>
</head>
<body>

<table width="100%" border="1">
	<tr bgcolor="#c0c0c0">
		<td>ID</td>
		<td>Nome</td>
		<td>Apagar</td>
		<td>Editar</td>
	</tr>
	<%
		CategoriaDAO dao = new CategoriaDAO();
		for (Categoria cat :dao.exibir()){
		
	%>
	<tr>
		<td><%=cat.getId()%></td>
		<td><%=cat.getNome()%></td>
		<td><a href="#" onclick="apagar('<%=cat.getId() %>')" >X</a></td>
		<td><a href="editar_cat.jsp?id=<%=cat.getId()%>">EDITAR</a></td>
	</tr>
	<%} %>
</table>
<br>
	<a href="novo.jsp" bgcolor=#315e8a;>Novo Cliente</a><br>
	<a href="novo_cat.jsp" bgcolor=#315e8a;>Nova Categoria</a>

</body>
</html>