<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BooksEntryPage</title>
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
				<br>
				<h2>Books Details Entry Page:</h2>
				<form:form method="POST" action="addBook">
					<table>
						<tr>
							<td><form:label path="bookId">Id</form:label></td>
							<td><form:input path="bookId" size="35"></form:input></td>
						</tr>
						<tr>
							<td><form:label path="name">Name</form:label></td>
							<td><form:input path="name" size="35"></form:input></td>
						</tr>
						<tr>
							<td><form:label path="author">Author</form:label></td>
							<td><form:input path="author" size="35"></form:input></td>
						</tr>
						<tr>
							<td><form:label path="description">Description</form:label></td>
							<td><form:input path="description" size="35"></form:input></td>
						</tr>
						<tr>
							<td><form:label path="publisher">Publisher</form:label></td>
							<td><form:input path="publisher" size="35"></form:input></td>
						</tr>
						<tr>
							<td><form:label path="copies">Copies</form:label></td>
							<td><form:input path="copies" size="35"></form:input></td>
						</tr>
						<tr>
							<td><input type="submit" value="Submit" /></td>
						</tr>

					</table>

				</form:form>
			</table>
</body>
</html>