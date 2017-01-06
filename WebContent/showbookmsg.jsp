
<%@page import="java.util.ArrayList"%>
<%@page import="com.bookexchange.sell.Showsellbook" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List" %>
<%@page import="com.bookexchange.communication.CommunicationInterface" %>
<%@page import="com.bookexchange.ObjectFactory.ObjectFactory" %>
<%@page import="com.bookexchange.beans.bookdetail"%>
<%@page import="com.bookexchange.beans.comm" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Messages</title>

<script type="text/javascript">
	function msg()
	{
		alert("your message send succesfully...");
		window.close("showbookmsg.jsp");
	}
	
</script>


</head>
<body onload="<%if(request.getParameter("msg")!=null){%>msg()<%}%>" background="images//back.jpg">


 <table border =0 width="390">
 				<tr bgcolor="#A6A6FF">
                 <th>NO</th>
                 <th>UserName</th>
                 <th>Message</th>
                 <th>DateTime</th>
                </tr>
                 <%
                 
                 Integer bookid=Integer.parseInt(request.getParameter("bookid"));
                 Integer userid=Integer.parseInt(request.getParameter("userid"));
                 CommunicationInterface objcomm=ObjectFactory.getInstance().getCommunicationInterface();
                 
            	 List<comm> objList2=new ArrayList<comm>();
            	 
                 List<comm> objList1=objcomm.showbookmsg(bookid,userid);
                 int b=1;
                 for(Iterator<comm> ib=objList1.iterator();ib.hasNext();)
                 {
                	 comm c=ObjectFactory.getInstance().getComm();
                	 c=ib.next();
                	
                	 comm cReply=ObjectFactory.getInstance().getComm();
                	 cReply.setSenderid(c.getSenderid());
                	 cReply.setReceiverid(c.getReceiverid());
                	 cReply.setUname(c.getUname());
                	 
                	 objList2.add(cReply);
                	 
                	 
                	 
                	 
                 %>
                 <tr>
                
                 <td><%=b++  %></td>
                <td><%=c.getUname() %></td>
                 <td><%=c.getMsg() %></td>
                 <td><%=c.getDatetime() %></td>
                 </tr>
                 <%} %>
               
                  </table>
				</br>
<form name="f1" action="ReplyMsg" method="post" >

			<table border="0" align="center">
			
				<caption ><font size="5" ><b>Reply</b></font></caption>
			<tr>
			<td align="right">To : </td>
			<td>
			
			<select name="receiverid">
				
				<%
				
				for(Iterator<comm> ib2=objList2.iterator();ib2.hasNext();)
                {
               	 comm cp=ObjectFactory.getInstance().getComm();
               	 cp=ib2.next();
               	
				%>
				
				<option value="<%=cp.getSenderid()%>" > <%=cp.getUname() %> </option>
				<%} %>
				</select>
			
			</td>
			</tr>
			<tr>
			<td align="right">From :</td>
			<td>
			<input type="text" name="fromUsername" value="<%=session.getAttribute("username")%>" readonly="readonly">
			<input type="hidden" value="<%=session.getAttribute("userid")%>" name="senderid"/>
			<input type="hidden" value="<%=request.getParameter("bookid")%>" name="bookid"/>
			</td>
			</tr>
			<tr>
			<td align="right">Message :</td><td><textarea rows="5" cals="5" name="msg"></textarea></td>
			</tr>
			<tr>
			<td colspan="2" align="center"><center><input type="submit" value="Reply" /></center></td>
			</tr>
			
			</table>
</form>

</body>

</html>