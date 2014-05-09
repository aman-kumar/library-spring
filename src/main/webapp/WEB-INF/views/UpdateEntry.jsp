<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
	import="com.aman.libraryspring.*,java.sql.*,java.util.*,com.aman.libraryspring.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdateEntry</title>
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
				<br><br>
				<br>
		<table align="left" width="2" border="2" bordercolor="black">
		<caption>
			<h2>Books present in the library</h2>
		</caption>
		<tr>
			<th width="15%">BookId</th>
			<th width="15%">Name</th>
			<th width="15%">Author</th>
			<th width="15%">Publication</th>
			<th width="15%">Description</th>
			<th width="15%">Copies</th>
		</tr>
<%
			List<Book> bookList = new ArrayList<Book>();
			bookList = (ArrayList<Book>)request.getAttribute("BookById");
			//session.setAttribute("Bookname", (ArrayList<Book>)session.getAttribute("name"));
			Book book=bookList.get(0);
			
		%>	
	
		<tr>
		                <td width="15%"><%=book.getBookId()%></td>
						<td width="15%"><%=book.getName()%></td>
						<td width="15%"><%=book.getAuthor()%></td>
						<td width="15%"><%=book.getPublisher()%></td>
						<td width="15%"><%=book.getDescription()%></td>
						<td width="15%"><%=book.getCopies()%></td>
					</tr>
					</table>
					<br><br><br>
					<br>
		<br>
		<br>
		<br>
		
<form method="GET" action="UpdateBookCopies">
<input type="hidden" name="bookId" value="<%=book.getBookId()%>"/>
Copies:<input type="text" name="copies" size="15" >
<button type="submit">Submit</button>
</form>
</body>
</html>