package com.sa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException{
		
		PrintWriter pw=null;
		String name=null,emailId=null,age=null,mobNo=null,address=null,companyName=null,designation=null;
		
		// general setting
		res.setContentType("text/html");
		pw=res.getWriter();
		
		//Request Parameter value
		name=req.getParameter("name");
		emailId=req.getParameter("email");
		age=req.getParameter("age");
		mobNo=req.getParameter("mob");
		address=req.getParameter("address");
		companyName=req.getParameter("company");
		designation=req.getParameter("designation");
		
		// Creating session object
		HttpSession ses=req.getSession(true);
		
		ses.setAttribute("name", name);
		ses.setAttribute("emailId", emailId);
		ses.setAttribute("age", age);
		ses.setAttribute("mobNo", mobNo);
		ses.setAttribute("address", address);
		ses.setAttribute("companyName", companyName);
		ses.setAttribute("designation", designation);

		// creating the dynamic form page using First Servlet
		
		pw.println("<head>");
		pw.println("<h1><center><font color='#0000ff'>Working Exprence and skills</font></center></h1>");
		pw.println("</head>");
		pw.println("<body bgcolor='#00ffff'>");
		pw.println("<form action="+res.encodeURL("surl")+" method='post'>");
		pw.println("<table align='center'>");
		pw.println("<tr><td>");
		pw.println("Expreience years");
		pw.println("<input type='text' name='exp'>");
		pw.println("</td></tr>");
		pw.println("<tr><td>");
		pw.println("Notice period");
		pw.println("<input type='text' name='notice'>");
		pw.println("</td></tr>");
		pw.println("<tr><td>");
		pw.println("Select skills");
		pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		pw.println("<select name='skills'>");
		pw.println("<option value='J2EE'>Java</option>");
		pw.println("<option value='Oracle'>DataBase</option>");
		pw.println("<option value='.Net'>DotNet</option>");
		pw.println("<option value='c#'>c#</option>");
		pw.println("</td></tr>");
		pw.println("<tr><td>");
		pw.println("<input type='submit' value='Continue'>");
		pw.println("</tr></td>");
		pw.println("</table>");
		pw.println("</form>");
		pw.println("</body>");
		
		//close
		pw.close();
		
		
	}
	
	public void doPost(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}

}
