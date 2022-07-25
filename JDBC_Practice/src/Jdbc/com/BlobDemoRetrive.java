package Jdbc.com;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BlobDemoRetrive {

	public static void main(String[] args) throws Exception,SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/main","root","1234");
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			    ResultSet.CONCUR_UPDATABLE);

		ResultSet rs1 = st.executeQuery("select * from persons");
		rs1.first();
		 InputStream in=rs1.getBinaryStream(2);
	      // System.out.println(in.getClass().getName());
	     	 FileOutputStream fos=new FileOutputStream("photo.jpg");
		     int bytesRead=0;
		     
	  	     byte[] buffer=new byte[52000];

	    	 while((bytesRead=in.read(buffer))!=-1)
		     {
	               // System.out.print(bytesRead +  "   ");
		        fos.write(buffer,0,bytesRead);
	         }
              fos.flush();
			System.out.println("photo is stored in newpict1.png");

	          fos.close();
		      in.close();
		      rs1.close();
		      st.close();
		      con.close();

	}

}
