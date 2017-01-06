package com.bookexchange.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookexchange.DAO.DAOInterface;
import com.bookexchange.ObjectFactory.ObjectFactory;

/**
 * Servlet implementation class Feedback
 */
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedback() {
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
		
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		
		String uid;
		if(request.getParameter("uid")!="")
			uid=request.getParameter("uid");
		else
			uid=null;
		
		
		
		String uname=request.getParameter("name");
		String email=request.getParameter("mail");
		String content=request.getParameter("comments");
		String date=ObjectFactory.getInstance().getTodayDate();
		
		List<String> objList=new ArrayList<String>();
		
		objList.add(""+86); // cmntmodeid === feedback,inquires 
		objList.add(uid);
		objList.add(uname);
		objList.add(email);
		objList.add(content);
		objList.add(date);
		
		boolean b=objDAO.manipulationMethod("feedback", objList);
		
		if(b==true)
		{
			response.sendRedirect("feedback.jsp?msg=success");
		}
		else
		{
			response.sendRedirect("feedback.jsp?msg=unsuccess");
		}
	}

}
