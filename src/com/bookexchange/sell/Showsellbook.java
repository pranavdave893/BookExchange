package com.bookexchange.sell;

import java.util.List;

import com.bookexchange.DAO.DAOInterface;
import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.beans.bookdetail;

public class Showsellbook 
{
	public List<bookdetail> showsellbook(int uid)
	{
	DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
	List<bookdetail> objList;
	
    objList=objDAO.showsellbook("showsellbook",uid);
    
    return objList;
    
	}
}

	

