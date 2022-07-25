
import java.util.Scanner;
import java.sql.*;
public class PreparedStatemntDemo {
	public static void main(String[] args)  throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main","root","1234");
		String qry = "select ename,ecity from employee where ename=? and ecity=?";
		PreparedStatement ps = con.prepareStatement(qry);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = sc.next();
		System.out.println("Enter your city");
		String city = sc.next();
		ps.setString(1,name);
		ps.setString(2, city);
	
	}
}
