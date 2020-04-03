<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="erro.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>

<form action="login" method="post" >
	Login: <input type="text" name="user" ><br>
	Senha: <input type="password" name="pass"><br>
	<button type="submit">Enviar</button><br>
	<div><c:out value="${erro}"></c:out></div>
</form>

</body>
</html>
<%
		//throw new ServletException("Mandatory Parameter missing");
%>