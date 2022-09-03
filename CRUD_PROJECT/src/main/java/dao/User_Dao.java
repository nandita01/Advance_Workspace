package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import module.User;



public class User_Dao {
	public static Connection getConnection() throws ClassNotFoundException,  SQLException {

		Connection con;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CRUD","root","1234");
		return con;
	}

	private static final String INSERT_USER_BY_uid = "Insert into user(uname,uemail,ucity) values(?,?,?)";
	private static final String SELECT_USER_BY_uid= "select uid,uname,uemail,ucity from user where uid=?";
	private static final String SELECT_ALL_USERS = "select * from  user";
	private static final String DELETE_USER_SQL = "delete from user where uid=?";
	private static final String UPDATE_USER_SQL = "update user set uname = ?, uemail = ? , ucity = ? where uid=?";



	public static void insertuser(User user) {
		try {
			Connection con = null;
			try {
				con = getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			PreparedStatement ps = con.prepareStatement(INSERT_USER_BY_uid);
			ps.setString(1, user.getUname());
			ps.setString(2,  user.getUemail());
			ps.setString(3,  user.getUcity());
			ps.executeUpdate();
		}

		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public boolean updateUser(User user) throws  Exception, SQLException {
		boolean rowUpdated;
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE_USER_SQL);){
			ps.setString(1, user.getUname());
			ps.setString(2,  user.getUemail());
			ps.setString(3,  user.getUcity());
			ps.setInt(4, user.getUid());
			rowUpdated = ps.executeUpdate() > 0 ;
		}
		return rowUpdated;
		
	}
	
	// $$$$$$$$$ SELECT USER BY uid $$$$$$$$$$$$
	public User selectUser(int uid) {
		User user = null;
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(SELECT_USER_BY_uid);){
			ps.setInt(1, uid);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			String uname = rs.getString("uname");
			String uemail = rs.getString("uemail");
			String ucity = rs.getString("ucity");
			user = new User(uid,uname,uemail,ucity);
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
			return user;
	}
	
	// @@@@@@@@@ SELECT ALL USERS  @@@@@@@@@
	public List<User> selectAllUsers() {
		List<User> user = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_USERS);
			System.out.println(ps);
			//Statement st = con.createStatement();
			//System.out.println(st);
			ResultSet rs = ps.executeQuery();
			//ResultSet rs = st.executeQuery("select * from user");
			while(rs.next()) {
			int uid = rs.getInt("uid");
			String uname = rs.getString("uname");
			String uemail = rs.getString("uemail");
			String ucity = rs.getString("ucity");
			user.add(new User(uid,uname,uemail,ucity));
			}
		}

		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	// @@@@@@@@@ DELETE USERS  @@@@@@@@@
	public boolean deleteUser(int uid)  throws ClassNotFoundException, SQLException{
		boolean rowDeleted;
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(DELETE_USER_SQL);){
			ps.setInt(1, uid);
			rowDeleted = ps.executeUpdate() > 0;
		}
		return rowDeleted;
	}

}
