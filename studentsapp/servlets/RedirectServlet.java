package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, 
			             HttpServletResponse resp)
	throws ServletException, IOException 
	{
		/*
		 * Don't Reject / Accept the Request
		 * Instead Redirect the Request
		 */
		//String url = "http://www.gmail.com";
		//String url = "http://localhost:8080/studentsApp/currentDate";
		//String url = "http://localhost:8080/studentsApp/index.html";
		String url = "currentDate";
		resp.sendRedirect(url);
		
	}//End of doGet
}//End of Class
