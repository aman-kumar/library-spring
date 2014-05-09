<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
	import="com.aman.libraryspring.*,java.sql.*,java.util.*,com.aman.libraryspring.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function No() {
	 window.location="http://localhost:8080/library-spring/";
		
}
</script>
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


	</td>		
	</tr>

	<form  action="Update">
	<%
			List<Book> bookList = new ArrayList<Book>();
			bookList = (ArrayList<Book>) request.getAttribute("updateBook");
			Book book=bookList.get(0);
			session.setAttribute("name", request.getAttribute("updateBook"));
		%>
		<br><br>
		<b>Book: <%=book.getName()%> is already present,Do you want to update it? <b><br><br>
		<%=book.getBookId() %>
		<%
		if(bookList.size()>0){
			
	%>
	    <input type="hidden" name="bookId" value="<%=book.getBookId()%>"/>
		<button type="submit">Yes</button>
		<button type="button" onclick="No()" >No</button>  
		   
	<%
		}
	%>	
</form>
</body>
</html>