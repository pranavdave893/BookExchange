package com.bookexchange.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.sell.SellInterface;

/**
 * Servlet implementation class SoldBook
 */
public class SoldBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoldBook() {
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
		// TODO Auto-generated method stub
		
		
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		
		SellInterface objSell=ObjectFactory.getInstance().getSellInterface();
		Boolean b=objSell.deletebook(bookid);
		
		if(b==true)
		{
			response.sendRedirect("userprofile.jsp?msg=success");
		}
		else{
			System.out.println("no deleted..");
		}
		
	}

}
