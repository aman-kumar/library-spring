<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*,com.aman.libraryspring.dao.*,com.aman.libraryspring.domain.*,com.aman.libraryspring.controller.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IssueDetailsPage</title>
</head>
<body>
	<table border="0">
		<tr>
			<td>
				<table align="left" width="2" border="3" bordercolor="black">
					<tr>
						<th width="35%"><a href="StudentDetailsEnterForm">StudentEntryPage</a></th>


						<th width="35%"><a href="SearchBookForm">SearchBook</a><br></th>


						<th width="35%"><a href="BookEntryPage">BookEntry</a><br></th>
					</tr>

				</table>
			</td>
		</tr>
		<tr>
			<td><%!List<Record> recordList = new ArrayList<Record>();%>

				<table align="left" border="2" bordercolor="black">
					<caption>
						<h4>BookRecord details</h4>
					</caption>
					<tr>
						<th width="15%">ID</th>
						<th width="15%">Book ID</th>
						<th width="15%">Status</th>
						<th width="15%">Student Id</th>
					</tr>
					<%
						recordList = (ArrayList<Record>) request.getAttribute("recordList");
						Iterator<Record> itr = recordList.iterator();
						while (itr.hasNext()) {
							Record record = (Record) itr.next();
					%>
					<tr>
						<td width="15%"><%=record.getBookRecord()%></td>
						<td width="15%"><%=record.getBookId()%></td>
						<td width="15%"><%=record.getStatus()%></td>
						<td width="15%"><%=record.getStudentId()%></td>
					</tr>
					<%
						}
					%>
				</table> <br> <br> <br> <br> <br> <br></td>
		</tr>
	</table>

</body>
</html>