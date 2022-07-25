package com.pp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SubController")
public class SubController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//setting the content type  
		PrintWriter pw=response.getWriter();//get the stream to write the data 
		pw.println("<html><body>");  
		pw.println("Nandita Rathore");  
		pw.println("</body></html>");  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//setting the content type  
		PrintWriter pw=response.getWriter();//get the stream to write the data 
		pw.println("<html><body>");  
		pw.println("Nandita Rathore");  
		pw.println("</body></html>");  
	}

}
