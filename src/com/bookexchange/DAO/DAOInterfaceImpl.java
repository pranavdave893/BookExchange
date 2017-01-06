package com.bookexchange.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.bookexchange.ObjectFactory.ObjectFactory;
import com.bookexchange.beans.bookSearch;
import com.bookexchange.beans.bid;
import com.bookexchange.beans.bookdetail;
import com.bookexchange.beans.comm;
import com.bookexchange.beans.confirmation;
import com.bookexchange.beans.deliverydetail;
import com.bookexchange.beans.invoice;
import com.bookexchange.beans.typedetail;
import com.bookexchange.beans.user;
import com.bookexchange.connection.ConnectionInterface;

public class DAOInterfaceImpl implements DAOInterface
{
	ConnectionInterface ci=(ConnectionInterface) ObjectFactory.getInstance().getConnectionInterface();
	Connection conn=ci.connect();
	Boolean b=false;
	Properties pr;
	PreparedStatement ps,ps1;
	int c = 0;
	
	public boolean selectMethod(String key,List<String> objList)
	{
		try 
		{
			pr = ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			c=0;
			
			for(int i = 0 ; i < objList.size();i++)
			{
				ps.setString(i+1,objList.get(i));
			}
			ResultSet rs=ps.executeQuery();
				
			while(rs.next())
			{
				c++;
			}
			if(c<=0)
			{
				b=true;
			}
			else
			{
				b=false;
			}
			rs.close();
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new Error(e);
		}
		return b;
	}
	
	
	public boolean manipulationMethod(String key,List<String> objList)
	{
		try 
		{
			pr = ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			System.out.println(pr.getProperty(key));
			for(int i = 0 ; i < objList.size();i++)
			{
				ps.setString(i+1,objList.get(i));
			}
			ps.executeUpdate();
			b=true;
			ps.close();
		} 
		catch (SQLException e) 
		{
			throw new Error(e);
		}
		return b;
	}
	
	
/*	public boolean checkDuplicateUser(String key, List<String> objList)  //it is implemented in select method.. 
	{
		int count=0;
		try 
		{
			pr = ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			//System.out.println(pr.getProperty(key));
			
			ps.setString(1, objList.get(1));
			System.out.println(objList.get(1));
			ResultSet rs=ps.executeQuery();
			
			while (rs.next())
			{
				count++;
				//System.out.println(rs.getInt(1));
			}
			if (count<=0)
				b=true;
			else      //if(count>=1)
				b=false;
			
			//System.out.println(b);
			
			rs.close();
			ps.close();
			
		}
		catch (SQLException e) 
		{
			throw new Error(e);
		}
		// TODO Auto-generated method stub
		return b;
	}

*/
	
	public List<typedetail> getTypeDetail(String key,int parentid,int typemasterid)
	{
		List<typedetail> objType=new ArrayList<typedetail>();
		
		try 
		{
			pr = ObjectFactory.getInstance().getProperties();
			//prField=ObjectFactory.getInstance().getPropertiesField();
			//prType=ObjectFactory.getInstance().getPropertiesType();
			
			ps=conn.prepareStatement(pr.getProperty(key));
			
			//String[] field=prField.getProperty(key).split(",");
			//String[] type=prType.getProperty(key).split(",");
			
			ps.setInt(1, typemasterid);
			ps.setInt(2, parentid);
			
	
			ResultSet rs=ps.executeQuery();
	
			while(rs.next())
			{
				typedetail td=ObjectFactory.getInstance().getTypeDetail();			
				
				td.setTypeid(rs.getInt("typeid"));
				td.setTypename(rs.getString("typename"));
			
				objType.add(td);
			}
			//System.out.println(objType.get(1));
			
			//Collections.sort(objType);
			
			//rs.close();
			//ps.close();
			//conn.close();
		}
		catch (SQLException e) 
		{
			throw new Error(e);
		}

		return objType;
	}
	
	
	public List<comm> getSenderIdName(String key,int bookid) //get userid(senderid) from bookdetail table for the insertion in comm_t table
	{
		List<comm> objList=new ArrayList<comm>();
		try
		{
			pr = ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			//System.out.println(pr.getProperty(key));
			
			
			
			ps.setInt(1, bookid);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				comm c=ObjectFactory.getInstance().getComm();
				c.setSenderid(rs.getInt("uid"));
				c.setUname(rs.getString("uname"));
				c.setBid(rs.getInt("bid"));
				objList.add(c);
				
			}
			//System.out.println(id);
		}
		catch (SQLException e) 
		{
			throw new Error(e);
		}
		
