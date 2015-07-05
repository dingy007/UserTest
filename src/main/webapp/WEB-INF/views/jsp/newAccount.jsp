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
<style>
	.error {
	 color: #ff0000;
	}
	
	.valid {
	color: green;
	}
</style>
<script type="text/javascript">

function onLoad() {
	$("#password").keyup(checkPasswordMatch);
	$("#confirmpass").keyup(checkPasswordMatch);
	$("#details").submit(canSubmit);
}
function canSubmit() {
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();
	
	if(password != confirmpass) {
		alert("Passwords do not match!")
		return false;
	}
	else {
		return true;
	}
	
}
function checkPasswordMatch() {
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();

	if ((password.length < 3) || (confirmpass.length < 3)) {
		return;
	}
	if (password == confirmpass){
		$("#matchpass").text("<fmt:message key='UnmatchedPassword.user.password'/>");
		$("#matchpass").addClass("valid");
		$("#matchpass").addClass("error");
	}
	else {
		$("#matchpass").text("<fmt:message key=\\"MatchedPassword.user.password\\"/>");
		$("#matchpass").removeClass("valid");
		$("#matchpass").addClass("error");
	}
	//alert(password + ":" + confirmpass);
}
$(document).ready(onLoad);
</script>

<form:form method="post" id="details" action="${pageContext.request.contextPath}/createAccount" commandName="user">

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
		<td><form:input path="password" id="password" name="password" type="text" /><br/></td>
		<td><div class="error"><form:errors path="password"></form:errors></div></td>
		
	</tr>
	<tr>
		<td>Confirm Password: </td>
		<td><input class="control" id="confirmpass" name="confirmpass" type="text" /><br/></td>
		<td><div id="matchpass"></div></td>
	</tr>		
	<tr>
		<td><input class="control" value="Create Account" type="submit" /></td>
		<td>
			<input type="reset" value="<spring:message code='label.cancel'/>"name="btnCancel" />
			
		</td>
	</tr>
</table>

</form:form>

<%@ include file="header_footer/footer.jsp" %>