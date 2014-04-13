<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StudentEntryPage</title>
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

			<h2>Student Details Entry Page:</h2>
			<form:form method="GET" action="addStudent">

				<table>
				<!--  
					<tr>
						<td><form:label path="studentId">ID</form:label></td>
						<td><form:input path="studentId" size="35"></form:input></td>
					</tr>
					-->
					<tr>
						<td><form:label path="firstName">First Name</form:label></td>
						<td><form:input path="firstName" size="35"></form:input></td>
					</tr>
					<tr>
						<td><form:label path="lastName">Last Name</form:label></td>
						<td><form:input path="lastName" size="35"></form:input></td>
					</tr>
					<tr>
						<td><form:label path="emailId">Email Id</form:label></td>
						<td><form:input path="emailId" size="60"></form:input></td>
					</tr>
					<tr>
						<td><form:label path="address">Address</form:label></td>
						<td><form:input path="address" size="60"></form:input></td>
					</tr>
					<tr>
						<td><form:label path="phoneNumber" >PhoneNumber</form:label></td>
						
						<td><form:input path="phoneNumber" size="11" ></form:input></td>
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