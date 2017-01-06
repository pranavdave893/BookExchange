package com.bookexchange.sell;

import java.util.List;
import com.bookexchange.beans.bookdetail;
import com.bookexchange.beans.typedetail;

public interface SellInterface 
{
	public boolean registerbook(List<String> objList);
	public boolean updateBook(List<String> objList) ;
	public List<bookdetail> getBookDetail(int bid);
	public Boolean deletebook(int bookid);
	public List<typedetail> setBookView(String key,int typemasterid,int parentid);
}
