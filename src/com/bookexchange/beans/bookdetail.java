package com.bookexchange.beans;

import java.util.Date;

import javax.xml.soap.Text;

public class bookdetail 
{
	private int bid;
	private String bname;
	private String author;
	private String publication;
	private String isbn;
	private float oldprice;
	private float newprice;
	private int btypeid;
	//private int bcondid;
	private String bcondid;
	private Date bregdate;
	private Date bupdatedate;
	private int bcatid;
	private int uid;
	private int editionid;
	private String content;
	private int fstatusid;
	private String image;
	
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
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public String getPublication() {
		return publication;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setOldprice(float oldprice) {
		this.oldprice = oldprice;
	}
	public float getOldprice() {
		return oldprice;
	}
	public void setNewprice(float newprice) {
		this.newprice = newprice;
	}
	public float getNewprice() {
		return newprice;
	}
	public void setBtypeid(int btypeid) {
		this.btypeid = btypeid;
	}
	public int getBtypeid() {
		return btypeid;
	}
	public void setBcondid(String bcondid) {
		this.bcondid = bcondid;
	}
	public String getBcondid() {
		return bcondid;
	}
	public void setBregdate(Date bregdate) {
		this.bregdate = bregdate;
	}
	public Date getBregdate() {
		return bregdate;
	}
	public void setBupdatedate(Date bupdatedate) {
		this.bupdatedate = bupdatedate;
	}
	public Date getBupdatedate() {
		return bupdatedate;
	}
	public void setBcatid(int bcatid) {
		this.bcatid = bcatid;
	}
	public int getBcatid() {
		return bcatid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUid() {
		return uid;
	}
	public void setEditionid(int editionid) {
		this.editionid = editionid;
	}
	public int getEditionid() {
		return editionid;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setFstatusid(int fstatusid) {
		this.fstatusid = fstatusid;
	}
	public int getFstatusid() {
		return fstatusid;
	}
	public void setImage(String image) {
		// TODO Auto-generated method stub
		this.image = image;
	}
	public String getImage() {
		return image;
	}
	
}
