<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>
<%!
Connection con;
PreparedStatement ps1,ps2;
public void jspInit() 
{
	 try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root","1234");
		//ps1=con.prepareStatement("select count(*) from employee where eid=?");
		ps1=con.prepareStatement("select count(*) from employee");
		ps2=con.prepareStatement("select * from employee");
	     }
	   catch(SQLException e)
	      { e.printStackTrace();} 
	    catch(Exception e)
		   { e.printStackTrace();} 
	
}
%>


<% 
String param= request.getParameter("s1");
%>
<h1><%= param %></h1>
<%
if(param.equals("link"))      // link == link
{
	ResultSet rs= ps2.executeQuery();
	out.println("<table>");
	while(rs.next())
	{
		out.println("<tr>");
		out.println("<td>"+rs.getInt(1)+ "</td>");
		out.println("<td>"  +rs.getString(2)+ "</td>");
		out.println("<td>"  +rs.getString(3)+ "</td>");
		out.println("<td>"  +rs.getString(4)+ "</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	
}
	
	else
	{
		//int ui = Integer.parseInt(request.getParameter("uid"));
		//ps1.setInt(1,ui);
		ResultSet rs= ps1.executeQuery();
		int cnt = 0;
		if (rs.next())
			 cnt=rs.getInt(1);
		//if(cnt==1) 
				out.println(rs.getInt(1));
		
		//out.println(rs.getString(1));
		//out.println(rs.getString(2));
		
	 }
	

%>
