package com.bookexchange.beans;

import java.util.Date;

import javax.xml.soap.Text;

public class comm
{
	
	private String uname;
	
public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
private int commid;
private int cmodeid;
private int senderid;
private int receiverid;
private String msg;
private Date datetime;
private int bid;
public void setCommid(int commid) {
	this.commid = commid;
}
public int getCommid() {
	return commid;
}
public void setCmodeid(int cmodeid) {
	this.cmodeid = cmodeid;
}
public int getCmodeid() {
	return cmodeid;
}
public void setSenderid(int senderid) {
	this.senderid = senderid;
}
public int getSenderid() {
	return senderid;
}
public void setReceiverid(int receiverid) {
	this.receiverid = receiverid;
}
public int getReceiverid() {
	return receiverid;
}
public void setMsg(String string) {
	this.msg = string;
}
public String getMsg() {
	return msg;
}
public void setDatetime(Date datetime) {
	this.datetime = datetime;
}
public Date getDatetime() {
	return datetime;
}
public void setBid(int bid) {
	this.bid = bid;
}
public int getBid() {
	return bid;
}

}
