package Jdbc.com;
import java.sql.*;
import java.text.SimpleDateFormat;
public class DateDemo {
	public static void main(String[] args)  throws Exception,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main","root","1234");
		String qry = "insert into TableDate values(?,?)";
		String s1="12-08-18";
		PreparedStatement pt = con.prepareStatement(qry); 
		pt.setString(1,s1);
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yy");
		java.util.Date ud2 = sdf2.parse(s1);
		java.sql.Date sd2 = new java.sql.Date(ud2.getTime());
		pt.setDate(2, sd2);
		int res= pt.executeUpdate();
		if(res == 1)
			System.out.println(" No Problem in DD-MM-YYYY format .");
		else
			System.out.println("  Problem in DD-MM-YYYY format .");
		
	}
}
