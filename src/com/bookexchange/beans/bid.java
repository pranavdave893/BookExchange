package com.bookexchange.beans;

public class bid<datetime>
{

	private String uname;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	private int bidid;
	private int uid;
	private int bid;
	private Double bidprice;
	private datetime bdatetime;
	
	public void setBidid(int bidid) {
		this.bidid = bidid;
	}
	public int getBidid() {
		return bidid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUid() {
		return uid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getBid() {
		return bid;
	}
	public void setBidprice(Double bidprice) {
		this.bidprice = bidprice;
	}
	public Double getBidprice() {
		return bidprice;
	}
	public void setBdatetime(datetime bdatetime) {
		this.bdatetime = bdatetime;
	}
	public datetime getBdatetime() {
		return bdatetime;
	}
	
	
	
	

}
