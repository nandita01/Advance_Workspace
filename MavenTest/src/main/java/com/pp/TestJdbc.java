package com.pp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/main","root","1234");
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select * from users");
		while(rs.next())
		{
			System.out.println(rs.getString("uname") +" "+rs.getString("pwd"));
		}
		

	}

}
