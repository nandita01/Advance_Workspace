<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Action</th>
</tr>
<c:forEach var="user" items="${listUser}">
<tr>
<td><c:out value="${user.id}"></c:out></td>
<td><c:out value="${user.name}"></c:out></td>
<td><c:out value="${user.email}"></c:out></td>
<td><a href="edit?id=<c:out value='${user.id}' />">Edit</a>|
	<a href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
</tr>

</c:forEach>
</table>
<a href="<%=request.getContextPath()%>/New">Add New User</a>
</body>
</html>