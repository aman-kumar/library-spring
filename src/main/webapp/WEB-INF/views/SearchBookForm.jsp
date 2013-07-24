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
	<table align="left" border="0">
		<tr>
			<table align="left" width="2" border="3" bordercolor="black">
				<tr>
					<th width="35%"><a href="StudentDetailsEnterForm">StudentEntryPage</a></th>
					<th width="35%"><a href="SearchBookForm">SearchBook</a><br></th>
					<th width="35%"><a href="BookEntryPage">BookEntry</a><br></th>
				</tr>
				</tr>
			</table>
		</tr>
		<br>
		<tr>
			<h2>Search Book Page:</h2>
			<form:form method="POST" action="searchBook">

				<table>
					<tr>
						<td><form:label path="book.name">Name</form:label></td>
						<td><form:input path="book.name" size="35"></form:input></td>
					</tr>
					<tr>
						<td><form:label path="book.author">Author</form:label></td>
						<td><form:input path="book.author" size="35"></form:input></td>
					</tr>
					<tr>
					<tr>
						<td><form:label path="student.firstName">First Name</form:label></td>
						<td><form:input path="student.firstName" size="35"></form:input></td>
					</tr>
					<tr>
						<td><form:label path="student.lastName">Last Name</form:label></td>
						<td><form:input path="student.lastName" size="35"></form:input></td>
					</tr>

					<tr>
						<td><input type="submit" value="Submit" /></td>
					</tr>

				</table>

			</form:form>
		</tr>
	</table>
</body>
</html>

