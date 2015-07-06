<%@ include file="header_footer/header.jsp" %>

		<div class="row">
			<div class="col-md-6">
				<h1>User Test System</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p>
					<a href="showEmployeeForm" class="btn btn-primary btn-lg btn-block">Add a new User</a>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p>
					<a href="listAllEmployees" class="btn btn-success btn-lg btn-block">List All Users</a>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p>
					<a href="listAllEmployeeDetails" class="btn btn-success btn-lg btn-block">List All User Details</a>
				</p>
			</div>
		</div>
		
		<%-- <p><a href="<c:url value='/j_spring_security_logout' />">Log out</a></p> --%>
		<%-- <p><a href="<c:url value='/logout' />">Log out</a></p> --%>
		
		<form method="post" action="logout">
			<%-- <p><a href="<c:url value='/logout' />">Log out</a></p> --%>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<!-- <button formaction="logout" type="submit" name="your_name" value="your_value">Logout</button> -->
			<!-- onclick="document.forms[0].submit();return false;" -->
			<a href="#" onclick="document.forms[0].submit();return false;">Logout</a>
		</form>
		<br>
		<form method="post" action="admin">
			<%-- <p><a href="<c:url value='/logout' />">Log out</a></p> --%>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<!-- <button formaction="logout" type="submit" name="your_name" value="your_value">Logout</button> -->
			<!-- onclick="document.forms[0].submit();return false;" -->
			<a href="#" onclick="document.forms[1].submit();return false;">admin</a>
		</form>
		
		<%@ include file="header_footer/footer.jsp" %>