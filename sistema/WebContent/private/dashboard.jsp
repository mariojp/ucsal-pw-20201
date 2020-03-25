<%@page import="br.ucsal.sistema.model.Usuario"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DashBoard</title>
</head>
<body>

<%
Usuario usuario = null;
if (session.getAttribute("USUARIO") != null){
	usuario = (Usuario) session.getAttribute("USUARIO"); 
}
%>

<p><strong>USUARIO:</strong> <%=usuario.getLogin()%></p>

<a href="/sistema/private/dashboard.jsp" >Home</a>

<a href="../logout" >Sair</a>

</body>
</html>