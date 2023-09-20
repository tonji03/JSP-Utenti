
<%@page import="it.dennis.web.model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">

	<%
		Utente u = (Utente)request.getAttribute("utente");
		out.println(u);
	%>

</body>
</html>