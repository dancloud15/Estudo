<%@page import="br.com.nakabar.DB.CategoriaDAO"%>
<%@page import="br.com.nakabar.DB.Categoria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	Categoria cat =null;

	if (request.getParameter("id") != null) {
		CategoriaDAO dao = new CategoriaDAO();
		cat = dao.getById(Integer.parseInt(request.getParameter("id")));
		System.out.println(cat.getId());
		System.out.println(cat.getNome());

	} else {
		response.sendRedirect("index.jsp");
	}
	
	
%>

<form action="http://localhost:8080/Hibernate/Categoria?update=<%=cat.getId() %>" method="post">

	Nome: <br/><input type="text" name="txtNome" value="<%=cat.getNome()%>">
	
	<br><br/>
	
	<input type="submit" value="Cadastrar">
	
</form>

</body>
</html>