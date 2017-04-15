package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		//1. Get the ServletContext Object
		ServletContext context = getServletContext();
		
		//2. Set Attribute
		context.setAttribute("contextKey", new Object());
		
		req.setAttribute("reqKey", "My Request Attribute");
		
		RequestDispatcher dispatcher
			= req.getRequestDispatcher("second");
		dispatcher.forward(req, resp);
		
		
		
		/*//3. Simple Msg as Response
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("Set the Context & Request Attributes ...");
		*/
		
		
		
	}//End of doGet
}//End of Class
