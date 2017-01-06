<%@page import="com.bookexchange.user.UserInterface"%>
<%@page import="com.bookexchange.sell.SellInterface"%>
<%@page import="com.bookexchange.ObjectFactory.ObjectFactory"%>
<%@page import="com.bookexchange.beans.typedetail"%>
<%@page import="com.bookexchange.beans.user"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List" %>

<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Book Exchange</title>

<script type="text/javascript">
	function msg()
	{
		alert("Record updated..");
		window.open("userprofile.jsp");
	}
</script>

</head>

<body onload="<%if(request.getParameter("msg")!=null){%>msg();<% }%>">


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

<form name="user" action="../BookExchange/UserRegistration"  method="post">
       <center>
        <table width="303" border="0">
       
		<%
			String email=request.getParameter("emailid");
			//out.print(email);
			
			UserInterface objUserInt=ObjectFactory.getInstance().getUserInterface();
			
			//List<user> objList=objUserInt.getUserDetail(email);
			
			List<user> objList=objUserInt.getUserDetail(email);
			
			Iterator<user> i= objList.iterator();
			
			user user=(user)i.next();

			%>
			
          <tr>
            <td align="right">Username</td>
            <td width="161">
            <label>
                <input type="text" name="txtusername" value="<%=user.getUname()%>">
              </label>                        
            
             
              </td>
          </tr>
          
          <tr>
            <td align="right">Email-id</td>
            <td width="161">
            <label>
                <input type="text" name="txtemail" value="<%=user.getEmail()%>" readonly="readonly">
              </label>                        
            
             
              </td>
          </tr>
          
          <tr>
            <td align="right">*Password</td>
            <td>
              <label>
                <input type="text" name="txtpassword" value="<%=user.getPassword()%>">
              </label>                        </td>
          </tr>
          
          <tr>
            <td align="right">Study Type </td>
            <td><select name="studytype">
              <option>Select study type</option>
            
				<%
			  	SellInterface objSell=ObjectFactory.getInstance().getSellInterface();
				List<typedetail> objList2=objSell.setBookView("gettypedetail",5,0);
			  	
			  	//typedetail td=ObjectFactory.getInstance().getTypeDetail();
			  	
			    for(Iterator<typedetail> i2= objList2.iterator(); i2.hasNext();)
				 //  Iterator<typedetail> i= objList.iterator();
				 //  while(i.hasNext())
			    {
			    	typedetail td=(typedetail)i2.next();
			    	int id=td.getTypeid();
			    	List<typedetail> objList1=objSell.setBookView("getcategory",5,id);
			    	
			    	for(Iterator<typedetail> i1= objList1.iterator(); i1.hasNext();)
         	   	   	 {
         		    	typedetail td1=(typedetail)i1.next();
         		    	int id1=td1.getTypeid();
         			    
			    %>
			    <option value="<%=td1.getTypeid()%>"><%=td1.getTypename()%></option>
			    <%
         	   	   	 }
			    }
				%>
            </select></td>
          </tr>
          <tr>
            <td align="right">Address</td>
            <td>
              
                <textarea name="txtaddress"><%=user.getAddress()%></textarea>                                 
                </td>
          </tr>
          <tr>
            <td align="right">*City</td>
            <td><select name="txtcity">
              <option>Select city</option>
              <option>Ahmedabad</option>
              <option>Gandhinagar</option>               
              <option>Kalol</option>  
             </select>                               
                 </td>
          </tr>
          <tr>
            <td align="right">*State</td>
            <td>
                <input type="text" name="txtstate" value="<%=user.getState()%>" readonly="readonly">             
                 </td>
          </tr>
          <tr>
            <td align="right">Phone no</td>
            <td>
                <input type="text" name="txtphoneno" value="<%=user.getPhno()%>">                              
                 </td>
          </tr>
          <tr>
            <td align="right">*Pin Code</td>
            <td>
              <label>
                <input type="text" name="txtpincode" value="<%=user.getPincode()%>">
              </label>                        </td>
          </tr>
          <tr>
            <td height="24" colspan="2">
                  <input type="checkbox" name="acceptcondition" value="checkbox">
                  I accept the Terms and Condition.</td>
          </tr>
          <tr>
            <td height="18" colspan="2">
            <center>
            <input type="submit" name="user" value="update" />
            
            </center>
            </td>
          </tr>
    
        </table>
        </center>
</form>
</div>
</div>
</body>
</html>
