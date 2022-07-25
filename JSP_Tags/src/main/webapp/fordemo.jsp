<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b> From fordemo.jsp </br> 

 <%--  <%@include file="B.jsp" %><br>  --%>
 
 <%-- <jsp:include page="B.jsp" >
   <jsp:param name="n" value = "Neeraj" />  
</jsp:include>  
  --%>
 <%=request.getParameter("n") %><br>
<%-- <%=a %><br>
<%=sum() %><br>
<%=met() %><br> --%>
<b> End of A.jsp </b> 
</body>
</html>