		return objList;
		
	} 
	
	
	public List<user> userDetail(String key,String email)
	{
		List<user> objList=new ArrayList<user>();
		
		try 
		{
			pr = ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			//System.out.println(pr.getProperty(key));
			//System.out.println(email);
			ps.setString(1, email);
			
			ResultSet rs=ps.executeQuery();
	
			while(rs.next())
			{
				user objUser=ObjectFactory.getInstance().getUser();
				//uname=?,password=?,address=?,city=?, state=?,phno=?,std_type=? where uid=?
				objUser.setUid(rs.getInt("uid"));
				objUser.setUname(rs.getString("uname"));
				System.out.println(rs.getString("uname"));
				objUser.setEmail(rs.getString("email"));
				objUser.setPassword(rs.getString("password"));
				objUser.setStdtype(rs.getString("stdtype"));
				objUser.setAddress(rs.getString("address"));
				objUser.setCity(rs.getString("city"));
				objUser.setState(rs.getString("state"));
				objUser.setPhno(rs.getInt("phno"));
				objUser.setPincode(rs.getInt("pincode"));
		
				objList.add(objUser);
				
				//System.out.println(rs.getString("uname"));	
			
				/*objList.add(rs.getString("uname"));
				objList.add(rs.getString("password"));
				objList.add(rs.getString("stdtype"));
				objList.add(rs.getString("address"));
				objList.add(rs.getString("city"));
				objList.add(rs.getString("state"));
				objList.add(String.valueOf(rs.getInt("phno")));
				objList.add(String.valueOf(rs.getInt("pincode")));
				*/
				//c++;
				
			}
			System.out.println(objList.size());
			//System.out.println(c);
			
			
			rs.close();
			ps.close();
			//conn.close();
		}
		catch (SQLException e) 
		{
			throw new Error(e);
		}

		
		return objList;
		
	}

	public List<bookdetail> bookDetail(String key,int bid)
	{
		List<bookdetail> objList=new ArrayList<bookdetail>();
		try
		{
			pr = ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			System.out.println(pr.getProperty(key));
			System.out.println(bid);
			ps.setInt(1, bid);
			
			ResultSet rs=ps.executeQuery();
	
			while(rs.next())
			{
				bookdetail objbookdetail=ObjectFactory.getInstance().getBookdetail();
				//uname=?,password=?,address=?,city=?, state=?,phno=?,std_type=? where uid=?
				objbookdetail.setBname(rs.getString("bname"));
				
				System.out.println(rs.getString("bname"));
				objbookdetail.setAuthor(rs.getString("author"));
				objbookdetail.setPublication(rs.getString("publication"));
				objbookdetail.setIsbn(rs.getString("isbn"));
				objbookdetail.setOldprice(rs.getFloat("oldprice"));
				objbookdetail.setNewprice(rs.getFloat("newprice"));
				objbookdetail.setBtypeid(rs.getInt("btypeid"));
				objbookdetail.setBcondid(String.valueOf(rs.getInt("bcondid")));
				objbookdetail.setBcatid(rs.getInt("bcatid"));
				objbookdetail.setEditionid(rs.getInt("editionid"));
				objbookdetail.setContent(rs.getString("content"));
				objbookdetail.setBid(bid);
				objbookdetail.setBregdate(rs.getTimestamp("bregdate"));
				objList.add(objbookdetail);
				
				//System.out.println(rs.getString("uname"));	
			
				/*objList.add(rs.getString("uname"));
				objList.add(rs.getString("password"));
				objList.add(rs.getString("stdtype"));
				objList.add(rs.getString("address"));
				objList.add(rs.getString("city"));
				objList.add(rs.getString("state"));
				objList.add(String.valueOf(rs.getInt("phno")));
				objList.add(String.valueOf(rs.getInt("pincode")));
				*/
				//c++;
				
			}
			System.out.println(objList.size());
			//System.out.println(c);
			
			
			rs.close();
			ps.close();
			
		}
		catch (SQLException e) 
		{
			throw new Error(e);
		}

		return objList;
		
	}
	
	
	public Hashtable<Integer, bookSearch> searchBook(String key,String bname,int uid)
	{
		
		Hashtable<Integer, bookSearch> objHash=new Hashtable<Integer, bookSearch>();
		
		try 
		{
		    final int Tablew=1;
			pr = ObjectFactory.getInstance().getProperties();
			
			ps=conn.prepareStatement(pr.getProperty(key));
			
			ps.setString(1, "%"+bname+"%");
			
			if(uid!=0)
			{
				ps.setInt(2, uid);
			}
			
			ResultSet rs=ps.executeQuery();
			int cnt = 0;
			while(rs.next())
			{
				bookSearch book=ObjectFactory.getInstance().getBookSearch();
				book.setB_id(rs.getInt("bid"));
				book.setName(rs.getString("bname"));
				book.setPrice(rs.getFloat("newprice"));
				book.setBtypeid(rs.getInt("btypeid"));
				book.setCondition(rs.getInt("bcondid"));
				
				book.setEdition(rs.getInt("editionid"));
				book.setLocation(rs.getString("city"));
				book.setRating(rs.getFloat("urating"));
				book.setDateadd(rs.getTimestamp("bregdate"));
				book.setImage(rs.getString("image"));
				
				objHash.put(cnt++, book);
				
			}
			cnt = objHash.size();
			for(int i = 0; i < objHash.size();i++)
			{
				bookSearch b = ObjectFactory.getInstance().getBookSearch();
				b=objHash.get(i);
				b.setRow_w(cnt--);
				b.setTable_w(Tablew);
				objHash.put(i, b);
			}
			
		}
		catch (Exception e) 
		{
			throw new Error(e);
		}
		
		return objHash;
		
	}

	public Hashtable<Integer, bookSearch> searchFilter(Hashtable<Integer,bookSearch> objHash,String field)
	{
		
		Hashtable<Integer, bookSearch> objHashOP=new Hashtable<Integer, bookSearch>();
		objHashOP.putAll(objHash);
		//objHash.clear();
		
		Double d1 = null,d2 = null;
		int table_w=0;
		int row_w=objHashOP.size();
		
		
		bookSearch b=ObjectFactory.getInstance().getBookSearch();
		
		int select = 0;
		if(field=="price" || field=="condition")
		{
			if(field=="price")
			{
				select=1;
				table_w=3;
			}
			else
			{
				select=3;
				table_w=5;
			}
			
			
			for(int i=0;i<=objHashOP.size()-1;i++)
			{
				for(int j=0;j<i;j++)
				{
					if(select==1)
					{
						d1=objHashOP.get(i).getPrice();
						d2=objHashOP.get(j).getPrice();
					}
					else if(select==3)
					{
						d1=(double) objHashOP.get(i).getCondition();
						d2=(double) objHashOP.get(j).getCondition();
					}
					
					System.out.println(d1+"<"+d2);
					
					if(d1 < d2)
					{
						b=objHashOP.get(i);
						objHashOP.put(i, objHashOP.get(j));
						objHashOP.put(j, b);	
					}
				}
			}
			
			for(int x=0;x<objHashOP.size();x++)
			{
					bookSearch book1=ObjectFactory.getInstance().getBookSearch();
					//book1=objHashOP.get(x);
					book1.setB_id(objHashOP.get(x).getB_id());
					book1.setCondition(objHashOP.get(x).getCondition());
					book1.setDateadd(objHashOP.get(x).getDateadd());
					book1.setEdition(objHashOP.get(x).getEdition());
					book1.setLocation(objHashOP.get(x).getLocation());
					book1.setName(objHashOP.get(x).getName());
					book1.setPrice(objHashOP.get(x).getPrice());
					book1.setImage(objHashOP.get(x).getImage());
					book1.setRow_w(row_w--);
					book1.setTable_w(table_w);
					
					book1.setBtypeid(objHashOP.get(x).getBtypeid());
					
					objHashOP.put(x, book1);
				
				/*objHashOP.get(x).setRow_w(0);
				objHashOP.get(x).setTable_w(0);*/
			}
		}

		return objHashOP;
	
	}
	
	public Hashtable<Integer,bookSearch> searchFilterDESC(Hashtable<Integer,bookSearch> objHash,String field)
	{
		Hashtable<Integer, bookSearch> objHashEdition=new Hashtable<Integer, bookSearch>();
		//objHashEdition = objHash;
		objHashEdition.putAll(objHash);
		
		bookSearch b=ObjectFactory.getInstance().getBookSearch();
		
		int table_w=4;
		int row_w=objHashEdition.size();
		
		int select=0;
		
		Double d1=null,d2=null;
			
		if(field=="edition" || field=="totalWeight")
		{
			if(field=="edition")
			{
				select=1;
				table_w=4;
			}
			else
			{
				select=3;
				
			}
			
		}	
		
			for(int i=0;i<=objHashEdition.size()-1;i++)
			{
				for(int j=0;j<i;j++)
				{
					
					if(select==1)
					{
						d1=(double) objHashEdition.get(i).getEdition();
						d2=(double) objHashEdition.get(j).getEdition();
					}
					else if(select==3)
					{
						d1=(double) objHashEdition.get(i).getTable_w();
						d2=(double) objHashEdition.get(j).getTable_w();
					}
					
					System.out.println(d1+">"+d2);
					
					if(d1 > d2)
					{
						b=objHashEdition.get(i);
						objHashEdition.put(i, objHashEdition.get(j));
						objHashEdition.put(j, b);
					}
				}
			}
			
			
		
				for(int x=0;x<objHashEdition.size();x++)
				{
					bookSearch bookEdition=ObjectFactory.getInstance().getBookSearch();
					
					bookEdition.setB_id(objHashEdition.get(x).getB_id());
					bookEdition.setCondition(objHashEdition.get(x).getCondition());
					bookEdition.setDateadd(objHashEdition.get(x).getDateadd());
					bookEdition.setEdition(objHashEdition.get(x).getEdition());
					bookEdition.setLocation(objHashEdition.get(x).getLocation());
					bookEdition.setName(objHashEdition.get(x).getName());
					bookEdition.setPrice(objHashEdition.get(x).getPrice());
					bookEdition.setBtypeid(objHashEdition.get(x).getBtypeid());
					bookEdition.setImage(objHashEdition.get(x).getImage());
					bookEdition.setRow_w(row_w--);
					
					if(select==1)
					{
						bookEdition.setTable_w(table_w);
					}
					else
					{
						bookEdition.setRow_w(objHashEdition.get(x).getTable_w());
					}
					
					objHashEdition.put(x, bookEdition);
				}
			
			
			return objHashEdition;
	}
		

		

	public Hashtable<Integer,bookSearch> searchFilterLocation(Hashtable<Integer,bookSearch> objHash,String city)
	{
		
		final int tablew=2;
		
		Hashtable<Integer, bookSearch> objHashLocation=new Hashtable<Integer, bookSearch>();
		objHashLocation.putAll(objHash);
		
		int table_w=2;
		int row_w=objHashLocation.size();
		
			Hashtable<Integer, bookSearch> objHash1=new Hashtable<Integer, bookSearch>();
			Hashtable<Integer, bookSearch> objHash2=new Hashtable<Integer, bookSearch>();
			int c1=0;
			int c2=0;
			for(int i=0;i<=objHashLocation.size()-1;i++)
			{
				if(objHash.get(i).getLocation().equals(city))
				{
					objHash1.put(c1, objHash.get(i));
					c1++;
				}
				else
				{
					objHash2.put(c2, objHash.get(i));
					c2++;
				}
			}
			
			for(int i=0;i<objHash2.size();i++)
			{
				objHash1.put(c1++, objHash2.get(i));
			}
			
			objHashLocation.putAll(objHash1);
			
			for(int x=0;x<objHashLocation.size();x++)
			{
				bookSearch bookLoc=ObjectFactory.getInstance().getBookSearch();
				
				bookLoc.setB_id(objHashLocation.get(x).getB_id());
				bookLoc.setCondition(objHashLocation.get(x).getCondition());
				bookLoc.setDateadd(objHashLocation.get(x).getDateadd());
				bookLoc.setEdition(objHashLocation.get(x).getEdition());
				bookLoc.setLocation(objHashLocation.get(x).getLocation());
				bookLoc.setName(objHashLocation.get(x).getName());
				bookLoc.setPrice(objHashLocation.get(x).getPrice());
				bookLoc.setRow_w(row_w--);
				bookLoc.setTable_w(tablew);
				bookLoc.setBtypeid(objHashLocation.get(x).getBtypeid());
				bookLoc.setImage(objHashLocation.get(x).getImage());
				objHashLocation.put(x, bookLoc);
			}
			
			return objHashLocation;
			
	}
	
	public Hashtable<Integer, bookSearch> searchFilterTable_w(
			Hashtable<Integer, bookSearch> objHash, Hashtable<Integer, bookSearch> objHashLocation,
			Hashtable<Integer, bookSearch> objHashPrice, Hashtable<Integer, bookSearch> objHashEdition,
			Hashtable<Integer, bookSearch> objHashCondition) 
	{
		int Total_w=0;
		int b_id,b_idL,b_idE,b_idC,b_idP;
		
		
		
		Hashtable<Integer, bookSearch> objHashTable_w=new Hashtable<Integer, bookSearch>();
		objHashTable_w.putAll(objHash);
		
		Hashtable<Integer, bookSearch> objHashFinal=new Hashtable<Integer, bookSearch>();
		
		for(int i=0;i<objHashTable_w.size();i++)
		{
			b_id=objHashTable_w.get(i).getB_id();
			Total_w=0;
			Total_w=(objHashTable_w.get(i).getRow_w()*objHashTable_w.get(i).getTable_w());
			
			for(int j=0;j<objHashTable_w.size();j++)
			{
				b_idL=objHashLocation.get(j).getB_id();
				b_idP=objHashPrice.get(j).getB_id();
				b_idE=objHashEdition.get(j).getB_id();
				b_idC=objHashCondition.get(j).getB_id();
				
				if(b_id==b_idL)
				{
					Total_w=Total_w+(objHashLocation.get(j).getTable_w()*objHashLocation.get(j).getRow_w());
				}
				if(b_id==b_idP)
				{
					Total_w=Total_w+(objHashPrice.get(j).getTable_w()*objHashPrice.get(j).getRow_w());
				}
				if(b_id==b_idE)
				{
					Total_w=Total_w+(objHashEdition.get(j).getTable_w()*objHashEdition.get(j).getRow_w());
				}
				if(b_id==b_idC)
				{
					Total_w=Total_w+(objHashCondition.get(j).getTable_w()*objHashCondition.get(j).getRow_w());
				}
			}
			
			bookSearch bookTotal_w=ObjectFactory.getInstance().getBookSearch();
			
			bookTotal_w.setB_id(objHashTable_w.get(i).getB_id());
			bookTotal_w.setCondition(objHashTable_w.get(i).getCondition());
			bookTotal_w.setDateadd(objHashTable_w.get(i).getDateadd());
			bookTotal_w.setEdition(objHashTable_w.get(i).getEdition());
			bookTotal_w.setLocation(objHashTable_w.get(i).getLocation());
			bookTotal_w.setName(objHashTable_w.get(i).getName());
			bookTotal_w.setPrice(objHashTable_w.get(i).getPrice());
			bookTotal_w.setBtypeid(objHashTable_w.get(i).getBtypeid());
			bookTotal_w.setImage(objHashTable_w.get(i).getImage());
			bookTotal_w.setTable_w(Total_w);
			objHashFinal.put(i, bookTotal_w);
			
		}

		return objHashFinal;
	}

	
	public List<bid> bidDetail(int bookid,String key)
	{
		
		
		List<bid> objList=new ArrayList<bid>();
		
		
		try{
			
			
		pr = ObjectFactory.getInstance().getProperties();
		ps=conn.prepareStatement(pr.getProperty(key));
		System.out.println(pr.getProperty(key));
		
		ps.setInt(1, bookid);
		
		ResultSet rs=ps.executeQuery();

		while(rs.next())
		{
			bid objBid=ObjectFactory.getInstance().getBid();
			
			objBid.setUname(String.valueOf(rs.getString("uname")));
			objBid.setBidprice(rs.getDouble("bidprice"));
			objBid.setBid(rs.getInt("bid"));
			objBid.setUid(rs.getInt("uid"));
			objBid.setBidid(rs.getInt("bidid"));
			objBid.setBdatetime(rs.getTimestamp("bdatetime"));
			
			objList.add(objBid);
			
		}
		
		
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		
		return objList;
		
	}
	
	
	public Double getHighestBidPrice(int bookid,String key)
	{
	
		Double price=(double) 0;
		
		try{
			
			
			pr = ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			//System.out.println(pr.getProperty(key));
			
			ps.setInt(1, bookid);
			
			ResultSet rs=ps.executeQuery();
		
			while (rs.next())
			{
				 price=(double) rs.getDouble("HighestPrice");
				
			}
			
		
			//	System.out.println("c=="+c);
			
			/*if(c==0)
			{
				price=null;
			}*/
			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			
			throw new Error(e);
		}
		
		
		return price;
		
	}
	
	
	public List<comm> getmsgs(int userid,String key)
	{
		List<comm> objList=new ArrayList<comm>();
		try
		{
				
			pr = ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			
			ps.setInt(1, userid);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				comm c= ObjectFactory.getInstance().getComm();
				c.setReceiverid(rs.getInt("receiverid"));
				c.setSenderid(rs.getInt("senderid"));
				c.setBid(rs.getInt("bid"));
				c.setMsg(rs.getString("msg"));
				objList.add(c);
			}
		}
		catch(Exception e)
		{
			throw new Error(e);
		}
		
	 return objList;
	}
	
	public List<bookdetail> showsellbook(String key,int uid)
	{
		List<bookdetail> objList=new ArrayList<bookdetail>();
		
		try
		{
			pr=ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			System.out.print(pr.getProperty(key));
			ps.setInt(1,uid);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				
				bookdetail objBook=ObjectFactory.getInstance().getBookdetail();
				
				objBook.setBname(rs.getString("bname"));
				objBook.setBid(rs.getInt("bid"));
				objBook.setAuthor(rs.getString("author"));
				objBook.setPublication(rs.getString("publication"));
				objBook.setIsbn(rs.getString("ISBN"));
				objBook.setOldprice(rs.getFloat("oldprice"));
				objBook.setNewprice(rs.getFloat("newprice"));
				objBook.setUid(rs.getInt("Uid"));
				objBook.setBregdate(rs.getTimestamp("bregdate"));
				
				objList.add(objBook);
				
				
				
			}
			rs.close();
			ps.close();
			
		}
		catch(Exception e)
		{
			throw new Error(e);
			
		}
		
		return objList;

		
	}


	public List<comm> showbookmsg(String key,int bookid,int userid)
	{
		List<comm> objList=new ArrayList<comm>();
		try
		{
			
		pr = ObjectFactory.getInstance().getProperties();
		ps=conn.prepareStatement(pr.getProperty(key));
		
	
		ps.setInt(1, userid);
		ps.setInt(2, bookid);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
				{
					comm c= ObjectFactory.getInstance().getComm();
					c.setSenderid(rs.getInt("senderid"));
					c.setSenderid(rs.getInt("receiverid"));
					c.setUname(rs.getString("uname"));
					c.setDatetime(rs.getTimestamp("datetime"));
					c.setMsg(rs.getString("msg"));
					objList.add(c);
				}
		}
		
		catch(Exception e)
		{
			throw new Error(e);
		}
		
	 return objList;
	}
	
	
	
	public Boolean soldBook(int bookid,String key)
	{
		
		b=false;
		try
		{
			
		pr = ObjectFactory.getInstance().getProperties();
		ps=conn.prepareStatement(pr.getProperty(key));
	
		ps.setInt(1, bookid);
		
		int i=0;
		i=ps.executeUpdate();
			if(i>0)
			{
			b=true;
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			throw new Error(e);
		}
		
		return b;
		
		
	}
	
	
	

	public List<bookdetail> recentlybookDetail(int uid)
	{
		List<bookdetail> objList=new ArrayList<bookdetail>();
		try
		{
			String key;
			pr = ObjectFactory.getInstance().getProperties();
			if(uid==0)
			{
				key="recentlyaddedbook";
				ps=conn.prepareStatement(pr.getProperty(key));
				
			}
			else
			{
				key="recentlyaddedbook1";
				ps=conn.prepareStatement(pr.getProperty(key));
				ps.setInt(1, uid);
			}
			
			ResultSet rs=ps.executeQuery();
	
			while(rs.next())
			{
				bookdetail objbookdetail=ObjectFactory.getInstance().getBookdetail();
				//uname=?,password=?,address=?,city=?, state=?,phno=?,std_type=? where uid=?
				objbookdetail.setBname(rs.getString("bname"));
				objbookdetail.setBid(rs.getInt("bid"));
				//System.out.println(rs.getString("bname"));
				objbookdetail.setAuthor(rs.getString("author"));
				objbookdetail.setPublication(rs.getString("publication"));
				objbookdetail.setIsbn(rs.getString("isbn"));
				objbookdetail.setOldprice(rs.getFloat("oldprice"));
				objbookdetail.setNewprice(rs.getFloat("newprice"));
				objbookdetail.setBtypeid(rs.getInt("btypeid"));
				objbookdetail.setBcondid(String.valueOf(rs.getInt("bcondid")));
				objbookdetail.setBcatid(rs.getInt("bcatid"));
				objbookdetail.setEditionid(rs.getInt("editionid"));
				objbookdetail.setContent(rs.getString("content"));
				objbookdetail.setImage(rs.getString("image"));
				objList.add(objbookdetail);
				
				//System.out.println(rs.getString("uname"));	
			
				/*objList.add(rs.getString("uname"));
				objList.add(rs.getString("password"));
				objList.add(rs.getString("stdtype"));
				objList.add(rs.getString("address"));
				objList.add(rs.getString("city"));
				objList.add(rs.getString("state"));
				objList.add(String.valueOf(rs.getInt("phno")));
				objList.add(String.valueOf(rs.getInt("pincode")));
				*/
				//c++;
				
			}
			System.out.println(objList.size());
			//System.out.println(c);
			
			
			rs.close();
			ps.close();
			
		}
		catch (SQLException e) 
		{
			throw new Error(e);
		}

		return objList;
		
	}
	
	public String getUseraddress(int userid,String key)
	{
		String add = null;
		try
		{
			
		
		pr=ObjectFactory.getInstance().getProperties();
		ps=conn.prepareStatement(pr.getProperty(key));
		
		ps.setInt(1, userid);
		
		ResultSet rs=ps.executeQuery();
		//System.out.println(pr.getProperty(key));
		
		while(rs.next())
		{
			add=rs.getString("shippingaddress");
		}
	
		
		
		ps.close();
		conn.close();
	} 
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		throw new Error(e);
		//e.printStackTrace();
		
	}
	
	
	return add;
	}
	
	
	
	public boolean updateaddress(int uid,String key,String address)
	{
		try{
			
			pr=ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			
			System.out.println(pr.getProperty(key));
			ps.setString(1,address);
			ps.setInt(2,uid);
			
		
		ps.executeUpdate();
		b=true;
		
		ps.close();
		
		conn.close();
		}
	
		catch(SQLException e)
		{
			throw new Error(e);
		}
	
		return b;
	}
	
	
	
	
	public List<confirmation> showconfirmforreceiver(String key,int uid)
	
	{
		List<confirmation> objList=new ArrayList<confirmation>();
		
		try
		{
			
			pr=ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			
			System.out.println(pr.getProperty(key));
			ps.setInt(1,uid);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				confirmation objCon=ObjectFactory.getInstance().getConfirmation();
				
				objCon.setBid(rs.getInt("bid"));
				objCon.setSenderid(rs.getInt("senderid"));
				objCon.setReceiverid(rs.getInt("receiverid"));
				objCon.setBidprice(rs.getDouble("bidprice"));
				
				objList.add(objCon);
			}
		}
		catch (Exception e) 
		{
			throw new Error(e);
		}

		return objList;
		
	}
	
	
	public List<user> userdetailBYID(String key,int uid)
	{
		
		List<user> objList=new ArrayList<user>();
		
		try
		{
			
			pr=ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			
			//System.out.println(pr.getProperty(key));
			ps.setInt(1,uid);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				user objuser=ObjectFactory.getInstance().getUser();
				
				objuser.setCity(rs.getString("city"));
				objuser.setShippingaddress(rs.getString("shippingaddress"));
				objuser.setAddress(rs.getString("address"));
				objuser.setUname(rs.getString("uname"));
				
				objList.add(objuser);
			}
		}
		catch (Exception e) 
		{
			throw new Error(e);
		}

		return objList;
		
	}
	
	

	public String getUserCity(String key,int uid)
	
	{
		String city=null;
		try
		{
			pr=ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			
			ps.setInt(1, uid);
			
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				city=rs.getString("city");
			}
		}
			
	    catch (Exception e) 
	    {
			// TODO: handle exception
	    	throw new Error(e);
		}
	
		return city;
	}
	
	
	
	public List<confirmation> getconfirmationdetail(int sellerid,int buyerid,int bookid,String key) 
	{
		List<confirmation> objList= new ArrayList<confirmation>();
		
		try
		{
		
			pr=ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			
			ps.setInt(1, sellerid);
			ps.setInt(2, buyerid);
			ps.setInt(3, bookid);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				confirmation con=ObjectFactory.getInstance().getConfirmation();
				con.setBid(rs.getInt("bid"));
				con.setBidprice(rs.getDouble("bidprice"));
				con.setReceiverid(rs.getInt("receiverid"));
				con.setSenderid(rs.getInt("senderid"));
				con.setBidid(rs.getInt("bidid"));
				
				objList.add(con);
				
			
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			throw new Error(e);
		}
		
		return objList;
	}
	
	
	public Integer getPostalCharges(String srccity,String destcity,String key) 
    {
		int charges=0;
		try
		{
		 
			pr=ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			
			ps.setString(1, srccity);
			ps.setString(2, destcity);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				charges=rs.getInt("charges");
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			throw new Error(e);
		}
		return charges;
	}
	
	public Integer getInvcidANDdeliveryid( int sellerid,int buyerid,int bookid,String key) 
	{ 
		int id=0;
	
		try
		{
		
			pr=ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			
			ps.setInt(1, sellerid);
			ps.setInt(2, buyerid);
			
			if(key.equals("getinvcid"))
			{
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
						id=rs.getInt("invcid");
				}
			}
			else
			{
				ps.setInt(3, bookid);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					id=rs.getInt("did");
				}
			}
		}
		
		catch (Exception e) 
		{
			throw new Error(e);
		}
		
		return id;
	}
	
	public List<invoice> getInvoice(String key,int bookid)
	{
		List<invoice> objList=new ArrayList<invoice>();
		
		try
		{
		 
			pr=ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			ps.setInt(1, bookid);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				invoice i=ObjectFactory.getInstance().getInvoice();
				
				i.setInvcid(rs.getInt("invcid"));
				i.setDate(rs.getTimestamp("invcdatetime"));
				i.setSellername(rs.getString("uname"));
				i.setBaddress(rs.getString("shippingaddress"));
				i.setBuyername(rs.getString("rname"));
				i.setSaddress(rs.getString("address"));
				i.setBookname(rs.getString("bname"));
				i.setCharges(rs.getDouble("charges"));
				i.setPrice(rs.getDouble("price"));
				i.setTotalprice(rs.getDouble("finalprice"));
				i.setBquantity(rs.getInt("bqnty"));
				
				objList.add(i);
			}
		}
		catch (Exception e) 
		{
			throw new Error(e);
		}
		
		return objList;
	}
	
	
	public String gettypedetail(int typeid,String key)
	{
		
		String name=null;
		

		try
		{
		 
			pr=ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			
			ps.setInt(1, typeid);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				name=rs.getString("typename");
			}
		}
		catch (Exception e) 
		{
			throw new Error(e);
		}
		
		
		return name;
		
	}
	
	
	public int getbookflag(int bookid,String key)
	{
		int id = 0;
		
		try
		{
		 
			pr=ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			
			ps.setInt(1, bookid);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				id=rs.getInt("fstatusid");
			}
		}
		catch (Exception e) 
		{
			throw new Error(e);
		}
		return id;
		
	}
	
	
	
	public List<deliverydetail> ShowBoughtbook(int buyerid,String key) 
	{
		List<deliverydetail> objList=new ArrayList<deliverydetail>();
		try
		{
			
			pr=ObjectFactory.getInstance().getProperties();
			ps=conn.prepareStatement(pr.getProperty(key));
			
			System.out.println(pr.getProperty(key));
			ps.setInt(1,buyerid);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				deliverydetail d=ObjectFactory.getInstance().getDeliverydetail();
				
				d.setSellerid(rs.getInt("sellerid"));
				d.setBuyerid(rs.getInt("buyerid"));
				d.setBid(rs.getInt("bid"));
				d.setBname(rs.getString("bname"));
				d.setDmodeid(rs.getInt("dmodeid"));
				
				objList.add(d);
				
			}
		}	
		catch (Exception e) 
		{
			// TODO: handle exception
			throw new Error(e);
			
		}
			
		return objList;
	}
	
	
	public Hashtable<Integer,bookSearch> getcategorybook(String key,int bcatid,int uid)
	{
		Hashtable<Integer, bookSearch> objHash=new Hashtable<Integer, bookSearch>();
		
		try 
		{
		   // final int Tablew=1;
			pr = ObjectFactory.getInstance().getProperties();
			
			ps=conn.prepareStatement(pr.getProperty(key));
			
			ps.setInt(1, bcatid);
			
			if(uid!=0)
			{
				ps.setInt(2, uid);
			}
			
			ResultSet rs=ps.executeQuery();
			int cnt = 0;
			while(rs.next())
			{
				bookSearch book=ObjectFactory.getInstance().getBookSearch();
				book.setB_id(rs.getInt("bid"));
				book.setName(rs.getString("bname"));
				book.setPrice(rs.getFloat("newprice"));
				book.setBtypeid(rs.getInt("btypeid"));
				book.setCondition(rs.getInt("bcondid"));
				
				book.setEdition(rs.getInt("editionid"));
				book.setLocation(rs.getString("city"));
				book.setRating(rs.getFloat("urating"));
				book.setDateadd(rs.getTimestamp("bregdate"));
				book.setImage(rs.getString("image"));
				
				objHash.put(cnt++, book);
				
			}
			/*cnt = objHash.size();
			for(int i = 0; i < objHash.size();i++)
			{
				bookSearch b = ObjectFactory.getInstance().getBookSearch();
				b=objHash.get(i);
				b.setRow_w(cnt--);
				b.setTable_w(Tablew);
				objHash.put(i, b);
			}*/
			
		}
		catch (Exception e) 
		{
			throw new Error(e);
		}
		
		return objHash;
	}
	
}

