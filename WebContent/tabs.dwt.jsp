<%@page import="com.bookexchange.sell.SellInterface"%>
<%@page import="com.bookexchange.beans.deliverydetail"%>
<%@page import="com.bookexchange.buy.BuyInterface"%>
<%@page import="com.bookexchange.DAO.DAOInterface"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bookexchange.beans.confirmation"%>
<%@page import="com.bookexchange.beans.user"%>
<%@page import="com.bookexchange.invoice.invoiceInterface"%>
<%@page import="com.bookexchange.sell.Showsellbook" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List" %>


<%@page import="com.bookexchange.beans.bookdetail"%>
<%@page import="com.bookexchange.beans.comm" %>


<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.bookexchange.ObjectFactory.ObjectFactory"%>
<%@page import="com.bookexchange.communication.CommunicationInterface"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="css/generic-notForMcTabs.css" rel="stylesheet" type="text/css" />
   
    <link href="css/mctabs.css" rel="stylesheet" type="text/css" />
    <script src="css/javascript-tabs.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- TemplateBeginEditable name="doctitle" -->
<title></title>
<!-- TemplateEndEditable -->
<!-- TemplateBeginEditable name="head" -->
<!-- TemplateEndEditable -->

<script type="text/javascript">

function callShowMsg(bookid,p)
{
	
	window.open("showbookmsg.jsp?bookid="+bookid+"&userid="+p,"","width=400,height=500,scrollbars=yes");
	
}

function callshowBid(bookid)
{
	window.open("showbid.jsp?bookid="+bookid,"","width=300,height=340");
}

function callshowaddress(bookid,sellerid)
{
	window.open("selection.jsp?bookid="+bookid+"&sellerid="+sellerid,"","width=200,height=200");
	
}

function callinvoice(bookid1,sellerid1,buyerid1,selection1)
{
	window.open("invoice.jsp?bookid="+bookid1+"&sellerid="+sellerid1+"&buyerid="+buyerid+"&selection="+selection1,"","width=500,height=500");	
}

</script>


</head>

