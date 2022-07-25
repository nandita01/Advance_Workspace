package Jdbc.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class BatchProcessingDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prestigepoint","root","1234");
		Statement st = con.createStatement();
		st.addBatch(" insert into student values(21,'maheru','Francein')");
		st.addBatch(" update student set name='Elon ' where sid=16;");
		st.addBatch("delete from student where sid=5");
		st.executeBatch();
		con.setAutoCommit(false);
		   int[] res=st.executeBatch();
		    
		   boolean flag=true;
		      for(int i=0;i<res.length;i++) 
		           {
		             if(res[i]==0)
		                flag=false;
		           }
		      if(flag)
		         con.commit();
		      else
		          con.rollback();
		          
	}

}
