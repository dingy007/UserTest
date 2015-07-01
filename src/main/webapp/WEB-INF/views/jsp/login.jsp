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
		</style>
	</head>
	<body onload="document.f.username.focus();">
		<div class="container">
			<h3>Login with Username and Password</h3>
			
			<c:if test="${param.error != null }">
				<p>
					<span class="error">Login failed. Check your user-name & password are correct.</span>
				</p>
			</c:if>
			<!-- <form name="f" action="/usertest/login" method="POST"> -->
			<form name="f" action="${pageContext.request.contextPath}/login" method="POST"> 
				<table>
					<tbody>
						<tr>
							<td>User Name:</td><td><input type="text" name="username" value=""></td>
						</tr>
						<tr>
							<td>Password:</td><td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan="2"><input name="submit" type="submit" value="Login"></td>
						</tr>
					   
					</tbody>
				</table>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
		</div>
	</body>
</html>