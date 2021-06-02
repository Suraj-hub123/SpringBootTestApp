<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script src="js/form-validation.js"></script>
</head>
<body>
	<h2>Save Contact</h2>
	<p><font color="green"> ${succMsg}</font></p>
	<p><font color="green"> ${errMsg}</font></p>
	<form:form action="saveContact" modelAttribute="contact" method="POST" >
		<table>
			<tr>
			<form:hidden path="contactId"/>
			
				<td>ContactName</td>
				<td><form:input path="contactName" /></td>
			</tr>

			<tr>
				<td>ContactEmail</td>
				<td><form:input path="contactEmail" /></td>
			</tr>

			<tr>
				<td>ContactNumber</td>
				<td><form:input path="contactNumber" /></td>
			</tr>

			<tr>

				<td><input type="reset" value="Reset" /></td>
				<td><input type="Submit" value="Save" /></td>
			</tr>



		</table>

	</form:form>
	<a href="viewContacts">View All Contacts</a>
	</body>
</html>