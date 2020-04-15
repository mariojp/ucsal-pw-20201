<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Usuarios</title>
</head>
<body>
<p><strong>USUARIO:</strong><c:out value="${usuario.login}" /></p>

<a href="/sistema/private/dashboard.jsp" >Home</a>
<a href="/sistema/private/usuarios" >Listar Usuarios</a>
<a href="/sistema/private/usuarios/form" >Inserir Usuario</a>
<a href="../logout" >Sair</a>


<h1>USUARIOS</h1>
<table class="table" >
<tr>
<th> LOGIN </th>
<th> PAPEL </th>
<th> AÇÕES </th>
 
</tr>

<c:forEach var="u" items="${lista}">
<tr>
 <td> ${u.login} </td>
 <td> ${u.papel.nome} </td>
 <td> <a href="/sistema/private/usuarios/delete?id=${u.id}">EXCLUIR</a>
 	  <a href="/sistema/private/usuarios/form?id=${u.id}">EDITAR</a></td>
 
 
<tr>
</c:forEach>
</table>

</body>
</html>