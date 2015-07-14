<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<script type="text/javascript">
		function setFocus() {
			document.f.username.focus();
		}
		
		$(document).ready(setFocus);
	</script>
		<div class="container">
			<h3>Login with Username and Password</h3>
			<br>
			<c:if test="${param.error != null }">
				<p>
					<span class="loginerror">Login failed. Check your user-name &amp; password are correct.</span>
				</p>
			</c:if>
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
							<td>Remember Me </td>
							<td><input type="checkbox" name="remember-me" checked="checked"></td>
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