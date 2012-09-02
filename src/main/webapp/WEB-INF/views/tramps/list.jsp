<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/tramps.css"/>" rel="stylesheet" type="text/css" media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Listing the tramps</title>
</head>
<body>
	<div class="container">
		<h1>Tramps of the new zealand</h1>
		<c:if test="${not empty tramps }">
			<table class="normal-table">
				<thead>
					<tr>
						<th>Key</th>
						<th>Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tramp" items="${tramps }">
						<tr>
							<td>${tramp.key }</td>
							<td>${tramp.value }</td>
						</tr>

					</c:forEach>

				</tbody>


			</table>

		</c:if>

	</div>
	<h1>Hi aman how are u</h1>
	<% String aman="hello guyz"; %>
	<%=aman %>
	<a href="home.jsp" >formlink</a>
</body>
</html>