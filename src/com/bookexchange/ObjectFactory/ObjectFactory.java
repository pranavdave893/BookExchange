package com.bookexchange.ObjectFactory;

/*import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;*/
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.bookexchange.DAO.DAOInterface;
import com.bookexchange.DAO.DAOInterfaceImpl;
import com.bookexchange.beans.bid;
import com.bookexchange.beans.bookSearch;
import com.bookexchange.beans.bookdetail;
import com.bookexchange.beans.comm;
import com.bookexchange.beans.confirmation;
import com.bookexchange.beans.deliverydetail;
import com.bookexchange.beans.invoice;
import com.bookexchange.beans.typedetail;
import com.bookexchange.beans.user;
import com.bookexchange.buy.BuyInterfaceImpl;
import com.bookexchange.buy.BuyInterface;
import com.bookexchange.communication.CommunicationInterfaceImpl;
import com.bookexchange.communication.CommunicationInterface;
import com.bookexchange.communication.DetailsInterfaceImpl;
import com.bookexchange.communication.DetailsInterface;
import com.bookexchange.connection.ConnectionInterface;
import com.bookexchange.connection.ConnectionInterfaceImpl;
import com.bookexchange.invoice.invoiceInterface;
import com.bookexchange.invoice.invoiceInterfaceimpl;
import com.bookexchange.login.LoginInterface;
import com.bookexchange.login.LoginInterfaceImpl;
import com.bookexchange.search.DefaultSearchInterfaceImpl;
import com.bookexchange.search.DefaultSearchInterface;
import com.bookexchange.search.FilterSearchInterfaceImpl;
import com.bookexchange.search.FilterSearchInterface;
import com.bookexchange.sell.DisplayRecentlyAddedBook;
import com.bookexchange.sell.SellInterfaceImpl;
import com.bookexchange.sell.SellInterface;
import com.bookexchange.sell.Showsellbook;
import com.bookexchange.user.UserInterface;
import com.bookexchange.user.UserInterfaceImpl;

import java.sql.Connection;


public class ObjectFactory 
{
		static Properties pr=new Properties();
		Date date;
	
		private static ObjectFactory obj;
		public static ObjectFactory getInstance()
		{
			
			if(obj == null)
				obj = new ObjectFactory();
			return obj;
		}
		
		public BuyInterface getBuyInterface(){
			return new BuyInterfaceImpl();
		}
		
		public CommunicationInterface getCommunicationInterface()
		{
			return new CommunicationInterfaceImpl();
		}
		
		public DetailsInterface getDetailsInterface()
		{
			return new DetailsInterfaceImpl();
		} 
		public UserInterface getUserInterface()
		{
			return new UserInterfaceImpl();
		} 
		public SellInterface getSellInterface(){
			return new SellInterfaceImpl();
		} 
		public DefaultSearchInterface getDefaultSearchInterface(){
			return new DefaultSearchInterfaceImpl();
		} 
		public FilterSearchInterface getFilterSearchInterface(){
			return (FilterSearchInterface) new FilterSearchInterfaceImpl();
		} 
		public LoginInterface getLoginInterface(){
			return new LoginInterfaceImpl();
		} 
		public ConnectionInterface getConnectionInterface(){
			return new ConnectionInterfaceImpl();
		} 
		public Properties getProperties()
		{
			if (pr!=null)
			{
				try
				{
					//System.out.println(ObjectFactory.class.getClassLoader().getResourceAsStream("//propertyFile.properties"));
					pr.load( ObjectFactory.class.getClassLoader().getResourceAsStream("//propertyFile.properties"));
					//InputStream in = getClass().getResourceAsStream("foo.properties");
					//pr.load(in);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			}
			else
			{
			return pr;
			}
			return pr;
		} 
		
		
		public DAOInterface getDAOInterface(){
			return new DAOInterfaceImpl();
		}
		
		public String getTodayDate(){
			date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//System.out.println(sdf.format(date));
			return sdf.format(date);
		}
		
		public typedetail getTypeDetail()
		{
			return new typedetail();
		}
		
		public DisplayRecentlyAddedBook getDisplayRecentlyAddedBook()
		{
			return new DisplayRecentlyAddedBook();
		}
		
		
		public user getUser()
		{
			return new user();
		}
		
		public bookdetail getBookdetail()
		{
			return new bookdetail();
		}
		
		public bookSearch getBookSearch(){
			return new bookSearch();
		}
		
		public bid getBid()
		{
			return new bid();
		}
		
		public comm getComm()
		{
			return new comm();
		}
		
		public Showsellbook getShowsellbook()
		{
		return new Showsellbook();	
		}
		
		public invoice getInvoice()
		{
			return new invoice();
		}
		
		public invoiceInterface getInvoiceInterface()
		{
			return new invoiceInterfaceimpl();
		}
		
		
		public confirmation getConfirmation()
		{
			return new confirmation();
		}
		
		public deliverydetail getDeliverydetail()
		{
			return new deliverydetail();
		}
		
		
		/*bookdetail
		cmntdetail
		cmntreplay
		comm
		courierdetail
		deliverydetail
		deliverymode
		flagstatus
		invcdetail
		invoice
		typedetail
		typemaster*/
		
	}

