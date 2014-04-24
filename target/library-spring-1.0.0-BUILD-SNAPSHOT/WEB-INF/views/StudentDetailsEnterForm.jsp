<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StudentEntryPage</title>
<script type="text/javascript">
function validateEntry(fld,min,max){
	var error="";
	
	var illegalChars = /^[A-Za-z\s]+$/; // allow letters
	
	 if (fld.value == "") {
	        error = "You didn't enter a value of field: "+fld.name +"\n" ;
	    } else if ((fld.value.length < min) || (fld.value.length > max)) {
	        
 	        error = "The value entered is of wrong length of field: "+fld.name +"\n";
	    } else if (!(illegalChars.test(fld.value))) {
	        
	    	error = "\n Field: "+ fld.name +"contains illegal characters.\n ";
	    } 
	    return error;	
}
function validateLength(fld){
	var error="";
	var illegalChars = /^[0-9]+$/;
	 if (fld.value == "") {
	        error = "You didn't enter a value of field: "+fld.name +"\n" ;
	    } else if ((fld.value == 0) || (fld.value.length > 7)) {
	        
 	        error = "The value entered is invalid for: "+fld.name +"\n";
	    } else if (!(illegalChars.test(fld.value))) {
	        
	    	error = "\n  Field: " + fld.name + " contains illegal characters.\n ";
	    } 
	    return error;	
}
function validateEmail(fld)
{
 var error="";
   var emailID = fld.value;
   atpos = emailID.indexOf("@");
   
   dotpos = emailID.lastIndexOf(".");
   if(fld.value == ""){
	   error="Empty email ID Field";
   }
   else if (atpos < 1 || ( dotpos - atpos < 2 )) 
   {
	   error="Please enter correct email ID";
   }
   return error;
}
function validateInputs(form){
	var reason="";
	reason+=validateEntry(form.firstName,2,24);
	reason+=validateEntry(form.lastName,2,24);
	reason+=validateEmail(form.emailId);
	reason+=validateEntry(form.address,2,50);
	reason+=validateLength(form.phoneNumber);
	if(reason !=""){
		alert("\n Error in data entered "+reason +"\n");
		
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
		</tr>
		<br>
		<tr>

			<h2>Student Details Entry Page:</h2>
			<form:form name="studentForm" method="POST" action="addStudent" onsubmit="return validateInputs(this)" >

				<table>
				
					<tr>
						<td><form:label path="firstName">First Name<span style="color: red;" >*</span></form:label></td>
						<td><form:input title="firstName" path="firstName" size="35"></form:input></td>
					</tr>
					<tr>
						<td><form:label path="lastName">Last Name<span style="color: red;" >*</span></form:label></td>
						<td><form:input title="lastName" path="lastName" size="35"></form:input></td>
					</tr>
					<tr>
						<td><form:label path="emailId">Email Id<span style="color: red;" >*</span></form:label></td>
						<td><form:input title="emailId" path="emailId" size="60"></form:input></td>
					</tr>
					<tr>
						<td><form:label path="address">Address<span style="color: red;" >*</span></form:label></td>
						<td><form:input title="address" path="address" size="60"></form:input></td>
					</tr>
					<tr>
						<td><form:label path="phoneNumber" >PhoneNumber<span style="color: red;" >*</span></form:label></td>
						
						<td><form:input title="phoneNumber" path="phoneNumber" size="11" ></form:input></td>
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