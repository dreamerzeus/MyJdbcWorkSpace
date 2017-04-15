package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookieServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, 
			             HttpServletResponse resp)
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		// Get Cookies from Request
		Cookie[] rcvdCookies = req.getCookies();
		
		if(rcvdCookies==null)
		{
			out.print("No Cookies Present !!!");
		}else{
			out.print("Cookies Present ...");
			for(Cookie rcvdCookie : rcvdCookies)
			{
				String name = rcvdCookie.getName();
				String value = rcvdCookie.getValue();
				out.print(" Cookie Name : "+name);
				out.print(" Cookie Value : "+value);
			}//End of for
		}//End of if-else
	}//End of doGet
}//End of Class
