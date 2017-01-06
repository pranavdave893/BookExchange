

<%@page import="java.util.Iterator"%>
<%@page import="com.bookexchange.ObjectFactory.ObjectFactory"%>
<%@page import="com.bookexchange.invoice.invoiceInterface"%>
<%@page import="com.bookexchange.beans.invoice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title>
</head>
<body>

<%

int bookid=Integer.parseInt(request.getParameter("bookid"));
int sellerid=Integer.parseInt(request.getParameter("sellerid"));
int buyerid=Integer.parseInt(request.getParameter("buyerid"));
String selection=request.getParameter("selection");

invoiceInterface objInvoice=ObjectFactory.getInstance().getInvoiceInterface();

int bookflag=objInvoice.getbookstatus(bookid);

if(bookflag!=5)
{
	//boolean invc=false,invcDetail=false;
	
boolean invcdelivery=objInvoice.insertInDeliveryDetail(sellerid,buyerid,bookid,selection);

//if (invcdelivery==true)
boolean	invc=objInvoice.insertInInvoice_t(sellerid,buyerid,bookid,selection);

//if(invc==true)
boolean invcDetail=objInvoice.insertionInInvoiceDetail_t(sellerid,buyerid,bookid);

boolean bookf=objInvoice.updatebookstatus(bookid);

boolean confirmf=objInvoice.updateconfirmationflag(bookid);

}

/* if(invcdelivery==true || invoice==true || invcDetail==true)
{
	out.print("successfully inserted...");
} */

