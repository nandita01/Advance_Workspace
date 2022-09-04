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
<c:if test="${user != null}">
		<form action="update" method="post">
</c:if>
<c:if test="${user == null}">
		<form action="insert" method="post">
</c:if>
<c:if test="${user != null}">
	<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
</c:if>

Name:<input type="text" name="name" value="<c:out value='${user.name}' />">
Email:<input type="text" name="email" value="<c:out value='${user.email}' />" >
<input type="submit" value="submit">



</form>
</body>
</html>