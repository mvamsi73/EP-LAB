<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.*" %>
    <%@ page import="DAO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<% String name=request.getParameter("name");
   String email=request.getParameter("email");
   long phone=Long.parseLong(request.getParameter("phnum"));
   String password=request.getParameter("pass");
   registrationbean rb=new registrationbean();
   rb.setName(name);
   rb.setEmail(email);
   rb.setPhone(phone);
   rb.setPassword(password);
   DAO d=new DAO();
   d.insert(rb);
%>
<h1 align="center">Welcome <%=name %> Your Registration is Successful</h1>
</body>
</html>