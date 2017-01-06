package com.bookexchange.buy;

import java.util.List;

import com.bookexchange.beans.bid;
import com.bookexchange.beans.deliverydetail;
import com.bookexchange.beans.invoice;


public interface BuyInterface 
{
	public Boolean AddBid(int bookid,int userid,Double price);
	public void UpdateBid(bid bidobj);
	
	
	public List<bid> showBid(int bookid);
	public Double getBidPrice(int bookid);
	
	public void Order(invoice invoiceobj);  //after biding, seller choose buyer for selling their book, at that time data will be save in invoice table. 

	public List<deliverydetail> ShowBoughtbook(int buyerid);
}
