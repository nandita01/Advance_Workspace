package Jdbc.com;
import java.sql.*;
import java.util.*;
public class SqlInjectionDemo {

	public static void main(String[] args) throws Exception, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main","root","1234");
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String user = sc.nextLine();
		System.out.println("Enter password");
		String pwd = sc.nextLine();
		String qry= "select count(*) from users where uname= '"+user+"' and pwd='"+pwd+"'";
		ResultSet rs = st.executeQuery(qry);
		int c=0;
		if(rs.next())
		{
			c=rs.getInt("count(*)");	 
		}
		if(c==0)
			System.out.println("Invalid user");
		else
			System.out.println("Valid user");
		con.close();
	}

} 
