package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

@WebServlet("/")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao;
	public UserController() {
		this.userDao = new UserDao();
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch(action) {
		case "/New":
			System.out.println("new case");
			showNewForm(request,response);
			break;
		case "/update":
			try {
				updateUser(request,response);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		
		case "/delete":
			try {
				deleteUser(request,response);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm(request,response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default: 
			try {
				SelectAllUser(request,response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}




	}
	public void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException,Exception{
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDao.selectUser(id);
		RequestDispatcher dispatcher =request.getRequestDispatcher("user_form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}


	public void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,ClassNotFoundException, SQLException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		User user = new User(name,email);
		userDao.insertUser(user);
		response.sendRedirect("list");

	}	

	public void SelectAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,ClassNotFoundException, SQLException{
		List<User> listUser =null;
		listUser = userDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_list.jsp");
		dispatcher.forward(request, response);
	}

	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,ClassNotFoundException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
	}
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException,ClassNotFoundException, SQLException{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		User user = new User(id,name,email);
		userDao.updateUser(user);
		response.sendRedirect("list");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
