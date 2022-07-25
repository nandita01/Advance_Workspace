package Jdbc.com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CollableDemo {

	public static void main(String[] args) throws SQLException {
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/prestigepoint","root","1234");
        CallableStatement cs = con.prepareCall("{?=call getAvg(?,?)}");
        cs.setInt(2,100);
        cs.setInt(3, 200);
        cs.registerOutParameter(1, Types.FLOAT);
        cs.execute();
       System.out.println("Salary"+cs.getFloat(1));
       con.close();
        

	}

}
