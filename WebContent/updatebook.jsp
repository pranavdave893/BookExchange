<%@page import="java.util.ArrayList"%>
<%@page import="com.bookexchange.sell.SellInterface"%>
<%@page import="com.bookexchange.ObjectFactory.ObjectFactory"%>
<%@page import="com.bookexchange.beans.typedetail"%>
<%@page import="com.bookexchange.beans.bookdetail"%>
<%@page import="java.util.Iterator"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<script type="text/javascript">

function msg(bookid)
{
	
	alert("your book successfully updated..");
	//window.open("http://localhost:8080/BookExchange/userprofile.jsp","","");
}


</script>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Update book</title>
</head>

<body onload="<%if(request.getParameter("msg")!=null)
				{%>
					msg(<%=request.getParameter("bookid")%>);
				<%}
				%>
				">


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

<form name="updatebook" method="post" action="../BookExchange/UpdateBook?bookid=<%=request.getParameter("bookid")%>" enctype="multipart/form-data">
<table width="400" border="0" align="center">
  <%
			//String bid=request.getParameter("querylink_bid");
			//out.print(bid);
			
			//int bid=1;
			
			int bid=Integer.parseInt(request.getParameter("bookid"));
			//out.print("bookid=="+bid);
			
			SellInterface objsellInt=ObjectFactory.getInstance().getSellInterface();
			
			List<bookdetail> objList=objsellInt.getBookDetail(bid);
			
			Iterator<bookdetail> i= objList.iterator();
			
			bookdetail bookdetail=(bookdetail)i.next();

			%>
  <tr>
    <td align="right">*BookName </td>
    <td width="161"><label>
      <input type="text" name="txtname" value="<%=bookdetail.getBname()%>"/>
      </label>    </td>
  </tr>
  <tr>
    <td align="right">*Author</td>
    <td><label>
      <input type="text" name="txtauthor" value="<%=bookdetail.getAuthor()%>"/>
      </label>    </td>
  </tr>
  <tr>
    <td align="right">Publication</td>
    <td><label>
      <input type="text" name="txtpublication" value="<%=bookdetail.getPublication()%>"/>
      </label>    </td>
  </tr>
  <tr>
    <td align="right">ISBN</td>
    <td><label>
      <input type="text" name="txtISBN" value="<%=bookdetail.getIsbn()%>"/>
      </label>    </td>
  </tr>
  <tr>
    <td align="right">Book Type </td>
    <td>
       
        <!-- for old or new  -->    
        
        <%
	  	SellInterface objSell=ObjectFactory.getInstance().getSellInterface();
	  	List<typedetail> objList1=objSell.setBookView("gettypedetail",2,0);
	  	
	  	//typedetail td=ObjectFactory.getInstance().getTypeDetail();
	  	
	    for(Iterator<typedetail> i1= objList1.iterator(); i1.hasNext();)
		 //  Iterator<typedetail> i= objList.iterator();
		 //  while(i.hasNext())
	    {
	    	typedetail td=(typedetail)i1.next();
	    
	    %>
	    <input name="booktype" type="radio" value="<%=td.getTypeid()%>"/><%=td.getTypename()%>
	  
	    <%
	   //i.remove();
	    } %>
	    
        
        </td>
  </tr>
  <tr>
    <td align="right">Old Price  </td>
    <td><input type="text" name="txtoldprice" value="<%=bookdetail.getOldprice()%>"/></td>
  </tr>
  <tr>
    <td align="right">*New Price </td>
    <td><input type="text" name="txtnewprice" value="<%=bookdetail.getNewprice()%>"/>   </td>
  </tr>
  <tr>
    <td align="right">*Book Condition </td>
    <td><select name="condition">
     <option value="conditin">Select condition</option>
    <%
    //SellInterface objSell=ObjectFactory.getInstance().getSellInterface();
  	List<typedetail> objList2=objSell.setBookView("gettypedetail",3,0);
  	
    //List<typedetail> objList2=objSell.setBookView(3);
  	
  	//typedetail td=ObjectFactory.getInstance().getTypeDetail();
  	
    for(Iterator<typedetail> i2= objList2.iterator(); i2.hasNext();)
	 //  Iterator<typedetail> i= objList.iterator();
	 //  while(i.hasNext())
    {
    	typedetail td=(typedetail)i2.next();
    
    
    %>
    <option value="<%=td.getTypeid()%>"><%=td.getTypename()%></option>
    <%
   //i.remove();
    } %>
      </select>
   
        </td>
  </tr>
  <tr>
    <td align="right">Book Category </td>
    <td><select name="category" "<%=bookdetail.getBcatid()%>">
    <option>Select category</option>
    <%
    //SellInterface objSell=ObjectFactory.getInstance().getSellInterface();
  	List<typedetail> objList3=objSell.setBookView("gettypedetail",5,0);
  	
  //	 List<typedetail> objList2=objSell.setBookView(5);
	    for(Iterator<typedetail> i3= objList3.iterator(); i3.hasNext();)
	    {
	    	typedetail td=(typedetail)i3.next();
	    	int id=td.getTypeid();
	    	List<typedetail> objList4=objSell.setBookView("getcategory",5,id);
	    	
	    	for(Iterator<typedetail> i1= objList4.iterator(); i1.hasNext();)
 	   	   	 {
 		    	typedetail td1=(typedetail)i1.next();
 		    	int id1=td1.getTypeid();
 		    	
				List<typedetail> objList5=objSell.setBookView("getcategory",5,id1);
 		    	
 		    	for(Iterator<typedetail> i2= objList5.iterator(); i2.hasNext();)
 	 	   	   	 {
 	 		    	typedetail td2=(typedetail)i2.next();
 	 		    	
 		    	
    %>
    <option value="<%=td2.getTypeid()%>"><%=td2.getTypename()%></option>
    <%
   //i.remove();
    }}}
	 %>
          </select></td>
  </tr>
  <tr>
    <td align="right">Book Edition</td>
    <td><label>
      <select name="edition">
      <option>edition</option>
          <%
  //	SellInterface objSell=ObjectFactory.getInstance().getSellInterface();
  	List<typedetail> objList6=objSell.setBookView("gettypedetail",4,0);
  	
  	//typedetail td=ObjectFactory.getInstance().getTypeDetail();
  	
    for(Iterator<typedetail> i6= objList6.iterator(); i6.hasNext();)
	 //  Iterator<typedetail> i= objList.iterator();
	 //  while(i.hasNext())
    {
    	typedetail td5=(typedetail)i6.next();
    	//out.print(td.getTypeid()+" "+td.getTypename());
    %>
    <option value="<%=td5.getTypeid()%>"><%=td5.getTypename()%></option>
    <%}
   //i.remove();
   %>
      </select>
    </label>    </td>
  </tr>
  <tr>
    <td align="right">Content </td>
    <td><textarea name="content" rows="4" cols="20" > <%=bookdetail.getContent()%></textarea></td>
  
  </tr>
  
  <td align="right">Change Image </td>
    <td><input type="file" name="image" value="<%=bookdetail.getImage()%>"/></td>
  </tr>
  
  
  <tr>
    
  </tr>
  <tr>
    <td height="18" colspan="2"><center>
  
      <input type="submit" name="bookdetail" value="update" />
    
      
    </center></td>
  </tr>
</table>
</form>
</div>
</div>
</body>
</html>
