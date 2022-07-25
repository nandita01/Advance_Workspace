package com.pp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdemo","root","1234");
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select * from demo");
		while(rs.next())
		{
			System.out.println(rs.getInt("id") +" "+rs.getString("string"));
		}
		

	
	return con;
	}
	
		
		
	

}
