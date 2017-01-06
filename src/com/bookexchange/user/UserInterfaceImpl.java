package com.bookexchange.user;

import java.util.ArrayList;
import java.util.List;

import com.bookexchange.DAO.DAOInterface;
import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.beans.user;

public class UserInterfaceImpl implements UserInterface 
{
	DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
	boolean b=false;
	public boolean registerUser(String key,List<String> objList)
	{
		
		//b=objDAO.checkDuplicateUser(key, objList);
		
		String email=objList.get(1);
		
		List<String> objList1=new ArrayList<String>();
		objList1.add(email);
		
		b=objDAO.selectMethod(key, objList1);
		
		
		System.out.println(b);
		
		if(b==true)
		{
			objDAO.manipulationMethod("userregistration", objList);
			b=true;
		}
		else
		{
			System.out.println("enter another emailid to avoid duplication");
			b=false;
		}
		return b;
	}

	
	public boolean updateUser(List<String> objList) 
	{
		b=objDAO.manipulationMethod("updateuser", objList);
		return b;
	}

	
	public boolean deleteUser(List<String> objList) 
	{
	
		b=objDAO.manipulationMethod("deleteuser", objList);
		return b;
	}

	public List<user> getUserDetail(String email) 
	{
		List<user> objList=objDAO.userDetail("userdetail",email);	
		return objList;
	}

	
	public String getAddress(int uid) 
	{

		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		
		String add=objDAO.getUseraddress(uid,"getadd");
		return add;
	}

	
	public  boolean updateuseradd(int uid,String address)
	{
		 b=objDAO.updateaddress(uid,"updateadd",address);
		 return b;
	}


	
	
}
