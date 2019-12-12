<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="./css/commons.css" />
<title>librarians</title>
</head>
<body>
	<h1>librarians</h1>
<table style=" border-style: solid; border-width:1px; width: 600px; border-collapse: collapse;">

<c:forEach var="librarian" items="${librarians}">
	<tr>
		<td>${librarian.id}</td>
		<td>${librarian.firstName}</td>
		<td>${librarian.lastName}</td>
		<td>${librarian.phoneNumber}</td>
	</tr>
</c:forEach>
</table>
<a href="index.jsp">return</a>
</body>
</html>
