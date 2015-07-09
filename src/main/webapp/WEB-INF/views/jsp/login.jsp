<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link type="text/css" href="css/bootstrap.css" rel="stylesheet" />
	<head>
		<title>Login Page</title>
		<style>
			.error {
			 color: #ff0000;
			 background-color: #ffEEEE;
			 border: 3px solid #ff0000;
			 padding: 8px;
			 margin: 16px;
			}
			td {
				padding: 5px;
			    vertical-align: center;
			}
			.table_buttons {
				padding: 15px;
			}
		</style>
	</head>
	<body onload="document.f.username.focus();" >
		<div class="container">
			<h3>Login with Username and Password</h3>
			<br>
			<c:if test="${param.error != null }">
				<p>
					<span class="error">Login failed. Check your user-name &amp; password are correct.</span>
				</p>
			</c:if>
			<!-- <form name="f" action="/usertest/login" method="POST"> -->
			<br>
			<form name="f" action="${pageContext.request.contextPath}/login" method="POST"> 
				<table>
					<tbody>
						<tr>
							<td>User Name:</td>
							<td><input type="text" name="username"></td>
						</tr>
						
						<tr>
							<td>Password:</td>
							<td><input type="password" name="password"></td>
						</tr>
						
						<tr>
							<td class="table_buttons"><input name="submit" type="submit" value="Login"></td>
							<td class="table_buttons"><input name="btnCancel" type="reset"></td>
						</tr>
					   
					</tbody>
				</table>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			<br>
			<p> <a href="<c:url value="/newAccount"/>">Create new account</a> 
			</p>
		</div>
	</body>
</html>