<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Record Entry Page</title>
</head>
<body>
	<h2>Books Record Entry Page:</h2>
	<form:form method="GET" action="addRecord">

		<table>
			<tr>
				<td><form:label path="bookRecord">BookRecordID</form:label></td>
				<td><form:input path="bookRecord" size="35"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="bookId">BookID</form:label></td>
				<td><form:input path="bookId" size="35"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="status">Status</form:label></td>
				<td><form:input path="status" size="35"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="studentId">StudentID</form:label></td>
				<td><form:input path="studentId" size="60"></form:input></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>

		</table>

	</form:form>


</body>
</html>