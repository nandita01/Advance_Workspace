package Jdbc.com;
import java.sql.*;
import java.util.Scanner;
public class PreparedDeleteDemo {

	public static void main(String[] args) throws Exception,SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prestigepoint","root","1234");
		String qry = "delete from student where sid=?";
		PreparedStatement ps = con.prepareStatement(qry);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student id");
		int sid= sc.nextInt();
		ps.setInt(1,sid);
		ps.execute();

		ps.executeQuery ("select * from student");
		ResultSet rs = ps.getResultSet();
		while(rs.next())
		{
			System.out.println(rs.getInt("sid")+ " " +rs.getString("sname")+ " " +rs.getString("city"));
		}


	}

}
