package cmp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Other")
public class Other extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		
		// GETTING ALL THE COOKIES
		Cookie[] cookies = request.getCookies();
		boolean f = false;
		String name1 =" ";
		if(cookies==null)
		{
			pw.println("<h1>You are new user go to home page and submit your name</h1>");
		return;
		}
		else
		{
			for(Cookie c:cookies)
			{
			String tname=c.getName();
			if(tname.equals("user_name"))
			{
				f=true;
			name = c.getValue();
			}
			
			}
		}
		if(f)
			{
			pw.println("<h1>Welcome back:" +name+ "</h1>" );
			}
		else
		{
			pw.println("<h1>You are new user go to home page and submit your name</h1>");

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
