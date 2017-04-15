package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, 
			             HttpServletResponse resp)
	throws ServletException, IOException 
	{
		/*
		 * Don't Reject, Accept / Redirect the Request
		 * Instead Forward the Request
		 */
		//String url = "index.html";
		//String url = "currentDate";
		//String url = "http://www.gmail.com";
				
		String url = "/login";
		
		/*RequestDispatcher dispatcher
					= req.getRequestDispatcher(url);*/
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher
				= context.getRequestDispatcher(url);
		
		dispatcher.forward(req, resp);
		
	}//End of doGet
	
	@Override
	protected void doPost(HttpServletRequest req, 
			             HttpServletResponse resp)
	throws ServletException, IOException 
	{
		String url = "login";
		RequestDispatcher dispatcher
					= req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
		
	}//End of doPost
	
	
}//End of Class
