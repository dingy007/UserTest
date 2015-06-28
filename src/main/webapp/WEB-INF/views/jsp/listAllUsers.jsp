<%@ include file="header_footer/header.jsp" %>
<h1>Listing All Users:</h1>
	<c:if test="${! empty usersList}">
		<table>
			<tr>
				<th>User Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Badge Id</th>
				<th>User Email Address</th>
			</tr>
			<c:forEach items="${usersList}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.fname}</td>
					<td>${user.lname }</td>
					<td>${user.badgeId}</td>
					<td>${user.details.emailAddress}</td>
					<td><a href="delete/${user.userId}">Delete</a></td>
				</tr>		
			</c:forEach>
		</table>
	</c:if>
<%@ include file="header_footer/footer.jsp" %>