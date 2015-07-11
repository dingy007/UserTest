<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Not Permitted to view the Page.</title>
</head>
<body>
		<sec:authorize access="!isAuthenticated()">
			<h3>Please login to access the link.</h3>
			<p><a href="<c:url value='/login' />">Login</a></p>
		</sec:authorize>
</body>
</html>