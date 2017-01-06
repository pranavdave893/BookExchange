<%@page import="com.bookexchange.sell.SellInterface"%>
<%@page import="com.bookexchange.ObjectFactory.ObjectFactory"%>
<%@page import="com.bookexchange.beans.typedetail"%>
<%@page import="java.util.Iterator"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Book Exchange</title>

<script type="text/javascript">
	function msg()
	{
			alert("book Inserted..");
			window.open("homepage.jsp");
		
	}
	
	/* 
	function msg(msg)
	{
		if(msg=="success")
		{
			alert("book Inserted");
		}
	
	} */


	function checkname()
	{
	var name=document.forms.bookregistration.txtname.value;
	
	if ( name=="") 
	  {
	  alert("Text must be filled out");
	  return false;
	  }
	
		
}
function checkauthor()
{
	var author=document.forms.bookregistration.txtauthor.value;
	
	if(author=="")
	{
	  alert("Text must be filled out");
	  return false;
	  }
	
}

function checkbooktype()
{
	var booktype=document.forms.bookregistration.booktype.value;
	
	 if(booktype=="")
	{
	  alert("Text must be filled out");
	  return false;
	  }
	
}

function checknewprice()
{
	var newprice=document.forms.bookregistration.txtnewprice.value;
	
	 if(newprice=="")
	 {
	  alert("Text must be filled out");
	  return false;
	  }	
}

function checkbookcondition()
{
	var bookcondition=document.forms.bookregistration.condition.value;
	
	 if(bookcondition=="")
	{
	  alert("Text must be filled out");
	  return false;
	  }
	
}

function checkbookcategory()
{
	var bookcategory=document.forms.bookregistration.category.value;
	
	 if(bookcategory=="")
	{
	  alert("Text must be filled out");
	  return false;
	  }
	
}

function checkbookedition()
{
	var bookedition=document.forms.bookregistration.edition.value;
	
	 if(bookedition=="")
	 {
		  alert("Text must be filled out");
		  return false;
	} 
}

	
	function validateForm1()
	{
	var name=document.forms.bookregistration.txtname.value;
	var author=document.forms.bookregistration.txtauthor.value;
	var booktype=document.forms.bookregistration.booktype.value;
	var newprice=document.forms.bookregistration.txtnewprice.value;
	var bookcondition=document.forms.bookregistration.condition.value;
	var bookcategory=document.forms.bookregistration.category.value;
	var bookedition=document.forms.bookregistration.edition.value;
	
		
	if ( name=="" && author=="" && booktype=="" && newprice=="" && bookcondition=="" && bookcategory=="" && bookedition=="")
	  {
	  alert("Text must be filled out");
	  
	  return false;
	  }
	}

	
	function terms()
	{
	if(document.getElementById('agree').checked)
	{
	alert('Thank you. Form is ready for approval.');
	return true;
	}
	else
	{
	alert('Terms rejected. Can not proceed....');
	return false;
	}
	}
</script>


</script>

</head>

<body onload="<%
				if(request.getParameter("msg")!=null)
				{%>
				msg();
				<% }%>">


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

