package com.bookexchange.user;

import java.util.List;

import com.bookexchange.beans.user;

public interface UserInterface 
{
 public boolean registerUser(String key,List<String> objList);
 public boolean updateUser(List<String> objList);
 public boolean deleteUser(List<String> objList);
 public List<user> getUserDetail(String email);
 public String getAddress(int uid);
 public  boolean updateuseradd(int uid,String address);
 //public void validate(int uid);
}
