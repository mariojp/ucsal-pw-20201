<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DashBoard</title>
<jsp:useBean id="usuario" class="br.ucsal.sistema.model.Usuario" scope="session"></jsp:useBean>
</head>
<body>


<p><strong>USUARIO:</strong><c:out value="${usuario.login}" /></p>

<a href="/sistema/private/dashboard.jsp" >Home</a>
<a href="/sistema/private/usuarios" >Listar Usuarios</a>
<a href="/sistema/private/usuarios/form" >Inserir Usuario</a>
<a href="../logout" >Sair</a>



</body>
</html>