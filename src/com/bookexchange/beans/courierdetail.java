package com.bookexchange.beans;

public class courierdetail
{
private int courid;
private String srccity;
private String destcity;
private float charges;
private int dmodeid;

public void setCourid(int courid) {
	this.courid = courid;
}
public int getCourid() {
	return courid;
}
public void setSrccity(String srccity) {
	this.srccity = srccity;
}
public String getSrccity() {
	return srccity;
}
public void setDestcity(String destcity) {
	this.destcity = destcity;
}
public String getDestcity() {
	return destcity;
}
public void setCharges(float charges) {
	this.charges = charges;
}
public float getCharges() {
	return charges;
}
public void setDmodeid(int dmodeid) {
	this.dmodeid = dmodeid;
}
public int getDmodeid() {
	return dmodeid;
}

}
