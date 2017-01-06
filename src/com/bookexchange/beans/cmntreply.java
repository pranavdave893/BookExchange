package com.bookexchange.beans;

import java.util.Date;

import javax.xml.soap.Text;

public class cmntreply 
{
private int rid;
private int cmntid;
private Text rmsg;
private Date rdatetime;
private int cmntbyid;

public void setRid(int rid) {
	this.rid = rid;
}
public int getRid() {
	return rid;
}
public void setCmntid(int cmntid) {
	this.cmntid = cmntid;
}
public int getCmntid() {
	return cmntid;
}
public void setRdatetime(Date rdatetime) {
	this.rdatetime = rdatetime;
}
public Date getRdatetime() {
	return rdatetime;
}
public void setRmsg(Text rmsg) {
	this.rmsg = rmsg;
}
public Text getRmsg() {
	return rmsg;
}
public void setCmntbyid(int cmntbyid) {
	this.cmntbyid = cmntbyid;
}
public int getCmntbyid() {
	return cmntbyid;
}
}
