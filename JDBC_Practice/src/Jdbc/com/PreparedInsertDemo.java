package Jdbc.com;
import java.sql.*;
import java.util.Scanner; 
public class PreparedInsertDemo {

	public static void main(String[] args) throws Exception, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prestigepoint","root","1234");

		String qry = "insert into student values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(qry);
		Scanner sc = new Scanner(System.in);
		while (true)
		{


			while (true)	
			{	
				System.out.println("Enter student id");
				int sid= sc.nextInt();

				System.out.println("Enter name");
				String name = sc.next();

				System.out.println("Enter city");
				String city = sc.next();

				ps.setInt(1,sid);
				ps.setString(2, name);
				ps.setString(3, city);
				ps.execute();

				System.out.println("Record Succesfully insert");

				System.out.println("Do you want to insert again yes or no");

				String opt =sc.next();
				if (opt.equalsIgnoreCase("no"))
				{
					break;
				}

			}	
			System.out.println("Do you want to fetch data of database");

			String opt1 =sc.next();

			if (opt1.equalsIgnoreCase("no"))
			{
				break;
			}	


			ps.executeQuery("select * from student");
			ResultSet rs = ps.getResultSet();
			while(rs.next())
			{
				System.out.println(rs.getInt("sid")+ " " +rs.getString("sname")+ " " +rs.getString("city"));
			}

			System.out.println("Do you want to insert again yes or no");

			String opt3 =sc.next();
			if (opt3.equalsIgnoreCase("no"))
			{
				break;
			}

		}
	}
}