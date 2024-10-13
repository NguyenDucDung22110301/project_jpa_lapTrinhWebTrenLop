<%@page import="java.net.http.HttpRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Demo</title>
</head>
<body>
	<% String rq = (String)request.getAttribute("message"); %>
<div>Apache FileUpload</div>
<div>Servlet Multipart</div>
<form method="post" action="multiPartServlet" enctype="multipart/form-data">
Choose a file: <input type="file" name="multiPartServlet"/>
<h1> <%= rq %></h1>>
<input type="submit" value="Upload"/>
</form>
</br>
</body>


</html>