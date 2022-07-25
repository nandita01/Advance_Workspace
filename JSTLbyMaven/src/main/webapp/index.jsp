<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- ###### FOR DECLARE/SET VARIABLES ##### -->
<c:set var="a" value="hello" scope="page"/>
<p>Before Remove Value is:<c:out value="${a}"/></p>
<c:remove var="a"/> 
<p>After Remove Value is: <c:out value="${a}"/></p> <hr> 
<c:set var="Salary" value="${4000*4}" scope="session"/>  
<c:out value="${Salary}"/>  
 

<!-- ###### SAME AS INCLUDE TAG content of any resource either within server or outside the server. ##### -->
<%-- <c:import var="data" url="http://www.javatpoint.com"/>  
<c:out value="${data}"/>   --%>

 <!-- ###### It is used for Catches any Throwable exceptions -->
 <c:catch var ="catchtheException">  
   <% int x = 2/0;%>  
</c:catch>  
  
<c:if test = "${catchtheException != null}">  
   <p>The type of exception is : ${catchtheException} <br />  
   There is an exception: ${catchtheException.message}</p>  
</c:if><hr> 

 <!-- ###### CHHOSE TAG WORKS LIKE A SWITCH -->
   <!-- ###### C:WHEN  TAG FOR TRUE CONDITION -->
    <!-- ###### C:OTHERWISE FOR FALSE CONDITION -->
 <c:set var="income" scope="session" value="${300*2}"/>  
<p>Your income is : <c:out value="${income}"/></p>  
<c:choose>  
    <c:when test="${income <= 1000}">  
       Income is not good.  
    </c:when>  
    <c:when test="${income > 10000}">  
        Income is very good.  
    </c:when>  
    <c:otherwise>  
       Income is undetermined...  
    </c:otherwise>  
</c:choose><hr>

<c:set var="num" value="10" scope="page"></c:set>
 <c:out value="${num}"></c:out>

<p>Even Odd Logic :</p>
<c:choose>
<c:when test="${num%2==0}">
<c:out value="${num} is even number"></c:out>  
</c:when>
<c:otherwise>
<c:out value="${num} is odd number"></c:out>  
</c:otherwise>
</c:choose>