/* 

List<invoice> objList=objInvoice.storeinvoice(selleremail, buyeremail, bookid);

Iterator<invoice> i=objList.iterator();

 	invoice iv=ObjectFactory.getInstance().getInvoice();
	iv=i.next();
	
	out.print("senderid="+iv.getSellerid()+"<br>");
	out.print("buyerid="+iv.getBuyerid());
	out.print("bookid="+iv.getBid());
	out.print("finalprice=="+iv.getFinalprice());
	 */

	 int c=0;
	 
	 List<invoice> objList=objInvoice.display(bookid);
	 
	for(Iterator<invoice> i=objList.iterator();i.hasNext();)
	{
	
		invoice invc=ObjectFactory.getInstance().getInvoice();
		
		invc=i.next();
	 
		c++;
	%>

<table style="border:1px solid #00539f;border-collapse:collapse;font-family:tahoma,arial,sans-serif;width:600px">
    <colgroup>
       <col span="1" style="width:50%">
       <col span="1" style="width:50%">
    </colgroup>

    
    <tbody><tr style="color:#00539f;font-size:12px;line-height:18px"><th colspan="2" style="color:#ffffff;font-size:14px;font-weight:bold;background-color:#666666;line-height:24px;text-align:left;padding-right:9px;padding-left:9px">&nbsp;</th></tr>

    <tr style="color:#00539f;font-size:12px;line-height:18px"><td style="padding-left:9px;padding-right:9px">&nbsp;</td><td style="padding-left:9px;padding-right:9px">&nbsp;</td></tr>

    
    <tr style="color:#00539f;font-size:12px;line-height:18px">
        <td style=" color:#000000;padding-left:9px;padding-right:9px; text-decoration:underline">Online secondhand book exchange</td>             
        <td style="padding-left:9px;padding-right:9px">Invoice Number:<%=invc.getInvcid()%></td>
    </tr>
    <tr style="color:#00539f;font-size:12px;line-height:18px">
        
        <td style="padding-left:9px;padding-right:9px">payment Type: 
        <%=selection.equals("facetoface")? "Face To Face":"Postal"%>
       </td>
    </tr> 
    <tr style="color:#00539f;font-size:12px;line-height:18px">
        <td style="padding-left:9px;padding-right:9px">Gujarat</td>             
        
    </tr>
    <tr style="color:#00539f;font-size:12px;line-height:18px">
        <td style="padding-left:9px;padding-right:9px">India</td>          
        <td style="padding-left:9px;padding-right:9px">Invoice Date: <%=invc.getDate()%></td>
    </tr>

    <tr style="color:#00539f;font-size:12px;line-height:18px"><td style="padding-left:9px;padding-right:9px">&nbsp;</td><td style="padding-left:9px;padding-right:9px">&nbsp;</td></tr>
    

    
    <tr style="color:#00539f;font-size:12px;line-height:18px">
        <th colspan="2" style="color:#ffffff;font-size:14px;font-weight:bold;background-color:#666666;line-height:24px;text-align:left;padding-right:9px;padding-left:9px">&nbsp; 
            
      </th>
    </tr>
    
    <tr style="color:#00539f;font-size:14px;line-height:18px">
        <td style="padding-left:9px;padding-right:9px">Seller Detail:</td>    
        <td style="padding-left:9px;padding-right:9px">Buyer Detail:</td>
    </tr>
    
        
        <tr style="color:#00539f;font-size:12px;line-height:18px">
          <td style="padding-left:9px;padding-right:9px">Name:<%=invc.getSellername() %>  </td>
       	  <td style="padding-left:9px;padding-right:9px">Name: <%=invc.getBuyername() %> <br> Shipping Address: <%=invc.getBaddress() %>  </td>
        </tr>
        
        
            <tr style="color:#00539f;font-size:12px;line-height:18px">
              <td style="padding-left:9px;padding-right:9px">INDIA</td>
              <td style="padding-left:9px;padding-right:9px">INDIA</td>
            </tr>
    
    
        <tr style="color:#00539f;font-size:12px;line-height:18px"><td style="padding-left:9px;padding-right:9px">&nbsp;</td><td style="padding-left:9px;padding-right:9px">&nbsp;</td></tr>
        <tr style="color:#00539f;font-size:12px;line-height:18px">
            <td style="padding-left:9px;padding-right:9px">&nbsp;</td>
        </tr>


</tbody></table>
<table width="500" style="border:1px solid #00539f;border-collapse:collapse;border-top-style:none;font-family:tahoma,arial,sans-serif;width:600px">
    <colgroup>
       <col span="1" style="width:2%">
       <col span="1" style="width:37%">
       <col span="1" style="width:10%">
       <col span="1" style="width:15%">
       <col span="1" style="width:10%">
       <col span="1" style="width:10%">
       <col span="1" style="width:25%">
    </colgroup>
    <tbody><tr style="color:#00539f;font-size:12px;line-height:18px">
        <th width="43" style="font-size:12px;line-height:25px;color:#00539f;text-align:center;background-color:#999999;border-width:1px;border-color:#00539f;border-style:solid;border-collapse:collapse;padding-right:9px;padding-left:9px;border-top-style:none">&nbsp;</th>
        <th width="141" style="font-size:12px;line-height:25px;color:#00539f;text-align:center;background-color:#999999;border-width:1px;border-color:#00539f;border-style:solid;border-collapse:collapse;padding-right:9px;padding-left:9px;border-top-style:none">Description of Book </th>
        <th width="76" style="font-size:12px;line-height:25px;color:#00539f;text-align:center;background-color:#999999;border-width:1px;border-color:#00539f;border-style:solid;border-collapse:collapse;padding-right:9px;padding-left:9px;border-top-style:none">Quantity</th>
        <th width="88" style="font-size:12px;line-height:25px;color:#00539f;text-align:center;background-color:#999999;border-width:1px;border-color:#00539f;border-style:solid;border-collapse:collapse;padding-right:9px;padding-left:9px;border-top-style:none">Net Amount</th>
       
        <th width="103" style="font-size:12px;line-height:25px;color:#00539f;text-align:center;background-color:#999999;border-width:1px;border-color:#00539f;border-style:solid;border-collapse:collapse;padding-right:9px;padding-left:9px;border-top-style:none">Shipping Costs</th>
        <th width="58" style="font-size:12px;line-height:25px;color:#00539f;text-align:center;background-color:#999999;border-width:1px;border-color:#00539f;border-style:solid;border-collapse:collapse;padding-right:9px;padding-left:9px;border-top-style:none">Total</th>
    </tr>

    <tr style="color:#00539f;font-size:12px;line-height:18px"> 
     <td style="border-bottom-style:none;border-collapse:collapse;border-color:#00539f;border-style:solid;border-top-style:none;border-width:1px;line-height:25px;padding-left:9px;padding-right:9px"><%= c%></td> 
     <td style="border-bottom-style:none;border-collapse:collapse;border-color:#00539f;border-style:solid;border-top-style:none;border-width:1px;line-height:25px;padding-left:9px;padding-right:9px"><%=invc.getBookname() %></td> 
      <td style="border-bottom-style:none;border-collapse:collapse;border-color:#00539f;border-style:solid;border-top-style:none;border-width:1px;line-height:25px;padding-left:9px;padding-right:9px" align="right"><%=invc.getBquantity() %></td> 
      <td style="border-bottom-style:none;border-collapse:collapse;border-color:#00539f;border-style:solid;border-top-style:none;border-width:1px;line-height:25px;padding-left:9px;padding-right:9px" align="right"><%=invc.getPrice() %></td>
       <td style="border-bottom-style:none;border-collapse:collapse;border-color:#00539f;border-style:solid;border-top-style:none;border-width:1px;line-height:25px;padding-left:9px;padding-right:9px" align="right"><%=invc.getCharges() %></td> 
        <td style="border-bottom-style:none;border-collapse:collapse;border-color:#00539f;border-style:solid;border-top-style:none;border-width:1px;line-height:25px;padding-left:9px;padding-right:9px" align="right"><%=(invc.getPrice()+invc.getCharges()) %></td></tr>

    <tr style="color:#00539f;font-size:12px;line-height:18px">
        <td colspan="5" align="right" style="border-collapse:collapse;border-color:#00539f;border-style:solid;border-width:1px;color:#00539f;font-size:12px;font-weight:bold;line-height:25px;padding-left:6px;padding-right:6px;text-align:right">
            Total Amount Due        </td>
        <td align="right" style="border-collapse:collapse;border-color:#00539f;border-style:solid;border-width:1px;color:#00539f;font-size:12px;line-height:25px;padding-left:9px;padding-right:9px;text-align:right"><%=invc.getTotalprice() %></td>
    </tr>
    

    <tr style="color:#000033;font-size:12px;line-height:18px">
        <td colspan="7" align="center" style="padding-left:9px;padding-right:9px">This type is Face to Face Delivery. so Payment is not specified.It is depend on seller and buyer communication. Thank You </td>
    </tr>
</tbody></table>
<%} %>

<br/>
<br/>
<!-- <a href="userprofile.jsp">BACK</a> -->


</body>
</html>