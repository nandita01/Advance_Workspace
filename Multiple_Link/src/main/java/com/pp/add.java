package com.pp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int ope;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		char ope = ( request.getParameter("ope")).charAt(0);
		
		switch (ope)  {
		
		case '+' : pw.println("<h1>Addition is "+(num1+num2)+"</h1>");
		break;
		
		case '-' : pw.println("<h1>Subtraction is "+(num1-num2)+"</h1>");
		break;
		
		case '*' : pw.println("<h1>Multiplication is "+(num1*num2)+"</h1>");
		break;
		
		case '/' : pw.println("<h1>Division is "+(num1/num2)+"</h1>");
		break;
		}
		
		/*
		 * String num3= request.getParameter("ope"); if("+".equals(num3)) { int sum =
		 * num1 + num2; pw.println("<h1> Addition is "+sum); }else if("-".equals(num3))
		 * { int sum = num1 - num2; pw.println("<h1> Substraction is "+sum); }else
		 * if("*".equals(num3)) { int sum = num1 * num2;
		 * pw.println("<h1> Multiplication  is "+sum); }else if("/".equals(num3)) {
		 * float sum = num1/num2; pw.println("<h1> Division is "+sum); }
		 * 
		 */		
		
		
		
		
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
