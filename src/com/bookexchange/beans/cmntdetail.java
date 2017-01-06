package com.bookexchange.beans;

import java.util.Date;

import javax.xml.soap.Text;

public class cmntdetail {

	private int cmntid;
	private int cmntmodeid;
	private int uid;
	private String uname;
	private Text email;
	private String title;
	private Text msg;
	private Date datetime;
	
	public void setCmntid(int cmntid) {
		this.cmntid = cmntid;
	}
	public int getCmntid() {
		return cmntid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUid() {
		return uid;
	}
	public void setCmntmodeid(int cmntmodeid) {
		this.cmntmodeid = cmntmodeid;
	}
	public int getCmntmodeid() {
		return cmntmodeid;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUname() {
		return uname;
	}
	public void setEmail(Text email) {
		this.email = email;
	}
	public Text getEmail() {
		return email;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setMsg(Text msg) {
		this.msg = msg;
	}
	public Text getMsg() {
		return msg;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public Date getDatetime() {
		return datetime;
	}
	
}
