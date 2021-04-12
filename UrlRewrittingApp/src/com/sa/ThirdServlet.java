package com.sa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ThirdServlet extends HttpServlet{
	public void doGet(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException{
		
		PrintWriter pw=null;
		String loc=null, currentSal=null, expectedSal=null;
		
		
		
		//general setting 
		pw=res.getWriter();
		res.setContentType("text/html");
		
		loc=req.getParameter("loc");
		currentSal=req.getParameter("currentSal");
		expectedSal=req.getParameter("expectedSal");
		
		//creating session object
		HttpSession ses=req.getSession(false);
				
		//fetching the session value
		String name=(String)ses.getAttribute("name");
		String emailId=(String)ses.getAttribute("emailId");
		String age=(String)ses.getAttribute("age");
		String mobNo=(String)ses.getAttribute("mobNo");
		String address=(String)ses.getAttribute("address");
		String companyName=(String)ses.getAttribute("companyName");
		String designation=(String)ses.getAttribute("designation");
		String exp=(String)ses.getAttribute("exp");
		String notice=(String)ses.getAttribute("notice");
		String skills=(String)ses.getAttribute("skills");
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			PreparedStatement ps=con.prepareStatement("insert into registration_form values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			System.out.println("Connection is fine");
			
			ps.setString(1, name);
			System.out.println("1");
			ps.setString(2, emailId);
			System.out.println("2");
			ps.setInt(3, Integer.parseInt(age));
			System.out.println("3");
			ps.setInt(4, Integer.parseInt(mobNo));
			System.out.println("4");
			ps.setString(5, address);
			System.out.println("5");
			ps.setString(6, companyName);
			System.out.println("6");
			ps.setString(7, designation);
			System.out.println("7");
			ps.setInt(8, Integer.parseInt(exp));
			System.out.println("8");
			ps.setInt(9, Integer.parseInt(notice));
			System.out.println("9");
			ps.setString(10, skills);
			System.out.println("10");
			ps.setString(11, loc);
			System.out.println("11");
			ps.setInt(12, Integer.parseInt(currentSal));
			System.out.println("12");
			ps.setInt(13, Integer.parseInt(expectedSal));
			System.out.println("13");
			
			int result=ps.executeUpdate();
			ses.invalidate();
			
			if(result != 0) {
				pw.println("<head>");
				pw.println("<h1><center><font color='#008000'>Person Details updated successfully</font></center><h1>");
				pw.println("</head>");
				pw.println("<body bgcolor='#00ffff'>");
				pw.println("<a href='form.html'>Home Page</a>");
				pw.println("</body>");
			}
			else {
				pw.println("<head>");
				pw.println("<h1><center><font color='red'>Person Details not updated successfully</font></center><h1>");
				pw.println("</head>");
				pw.println("<body bgcolor='#00ffff'>");
				pw.println("<a href='form.html'>Home Page</a>");
				pw.println("</body>");
			}
			
			
		}//try
		catch(Exception e) {
			pw.println("<head>");
			pw.println("<h1><center><font color='red'>Error !!! Check the code</font></center><h1>");
			pw.println("</head>");
			pw.println("<body bgcolor='#00ffff'>");
			pw.println("<a href='form.html'>Home Page</a>");
			pw.println("</body>");
		}//catch
		//close
		pw.close();
		
	}//doGet()
	public void doPost(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}//doPost()

}//class()
