<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
<!--

function onDeleteClick(event) {
	// event.preventDefault();
	// alert("Delete clicked!");
	var doDelete = confirm("Are you sure want to delete this offer?");
	
	if (doDelete == false) {
		event.preventDefault();
	}
}

function onReady() {
	$("#delete").click(onDeleteClick);
}

$(document).ready(onReady);
//-->
</script>
<div class="container">
	<h1>Listing All Users:</h1>
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
					<td>${employee.lname }</td>
					<td>${employee.badgeId}</td>
					<td>${employee.details.emailAddress}</td>
					<td><a id = "delete" class = "delete" href="delete/${employee.employeeId}">Delete</a></td>
				</tr>		
			</c:forEach>
		</table>
	</c:if>
</div>
