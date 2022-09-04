package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import model.User;

public class UserDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		//Connection con;
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/inter","root","1234");
		}
	
	public void insertUser(User user) throws ClassNotFoundException, SQLException {
		try(Connection con =getConnection();
				PreparedStatement ps = con.prepareStatement("insert into user(name,email)values(?,?)");){
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.executeUpdate();
		}
		
	}

	public List<User> selectAllUsers() throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<>();
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("select * from user");){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				users.add(new User(id,name,email));
			}
			
				
				
		}
		
		return users;
	}
	
	public void deleteUser(int id) throws ClassNotFoundException, SQLException  {
		
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("delete from user where id=?");){
			ps.setInt(1, id);
			ps.executeUpdate();
			}
		
			
		
		
		
	}

	public void updateUser(User user) throws ClassNotFoundException, SQLException {
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("update user set name=?, email=? where id=?");){
			ps.setInt(3, user.getId());
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.executeUpdate();
	}
}

	public User selectUser(int id) throws ClassNotFoundException, SQLException {
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("select * from user  where id=?");){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			User user= null;

			while(rs.next()) {
				
				String email = rs.getString("email");
				String name = rs.getString("name");
				user = new User(id,name,email);
			}
			
		return user;
	}
}
}
