package com.bookexchange.sell;

import java.util.List;
import com.bookexchange.DAO.DAOInterface;
import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.beans.bookdetail;
import com.bookexchange.beans.typedetail;

public class SellInterfaceImpl implements SellInterface 
{
	DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
	boolean b=false;
	public List<bookdetail> getBookDetail(int bid) 
	{
		List<bookdetail> objList=objDAO.bookDetail("bookdetail",bid);	
		return objList;
	}
	public boolean registerbook(List<String> objList)
	{
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		boolean b=objDAO.manipulationMethod("bookregistation", objList);
		return b;
	}
	public boolean updateBook(List<String> objList) 
	{
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		boolean b=objDAO.manipulationMethod("updatebook", objList);
		return b;
	}
	public Boolean deletebook(int bookid) 
	{
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		Boolean b=objDAO.soldBook(bookid,"soldbook");
		return b;
	}
	public List<typedetail> setBookView(String key,int parentid,int typemasterid) 
	{
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		return objDAO.getTypeDetail(key,typemasterid,parentid);
	}
}
