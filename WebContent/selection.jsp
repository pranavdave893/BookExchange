<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selection Process</title>

<script type="text/javascript">

function facetoface(bookid,sellerid,buyerid)
{
	window.open('invoice.jsp?bookid='+bookid+'&sellerid='+sellerid+'&buyerid='+buyerid+'&selection=facetoface', 'new', 'width=500,height=530')
	window.opener.location.reload();
	window.close("selection.jsp");
}

function postal(bookid,sellerid,buyerid) 
{
	window.open('address.jsp?bookid='+bookid+'&sellerid='+sellerid+'&buyerid='+buyerid+'&selection=postal', 'new', 'width=300,height=300')
	window.close("selection.jsp");
}

</script>

</head>
<body background="images//back.jpg">
<form name="delivery" action="" method="post" >
<center>
<%

int bookid= Integer.parseInt(request.getParameter("bookid"));
int sellerid= Integer.parseInt(request.getParameter("sellerid"));
int buyerid=(Integer)session.getAttribute("userid");
%>
<table>
<input type="radio" name="post1" onClick="javascript:facetoface(<%=bookid%>,<%=sellerid%>,<%=buyerid%>)"> Face to Face 
</br>
<input type="radio" name="post1" onClick="javascript:postal(<%=bookid%>,<%=sellerid%>,<%=buyerid%>)"> By Post 
</br>
</table>
</center>
</form>
</body>
</html>