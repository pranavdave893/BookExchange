package com.bookexchange.beans;

import java.sql.Timestamp;

public class bookSearch {
	
	private int b_id;
	private String bname;
	private String location;
	private float rating;
	private double price;
	private Timestamp dateadd;
	private int condition;
	private int edition;
	private int row_w;
	private int table_w;
	private String image;
	
	private int btypeid;
	
	public int getBtypeid() {
		return btypeid;
	}
	public void setBtypeid(int btypeid) {
		this.btypeid = btypeid;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getName() {
		return bname;
	}
	public void setName(String name) {
		this.bname = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Timestamp getDateadd() {
		return dateadd;
	}
	public void setDateadd(Timestamp dateadd) {
		this.dateadd = dateadd;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public int getRow_w() {
		return row_w;
	}
	public void setRow_w(int row_w) {
		this.row_w = row_w;
	}
	public int getTable_w() {
		return table_w;
	}
	public void setTable_w(int table_w) {
		this.table_w = table_w;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
