package Jdbc.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClobDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/main","root","1234");
		File f = new File("H:\\Eclipse\\JDBC_Practice\\src\\Jdbc\\com\\nandita.doc");
		//File f = new File("nandita.doc");
		long length=f.length();
		 FileReader reader=new FileReader(f);
		
		PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?)");

		ps.setString(1, "Adwik");
		ps.setString(2, "boy");
		ps.setCharacterStream(3, reader,f.length());
		int rs = ps.executeUpdate();
		if(rs==0)
			System.out.println("Record not inserted");
		else
		System.out.println("Record inserted");
	

	}

}

