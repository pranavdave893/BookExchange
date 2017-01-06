package com.bookexchange.buy;

import java.util.ArrayList;
import java.util.List;

import com.bookexchange.DAO.DAOInterface;
import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.beans.bid;
import com.bookexchange.beans.deliverydetail;
import com.bookexchange.beans.invoice;

public class BuyInterfaceImpl implements BuyInterface
{

	
	public Boolean AddBid(int bookid,int userid,Double price) 
	{
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		
		List<String> objList=new ArrayList<String>();
		objList.add(String.valueOf(bookid));
		objList.add(String.valueOf(userid));
		objList.add(String.valueOf(price));
		
		String date=ObjectFactory.getInstance().getTodayDate();
		
		objList.add(date);
		
		Boolean b=objDAO.manipulationMethod("addbid", objList);
		return b;
	}

	
	public List<bid> showBid(int bookid)
	{
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		
		
		List<bid> objList=objDAO.bidDetail(bookid, "showbid");
		
		return objList;
		
	}
	
	
	public Double getBidPrice(int bookid)
	{
		Double price;
		
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		
		price=objDAO.getHighestBidPrice(bookid,"highestbidprice");
		
		return price;
		
	}
	
	
	public void UpdateBid(bid bidobj) {
		// TODO Auto-generated method stub
		
	}

	
	public void Order(invoice invoiceobj) 
	{
		// TODO Auto-generated method stub
		
	}
	
	public List<deliverydetail> ShowBoughtbook(int buyerid) 
	{
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		 List<deliverydetail> objList=new ArrayList<deliverydetail>();
		 objList= objDAO.ShowBoughtbook(buyerid, "boughtbook");
		return objList;   
		
	}
	
	
}
