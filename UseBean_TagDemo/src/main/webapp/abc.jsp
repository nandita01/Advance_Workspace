<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="obj" class="com.Student"  scope="application"></jsp:useBean>

<jsp:setProperty property="*" name="obj"/>


 <h2>Record of Students</h2>
<%-- Id:<jsp:getProperty property="id" name="obj" /><br>
Name:<jsp:getProperty property="name" name="obj" /><br>
Address:<jsp:getProperty property="address" name="obj" /><br> --%>

 
  <jsp:forward page="display.jsp"/> 
  
  
</body>
</html>