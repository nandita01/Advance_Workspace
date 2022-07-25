package com.pp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/Valid")
public class Valid2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		/********  URL REWRITING FETCH CODE *************/
//		String user= request.getParameter("Name");
//		String city = request.getParameter("UserCity");
//		pw.println("<h1> Second Name:" +user+ "<br>City:"+city+ "</h1>");
		String user= request.getParameter("uname");
		String city = request.getParameter("ucity");
		pw.println("<h1> Second Name:" +user+ "<br>City:"+city+ "</h1>");
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
