package Jdbc.com;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

import javax.imageio.stream.FileImageInputStream;
public class BlobDemo {

	public static void main(String[] args) throws Exception,SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/main","root","1234");
		File f = new File("H:\\Eclipse\\JDBC_Practice\\src\\Jdbc\\com\\adwik.jpg.jpg");
		FileInputStream fis = new FileInputStream(f);
		PreparedStatement ps = con.prepareStatement("insert into persons (pname, image) values(?,?)");
		ps.setString(1, "Nandita");
		ps.setBinaryStream(2, fis,f.length());
		int rs = ps.executeUpdate();
		if(rs==0)
			System.out.println("Record not inserted");
		else
		System.out.println("Record inserted");
	

	}

}
