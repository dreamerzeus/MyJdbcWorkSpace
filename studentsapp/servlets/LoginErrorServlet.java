package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspiders.studentsapp.dao.StudentDAO;
import com.jspiders.studentsapp.dao.StudentsInfoBean;
import com.mysql.jdbc.Driver;

public class LoginErrorServlet extends HttpServlet 
{
	RequestDispatcher dispatcher = null;
	
	@Override
	protected void doPost(HttpServletRequest req, 
						 HttpServletResponse resp)
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String message = (String)req.getAttribute("msg");
		
		out.print("<font color=\"red\">");
		out.println(message);
		out.print("</font>");
		out.print("<BR><BR>");
		dispatcher = req.getRequestDispatcher("Login.html");
		dispatcher.include(req, resp);
		
	}//End of doPost
}//End of Class





