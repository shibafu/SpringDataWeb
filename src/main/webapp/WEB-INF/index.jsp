<!DOCTYPE html>

<%@ page import="java.util.List" %>
<%@ page import="com.tsugaruinfo.model.Mypersonaldata" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>JPA Sample1</title>
	</head> 
	<body>
		<h1>Welcome to JPA Sample!</h1>
		
		<form method="post" action="person">
		<table>
			<tr><td>Name:Input<input type ="text" name="name"></td></tr>
			<tr><td>Mail:Input<input type ="text" name="mail"></td></tr>
			<tr><td>Age:Input<input type ="text" name="age"></td></tr>
			<tr><td><input type ="submit" value="追加"></td></tr>
		</table>
		</form>
		<c:url value="/showMessage.html" var="messageUrl" />
		<a href="${messageUrl}">Click to enter</a>
		<ol>
		 
			<% for(Object entity : (List)request.getAttribute("entities")){ %>
				<li><%=entity %></li>
			<% } %>
		</ol>
	</body>
</html>
