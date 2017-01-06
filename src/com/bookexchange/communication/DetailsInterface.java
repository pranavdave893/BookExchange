package com.bookexchange.communication;

import com.bookexchange.beans.bookdetail;
import com.bookexchange.beans.user;

public interface DetailsInterface {

	public user getUser(int userid);
	
	public bookdetail getBookdetail(int bookid);
}
