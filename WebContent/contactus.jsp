<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>contact us</title>
</head>
<body>


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
<!-- <center><h1>Contact Us...</h1></center> -->

<!-- <marquee behavior="alternate" ><a href="feedback.jsp"><font color="#993333" size="+1"><b>you can contact us through feedback</b></font></a></marquee> <br /> -->
<center>
<br>
<br>
  <font color="0033FF"><b>Name</b>:&nbsp Pranav Dave<br></a>
	<b>E-mail id</b>:&nbsp <a href="https://mail.google.com/mail/">pranavdave893@gmail.com</a>
	</br><b>Phone no.</b>:&nbsp+91 9033378540</p></font>
<br>



<br>
</center>
</div>
</div>
</body>
</html>