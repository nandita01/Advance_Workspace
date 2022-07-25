package Jdbc.com;
import java.sql.*;
import java.util.Scanner;

public class PrepareUpdateDemo {

	public static void main(String[] args)  throws Exception, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prestigepoint","root","1234");
		String qry="update student set sname=?,city=? where sid=? ";
		//String qry="update student set sname=? where sid=? ";
		PreparedStatement ps = con.prepareStatement(qry);
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter city");
		String city = sc.next();

		System.out.println("Enter student id");
		int sid= sc.nextInt();
		ps.setString(1, name);
		ps.setString(2, city);
		ps.setInt(3,sid);
		ps.execute();
		ps.executeQuery("select * from student");
		ResultSet sr=ps.getResultSet();
		while(sr.next())
		{
			System.out.println(sr.getInt("sid")+ "   " +sr.getString("sname")+ "  " +sr.getString("city"));	
		}


	}

}
