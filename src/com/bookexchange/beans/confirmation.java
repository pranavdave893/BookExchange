package com.bookexchange.beans;

public class confirmation
{
	
	private int senderid,receiverid,bid,bidid;
	
	private double bidprice;
	

	public int getBidid() {
		return bidid;
	}
	public void setBidid(int bidid) {
		this.bidid = bidid;
	}
	
	public int getSenderid() {
		return senderid;
	}
	public void setSenderid(int senderid) {
		this.senderid = senderid;
	}
	public int getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(int receiverid) {
		this.receiverid = receiverid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public double getBidprice() {
		return bidprice;
	}
	public void setBidprice(double bidprice) {
		this.bidprice = bidprice;
	}
	
	
}
