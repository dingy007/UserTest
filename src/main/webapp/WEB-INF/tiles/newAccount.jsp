<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Add a new Account:</h2>
<script type="text/javascript">

function onLoad() {
	$("#password").keyup(checkPasswordMatch);
	$("#confirmpass").keyup(checkPasswordMatch);
	$("#details").submit(canSubmit);
}
function canSubmit() {
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();
	
	if(password != confirmpass) {
		alert("Passwords do not match!")
		return false;
	}
	else {
		return true;
	}
}
function checkPasswordMatch() {
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();

	if ((password.length < 3) || (confirmpass.length < 3)) {
		return;
	}
	if (password != confirmpass){
		$("#matchpass").text("<fmt:message key='UnmatchedPassword.user.password'/>");
		$("#matchpass").removeClass("valid");
		$("#matchpass").addClass("error");
	}
	else {
		$("#matchpass").text("<fmt:message key='MatchedPassword.user.password'/>");
		$("#matchpass").addClass("valid");
		$("#matchpass").removeClass("error");
	}
}

$(document).ready(onLoad);
</script>
<div class="container">
	<form:form method="post" id="details" action="${pageContext.request.contextPath}/createAccount" commandName="user">
		<table class="formtable">
			<tr>
				<td>Username: </td>
				<td><form:input  path="username" name="username" type="text" /><br/></td>
				<td><div class="error"><form:errors path="username"></form:errors></div></td>
			</tr>
			<tr>
				<td>Email: </td>
				<td><form:input   path="email" name="email" type="text" /><br/></td>
				<td><div class="error"><form:errors path="email"></form:errors></div></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><form:input path="password" id="password" name="password" type="password" /><br/></td>
				<td><div class="error"><form:errors path="password"></form:errors></div></td>
				
			</tr>
			<tr>
				<td>Confirm Password: </td>
				<td><input class="control" id="confirmpass" name="confirmpass" type="password" /><br/></td>
				<td><div id="matchpass"></div></td>
			</tr>		
			<tr>
				<td><input class="control" value="Create Account" type="submit" /></td>
				<td>
					<input type="reset" value="<spring:message code='label.cancel'/>"name="btnCancel" />
				</td>
			</tr>
		</table>
	</form:form>
</div>
