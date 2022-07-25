package Jdbc.com;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.*;

public class DateRetriveDemo {

	public static void main(String[] args) throws Exception  {
		Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main","root","1234");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select *from tabledate");
		while(rs.next()) {
			
			String s=rs.getString(1);
			java.sql.Date jsd =rs.getDate(2);
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
			java.util.Date jud = (java.util.Date)jsd;
			String finaldate=sdf.format(jud);
			System.out.println(s+"    "+finaldate);
		}
		rs.close();
		st.close();
		con.close();
	}

}
