package com.bookexchange.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.communication.CommunicationInterface;

/**
 * Servlet implementation class SendMsg
 */
public class SendMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMsg() {
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
		
		List<String> objList=new ArrayList<String>();
		
		objList.add(request.getParameter("senderid"));
		objList.add(request.getParameter("receiverid"));
		objList.add(request.getParameter("msg"));
		objList.add(request.getParameter("bookid"));
		
		CommunicationInterface com=ObjectFactory.getInstance().getCommunicationInterface();
		
		boolean b=com.savemessage(objList);
		
		if(b==true)
		{
			response.sendRedirect("sendMsg.jsp?msg=success");
		}
		
	}

}