<form name="bookregistration" method="post" action="BookRegistration" enctype="multipart/form-data">
<center>
<table width="400" border="0">
  <tr>
    <td align="right">*BookName </td>
    <td width="161"><label>
      <input type="text" name="txtname" onblur="checkname()"/>
      <input type="hidden" name="txtuserid" value="<%=session.getAttribute("userid") %>" />
      </label>    </td>
  </tr>
  <tr>
    <td align="right">*Author</td>
    <td><label>
      <input type="text" name="txtauthor" onblur="checkauthor()"/>
      </label>    </td>
  </tr>
  <tr>
    <td align="right">Publication</td>
    <td><label>
      <input type="text" name="txtpublication" />
      </label>    </td>
  </tr>
  <tr>
    <td align="right">ISBN</td>
    <td><label>
      <input type="text" name="txtISBN" />
      </label>    </td>
  </tr>
  <tr>
    <td align="right">*Book Type </td>
    <td>
       
        <!-- for old or new  -->    
        
        <%
	  	SellInterface objSell=ObjectFactory.getInstance().getSellInterface();
	  	List<typedetail> objList=objSell.setBookView("gettypedetail",2,0);
	  	
	  	//typedetail td=ObjectFactory.getInstance().getTypeDetail();
	  	
	    for(Iterator<typedetail> i= objList.iterator(); i.hasNext();)
		 //  Iterator<typedetail> i= objList.iterator();
		 //  while(i.hasNext())
	    {
	    	typedetail td=(typedetail)i.next();
	    
	    %>
	    <input name="booktype" type="radio" value="<%=td.getTypeid()%>" onblur="checkbooktype()"/><%=td.getTypename()%>
	  
	    <%
	   //i.remove();
	    } %>
	    
        
        </td>
  </tr>
  <tr>
    <td align="right">*Old Price  </td>
    <td><input type="text" name="txtoldprice" /></td>
  </tr>
  <tr>
    <td align="right">*New Price </td>
    <td><input type="text" name="txtnewprice" onblur="checknewprice()"/>   </td>
  </tr>
  <tr>
    <td align="right">*Book Condition </td>
    <td><select name="condition" onblur="checkbookcondition()">
    <option value="conditin">Select condition</option>
    <%
  //	SellInterface objSell=ObjectFactory.getInstance().getSellInterface();
  	 objList=objSell.setBookView("gettypedetail",3,0);
  	
  	//typedetail td=ObjectFactory.getInstance().getTypeDetail();
  	
    for(Iterator<typedetail> i= objList.iterator(); i.hasNext();)
	 //  Iterator<typedetail> i= objList.iterator();
	 //  while(i.hasNext())
    {
    	typedetail td=(typedetail)i.next();
    
    %>
    <option value="<%=td.getTypeid()%>"><%=td.getTypename()%></option>
    <%
   //i.remove();
    } %>
    
      
    </select></td>
  </tr>
  <tr>
    <td align="right">*Book Category </td>
    <td><select name="category" onblur="checkbookcategory()">
    <option>Select category</option>
      <%
 
	  	 objList=objSell.setBookView("gettypedetail",5,0);
	    for(Iterator<typedetail> i= objList.iterator(); i.hasNext();)
	    {
	    	typedetail td=(typedetail)i.next();
	    	int id=td.getTypeid();
	    	List<typedetail> objList1=objSell.setBookView("getcategory",5,id);
	    	
	    	for(Iterator<typedetail> i1= objList1.iterator(); i1.hasNext();)
 	   	   	 {
 		    	typedetail td1=(typedetail)i1.next();
 		    	int id2=td1.getTypeid();
 		    	
 		    	List<typedetail> objList2=objSell.setBookView("getcategory",5,id2);
 		    	
 		    	for(Iterator<typedetail> i2= objList2.iterator(); i2.hasNext();)
 	 	   	   	 {
 	 		    	typedetail td2=(typedetail)i2.next();
 	 		    	
	    %>
	    <option value="<%=td2.getTypeid()%>"><%=td2.getTypename()%></option>
	    <%
	    }
	    }
	    }
	    %>
    </select></td>
  </tr>
  <tr>
    <td align="right">*Book Edition</td>
    <td><label>
      <select name="edition" onblur="validateForm()">
      <option>edition</option>
        <%
  //	SellInterface objSell=ObjectFactory.getInstance().getSellInterface();
  	 objList=objSell.setBookView("gettypedetail",4,0);
  	
  	//typedetail td=ObjectFactory.getInstance().getTypeDetail();
  	
    for(Iterator<typedetail> i= objList.iterator(); i.hasNext();)
	 //  Iterator<typedetail> i= objList.iterator();
	 //  while(i.hasNext())
    {
    	typedetail td=(typedetail)i.next();
    	//out.print(td.getTypeid()+" "+td.getTypename());
    %>
    <option value="<%=td.getTypeid()%>"><%=td.getTypename()%></option>
    <%
   //i.remove();
    }
	 %>
      </select>
    </label>    </td>
  </tr>
  <tr>
    <td align="right">Content </td>
    <td><textarea name="content" rows="4" cols="20"> </textarea></td>
  </tr>
  
  <tr>
  <td align="right">Add Image </td>
    <td><input type="file" name="image" /></td>
  </tr>
  
  <tr>
    <td height="18" colspan="2"><center>
      <input type="submit" name="Register" value="Register"/>
     <!--  <input type="submit" name="Register" value="delete" /> -->
    </center></td>
  </tr>
  
  
</table>
</center>
</form>
<br />
<br />
<center><a href="homepage.jsp">BACK</a></center>

</div>
</div>
</body>
</html>
