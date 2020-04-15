<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
</head>
<body>

<form action="/sistema/private/usuarios/salvar" method="post">
	<input type="hidden" name="id" value="${cadastro.id}">
	Login: <input type="text" name="login"value="${cadastro.login}" ><br>
	Senha: <input type="password" name="senha" value="${cadastro.senha}"><br>
	Papel: <select name="papel" >
			<option value="" selected>Selecione</option>
			<c:forEach var="papel" items="${lista}">
				<option ${papel.id == cadastro.papel.id ? 'selected="selected"' : ''} value="${papel.id}">${papel.nome}</option>
			</c:forEach>
		</select>

	<br>
	
	
	<button type="submit">Enviar</button><br>


</form>

</body>
</html>