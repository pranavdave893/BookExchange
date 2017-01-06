package com.bookexchange.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookexchange.DAO.DAOInterface;
import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.beans.user;
import com.bookexchange.user.UserInterface;

/**
 * Servlet implementation class UserRegistration
 */
public class UserRegistration extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
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
		response.setContentType("text/html");
		//@SuppressWarnings("unused")
		PrintWriter out=response.getWriter();
		boolean b;
		
		try
		{
			
			List<String> objList=new ArrayList<String>();
			
			DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
			UserInterface regImpl=ObjectFactory.getInstance().getUserInterface();
			
			String action=request.getParameter("user");
			System.out.println(action);
			
			if(action.equals("Register"))
			{
			
				String username= request.getParameter("txtusername");
				String email=request.getParameter("txtemail");
				String password=request.getParameter("txtpassword");
				//String verifypassword=request.getParameter("txtverifypassword");
				String studytype=request.getParameter("studytype");
				String address=request.getParameter("txtaddress");
				String city=request.getParameter("txtcity");
				String state=request.getParameter("txtstate");
				
				int phoneno;
				
				if(request.getParameter("txtphoneno")=="")
				{
					phoneno=0;
				}
				else
				{
					phoneno=Integer.parseInt(request.getParameter("txtphoneno"));
				}
				
				int pincode=Integer.parseInt(request.getParameter("txtpincode"));
				String gender=request.getParameter("gender");
				String date=ObjectFactory.getInstance().getTodayDate();
				
				objList.add(username);
				objList.add(email);
				objList.add(password);
				objList.add(gender);
				objList.add(address);
				
				objList.add(String.valueOf(phoneno));
				objList.add(studytype);
				objList.add(city);
				objList.add(state);
				objList.add(String.valueOf(pincode));
				//urating
				//utypeid,fstatusid,regdate,updatedate
				objList.add(String.valueOf(1)); //utypeid==user/admin
				objList.add(String.valueOf(1)); //fstatusid===active/inactive
				objList.add(date);
				objList.add(date);
				
				 b=regImpl.registerUser("checkduplication", objList);		
				 response.sendRedirect("userRegistration.jsp?msg=success");
				 
				if (b==true)
					out.print("date inserted....");
				else
					out.print("enter another emailid to avoid duplication...");
			}
			else if(action.equals("update"))
			{
				
				String username= request.getParameter("txtusername");
				String password=request.getParameter("txtpassword");
				//String verifypassword=request.getParameter("txtverifypassword");
				String studytype=request.getParameter("studytype");
				String address=request.getParameter("txtaddress");
				String city=request.getParameter("txtcity");
				String state=request.getParameter("txtstate");
				int phoneno=Integer.parseInt(request.getParameter("txtphoneno"));
				int pincode=Integer.parseInt(request.getParameter("txtpincode"));
				//String gender=request.getParameter("gender");
				String date=ObjectFactory.getInstance().getTodayDate();
				String email=request.getParameter("txtemail");
				
				objList.add(username);
				objList.add(password);
				objList.add(studytype);
				objList.add(address);
				objList.add(city);
				objList.add(state);
				objList.add(String.valueOf(phoneno));
				objList.add(String.valueOf(pincode));
				objList.add(date);
				objList.add(email);
				
				 b=regImpl.updateUser(objList);
				
				 response.sendRedirect("updateuser.jsp?msg=success");
				 
				if (b==true)
					out.print("date updated.....");
				else
					out.print("not updated......");
		
				
			}
			else if(action.equals("delete"))
			{
				objList.add("ssss@gmail.com");
				b=regImpl.deleteUser(objList);
				if (b==true)
					out.print("user deleted....");
				else
					out.print("u have no rights to delete user....");
			}
			
			
		//	response.sendRedirect("display.jsp");
		}
		catch (Exception e) {
			throw new Error(e);
		}

	}
}
