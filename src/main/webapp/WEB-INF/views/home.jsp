<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page import="java.util.*"%>
<html>
<head>
<title>Home</title>
</head>

<body>
	<h1>Hello world!</h1>  hi aman 
<%!
List<String> sampleList = new ArrayList<String>();
%> 
<% 
sampleList.add("aman");
sampleList.add("ad");
sampleList.add("abdur");
sampleList.add("aman1");

%>

        
     
	<P>The time on the server is ${serverTime}.</P><br><br>
	 The choices are :<br><br>
<%
Iterator<String> it=sampleList.iterator();

    for(int i=0;i<sampleList.size();i++){
        
       
        
   %>
   <input type="radio" name="group1" value=<%=sampleList.get(i)%>><%=sampleList.get(i)%><br><br><br>
   
   <%     
    }


%>
	
</body>
</html>
