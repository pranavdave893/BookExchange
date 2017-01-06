package com.bookexchange.invoice;

import java.util.List;

import com.bookexchange.beans.bookdetail;
import com.bookexchange.beans.confirmation;
import com.bookexchange.beans.invoice;
import com.bookexchange.beans.user;

public interface invoiceInterface 
{
	//public List<invoice> storeinvoice(String sellerid,String buyerid,int bookid);
	
	public boolean insertconfirm(List<String> objList);

	public boolean bookuncheck(int bookid);

	
	public  boolean showconfirm(int rid);
	
	
	public List<confirmation> getconfirmationdetail(int uid);
	
	
	public List<bookdetail> getbookdetail(int bookid);
	
	public List<user> getuserdetail(int uid);
	
	
	public boolean insertionInInvoiceDetail_t(int sellerid,int buyerid,int bookid);
	
	public boolean insertInInvoice_t(int sellerid,int buyerid,int bookid,String selection);
	
	public boolean insertInDeliveryDetail(int sellerid,int buyerid,int bookid,String selection);
	
	public List<invoice> display(int bookid);
	
	public boolean updatebookstatus(int bookid);
	
	public int getbookstatus(int bookid);
	
	public boolean updateconfirmationflag( int bookid);
	
	//public List<invoice> getInvoice(int bookid);
	

}
