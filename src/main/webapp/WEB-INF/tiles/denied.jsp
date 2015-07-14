<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container">
	<sec:authorize access="!isAuthenticated()">
		<h3>Please login to access the link.</h3>
		<p><a href="<c:url value='/login' />">Login</a></p>
	</sec:authorize>
</div>