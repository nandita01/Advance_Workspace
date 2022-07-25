package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.SQLExceptionList;

import com.beans.Employee;
import com.service.RegisterService;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("fname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		Employee employee = new Employee(name, email, address);
		RegisterService rs = new RegisterService();
		try {
			rs.save(employee);
			pw.println("<h1>data inserted successfully");
		}
		catch(Exception e){
			e.printStackTrace();
		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
