package com.bookexchange.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request,response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
				HttpSession s=request.getSession();
				s.removeAttribute("username");
				s.removeAttribute("username");
				s.setAttribute("username", null);
				s.removeAttribute("userid");
				s.setAttribute("username", null);
				s.removeAttribute("useremail");
				s.setAttribute("useremail", null);
				s.removeAttribute("city");
				s.setAttribute("city", null);
				
				
				
				if(s.getAttribute("username") != null)
				{
					
					response.sendRedirect("homepage.jsp");
				}
				else 
				{
					response.sendRedirect("homepage.jsp");
				}
				
				
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
