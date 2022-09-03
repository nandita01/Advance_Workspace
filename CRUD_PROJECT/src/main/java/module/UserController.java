package module;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User_Dao;


@WebServlet("/")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private User_Dao  user_Dao;
       
       public UserController() {
       this.user_Dao = new User_Dao();
       }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch(action) {
		case "/new" :
			showNewForm(request,response);
			break;
		case "/insert" :
			try{
				insertuser(request,response);
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/delete" :
			try {
				deleteUser(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/edit" : 
			try {
				showEditForm(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/update" :
			try {
				updateUser(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			try {
				listUser(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	RequestDispatcher dispatcher = request.getRequestDispatcher("user_form.jsp");
	dispatcher.forward(request, response);
	
	}
	
	private void insertuser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String city = request.getParameter("ucity");
		User newUser = new User(name,email,city);
		User_Dao.insertuser(newUser);
		response.sendRedirect("list");
		}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception{
		int id = Integer.parseInt(request.getParameter("uid"));
		user_Dao.deleteUser(id);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException,Exception{
		int id = Integer.parseInt(request.getParameter("uid"));
		User existingUser = user_Dao.selectUser(id);
		RequestDispatcher dispatcher =request.getRequestDispatcher("user_form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String city = request.getParameter("ucity");

		User book = new User(id,name,email,city);
		user_Dao.updateUser(book);
		response.sendRedirect("list");
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		List<User> listUser = user_Dao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_list.jsp");
		dispatcher.forward(request, response);
	}


	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}