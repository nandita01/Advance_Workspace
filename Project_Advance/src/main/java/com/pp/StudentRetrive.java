package com.pp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/StudentRetrive")
public class StudentRetrive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select *from student");
		
		List<Student> students = new ArrayList<>();
		
		while(rs.next())
		{
			int id = rs.getInt("sid");
			String name = rs.getString("sname");
			String city = rs.getString("scity");
			

			Student tempStudent = new Student(id,name,city);

			students.add(tempStudent);

		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/table.jsp");
		request.setAttribute("STUDENTS", students);
		
		rd.forward(request, response);
		
		rs.close();
		st.close();
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
