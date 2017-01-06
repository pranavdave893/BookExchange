<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="com.bookexchange.ObjectFactory.ObjectFactory"%>
<%@page import="com.bookexchange.user.UserInterface"%>
<%@page import="com.bookexchange.beans.bookdetail"%>
<%@page import="com.bookexchange.beans.comm" %>
<head>
<h4>
Confirm you'r Address
</h1>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address</title>

<script type="text/javascript">
	function msg()
	{
		alert("address updated...");
	}
	
	function showInvoice(bookid,sellerid,buyerid,selection)
	{
		alert("hello.....");
		window.close("address.jsp");
		window.open("invoicepost.jsp?bookid="+bookid+"&sellerid="+sellerid+"&buyerid="+buyerid+"&selection="+selection,"","width=600,height=600");
	}
	
</script>


</head>
<body onload="<%if(request.getParameter("msg")!=null){%>msg()<%}%>" background="images//back.jpg">
<form method="post" action="">

<%

int sellerid= Integer.parseInt(request.getParameter("sellerid"));

int buyerid=(Integer)session.getAttribute("userid");

String selection=request.getParameter("selection");

int bookid=Integer.parseInt(request.getParameter("bookid"));

UserInterface objadd=ObjectFactory.getInstance().getUserInterface();
String a=objadd.getAddress(buyerid);



%>
If you want new address then click reset
<center>
<textarea row=10 column=8 name="address" > <%=a%></textarea>
<!-- <input type="hidden" name="uid" value="<%=sellerid%>"></input> -->

<input type="submit" value="Submit address" onclick="form.action='Updateadd?uid=<%=buyerid%>&bookid=<%=bookid%>&selection=<%=selection%>';"></input>
<input type="reset">
<button value="NEXT"  onclick="form.action='invoice.jsp?bookid=<%=bookid%>&sellerid=<%=sellerid%>&buyerid=<%=buyerid%>&selection=<%=selection%>';">
NEXT</button>
</center>
</form>

</body>
</html>