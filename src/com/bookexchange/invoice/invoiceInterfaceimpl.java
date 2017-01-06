package com.bookexchange.invoice;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.bookexchange.DAO.DAOInterface;
import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.beans.bookdetail;
import com.bookexchange.beans.confirmation;
import com.bookexchange.beans.invoice;
import com.bookexchange.beans.user;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class invoiceInterfaceimpl implements invoiceInterface
{

	/*
	public List<invoice> storeinvoice(String sellerid, String buyerid, int bookid) 
	{	
		
		
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		
		List<invoice> objListfinal=new ArrayList<invoice>();
		
		List<user> seller=new ArrayList<user>();
		List<user> buyer=new ArrayList<user>();
		List<bookdetail> book=new ArrayList<bookdetail>();
	
		seller=objDAO.userDetail("userdetail", sellerid);
		buyer=objDAO.userDetail("userdetail", buyerid);
		book=objDAO.bookDetail("bookdetail", bookid);
		
		
		
		
		private int invcid;
		private int sellerid;
		private int buyerid;
		
		private int bid;
		//private int bqnty;
		private float totalprice;
		private float charges; //default
		private float finalprice;bookprice+charges
		private Date invcdatetime;
		private int did;===baki
		private int invcflag;===baki
		
		
		
		invoice objInvoice=ObjectFactory.getInstance().getInvoice();
		
		for(Iterator<user> i=seller.iterator();i.hasNext();)
        {
        
        	user u=(user)i.next();
        	
        	objInvoice.setSellerid(u.getUid());
        	
        	objListfinal.add(objInvoice);
		
        }
		
		for(Iterator<user> i1=buyer.iterator();i1.hasNext();)
        {
        
        	user u=(user)i1.next();
        	
        	objInvoice.setBuyerid(u.getUid());
        	
        	objListfinal.add(objInvoice);
		
        }
		
		bookdetail bk=ObjectFactory.getInstance().getBookdetail();
	
		for(Iterator<bookdetail> i2=book.iterator();i2.hasNext();)
        {
        
        	 bk=(bookdetail)i2.next();
        	
        	 objInvoice.setBid(bk.getBid());
        	 
        	//count total price
        	objInvoice.setTotalprice(bk.getNewprice());
        	objInvoice.setCharges(25);
        	
        	int finalprice=(int) (bk.getNewprice()+25);
        	
        	objInvoice.setFinalprice(finalprice);
        	
        	String date=ObjectFactory.getInstance().getTodayDate();
        	
        	objInvoice.setInvcdatetime(date);
        	
        	
        	objListfinal.add(objInvoice);
		
        }
		
		return objListfinal;
		}
	
	
		*/
	
	
	public boolean bookuncheck (int bookid)
	{
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		 boolean b=true;
		
		 b=objDAO.soldBook(bookid,  "soldbook");
		 
		return b;
		
	}
		
		
	
		public boolean insertconfirm(List<String> objList) 
		{
		
			DAOInterface cnfrm=ObjectFactory.getInstance().getDAOInterface();
			
			boolean c;
			
			objList.add(String.valueOf(0));
			
			c=cnfrm.manipulationMethod("insertconfirm", objList);
			
			return c;
		}


		public  boolean showconfirm(int uid)
		
		{
	
		   boolean d=false;
		   
		   DAOInterface showconfirm=ObjectFactory.getInstance().getDAOInterface();
		  
		   List<String> objList= new ArrayList<String>();
		  
		   objList.add(String.valueOf(uid));
		  
		   d= showconfirm.selectMethod("showconfirm", objList);
		   
		   
		   if(d==true)
		   {
			   System.out.println("show d===="+d);
		   }
		   
			return d;
			
			
		}
		
		
		public List<confirmation> getconfirmationdetail(int uid)
		{
			List<confirmation> objList=new ArrayList<confirmation>();
			
			DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
			
			objList=objDAO.showconfirmforreceiver("showconfirm",uid);
			
			return objList;
		}

		
	
		
		public List<bookdetail> getbookdetail(int bookid)
		{
			DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
			
			List<bookdetail> objListBook=new ArrayList<bookdetail>();
			
           	objListBook=objDAO.bookDetail("bookdetail",bookid);
           	
           	return objListBook;
           	
		}
		
		public List<user> getuserdetail(int uid)
		{
			DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
			
			List<user> objListuser=new ArrayList<user>();
			
           	objListuser=objDAO.userdetailBYID("userdetailBYID",uid);
           	
           	return objListuser;
		}

		
		
		public boolean insertionInInvoiceDetail_t(int sellerid,int buyerid,int bookid1)
		{
			
			boolean b=false;
			
			DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
			
			int invcid=objDAO.getInvcidANDdeliveryid(sellerid,buyerid,bookid1,"getinvcid");
			
			List<confirmation> objList=new ArrayList<confirmation>();
			
			objList=objDAO.getconfirmationdetail(sellerid,buyerid,bookid1,"getconfirmation");
			
			for(Iterator<confirmation> ic=objList.iterator();ic.hasNext();)
			{
				confirmation con=ObjectFactory.getInstance().getConfirmation();
				
				con=ic.next();
				
				List<String> book=new ArrayList<String>();
				
				book.add(String.valueOf(con.getBidid()));
				book.add(String.valueOf(con.getBidprice()));
				book.add(String.valueOf(con.getBid()));
				
				int bookid=con.getBid();
				
				List<bookdetail> bdetail=new ArrayList<bookdetail>();
				bdetail=objDAO.bookDetail("bookdetail", bookid);
				
				for(Iterator<bookdetail> b1=bdetail.iterator();b1.hasNext();)
				{
					bookdetail bd=ObjectFactory.getInstance().getBookdetail();
					bd=b1.next();
					book.add(bd.getBname());
					
				}
				
				book.add(String.valueOf(sellerid));
				book.add(String.valueOf(invcid));
				book.add(String.valueOf(buyerid));
				
				b=objDAO.manipulationMethod("insertinvoicedetail", book);
			}
			
			
			
			return b;
			
		}
		
		
		public boolean insertInInvoice_t(int sellerid,int buyerid,int bookid,String selection) 
		{
			boolean b=false;
			DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
			List<confirmation> objbooklist=new ArrayList<confirmation>();
			objbooklist=objDAO.getconfirmationdetail(sellerid,buyerid,bookid,"getconfirmation");
			
			int count=0;
			Double bsum=(double) 0;
		
			
			for(Iterator<confirmation> i=objbooklist.iterator();i.hasNext();)
			{
				confirmation con=ObjectFactory.getInstance().getConfirmation();
				con=i.next();
				count++;
				
				bsum=bsum + (con.getBidprice());
				
			}
			
			String srccity=objDAO.getUserCity("getcity", sellerid);
			String destcity=objDAO.getUserCity("getcity", buyerid);
			double charges; //=insertinvoice.getPostalCharges(srccity, destcity, "getpcharges");
			double finalprice; //=bsum+charges;
			
			List<String> objInvoice=new ArrayList<String>();
			objInvoice.add(String.valueOf(buyerid));
			objInvoice.add(String.valueOf(count));
			objInvoice.add(String.valueOf(bsum));
			
			
			
			String date=ObjectFactory.getInstance().getTodayDate();
			
			objInvoice.add(date);
			int did;
			
			if(selection.equals("facetoface"))
			{
				
				did=objDAO.getInvcidANDdeliveryid(sellerid,buyerid,bookid,"getdeliveryid");
				
				objInvoice.add(String.valueOf(0)); //for postal changes thats why it is 0
				finalprice=bsum;
				objInvoice.add(String.valueOf(finalprice));
				
			}
			else
			{
				did=objDAO.getInvcidANDdeliveryid(sellerid,buyerid,bookid,"getdeliveryid");
				
				charges=objDAO.getPostalCharges(srccity, destcity, "getpcharges");
				finalprice=bsum+charges;
				
				objInvoice.add(String.valueOf(charges));
				objInvoice.add(String.valueOf(finalprice));
				
			}
		
			
			objInvoice.add(String.valueOf(did));
			objInvoice.add(String.valueOf(1));
			objInvoice.add(String.valueOf(sellerid));
			
			boolean B=objDAO.manipulationMethod("insertInvoice", objInvoice);
					
		    return B;
			
		}

		
		
		
		
		public boolean insertInDeliveryDetail(int sellerid,int buyerid,int bookid,String selection) 
		{
			
			boolean d=false;
			
			DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
			
			int demodeid;
			
			String sciry;
			String bcity;
			int charges;
			
			if(selection.equals("facetoface"))
			{
				demodeid=2;
				charges=0;
			}
			else
			{
				demodeid=1;
				sciry=objDAO.getUserCity("getcity", sellerid);
				bcity=objDAO.getUserCity("getcity", buyerid);
				
				charges=objDAO.getPostalCharges(sciry, bcity, "getpcharges");
			}
			
			
			
			
			List<confirmation> objbooklist=new ArrayList<confirmation>();
			objbooklist=objDAO.getconfirmationdetail(sellerid,buyerid,bookid,"getconfirmation");
			
			for(Iterator<confirmation> i=objbooklist.iterator();i.hasNext();)
			{
				confirmation con=ObjectFactory.getInstance().getConfirmation();
				con=i.next();
				
				List<String> objList=new ArrayList<String>();
				
				objList.add(String.valueOf(demodeid));
				
				List<user> objListUserSeller=new ArrayList<user>();
				objListUserSeller=objDAO.userdetailBYID("userdetailBYID",sellerid);
				
				String sellerAddress=null;
				String buyerAddress=null;
				
				for(Iterator<user> is=objListUserSeller.iterator();is.hasNext();)
				{
					user objuser=ObjectFactory.getInstance().getUser();
					objuser=is.next();
					
					sellerAddress=objuser.getAddress();
				}
				
				
				List<user> objListUserBuyer=new ArrayList<user>();
				objListUserBuyer=objDAO.userdetailBYID("userdetailBYID",buyerid);
				
				for(Iterator<user> ib=objListUserBuyer.iterator();ib.hasNext();)
				{
					user objuser=ObjectFactory.getInstance().getUser();
					objuser=ib.next();
					
					buyerAddress=objuser.getShippingaddress();
				}
				
				objList.add(String.valueOf(sellerAddress));
				objList.add(String.valueOf(buyerAddress));
				objList.add(String.valueOf(charges));
				objList.add(String.valueOf(con.getBid()));
				
				objList.add(String.valueOf(sellerid));
				objList.add(String.valueOf(buyerid));
				
				 d= objDAO.manipulationMethod("insertdeliverydetail", objList);
				
				}
			
			return d;
			
		}
		
		
		public List<invoice> display(int bookid)
		{
			DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
			
			List<invoice> objList=new ArrayList<invoice>();
			
			objList=objDAO.getInvoice("dispayinvoice",bookid);
			
			return objList;
			
		}
		
		public boolean updatebookstatus(int bookid)
		{
			DAOInterface objDaoInterface=ObjectFactory.getInstance().getDAOInterface();
			boolean b=objDaoInterface.soldBook(bookid, "updatebookstatus");
			return b;
		}
		
		public int getbookstatus(int bookid)
		{
			DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
			int bstatus=objDAO.getbookflag(bookid,"getbookstatus");
			return bstatus;
		}
		
		public boolean updateconfirmationflag( int bookid)
		{
			DAOInterface objDaoInterface=ObjectFactory.getInstance().getDAOInterface();
			boolean b=objDaoInterface.soldBook(bookid, "updateconfirmationflag");
			return b;
		}
}
