<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BooksEntryPage</title>
<script type="text/javascript">
//validateName
//validateAuthor
//validateDescription
//validatePublisher
//validateCopies

// main function validateInputs
function validateEntry(fld,min,max){
	var error="";
	
	var illegalChars = /^[A-Za-z\s]+$/; // allow letters, numbers, and underscores
	
	 if (fld.value == "") {
	        error = "You didn't enter a value of field: "+fld.name +"\n" ;
	    } else if ((fld.value.length < min) || (fld.value.length > max)) {
	        
 	        error = "The value entered is of wrong length of field: "+fld.name +"\n";
	    } else if (!(illegalChars.test(fld.value))) {
	        
	        error = "The username contains illegal characters.\n "+fld.name;
	    } 
	    return error;	
}
function validateLength(fld){
	var error="";
	var illegalChars = /^[0-9]+$/;
	 if (fld.value == "") {
	        error = "You didn't enter a value of field: "+fld.name +"\n" ;
	    } else if ((fld.value == 0) || (fld.value > 30)) {
	        
 	        error = "The value entered is invalid for: "+fld.name +"\n";
	    } else if (!(illegalChars.test(fld.value))) {
	        
	        error = "The username contains illegal characters.\n "+fld.name;
	    } 
	    return error;	
}
function validateInputs(form){
	var reason="";
	reason+=validateEntry(form.name,2,24);
	reason+=validateEntry(form.author,2,24);
	reason+=validateEntry(form.description,2,52);publisher
	reason+=validateEntry(form.publisher,2,24);
	reason+=validateLength(form.copies);
	if(reason !=""){
		alert("Error in: "+ name +"field value: "+reason);
		return false;
	}
	else{
		return true;
	}
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
				<br>
				<h2>Books Details Entry Page:</h2>
				<form:form name="Bookform" method="POST" action="addBook" onsubmit=" return validateInputs(this)" >
					<table>
						
						<tr>
							<td><form:label path="name">Name<span style="color: red;" >*</span></form:label></td>
							<td><form:input title="name" path="name" size="35" ></form:input></td>
						</tr>
						<tr>
							<td><form:label path="author">Author<span style="color: red;" >*</span></form:label></td>
							<td><form:input  title="author" path="author" size="35"></form:input></td>
						</tr>
						<tr>
							<td><form:label path="description">Description<span style="color: red;" >*</span></form:label></td>
							<td><form:input title="description" path="description" size="35"></form:input></td>
						</tr>
						<tr>
							<td><form:label path="publisher">Publisher<span style="color: red;" >*</span></form:label></td>
							<td><form:input title="publisher" path="publisher" size="35"></form:input></td>
						</tr>
						<tr>
							<td><form:label path="copies">Copies<span style="color: red;" >*</span></form:label></td>
							<td><form:input  title="copies" path="copies" size="35"></form:input></td>
						</tr>
						<tr>
							<td><input type="submit" value="Submit" onclick=""/></td>

						</tr>



					</table>


 				</form:form	>
			</table>
</body>
</html>