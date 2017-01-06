package com.bookexchange.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.bookexchange.ObjectFactory.ObjectFactory;

public class ConnectionInterfaceImpl implements ConnectionInterface
{
	public Connection connect() 
	{
		Properties pr=ObjectFactory.getInstance().getProperties();
		try
		{
			Class.forName(pr.getProperty("driver"));
			return DriverManager.getConnection(pr.getProperty("connectionstring"),pr.getProperty("username"),pr.getProperty("password"));
		}
		catch(Exception e)
		{
			return null;
		}
	}
	public void close(Connection c)
	{
		try 
		{
			c.close();
			
		}
		catch(Exception e)
		{
			//return false;
		}
	}

}
