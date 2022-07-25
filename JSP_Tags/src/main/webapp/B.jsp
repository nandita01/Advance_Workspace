<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b> From B.jsp </b> <br>
  <jsp:include page="fordemo.jsp">
<jsp:param name="n" value="mumbai"/>
</jsp:include> 
 
 <%--  <jsp:forward page="fordemo.jsp" >
   <jsp:param name="n" value = "Neeraj" />  
</jsp:forward>  --%>
<%-- <jsp:include page="fordemo.jsp" >
   <jsp:param name="n" value = "Neeraj" />  
</jsp:include>  
 --%><%-- <%= new java.util.Date() %>
<br>
<b> End of B.jsp </b>  --%>
 <%!
int a=10;
int b=20;
public int sum()
{
	int sum= a+b;
	return sum;
	} 
  public String met()
{
	return "Nandita";
	}
 
%>
</body>
</html>