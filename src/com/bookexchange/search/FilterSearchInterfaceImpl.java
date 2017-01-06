package com.bookexchange.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;


import com.bookexchange.DAO.DAOInterface;
import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.beans.bookSearch;
import com.bookexchange.beans.bookdetail;

public class FilterSearchInterfaceImpl implements FilterSearchInterface
{

	public Hashtable<Integer,bookSearch> searchByBookname(String bname,String ucity,int uid) 
	{
		
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		
		Hashtable<Integer,bookSearch> objHash=new Hashtable<Integer, bookSearch>();
		
		if(uid==0)
		{
			objHash=objDAO.searchBook("sbookbynameWithoutLogin", bname,uid);
		}
		else
		{
			objHash=objDAO.searchBook("sbookbyname", bname,uid);
		}
		//HashMap<Integer,bookSearch> objHash=Collections.unmodifiableMap(objHashrecentlyadd)
		
		Hashtable<Integer, bookSearch> objHashLocation=objDAO.searchFilterLocation(objHash,ucity);
		
		Hashtable<Integer,bookSearch> objHashPrice=new Hashtable<Integer,bookSearch>();
		objHashPrice=objDAO.searchFilter(objHash,"price");
		
		Hashtable<Integer,bookSearch> objHashEdition=objDAO.searchFilterDESC(objHash,"edition");
		
		Hashtable<Integer,bookSearch> objHashCondition=objDAO.searchFilter(objHash,"condition");
		
		Hashtable<Integer,bookSearch> objHashTotoal_w=objDAO.searchFilterTable_w(objHash, objHashLocation, objHashPrice, objHashEdition, objHashCondition);
		
		Hashtable<Integer,bookSearch> objHashFinal=objDAO.searchFilterDESC(objHash,"totalWeight");
		
		return objHashFinal;
	}
	
	public String gettypename(int typeid)
	{
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		
		String name=null;
		
		name=objDAO.gettypedetail(typeid, "gettypename");
		
		return name;
	}
	
	public Hashtable<Integer,bookSearch> getselectedbook(String bcatid,int uid)
	{
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		Hashtable<Integer,bookSearch> objHash=new Hashtable<Integer, bookSearch>();
		
		if(uid==0)
		{
			objHash=objDAO.getcategorybook("sbookbynameWithoutLoginCat",Integer.parseInt(bcatid),uid);
		}
		else
		{
			objHash=objDAO.getcategorybook("getcategorybook",Integer.parseInt(bcatid),uid);
		}
		return objHash;
		
	}
	
}
