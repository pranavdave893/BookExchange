package com.bookexchange.DAO;

import java.util.Hashtable;
import java.util.List;

import com.bookexchange.beans.bid;
import com.bookexchange.beans.bookSearch;
import com.bookexchange.beans.bookdetail;
import com.bookexchange.beans.comm;
import com.bookexchange.beans.confirmation;
import com.bookexchange.beans.deliverydetail;
import com.bookexchange.beans.invoice;
import com.bookexchange.beans.typedetail;
import com.bookexchange.beans.user;

public interface DAOInterface 
{
	public boolean selectMethod(String key,List<String> objList);
	public boolean manipulationMethod(String key,List<String> objList);
	//public boolean checkDuplicateUser(String key,List<String> objList);
	public List<typedetail> getTypeDetail(String key,int parentid,int typemasterid);
	public List<comm> getSenderIdName(String key,int bookid); //get userid(senderid) from bookdetail table for the insertion in comm_t table
	public List<user> userDetail(String key,String email);
	public List<bookdetail> bookDetail(String key,int bid);
	public Hashtable<Integer, bookSearch> searchBook(String key,String bname,int uid);
	public Hashtable<Integer,bookSearch> searchFilter(Hashtable<Integer, bookSearch> objHash,String field);
	public Hashtable<Integer,bookSearch> searchFilterDESC(Hashtable<Integer,bookSearch> objHash,String field);
	public Hashtable<Integer,bookSearch> searchFilterLocation(Hashtable<Integer,bookSearch> objHash,String city);
	public Hashtable<Integer,bookSearch> searchFilterTable_w(Hashtable<Integer, bookSearch> objHash,Hashtable<Integer, bookSearch> objHashLocation,Hashtable<Integer, bookSearch> objHashPrice,Hashtable<Integer, bookSearch> objHashEdition,Hashtable<Integer, bookSearch> objHashCondition);
	public List<bid> bidDetail(int bookid,String key);
	public Double getHighestBidPrice(int bookid,String key);
	public List<comm> getmsgs(int userid,String commmsg);
	public List<bookdetail> showsellbook(String key,int uid);
	public List<comm> showbookmsg(String key,int bookid,int userid);
	public Boolean soldBook(int bookid,String key);
	public List<bookdetail> recentlybookDetail(int uid);
	public boolean updateaddress(int uid,String key,String address);
	public String getUseraddress(int userid,String address);
	public List<confirmation> showconfirmforreceiver(String key,int uid);
	
	public List<user> userdetailBYID(String key,int uid);
	
	public List<confirmation> getconfirmationdetail(int sellerid,int bookid,int buyerid,String key);
	public String getUserCity(String key,int uid);
	public Integer getPostalCharges(String srccity,String destcity,String key);
	public Integer getInvcidANDdeliveryid( int sellerid,int buyerid,int bookid,String key);
	
	public List<invoice> getInvoice(String key,int bookid);
	
	public String gettypedetail(int typeid,String key);
	
	public int getbookflag(int bookid,String key);
	
	
	public List<deliverydetail> ShowBoughtbook(int buyerid,String key);
	
	public Hashtable<Integer,bookSearch> getcategorybook(String key,int bcatid,int uid);
	
}
