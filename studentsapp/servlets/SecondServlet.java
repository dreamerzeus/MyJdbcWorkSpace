package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//1. Get the ServletContext Object
		ServletContext context = getServletContext();
		
		//2. Get Attribute
		Object obj = context.getAttribute("contextKey");
		
		//3. Print this Value as Response
		if(obj==null){
			out.print("Context Attribute Not Present !!!");
		}else{
			out.print("Context Attribute is Present .... ");
			String val = obj.toString();
			out.print("Value is : "+val);
		}
		
		Object obj2 = req.getAttribute("reqKey");
		if(obj2==null){
			out.print("Request Attribute Not Present !!!");
		}else{
			out.print("Request Attribute is Present ...");
			String val = (String)obj2;
			out.print("Value is : "+val);
		}
		
	}//End of doGet
}//End of Class
