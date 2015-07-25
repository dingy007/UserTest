<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	
	<a href="<c:url value='/uploadFile'/>">Upload File</a>
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
	<br>
	<sec:authorize access="hasRole('ADMIN')"> 
		<a href="<c:url value='/getmessages'/>">Messages(<span id="numberMessages">0</span>)</a>
	</sec:authorize>
	
	<script type="text/javascript">
	<!--
	
	function updateMessageLink(data) {
		$("#numberMessages").text(data.number);
		// alert(data.number);
	}
	function onLoad() {
		// alert("Document loaded.");
		updatePage();
		window.setInterval(updatePage,5000);
	}
	function updatePage() {
		//alert("updating page")
		$.getJSON("<c:url value='/getmessages'/>", updateMessageLink);
	}
	
	$(document).ready(onLoad);
	//-->
	</script>
</div>