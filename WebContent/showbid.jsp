
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.bookexchange.buy.BuyInterfaceImpl"%>
<%@page import="com.bookexchange.beans.bookSearch"%>
<%@page import="com.bookexchange.beans.bid"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.bookexchange.ObjectFactory.ObjectFactory"%>
<%@page import="com.bookexchange.search.FilterSearchInterface"%>
<%@page import="com.bookexchange.buy.BuyInterface" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function msg()
{
	alert("success");
	window.opener.location.reload();
	window.close("showbid.jsp");
	
}
function validate()
{
	alert("no bids on ur book...");
	//window.location.reload(true);
	//window.opener.location.reload(true);
	//window.opener.reload();
	window.close("showbid.jsp");
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Bid</title>

</head>
<body onLoad="<%if (request.getParameter("msg")!= null){%> msg(); <%} %>" background="images//back.jpg">
<form action="" method="post" name="f1">

 <%
 						boolean b;
 						String recid=null;
						double bidPrice=0;
						
		               BuyInterface objBuy=ObjectFactory.getInstance().getBuyInterface();
		               
		               int bookid= Integer.parseInt(request.getParameter("bookid"));
		              
		               
		             List<bid> objBid=objBuy.showBid(bookid);
		            %>
		            
		             <table border=0  width="300">
		             <tr bgcolor="#A6A6FF">
			             <th>SelectBid  </th>
			             <th>UserName  </th>
			          	 <th>BidPrice  </th>
			             <th>DateTime  </th>  
		             </tr>
		             
		             <%
		             
		             for(Iterator<bid> it=objBid.iterator();it.hasNext();)
		             {
		             %>
		            
		             <%
		            	 bid b1=it.next();
		            	 recid=String.valueOf(b1.getUid());
		            	 bidPrice=b1.getBidprice() ;
		               %>
		               
		               <tr>
		               		<td>
		               		<input type="radio" name="selectbid" value="<%=bidPrice%>"/> 
		               		</td>
		               		
		               		<td>
		               		<%=b1.getUname() %>
		               		</td>
		               	
		               		<td>
		               		
		               		<%=b1.getBidprice() %>
		               		</td>
		               		
		               		<td>
		               		<%=b1.getBdatetime() %>
		               		<input type="hidden" name="bidid" value="<%=b1.getBidid()%>"> 
		               		<input type="hidden" name="receiverid" value="<%=recid%>"> 
		               		</td>
		               		
		               </tr>
		               
		               
		               <%
		             } %>
		               
		         </table> 
					
 <input type="submit" value="OK" onClick="<%if(recid==null) { %>validate();<%} 
 										else{%>
 											form.action='http://localhost:8080/BookExchange/Bookuncheck?bookid=<%=request.getParameter("bookid") %>&senderid=<%=session.getAttribute("userid")%>';
 											<%} %>">
 </form>



</body>
</html>