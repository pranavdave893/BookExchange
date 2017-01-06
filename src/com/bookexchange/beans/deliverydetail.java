package com.bookexchange.beans;

import javax.xml.soap.Text;

public class deliverydetail 

{
  private int did;
  private int dmodeid;
  private Text saddress;
  private Text raddress;
  private float charges;
  private int sellerid;
  private int buyerid;
  private String bname;
  private int bid;
public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
}
public int getDmodeid() {
	return dmodeid;
}
public void setDmodeid(int dmodeid) {
	this.dmodeid = dmodeid;
}
public Text getSaddress() {
	return saddress;
}
public void setSaddress(Text saddress) {
	this.saddress = saddress;
}
public Text getRaddress() {
	return raddress;
}
public void setRaddress(Text raddress) {
	this.raddress = raddress;
}
public float getCharges() {
	return charges;
}
public void setCharges(float charges) {
	this.charges = charges;
}
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
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
}
