package com.sa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		PrintWriter pw=null;
		String expYears=null,notice=null,skills=null;
		
		//general setting
		res.setContentType("text/html");
		pw=res.getWriter();
		
		//Request parameter
		
		expYears=req.getParameter("exp");
		notice=req.getParameter("notice");
		skills=req.getParameter("skills");
		
		// Create the session object
		HttpSession ses = req.getSession(false);
		
		ses.setAttribute("exp", expYears);
		ses.setAttribute("notice", notice);
		ses.setAttribute("skills", skills);
		
		pw.println("<head>");
		pw.println("<h1><center><font color='red'>Preferred location and salary</font></center></h1>");
		pw.println("</head>");
		pw.println("<body bgcolor='#00ffff'>");
		pw.println("<form action="+res.encodeURL("turl")+" method='post'>");
		pw.println("<table align='center'>");
		pw.println("<tr><td>");
		pw.println("Preferred location");
		pw.println("<input type='text' name='loc'");
		pw.println("</td></tr>");
		pw.println("<tr><td>");
		pw.println("Current salary");
		pw.println("<input type='text' name='currentSal'");
		pw.println("</td></tr>");
		pw.println("<tr><td>");
		pw.println("Expected salary");
		pw.println("<input type='text' name='expectedSal'");
		pw.println("</td></tr>");
		pw.println("<tr><td>");
		pw.println("<input type='submit' value='Continue'");
		pw.println("</td></tr>");
		pw.println("</table>");
		pw.println("</form>");
		pw.println("</body>");
		
		pw.close();
	    
		
	}
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		doGet(req,res);
	}

}
