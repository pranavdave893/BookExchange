
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Bid</title>

<script type="text/javascript">
	function msg()
	{
			alert("Bid Inserted..");
			//window.parent.reload();
			//window.location.reload();
			window.opener.location.reload();
			window.close();
			
	}
	function validate()
	{
		alert("please login first....");
	}
</script>
</head>
<body onload="<%if(request.getParameter("msg")!=null){%>msg();<%}%>" background="images//back.jpg">


 <%
		               
		               BuyInterface objBuy=ObjectFactory.getInstance().getBuyInterface();
		               
		               int bookid= Integer.parseInt(request.getParameter("bookid"));
		              
		               
		             List<bid> objBid=objBuy.showBid(bookid);
		            %>
		             <table>
		             <tr bgcolor="#A6A6FF">
		             <th >UserName</th>
		          	 <th>BidPrice</th>
		             <th >DateTime</th>
		             </tr>
		             
		             <%
		             for(Iterator<bid> it=objBid.iterator();it.hasNext();)
		             {
		             
		             %>
		            
		             <%
		            	 bid b=it.next();
		            
		               %>
		               <tr>
		               		<td><%=b.getUname() %></td>
		               		<td><%=b.getBidprice() %></td>
		               		<td><%=b.getBdatetime() %></td> 
		               </tr>
		               
		               <%} %>
		               
					</table>
					
					</br>
<form action="Bid?bookid=<%= request.getParameter("bookid")%>" method="post" name="f1">
			
<tr>
<td>Enter Bid</td>
<td><input type="text" name="bid"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Add"> </td>
</tr>
</table>

</form>
</body>
</html>