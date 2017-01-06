package com.bookexchange.beans;

import java.util.Date;

import java.sql.Timestamp;

public class invoice 
{
	private int invcid;
	private Timestamp date;
	private String sellername,buyername,saddress,baddress,bookname;
	Double price,charges,totalprice;
	
	private int bquantity;
	
	
	public int getBquantity() {
		return bquantity;
	}
	public void setBquantity(int bquantity) {
		this.bquantity = bquantity;
	}
	public int getInvcid() {
		return invcid;
	}
	public void setInvcid(int invcid) {
		this.invcid = invcid;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getSellername() {
		return sellername;
	}
	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
	public String getBuyername() {
		return buyername;
	}
	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getBaddress() {
		return baddress;
	}
	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getCharges() {
		return charges;
	}
	public void setCharges(Double charges) {
		this.charges = charges;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	
	
}
