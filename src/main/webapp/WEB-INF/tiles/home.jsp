<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
	<div class="row">
		<div class="col-md-6">
			<h1>User Test System</h1>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-md-6">
			<p>
				<a href="showEmployeeForm" class="btn btn-primary btn-lg btn-block">Add a new User</a>
			</p>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-md-6">
			<p>
				<a href="listAllEmployees" class="btn btn-success btn-lg btn-block">List All Users</a>
			</p>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-md-6">
			<p>
				<a href="listAllEmployeeDetails" class="btn btn-success btn-lg btn-block">List All User Details</a>
			</p>
		</div>
	</div>

	<br>
	
	<sec:authorize access="!isAuthenticated()">
		<p><a href="<c:url value='/login' />">Login</a></p>
	</sec:authorize>
	<br>		
	<sec:authorize access="isAuthenticated()">
		<form method="post" action="logout">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<a href="#" onclick="document.forms[0].submit();return false;">Logout</a>
		</form>
	</sec:authorize>
	<br>
	<sec:authorize access="hasRole('ADMIN')">
		<form method="post" action="admin">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<a href="#" onclick="document.forms[1].submit();return false;">Admin</a>
		</form>
	</sec:authorize>
</div>