import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
public class DateServlet implements Servlet

{  
 public void init(ServletConfig sc) { System.out.println("Hello");}
 public void destroy() { }
 public ServletConfig getServletConfig() { return null;}
 public String getServletInfo() { return null; }  
public void service(ServletRequest request, ServletResponse response) 
  throws IOException,ServletException
{
  PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
                java.util.Date d = new java.util.Date();
               pw.println(d.toString());
		//pw.println("hello....welcome to servlet.....");
}
}





/* public class DateServlet extends GenericServlet
{
 public void service(ServletRequest request, ServletResponse response) 
  throws IOException,ServletException */
/*
public class DateServlet extends HttpServlet
 {
    public void service(HttpServletRequest request, HttpServletResponse response) 
  throws IOException,ServletException 
        {
                PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
                java.util.Date d = new java.util.Date();
                pw.println(d.toString());
                pw.println("<br>");
                pw.println(request.getClass().getName());
                pw.println("<br>");
                pw.println(response.getClass().getName());
                pw.println("<br>"); 
                pw.println(Thread.currentThread().getName());
                pw.println("<br>");
                pw.println(this.hashCode());
  }
}  */
