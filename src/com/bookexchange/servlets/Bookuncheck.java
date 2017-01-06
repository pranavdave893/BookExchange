package com.bookexchange.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.invoice.invoiceInterface;

/**
 * Servlet implementation class Bookuncheck
 */
public class Bookuncheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookuncheck() {
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
		Boolean b;
		
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		String senderid=(String)request.getParameter("senderid");
		String receiverid=(String)request.getParameter("receiverid");
		String bidprice=request.getParameter("selectbid");
		int bidid=Integer.parseInt(request.getParameter("bidid"));
		
		List<String> objList=new ArrayList<String>();
		
		objList.add(String.valueOf(bookid));
		objList.add(senderid);
		objList.add(receiverid);
		objList.add(bidprice);
		objList.add(String.valueOf(bidid));
		
		invoiceInterface obj=ObjectFactory.getInstance().getInvoiceInterface();

		b=obj.insertconfirm(objList);

		
		
		b=obj.bookuncheck(bookid);
		
		if(b==true)
		{
			response.sendRedirect("showbid.jsp?msg=success&bookid="+bookid);
			
		}
		
	
	}

}
