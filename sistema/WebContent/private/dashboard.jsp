<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DashBoard</title>
</head>
<body>

<p><strong>USUARIO:</strong> <%=session.getAttribute("USUARIO")%></p>

<a href="./dashboard.jsp" >Home</a>

<a href="../logout" >Sair</a>

</body>
</html>