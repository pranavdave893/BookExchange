package com.bookexchange.beans;

public class invcdetail 
{
private int invcdetailid;
private int bidid;
private float price;
private int bid;
private String bname;
private int sellerid;
private int buyerid;
public int getSellerid() {
	return sellerid;
}
public void setSellerid(int sellerid) {
	this.sellerid = sellerid;
}
public int getBuyerid() {
	return buyerid;
}
public void setBuyerid(int buyerid) {
	this.buyerid = buyerid;
}

private String uname;
private int invcid;

public void setInvcdetailid(int invcdetailid) {
	this.invcdetailid = invcdetailid;
}
public int getInvcdetailid() {
	return invcdetailid;
}
public void setBidid(int bidid) {
	this.bidid = bidid;
}
public int getBidid() {
	return bidid;
}
public void setBidprice(float price) {
	this.price = price;
}
public float getPrice() {
	return price;
}
public void setBid(int bid) {
	this.bid = bid;
}
public int getBid() {
	return bid;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getBname() {
	return bname;
}

public void setUname(String uname) {
	this.uname = uname;
}
public String getUname() {
	return uname;
}
public void setInvcid(int invcid) {
	this.invcid = invcid;
}
public int getInvcid() {
	return invcid;
}
}
