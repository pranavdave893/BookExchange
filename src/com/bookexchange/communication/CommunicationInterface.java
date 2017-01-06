package com.bookexchange.communication;

import java.util.List;

import com.bookexchange.beans.comm;

public interface CommunicationInterface 
{
	
	public Boolean savemessage(List<String> objList);
	
	public List<comm> getSenderIdName(int bookid);
	
	//public void sendmsg(String sm);
	
	//public void recievemsg(String rm);

	public List<comm> showMessageInbox(int userid);
	public List<comm> showMessageOutbox(int userid);
	public List<comm> showbookmsg(int bookid,int userid); 
	
}
