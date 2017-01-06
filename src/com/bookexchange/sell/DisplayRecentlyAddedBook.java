package com.bookexchange.sell;

import java.util.ArrayList;
import java.util.List;

import com.bookexchange.DAO.DAOInterface;
import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.beans.bookdetail;

public class DisplayRecentlyAddedBook 
{
	
	public List<bookdetail> displayBook(int uid)
	{
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		List<bookdetail> objList=objDAO.recentlybookDetail(uid);
	
		return objList;
	}
	
}
