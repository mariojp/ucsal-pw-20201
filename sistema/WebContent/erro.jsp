<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Error Page</title>
</head>
<body>

Pagina de Erro:
<c:out value="${response.status}" />



<% if(response.getStatus() == 500){ %>
<font color="red">Error: <%=exception.getMessage() %></font><br>

<%}else {%>

Ocorreu um erro There, codigo  <%=response.getStatus() %><br>
Va para o index<a href="/sistema/index.jsp">voltar</a>
<%} %>
</body>
</html>
