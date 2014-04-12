<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*,com.aman.libraryspring.dao.*,com.aman.libraryspring.domain.*,com.aman.libraryspring.controller.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Display Result</title>
<script type="text/javascript">
function submitForm(){
	/*var radioButtonSelectedValue = "";
	var AllFormElements = window.document.getElementById("recordForm").elements;
    for (i = 0; i < AllFormElements.length; i++) 
    {
        if (AllFormElements[i].type == 'radio') 
        {
            var ThisRadio = AllFormElements[i].name;
            var ThisChecked = 'No';
            var AllRadioOptions = document.getElementsByName(ThisRadio);
            for (x = 0; x < AllRadioOptions.length; x++)
            {
                 if (AllRadioOptions[x].checked && ThisChecked == 'No')
                 {
                     ThisChecked = 'Yes';
                     radioButtonSelectedValue = AllRadioOptions[x].value;
                     break;
                 } 
            }   
            var AlreadySearched = ShowAlert.indexOf(ThisRadio);
            if (ThisChecked == 'No' && AlreadySearched == -1)
            {
            ShowAlert = ShowAlert + ThisRadio + ' radio button must be answered\n';
            }     
        }	
        document.forms["recordForm"]["selectedRecord"].value = radioButtonSelectedValue;*/
	document.forms[0].submit();
}
</script>
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
<td><%!int copies;
	Record record;
	String status;%>


				<table align="left" width="2" border="3" bordercolor="black">
					<tr>
						<th width="15%">BookRecordId</th>
						<th width="15%">BookId</th>
						<th width="15%">Status</th>
						<th width="15%">StudentId</th>
					</tr>
					<%
						boolean bookAvailable = false;
						List<Record> recordList = (ArrayList<Record>) request
								.getAttribute("recordList"); // pwm.println("The book has been located in the database");
						int recordListSize = 0;
						if (recordList != null && recordList.size() > 0) {
					%>
					<form name="recordForm" action="Issue">
						<%
							recordListSize = recordList.size();
								Iterator<Record> itr = recordList.iterator();
								while (itr.hasNext()) {
									record = (Record) itr.next();
						%>

						<tr>
							<td width="15%"><input type="radio"
								name=<%=record.getBookRecord()%> value=><%=record.getBookRecord()%>
							</td>
							<td width="15%"><%=record.getBookId()%></td>
							<td width="15%"><%=record.getStatus()%></td>
							<td width="15%"><%=record.getStudentId()%></td>

						</tr>
						<%
							//copies=book.getCopies();
									status = record.getStatus();
									if ("available".equals(status)) {
										bookAvailable = true;
									}

								}

							}
						%>
						<input name="selectedRecord" type="hidden" value="">
					


				</table> <%
 	if (bookAvailable) {
 %> <br> <br> <br> The book can be issued <br> <br>
				<input type="submit" name="submitRecordForm" onClick="submitForm()"> <%
 	} else {
 %> The book cannot be issued <br> <%
 	}
 %>
 </form>
		</tr>
	</table>

</body>
</html>

