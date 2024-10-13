<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% User us =  (User)session.getAttribute("account");
	%>
	<% if(us != null){ %>
		<h1> chào anh <%= us.getFullName() %> </h1>
	<% } else {%>
		<h1> chua co khach hang </h1>
	<%} %>
</body>
</html>