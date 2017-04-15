package com.jspiders.studentsapp.servlets;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class MyFirstServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, 
			             HttpServletResponse resp)
	throws ServletException, IOException 
	{
		//Java Code to Generate Date & Time
		Date dateRef = new Date();
		String currentDate = dateRef.toString();
		
		//Get the Query String Information
		String fnameVal = req.getParameter("fname");
		String lnameVal = req.getParameter("lname");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<center>");
		out.print("<h1>");
		out.print("Current Date & Time is :");
		out.print("<BR>");
		out.print("<font color=\"blue\">");
		out.print(currentDate);
		out.print("</font>");
		out.print("<BR><BR>");
		out.print("First Name : ");
		out.print(fnameVal);
		out.print("<BR>");
		out.print("Last Name : ");
		out.print(lnameVal);
		out.print("</h1>");
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");
	}//End of doGet
}//End of Class






