package Jdbc.com;
import java.sql.*;
import java.util.Scanner;
public class SqlPrepared {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main","root","1234");
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter username");
	String user = sc.nextLine();
	System.out.println("Enter password");
	String pwd = sc.nextLine();
	//String qry="select count(*) from users uname=? and pwd=?";
	
	PreparedStatement ps = con.prepareStatement("select count(*) from users  where uname=? and pwd=?");
	
	ps.setString(1,user);
	ps.setString(2,pwd);

	
	
	ResultSet rs =ps.executeQuery();
	
		int c=0;
		
	if(rs.next())
	{
		c=rs.getInt(1);	 
	}
	if(c==0)
	{
		System.out.println("Invalid user");
	}
	else
		System.out.println("Valid user");
	
	
	rs.close();
	ps.close();
	con.close();
}

}

