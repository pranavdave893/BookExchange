package com.bookexchange.search;

import java.util.List;

import com.bookexchange.beans.bookdetail;

public interface DefaultSearchInterface 
{
 public List<bookdetail> withoutloginusersearch(String bname,String author, String ISBN);
 public List<bookdetail> loginusersearch(int uid,String bname,String author, String ISBN);
 
 
 
}