<body class="bd1" >
<div id="right-stack">
     
        <div class="container1">
            <ul id="tabs1" class="mctabs">
                <li><a href="#view1">Statistics</a></li>
                <li><a href="#view2">Inbox</a></li>
                <li><a href="#view3">Outbox</a></li>
                <li><a href="#view4">conformation</a></li>
            </ul>
            <div class="panel-container">
                <div id="view1">
                    
                    
                    <%
                   Integer p=(Integer)session.getAttribute("userid");
                     
                   // System.out.println("userid=="+session.getAttribute("userid"));
                    
                    Showsellbook objsell=ObjectFactory.getInstance().getShowsellbook();
                    
                    List<bookdetail> objList=objsell.showsellbook(p);
                    
                    if (objList.size()>0)
                    {
                    %>
                    	<table border="0" max-width="750" >
                        <caption>MY BOOK</caption>
                        <tr>
                        <th bgcolor="#D3D3D3">No</th>
                        <th bgcolor="#D3D3D3">Book Name</th>
                        <th bgcolor="#D3D3D3">Author</th>
                        <th bgcolor="#D3D3D3">Publication</th>
                        <th bgcolor="#D3D3D3">ISBN</th>
                        <th bgcolor="#D3D3D3">New Price</th>
                        <th bgcolor="#D3D3D3">Old Price</th>
                        <th bgcolor="#D3D3D3">Reg.Date</th>
                        <th bgcolor="#D3D3D3"></th>
                        <th bgcolor="#D3D3D3"></th>
                        <th bgcolor="#D3D3D3"></th>
                        <th bgcolor="#D3D3D3"></th>
                        </tr>
                    	<%
                    	
                    int a=1;
                    for(Iterator<bookdetail> it=objList.iterator();it.hasNext();)
                    {
                    	
                    	bookdetail book=(bookdetail)it.next();
                  
                    %>
                    
                    <tr>
                    <td><%=a++ %></td>
                    <td ><%=book.getBname()%></td>
                    <td><%=book.getAuthor() %></td>
                    <td ><%=book.getPublication() %></td>
                    <td ><%=book.getIsbn() %></td>
                    <td ><%=book.getNewprice() %></td>
                   	<td ><%=book.getOldprice()%></td>
                   	<td><%=book.getBregdate()%></td>
                   	<td><a href="updatebook.jsp?bookid=<%=book.getBid()%>">Edit</a></td>
                    <td><a href="javascript:callShowMsg(<%=book.getBid()%>,<%=p%>);">ShowMsg</a></td>
                    <td><a href="javascript:callshowBid(<%=book.getBid()%>);">ShowBid</a></td>
                    <td><a href="SoldBook?bookid=<%=book.getBid()%>"> Delete </a></td>
                    </tr>
                    <%
                    }
                    }

                    else 
                    {
                    	out.print("you have  not entered any book to sell ");
                    	
                    }
                    %>
                    </table>  
                    
                     <%
                     
                     int buyerid=(Integer)session.getAttribute("userid");
                     int ci=1;
                    BuyInterface objBuy=ObjectFactory.getInstance().getBuyInterface(); 
                   // objBuy.ShowBoughtbook(buyerid);
                    
                    String bname;
                    int bookid1;
                    int sellerid1;
                    String selection;
                    List<deliverydetail> objList4=objBuy.ShowBoughtbook(buyerid);
                    
                    if(objList4.size()>0)
                    { 
                   // out.print("list size=="+objList4.size());
                    
                    %>
                    </br>
                    </br>
                    </br>
                    <table border="0" width="200" >
                    <caption> books bought by you</caption>
                    <th bgcolor="#D3D3D3">No</th>
                    <th bgcolor="#D3D3D3">Book Name</th>
                    
                    <%
                    
                    for(Iterator<deliverydetail> id=objList4.iterator();id.hasNext();)
                    {
                    	deliverydetail d=ObjectFactory.getInstance().getDeliverydetail();
                    	d=id.next();
                    	
                    	bookid1=d.getBid();
                    	sellerid1=d.getSellerid();
                    	int x=d.getDmodeid();
                    	if(x==2)
                    		selection="facetoface";
                    	else
                    		selection="postal";
                    	
                    %>
                     
                    <tr>
                    <td>
                   
                    <%=ci++%>
                    </td>
                    <td>
                 <%--    <a href="javascript:callinvoice(<%=bookid1%>,<%=sellerid1%>,<%=buyerid%>,<%=selection%>);"> <%=d.getBname()%></a> --%>
                   <a href="invoice.jsp?bookid=<%=bookid1%>&sellerid=<%=sellerid1%>&buyerid=<%=buyerid%>&selection=<%=selection%>"> <%=d.getBname()%></a>
                    </td>
                    </tr>
                    
                   <%}
                    }
                    else
                    {%>
                    <br/>
                    <br/>
                    	you have not bought any book
                    <%}
                    %>
                   </table>
                    
                    
                </div>
               
               
               
               
                <div id="view2">
                  
               
                
                 <%
                 
                 Integer pi=(Integer)session.getAttribute("userid");
                 CommunicationInterface objcomm=ObjectFactory.getInstance().getCommunicationInterface();
                 
                 List<comm> objList1=objcomm.showMessageInbox(pi);
                
                
                 if (objList1.size()>0)
                 {
                	 %>
                 
                  <table border="0" width="750">
                 <th bgcolor="#D3D3D3">NO</th>
                 <th bgcolor="#D3D3D3">Message</th>
                 <th bgcolor="#D3D3D3">BookName</th>
                 <th bgcolor="#D3D3D3">TO</th>
                
                <%
                 
                DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
                
                 int b=1;
                int bookid;
                int senderid;
                
                 for(Iterator<comm> ib=objList1.iterator();ib.hasNext();)
                 {
                	 comm c=ObjectFactory.getInstance().getComm();
                	 c=ib.next();
                	 
                	 bookid=c.getBid();
                	 senderid=c.getSenderid();
                	 
                	 List<user> objuser=objDAO.userdetailBYID("userdetailBYID",senderid);
                	 for(Iterator<user> u=objuser.iterator();u.hasNext();)
                     {
                    	 user ou=ObjectFactory.getInstance().getUser();
                    	 ou=u.next();
                    	 
                    	 
                	 SellInterface bookdetail=ObjectFactory.getInstance().getSellInterface();
                	 List<bookdetail> book=bookdetail.getBookDetail(bookid);
                	
                	 for(Iterator<bookdetail> ib1=book.iterator();ib1.hasNext();)
                     {
                    	 bookdetail cb=ObjectFactory.getInstance().getBookdetail();
                    	 cb=ib1.next();
                    	 
                 %>
                 <tr>
                
                 <td>
                 <%=b++  %>
                 </td>
                
                 <td>
                 <%=c.getMsg() %></td>
                
                 <td>
                 <%=cb.getBname()%>
                 </td>
                
                <td>
                 <%=ou.getUname()%>
                 </td>
                 </tr>
                 
                 
                 <%} }}}
                 else
                 {
                	 out.print("you dont have any message ");
                	 
                 }
                 
                 %>
               
                  </table>
                  
                </div>
               
               
               
               
                <div id="view3">
               
               
                  <%
                 
                
                 List<comm> objList11=objcomm.showMessageOutbox(pi);
                 
                 if (objList11.size()>0)
                 {
	             %>
	             
	               <table border =0 width="750">
                 <th bgcolor="#D3D3D3">NO</th>
                 <th bgcolor="#D3D3D3">Message</th>
                 <th bgcolor="#D3D3D3">Bookname</th>
                 <th bgcolor="#D3D3D3">TO</th>
                 
                 <%
                 
                 int receiverid;
                 DAOInterface objDAO=ObjectFactory.getInstance().getDAOInterface();
                 int b1=1;
                 for(Iterator<comm> ib=objList11.iterator();ib.hasNext();)
                 {
                	 comm c=ObjectFactory.getInstance().getComm();
                	 c=ib.next();
                	 
                	int bookid=c.getBid();
                 	
                	receiverid=c.getReceiverid();
                	 
                	 List<user> objuser=objDAO.userdetailBYID("userdetailBYID",receiverid);
                	 for(Iterator<user> u=objuser.iterator();u.hasNext();)
                     {
                    	 user ou=ObjectFactory.getInstance().getUser();
                    	 ou=u.next();
                    	 
                	
                	
                	 SellInterface bookdetail=ObjectFactory.getInstance().getSellInterface();
                	 List<bookdetail> book=bookdetail.getBookDetail(bookid);
                	
                	 for(Iterator<bookdetail> ib2=book.iterator();ib2.hasNext();)
                     {
                    	 bookdetail cb=ObjectFactory.getInstance().getBookdetail();
                    	 cb=ib2.next();
                    	 
                	
                 %>
                 <tr>
                
                 <td>
                 <%=b1++  %>
                 </td>
                
                 <td>
                 <%=c.getMsg() %></td>
                
                 <td>
                 <%=cb.getBname()%>
                 </td>
                
                <td>
                 <%=ou.getUname()%>
                 </td>
                
                 </tr>
                 
                 
                 <%} }}}
                 else
                 {
                	 out.print("you dont have any message ");
                	 
                 }
                 %>
               
                </table>
                
               
                </div>
                
               
                <div id="view4">
               
              
               <%
               
               invoiceInterface objInvoice=ObjectFactory.getInstance().getInvoiceInterface();
               
               int rid=(Integer) session.getAttribute("userid");
               
              // out.print("userid==="+rid);
               
              
              List<confirmation> objList2=new ArrayList<confirmation>();
              List<bookdetail> objListBook=new ArrayList<bookdetail>();
              List<user> objListUser=new ArrayList<user>();
              
               boolean d= objInvoice.showconfirm(rid);
              
               int bookid; 
              int sellerid;
               
              if(d==false)
               {
            	   
            	   objList2=objInvoice.getconfirmationdetail(rid); // chnage method which has rid,sid
            	   
            	   for(Iterator<confirmation> a1=objList2.iterator();a1.hasNext();)
                   {
                  	 confirmation confirm=ObjectFactory.getInstance().getConfirmation();
                  	
                  	confirm=a1.next();
              			
                  	bookid=confirm.getBid();
                  	sellerid=confirm.getSenderid();
                  	//out.print("bookid==="+bookid);
                  	
                  		objListBook=objInvoice.getbookdetail(confirm.getBid());
                  		
                  		
                  
                  		 for(Iterator<bookdetail> b11=objListBook.iterator();b11.hasNext();)
                         {
                        	 bookdetail book1=ObjectFactory.getInstance().getBookdetail();
                        	
                        	book1=b11.next();
                  			
                        	objListUser=objInvoice.getuserdetail(confirm.getSenderid());
                        	 for(Iterator<user> u1=objListUser.iterator();u1.hasNext();)
                             {
                            	 user userobj=ObjectFactory.getInstance().getUser();
                            	
                            	userobj=u1.next();
                        	
                        
               %>
               
                <table border=0>
               
               
               <tr>
               <td>         
               Your bid price <font color="#0033FF"> <%=confirm.getBidprice() %></font> is confirmed on book name <font color="#0033FF"><%=book1.getBname()%></font> by seller name <font color="#0033FF"><%=userobj.getUname() %> </font>if you want to buy this book then click <a href="javascript:callshowaddress(<%=bookid%>,<%=sellerid%>);">ok</a>
               </td>
               </tr>
               <tr>
               
               </tr>
               </table>
               
               <%}}}} else { %>You don't have any book request for buy...<%} %>
               
                </div>
                
                
            </div>
            <br />

        </div>
    </div>
    </div>
</body>
</html>
