package com.bookexchange.search;

import java.util.Hashtable;
import java.util.List;

import com.bookexchange.beans.bookSearch;
import com.bookexchange.beans.bookdetail;


public interface FilterSearchInterface
{
  
  public Hashtable searchByBookname(String bname,String ucity,int uid);
  
  public String gettypename(int typeid);
  
  public Hashtable<Integer,bookSearch> getselectedbook(String typeid,int uid);
  
}
