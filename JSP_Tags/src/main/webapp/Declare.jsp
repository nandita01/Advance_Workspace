<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  @@@@@@@@@@@ DECLARATIVE STANDARD TAG @@@@@@@@@@@ -->
<%!
int a=20;
int b=40;
public int add()
{
	return a+b;
	}
%>
<%-- <%=add() %> --%>
<!--  @@@@@@@@@@@ DECLARATIVE XML TAG @@@@@@@@@@@ -->
<%-- <jsp:declaration>

int a=40;
int b=60;
public int sub()
{
	return a-b;
	}
</jsp:declaration> 
<%=sub() %> --%>
<% 

out.println(add());

%>

</body>
</html>