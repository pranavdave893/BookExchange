package com.bookexchange.communication;

import com.bookexchange.beans.bookdetail;
import com.bookexchange.beans.user;

public class DetailsInterfaceImpl implements DetailsInterface {

	public bookdetail getBookdetail(int bookid) {
		// TODO Auto-generated method stub
		
		bookdetail detail=new bookdetail();
		
		//query resultset
		
		detail.setBid(bookid);
		
		
		return null;
	}

	public user getUser(int userid) {
		// TODO Auto-generated method stub
		
		user detail=new user();
		//Query resultset
		
		detail.setUid(userid);
		
		
		
		return null;
	}

}
