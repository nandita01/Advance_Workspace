<html>
<body>
<h2>Hello World!</h2>

	<!-- 	%%%%%%% EXTRA SERVLET CODE 
 -->
 <!-- <form action="Extra" method="get">
 FirstName:<input type="text" name="fname">
LastName:<input type="text" name="lname">
<input type="submit"> 
</form>
-->
 <form action="InsertData" method="get">
        <p>ID:</p> 
        <!-- Create an element with mandatory name attribute,
        so that data can be transfer to the servlet using getParameter() -->
        <input type="text" name="id"/>
        <br/>
        <p>String:</p> 
        <input type="text" name="string"/>
        <br/><br/><br/>
        <input type="submit"/>
    </form>



</body>

</html>
