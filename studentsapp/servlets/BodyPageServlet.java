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

public class BodyPageServlet extends HttpServlet 
{
	RequestDispatcher dispatcher = null;
	
	@Override
	protected void doPost(HttpServletRequest req, 
						 HttpServletResponse resp)
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		StudentsInfoBean data 
		 = (StudentsInfoBean)req.getAttribute("studentData");
		
		int regnum = data.getRegno();
		String fNM = data.getFirstNM();
		String mNM = data.getMiddleNM();
		String lNM = data.getLastNM();
		String gfNM = data.getGfirstNM();
		String gmNM = data.getGmiddleNM();
		String glNM = data.getGlastNM();
		String isAdmin = data.getIsAdmin();
		
		dispatcher = req.getRequestDispatcher("Header.html");
		dispatcher.include(req, resp);
		
		if(isAdmin.equals("Y"))
		{
			String url = "#";
			out.println("<a href=\""+url+"\"> Click Here <a> to View ALL Students Info ...");
			out.println("<BR> ");
		}
		out.println("<html> ");
		out.println("<body> ");
		out.println("<table>");
		out.println("<tr bgcolor=\"green\">");
		out.println("<td>Reg. No.</td>     ");
		out.println("<td>First Name</td>   ");
		out.println("<td>Middle Name</td>  ");
		out.println("<td>Last Name</td>    ");
		out.println("<td>G First Name</td> ");
		out.println("<td>G Middle Name</td>");
		out.println("<td>G Last Name</td>  ");
		out.println("</tr>");
		out.println("<tr> ");
		out.println("<td>"+regnum+"</td>  ");
		out.println("<td>"+fNM+"</td>");
		out.println("<td>"+mNM+"</td> ");
		out.println("<td>"+lNM+"</td>");
		out.println("<td>"+gfNM+"</td>");
		out.println("<td>"+gmNM+"</td> ");
		out.println("<td>"+glNM+"</td>");
		out.println("</tr>       ");
		out.println("</table>    ");
		out.println("</body>     ");
		out.println("</html>     ");
		
		dispatcher = req.getRequestDispatcher("Footer.html");
		dispatcher.include(req, resp);
		
	}//End of doPost
}//End of Class





