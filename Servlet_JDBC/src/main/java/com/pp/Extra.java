package com.pp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Extra")


public class Extra extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public void display(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
{    	 
	response.setContentType("text/html");
	PrintWriter pw = response.getWriter();
	String fname= request.getParameter("fname");
	String lname= request.getParameter("lname");
	pw.println(fname);
	pw.println(lname);
	pw.close();	
 }
     public void service() throws Exception
     {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/main","root","1234");
    			Statement st= con.createStatement();
    			ResultSet rs= st.executeQuery("select * from employee");
    			while(rs.next())
    			{
    				System.out.println(rs.getString("ename") +" "+rs.getString("ecity"));
    			}
    		
     }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		display(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
