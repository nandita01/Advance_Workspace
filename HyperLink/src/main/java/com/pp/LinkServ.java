package com.pp;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/LinkServ")

public class LinkServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String pval = request.getParameter("s1");
		if(pval.equals("link1"))
		{
			Locale locale[]=Locale.getAvailableLocales();
			for(Locale loc:locale)
			{
				pw.println(loc.getDisplayCountry()+"&nbsp;");
			}
		}	
		else if(pval.equals("link2"))
			{
				Locale locale[]=Locale.getAvailableLocales();
				for(Locale loc:locale)
				{
					pw.println(loc.getDisplayLanguage()+"&nbsp;");
				}
			}
		else
			 pw.println("Date and Time :"+new Date());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
