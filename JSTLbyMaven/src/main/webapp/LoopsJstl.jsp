<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored = "false" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- ###### FOR EACH TAG USED FOR ITERATION ####### -->

<c:forEach var="j" begin="1" end="6">  
   <c:out value="${j}"/><br>
</c:forEach><hr> 
<!-- ##### FORTOKENS USED FOR ITERATION ADDED ONE NEW FEATURE DELIMES'-' ####### -->
 
 <c:forTokens items="Nandita-Neha-Nakul" delims="-" var="name">  
   <c:out value="${name}"/><p>  
</c:forTokens>  
<!-- #####  PARAM ADD THE PARAMETER IN THE CONAINING IMPORT ####### -->
 
<%-- <c:url value="/index.jsp" var="completeURL"/>  
 <c:param name="trackingId" value="786"/>  
 <c:param name="user" value="Nakul"/>  
</c:url>  
${completeURL} --%>


<!-- ##### used for redirecting the browser to an alternate URL  ####### -->

<c:set var="url" value="5" scope="request"/>  
  <c:if test="${url<1}">  
     <c:redirect url="https://mvnrepository.com/"/>  
  </c:if>  
  <c:if test="${url>1}">  
     <c:redirect url="http://facebook.com"/>  
  </c:if>  
  
  <%-- <c:url value="/RegisterService.jsp"/>   --%>