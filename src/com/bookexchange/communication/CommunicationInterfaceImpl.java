package com.bookexchange.communication;

import java.util.ArrayList;
import java.util.List;

import com.bookexchange.DAO.DAOInterface;
import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.beans.comm;

public class CommunicationInterfaceImpl implements CommunicationInterface
{

	
	public Boolean savemessage(List<String> objList) 
	{
		// TODO Auto-generated method stub
		
		
		objList.add(ObjectFactory.getInstance().getTodayDate());
		objList.add(String.valueOf(0));
		
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		Boolean b=objDAO.manipulationMethod("savemsg", objList);
		return b;
	}

	
	public List<comm> getSenderIdName(int bookid)
	{
		int id;
		
		DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
		List<comm> objList=objDAO.getSenderIdName("getsenderid", bookid);
		
		return objList;
	}

	
	public List<comm> showMessageInbox(int userid)
	{
		List<comm> objList=new ArrayList<comm>();
		
		DAOInterface DAOobj=ObjectFactory.getInstance().getDAOInterface();
		objList=DAOobj.getmsgs(userid,"inbox");
		
		
		return objList;
		
		
	}

	public List<comm> showMessageOutbox(int userid)
	{
		List<comm> objList=new ArrayList<comm>();
		
		DAOInterface DAOobj=ObjectFactory.getInstance().getDAOInterface();
		objList=DAOobj.getmsgs(userid,"outbox");
		
		
		return objList;
		
		
	}
	
	public List<comm> showbookmsg(int bookid,int userid)
	{
		List<comm> objList= new ArrayList<comm>();
		DAOInterface DAOobj=ObjectFactory.getInstance().getDAOInterface();
		objList=DAOobj.showbookmsg("prbookmsg", bookid,userid);
		
		return objList;
	}


	
/*	public Userdetail getUser(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bookdetail getbookdetail(int bookid) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*public Userdetail getUser(int userid) {
		// TODO Auto-generated method stub
		Userdetail detail = new Userdetail();
		//Query
		
		detail.setAddress(null);
		detail.setCity(null);
		detail.setUid(0);
		detail.setEmail(null);
		
		return detail;
	}

	public Bookdetail get(int bookid) {
		
		
		// TODO Auto-generated method stub
		return null;
	}*/
	


}
