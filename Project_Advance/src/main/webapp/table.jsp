<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored = "false" %>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.table{
width:80%;
text-align:center;
}
</style>
</head>
<body>
<table border="1" align="center" class="table">
				<tr>
					<th>ID</th> 
					<th>Name</th>
					<th>City</th>
					
				</tr>
				<c:forEach var="student" items="${STUDENTS }">
				<!-- ####IT IS NECCESARY TO TAKE VARIABLE SAME AS POJO CLASS  -->
				<tr>
					<td>${student.sid }</td>
					<td>${student.sname }</td>
					<td>${student.scity}</td>
					
				</tr>
				
				</c:forEach>
			</table>
</body>
</html>