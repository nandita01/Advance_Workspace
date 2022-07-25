<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- ################# STANDARD TAG ############### -->
<% 
int a=10;
int b=20;
if(a<b)
	out.println("A is smaller");
else
	out.println("B is greater");
%> --%>
<!-- ################# XML TAG ############### -->
<%-- 
<jsp:scriplet>
int a=10;
int b=20;
if(a<b)
	out.println("A is smaller");
else
	out.println("B is greater");
</jsp:scriplet> --%>

<!--***************** IN XML (<) IS ASSUME AS STARTING TAG SO WE WILL GET ERROR WE SOLVE THIS PROBLEM BY "<![CDATA[  ]]>"-->

<jsp:scriptlet>
<![CDATA[
int g=40;
int h=60;
if(g<h)
	out.println("g is smaller");
else
	out.println("h is greater");
	]]>
</jsp:scriptlet> 

</body>
</html>