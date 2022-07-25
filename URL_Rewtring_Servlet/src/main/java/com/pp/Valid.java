package com.pp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/Valid")
public class Valid extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String fn = request.getParameter("fname");
		String ct = request.getParameter("city");
		
		if(fn.equals("")) 
			pw.println("Name is Required");
		if(ct.equals("")) 
			pw.println("City is Required");
		
		/********** URL REWRITING CODE **********************/
//	  pw.println("<p><a href='Valid2?Name="+fn+"&UserCity="+ct+"'>Go Second Servlet</a></p>");
		pw.println(""
				+"<form action='Valid2' >"
				+"<input type='hidden' name='uname' value='"+fn+"'/>"
				+"<input type='hidden' name='ucity' value='"+ct+"'/>"
				+"<button>Go to Second Servlet</button>"
				+"</form>");
		pw.println("<h1>Your  Name is:" +fn+ "<br> Your City is:"+ct+ "</h1>");


	
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
