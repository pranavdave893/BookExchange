<%@page import="java.util.Iterator"%>
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
<title>search page</title>
</head>



<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
function myFunction(bookid,values)
{
	
	window.open("bid.jsp?bookid="+bookid+"&value="+values,"mybook","width=300,height=300");
	
	//return false;
}


function pleaseLogin(){
	
	alert("Please login to perform the selected operation");
	
}
function myFunction1(bookid,values)
{
	window.open("sendMsg.jsp?bookid="+bookid+"&value="+values,"","width=300,height=300");		
	//return false;
}

</script>

<style>
	.leftbox p b{
	color: black;
	}
</style>
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
		
<div id="right-stack">
  
 <table cellspacing="20"  width="100" >
            
			<!-- <tr> <font size="3" face="Times New Roman, Times, serif">
			
             
			  <marquee behavior="alternate">
                RECENTLY ADDED BOOKS
			 </marquee>               
			 
            </font>
			 </tr> -->
            <tr>
              <td>&nbsp;</td>
            </tr>
           <tr>
            <%
           int uid; //=(Integer)session.getAttribute("userid");
            
            Hashtable<Integer,bookSearch> objHash;
            FilterSearchInterface search=ObjectFactory.getInstance().getFilterSearchInterface();
            
            String city;
            if(session.getAttribute("userid")!=null)
            {
            	city=(String)session.getAttribute("city");
            	uid=(Integer)session.getAttribute("userid");
            }
            else
            {
            	city="";
            	uid=0;
            }
            
            String valString=request.getParameter("value");
            
            if(valString.equals("null"))
            {
	            objHash=search.searchByBookname(request.getParameter("txtsearch"),city,uid);
            }
            else
            {
            	objHash=search.getselectedbook(valString,uid);
            }
            
            if(objHash.size()>0)
            {
	            for(int i=0;i<objHash.size();i++)
	            {
	            
            %>
            
              <td>
	              <div class="leftbox">
	              <% String image= objHash.get(i).getImage();
					if(image==null){ %>
				  <img src="images//25.jpg" width="100" height="100" alt="photo 1" />
				   <%} else
						{%>
						
						<img src="images//<%=objHash.get(i).getImage()%>" width="100" height="100">
						<%} %>
				   	<!-- 	<img src="images/photo_1.jpg" width="100" height="100" alt="photo 1"  class="left" /> -->
					   <p><b>Name: <%= objHash.get(i).getName()%></b> 
					   <%-- <p><b>bookid: <%= objHash.get(i).getB_id()%></b> --%>
					   <p><b>Type:<%=search.gettypename(objHash.get(i).getBtypeid()) %></b>
					   <p><b>Edition: <%=search.gettypename(objHash.get(i).getEdition()) %></b> 
		               <p><b>Condition:<%=search.gettypename(objHash.get(i).getCondition()) %></b>
		               <p><b>price:<%= objHash.get(i).getPrice() %></b>
		               <p><b>Location:<%=objHash.get(i).getLocation() %></b>
		              <%--  <p><b>User-rating:<%=objHash.get(i).getRating() %></b> --%>
		                  
			            <input type="hidden" id="bookid" name="bookid" value="<%=objHash.get(i).getB_id()%>" />
		               
		               
		               
		               <%
		             
		             BuyInterface objBuy=ObjectFactory.getInstance().getBuyInterface();
		             
		             Double price=objBuy.getBidPrice(objHash.get(i).getB_id());
		             
		             %>
		             
		              
		              <p><b>Highest Bid:<%=price%> </b>
		               
		           
		              <%--  <a href="javascript:myFunction(<%=objHash.get(i).getB_id()%>);">BId Now</a> --%>
		               
		               <a name="bid"  onclick="<%=session.getAttribute("userid")!=null?"myFunction("+objHash.get(i).getB_id()+","+valString+")":"pleaseLogin()" %>" >BIDNOW</a>  
		               
		                &nbsp &nbsp <a href="javascript:void(0)" name="Ienquiry" onclick="<%=session.getAttribute("userid")!=null?"myFunction1("+objHash.get(i).getB_id()+","+valString+")":"pleaseLogin()"%>" >INQUIRY</a> 
		                 
		                 </td>
		                
		               <%} 
		               
            }
            else{
           
            %>
            	<p>Book not available for this category...</p>
		             <%}%>
		            
	          
		               
		            </div>
            
            
       
            </tr>
          </table>
 
   </div>
   
   
</body>
</html>