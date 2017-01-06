package com.bookexchange.login;


import java.util.ArrayList;
import java.util.List;

import com.bookexchange.DAO.DAOInterface;
import com.bookexchange.ObjectFactory.ObjectFactory;


public class LoginInterfaceImpl implements LoginInterface
{

	public boolean authentication(List<String> objList) 
	{
		
		DAOInterface obj=ObjectFactory.getInstance().getDAOInterface();
		
		boolean b=obj.selectMethod("login",objList);
		
		return b;
		
	}

}
