<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Properties properties = new Properties();
		properties.setProperty("javax.persistence.schema-generation.database.action", "create");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("supernaturalPU", properties);
		out.println("Eu desisto");
	%>
</body>
</html>