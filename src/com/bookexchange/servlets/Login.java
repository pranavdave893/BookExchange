package com.bookexchange.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.beans.user;
import com.bookexchange.login.LoginInterface;
import com.bookexchange.user.UserInterface;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		
		LoginInterface lg=ObjectFactory.getInstance().getLoginInterface();
		//lg.authentication(email, password)
		
		String user=request.getParameter("user");
		
		List<String> objList=new ArrayList<String>();
		objList.add(request.getParameter("user"));
		objList.add(request.getParameter("pass"));
		
		/*
		objList.add("geeta");
		objList.add("abc");
		*/
		boolean b=lg.authentication(objList);
		
		//System.out.println("valid user===="+b);
		
		if(b==false)
		{
			//out.print("u r valid user...");
			
			UserInterface userdetail=ObjectFactory.getInstance().getUserInterface();
			
			List<user> objListUser=userdetail.getUserDetail(user);
			
			Iterator<user> it=objListUser.iterator();
			user objuser=ObjectFactory.getInstance().getUser();
			objuser=it.next();
			
			String uname=objuser.getUname();
			int uid=objuser.getUid();
			String city=objuser.getCity();
			String email=objuser.getEmail();
			
			HttpSession session=request.getSession(true);
			
			
			session.setAttribute("username", uname);
			session.setAttribute("city", city);
			session.setAttribute("userid", uid);
			session.setAttribute("useremail", email);
			
			
			response.sendRedirect("userprofile.jsp");
		}	
		else
		{
			response.sendRedirect("homepage.jsp?msg=unsuccess");
			out.print("not valid plz try again...");
		}
	}

}
