<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Book Page</title>
</head>
<body>
	<h2>Search Book Page:</h2>
	<form:form method="POST" action="searchBook">

		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" size="35"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="author">Author</form:label></td>
				<td><form:input path="author" size="35"></form:input></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>

		</table>

	</form:form>


</body>
</html>