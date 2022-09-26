package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TeachersServlet
 */
public class TeachersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();	
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","root");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ListTeachers");
			out.println("<body bgcolor='orange'>");
			while(rs.next()) {
				out.println("<br>"+"Name: "+rs.getString("name")+"<br>"+"Subject: "+rs.getString("subject")+"<br>");
				out.println("-------------------");
			}
			out.println("<br>"+"<a href='Admin.html'>Back to Dashboard</a>'");
			out.println("</body>");
		
	
		} catch (Exception e) {
			System.out.println(e);
	}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
