<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login Failed | Hello World Struts application in Eclipse</title>
    </head>
    <body>
   
    	<% String error = (String) request.getAttribute("error");
    	if (error.equals("error1")) {
    		String username = (String) request.getAttribute("username"); %>  	   
        	<h1>La password inserita per l'utente <%=username %> non è corretta!</h1>
        <% } else { %>
        	<h1>I dati inseriti non sono validi!</h1>
        <% } %>
        <a href="javascript:history.back()">Back</a>
    </body>
</html>