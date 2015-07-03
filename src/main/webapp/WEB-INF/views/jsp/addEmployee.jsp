<%@ include file="header_footer/header.jsp" %>
<!-- <title>Spring - Hibernate Integration - Quotation & Invoice App</title>
</head>
<body>
	<div class="container"> -->
		<h1>Add a New User:</h1>

		<form:form action="addNewEmployee" method="POST" modelAttribute="employee">
		<form:errors/>
			<table>
				<tr>
					<td><spring:message code="label.user_fname" /></td>
					<td><form:input path="fname" size="20" value="UserFname" /></td>
					<td><form:errors path="fname" cssClass="fieldErrors" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.user_lname" /></td>
					<td><form:input path="lname" size="20" value="UserLname" /></td>
					<td><form:errors path="lname" cssClass="fieldErrors" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"
						value="<spring:message code='label.add_user'/>" name="btnSubmit" />
						<input type="reset" value="<spring:message code='label.cancel'/>"name="btnCancel" /></td>
				</tr>
			</table>
		</form:form>
<%@ include file="header_footer/footer.jsp" %>