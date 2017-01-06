<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">

function msg()
{
	alert("successfully send....");
}

</script>

<title>Feedback</title>
</head>
<body bgcolor="#0033FF" onload="<%if(request.getParameter("msg")!=null){%> msg() <%}%>">


<%
 if(session.getAttribute("userid")!=null)
 {
 %>
 
 <div id="afterlogin">
			 <a href="userprofile.jsp"><%=session.getAttribute("username")%> </a>
			&nbsp <font color="#FFFFFF"><a href="updateuser.jsp?emailid=<%=session.getAttribute("useremail")%>">Edit profile</a></font>
			&nbsp	<font color="#FFFFFF"><a href="Logout">Log Out</a></font>
</div>
		
<%} %>

<jsp:include page="index3.jsp"></jsp:include>
<div id="right-stack" class="font">
<div class="registration">
<center>
<h1>Send Us Your Feedback!</h1>
<form action="Feedback" method="post">
<table>
	
	<tr>
	<td><font color="#000000" style="text-shadow:#666666"><b>UserName:</b></font></td>
	<td>
	<input type="text" name="name" maxlength="100"   value="<% if (session.getAttribute("username")!= null)
																{
																	out.print(session.getAttribute("username"));																
																}
																else
																{
																	out.print("");
																}%>" />
	</td>
	</tr>
	
	<tr>
	<td><font color="#000000" style="text-shadow:#666666"><b>Email Address:</b></font></td>
	<td>
	<input type="text" name="mail" maxlength="100" value="<% if (session.getAttribute("useremail")!= null)
																{
																	out.print(session.getAttribute("useremail"));																
																}
																else
																{
																	out.print("");
																}%>"/>
	</td>
	</tr>

<input type="hidden" name="uid" maxlength="100" value="<% if (session.getAttribute("userid")!= null)
																{
																	out.print(session.getAttribute("userid"));																
																}
																else
																{
																	out.print("");
																}%>" />
	
	<tr>
	<td><font color="#000000" style="text-shadow:#666666"><b>Comments:</b></font></td>
	<td>
	<textarea rows="10" cols="50" name="comments" > </textarea>
	</td>
	</tr>
	<tr><td>&nbsp;</td>
	<td>
	<input type="submit" value="Submit" />
	</td>
	</tr>
</table>
</form>
</center>
</div>
</div>
</body>
</html>