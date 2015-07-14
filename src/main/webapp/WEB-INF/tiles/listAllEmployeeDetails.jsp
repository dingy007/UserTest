<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<h1>My Contact List</h1>
		<c:if test="${! empty employeesList}">
			<table  class="table table-striped">
				<tr>
					<th>Employee Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Badge Id</th>
					<th>Employee Email Address</th>
				</tr>
				<c:forEach items="${employeesList}" var="employee">
				<tr>
					<td>${employee.employeeId}</td>
					<td>${employee.fname}</td>
					<td>${employee.lname}</td>
					<td>${employee.badgeId}</td>
					<td>${employee.details.emailAddress}</td>
					<td><a href="delete/${employee.employeeId}">Delete</a></td>
				</tr>		
			</c:forEach>
		</table>
	</c:if>
</div>
