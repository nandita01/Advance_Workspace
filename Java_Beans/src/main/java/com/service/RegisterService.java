package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.beans.Employee;

public class RegisterService {

	public void save(Employee employee) throws SQLException, ClassNotFoundException {
		 
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabeans","root","1234");
		 PreparedStatement ps = con.prepareStatement("insert into employee values (?,?,?)");
		 ps.setString(1, employee.getName());
		 ps.setString(2, employee.getEmail());
		 ps.setString(3, employee.getAddress());
		 boolean b = ps.execute();
		 if(b) 
			 System.out.println("Record inserted successfully");
		 else
		 System.out.println("Not inserted");
	
	}
}
