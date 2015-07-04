<%-- <%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Create New Account</title>
</head>
<body>
 --%>
 <%@ include file="header_footer/header.jsp" %>
<h2>Add a new Account:</h2>

<form:form method="post" action="${pageContext.request.contextPath}/createAccount" commandName="user">

<table class="formtable">
	<tr>
		<td>Username: </td>
		<td><form:input  path="username" name="username" type="text" /><br/></td>
		<td><div class="error"><form:errors path="username"></form:errors></div></td>
	</tr>
	<tr>
		<td>Email: </td>
		<td><form:input   path="email" name="email" type="text" /><br/></td>
		<td><div class="error"><form:errors path="email"></form:errors></div></td>
	</tr>
	<tr>
		<td>Password: </td>
		<td><form:input path="password" name="password" type="text" /><br/></td>
		<td><div class="error"><form:errors path="password"></form:errors></div></td>
		
	</tr>
	<tr>
		<td>Confirm Password: </td>
		<td><input class="control" name="confirmpass" type="text" /><br/></td>
	</tr>		
	<tr>
		<td><input class="control" value="Create Account" type="submit" /></td>
		<td><input type="reset" value="<spring:message code='label.cancel'/>"name="btnCancel" /></td>
	</tr>
</table>

</form:form>

<%@ include file="header_footer/footer.jsp" %>