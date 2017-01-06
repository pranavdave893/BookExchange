package com.bookexchange.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.user.UserInterface;

/**
 * Servlet implementation class Updateadd
 */
public class Updateadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateadd() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address=request.getParameter("address");
		int a=Integer.parseInt(request.getParameter("uid"));
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		String selection=request.getParameter("selection");
		
		UserInterface objadd=ObjectFactory.getInstance().getUserInterface();
		boolean b= objadd.updateuseradd(a,address);
		
		if(b==true)
		{
			response.sendRedirect("address.jsp?msg=success&sellerid="+a+"&bookid="+bookid+"&selection="+selection);
		}
	}

}
