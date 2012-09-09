<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.aman.libraryspring.*,java.sql.*,java.util.*,com.aman.libraryspring.domain.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Record Display Page</title>
</head>
<body>
	<%!List<Record> recordList = new ArrayList<Record>();%>

	<table border="2" bordercolor="black">
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
		    Iterator itr = recordList.iterator();
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
	</table>

</body>
</html>