package com.bookexchange.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.buy.BuyInterface;

/**
 * Servlet implementation class Bid
 */
public class Bid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
		HttpSession session = request.getSession();
		
		Double bid=Double.parseDouble(request.getParameter("bid"));
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		String sessionid= session.getId();
		
	//	if(sessionid==null)
	//	{
		
			
		
				int userid=(Integer)session.getAttribute("userid");
				
				BuyInterface buy=ObjectFactory.getInstance().getBuyInterface();
				
				Boolean b=buy.AddBid(bookid,userid,bid);
				
				if(b==true)
				{
					 response.sendRedirect("bid.jsp?msg=success&bookid="+bookid);
				}
			
	/*	}
		else
		{
			response.sendRedirect("popup.jsp?msg=unsuccess&bookid="+bookid);
		}
	*/	
	}

}
