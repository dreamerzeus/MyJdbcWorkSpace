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

public class LoginServlet extends HttpServlet 
{
	RequestDispatcher dispatcher = null;
	
	@Override
	protected void doPost(HttpServletRequest req, 
						 HttpServletResponse resp)
	throws ServletException, IOException 
	{
		//I. Get the Form Data
		String regnoVal = req.getParameter("regno");
		String passVal = req.getParameter("pass");
		
	   /* II. Authenticate the Credentials by 
		*      interacting with DB & Generate 
		*      the Response
		*/
		StudentDAO dao = new StudentDAO();
		StudentsInfoBean data = dao.authenticate(regnoVal, passVal);
		
		String url=null;
		if(data!=null)
		{
			//Valid Credentials
			req.setAttribute("studentData", data);
			url = "home";
			
		}else{
			//In-Valid Credentials
			req.setAttribute("msg", "In-Valid User Name / Password");
			url = "loginErr";
		}
		dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}//End of doPost
}//End of Class





