package com.bookexchange.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.sell.SellInterface;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/UpdateBook")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)

public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
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
	

		//response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try
		{
			String bookid= request.getParameter("bookid");
			String name= request.getParameter("txtname");
			String author=request.getParameter("txtauthor");
			String publication=request.getParameter("txtpublication");
			String ISBN=request.getParameter("txtISBN");
			String booktype=request.getParameter("booktype");
			String oldprice=request.getParameter("txtoldprice");
			String newprice=request.getParameter("txtnewprice");
			String condition=request.getParameter("condition");
			//out.print(condition);
			String category=request.getParameter("category");
			String edition=request.getParameter("edition");
			String content=request.getParameter("content");
			String date=ObjectFactory.getInstance().getTodayDate();
			
			List<String> objList=new ArrayList<String>();
			
			SellInterface objSell=ObjectFactory.getInstance().getSellInterface();
			
			objList.add(name);
			objList.add(author);
			objList.add(publication);
			objList.add(ISBN);
			objList.add(oldprice);
			objList.add(newprice);
			objList.add(booktype); 
			objList.add(condition); 
			//objList.add(date);
			objList.add(date);
			objList.add(category); 
			objList.add(edition);
			objList.add(content);
			
			//user id====uid= select uid from userdetail_t where email=?;
			//flag status id == it will store in sellitenfaceimpl... 
		
			String savePath = "D:\\workspace\\BookExchange\\WebContent\\images";
         
	        Part part=request.getPart("image");
	        String fileName=extractFileName(part);
	        part.write(savePath + File.separator + fileName);
			
	        String filePath=/* savePath + File.separator + */fileName ;
	        
	        objList.add(filePath);
	        objList.add(bookid);
	        
			boolean b=objSell.updateBook(objList);
			
			if(b==true)
				response.sendRedirect("updatebook.jsp?msg=success&bookid="+bookid);
			else
				out.print("data not insert...");
		
		}
		catch (Exception e)
		{
			throw new Error(e);
		}

	}


	private String extractFileName(Part part)
	{
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
	
}
