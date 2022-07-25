package Jdbc.com;
import java.util.Scanner;
import java.sql.*;
public class PreparedStatemntDemo {
	public static void main(String[] args)  throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main","root","1234");
		String qry = "select * from employee where ename=? and ecity=?";
		PreparedStatement ps = con.prepareStatement(qry);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = sc.next();
		System.out.println("Enter your city");
		String city = sc.next();
		ps.setString(1,name);
		ps.setString(2, city);
		    ps.execute();
		    ResultSet rs=ps.getResultSet();
		    while(rs.next())
		    {
		    	System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));	
		    }
	
	}
}
