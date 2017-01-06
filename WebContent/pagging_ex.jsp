<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.Connection"%>
<%@page import="com.bookexchange.ObjectFactory.ObjectFactory"%>
<%@page import="com.bookexchange.connection.ConnectionInterface"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
<tr>
<th>ID</th>
<th>Bookname</th>
<th>author</th>
<th>price</th>
</tr>
<%
int i=0;
int total=0;
if(request.getParameter("count")!=null)
{
	total=Integer.parseInt(request.getParameter("count"));
}
else
{
	total=0;
}

i=total;

ConnectionInterface ci=ObjectFactory.getInstance().getConnectionInterface();
Connection con=ci.connect();

PreparedStatement pr=con.prepareStatement("select count(*) from bookdetail_t");
ResultSet rs=pr.executeQuery();

int totalrecord=0;

while(rs.next())
{
	totalrecord=rs.getInt(1);	
}
int halfrecord=(totalrecord/2);


PreparedStatement pr1=con.prepareStatement("select * from bookdetail_t LIMIT "+i+" , "+halfrecord+" ");


ResultSet rs1=pr1.executeQuery();

while(rs1.next())
{
%>
	<tr>
		<td><%=rs1.getInt("bid") %></td>
		<td><%=rs1.getString("bname") %></td>
		<td><%=rs1.getString("author") %></td>
		<td><%=rs1.getDouble("newprice") %></td> 
	</tr>
	
<%} %>
<tr>
<td colspan="2"><a href="pagging_ex.jsp?count=<%=(i-halfrecord)%>" style="visibility: 
            <%
            	if(i!=0)
            	{
            		out.print("visible;");
            	}
            	else
            	{
            		out.print("hidden;");
            	}	%> " >Prevoius</a></td>
            	
<td colspan="2"><a href="pagging_ex.jsp?count=<%=halfrecord%>" style="visibility:
            <%
            	if(total<halfrecord)
            	{
            		out.print("visible;");
            	}
            	else
            	{
            		out.print("hidden;");
            	}	
            %> 
            " >NEXT</a></td>
</tr>
</table>
</body>
</html>