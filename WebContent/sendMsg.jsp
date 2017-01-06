<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.bookexchange.beans.comm"%>
<%@page import="com.bookexchange.ObjectFactory.ObjectFactory"%>
<%@page import="com.bookexchange.communication.CommunicationInterface"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inquiry</title>

<script type="text/javascript">
	function msg()
	{
		alert("your message send succesfully...");
		window.close("sendMsg.jsp");
	}
	
</script>

</head>
<body onload="<%if(request.getParameter("msg")!=null){%>msg()<%}%>
				" background="images//back.jpg"> 

<form name="f1" action="SendMsg" method="post">

	<table>

	<%
		
	if(request.getParameter("bookid")!=null)
	{
	
	int bookid=Integer.parseInt(request.getParameter("bookid")); 
	int userid=(Integer)session.getAttribute("userid");
	
	CommunicationInterface com=ObjectFactory.getInstance().getCommunicationInterface();
	List<comm> objList=com.getSenderIdName(bookid);

	for(Iterator<comm> i=objList.iterator();i.hasNext();)
	{
		
		comm c=ObjectFactory.getInstance().getComm();
		c=i.next();
			
	%>

	

		<tr>
			<td align="right">Receiver Name:</td>
			<td><input type="text" name="receivername" value="<%=c.getUname() %>" readonly="readonly"></td>
			<input type="hidden" value="<%=c.getSenderid()%>" name="receiverid"/>
		</tr>
		<tr>
			<td align="right">Sender Name:</td>
			<td><input type="text" name="sendername" value="<%=session.getAttribute("username")%>" readonly="readonly"></td>
			<input type="hidden" value="<%=session.getAttribute("userid")%>" name="senderid"/>
			<input type="hidden" value="<%=c.getBid() %>" name="bookid"/>
		</tr>
		<tr>
			<td align="right">Message:</td>
			<td><textarea row="10" cols="16" name="msg"> </textarea></td>
		</tr>
		<tr>
			
			<td colspan="2"><center><input type="submit" value="Send" /></center></td>
		</tr>
	
	<%} }
	/* else
	{
		response.sendRedirect("searchpage.jsp");
	} */
	%>
		
		</table>

</form>

</body>
</html>