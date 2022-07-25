package com.pp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/SimpleIn")
public class SimpleIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
//		int id=Integer.parseInt(request.getParameter("id"));
//		String string = request.getParameter("string");
//		pw.println(id);
//  	pw.println(string);
		pw.print("<h1>Display the record</h1>");
		pw.print("<table border=1><tr><th>Id</th><th>String</th></tr>");
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdemo","root","1234");
		//	PreparedStatement ps = con.prepareStatement("select * from demo where id=?");
			//PreparedStatement ps = con.prepareStatement("insert into demo values(?, ?)");
			//PreparedStatement ps = con.prepareStatement("update  demo set string=? where id = ?");
		//	ps.setInt(1, id);
			Statement st = con.createStatement();			
		    ResultSet rs = st.executeQuery("select * from demo");
		    while (rs.next())
		    	
		    	
		    	
		    	
		    	
		    	
		    	

		    {
		    	pw.print("<tr><td>");
		    	pw.print(rs.getInt(1));
		    	pw.print("</td>");
		    	pw.print("<td>");
		    	pw.print(rs.getString(2)+"</td></tr>");
		    }
			//ps.setString(2, string);
//			int i= ps.executeUpdate(); 
//			 if(i==0)
//					pw.println("<br>Record not inserted");
//				else
//					pw.println("<br>Record successfully inserted");
	}	
	catch(Exception e)
		{
			e.printStackTrace();
		}
		pw.print("</table>");
		pw.close();
   
		 

  }
		
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

			}

}
