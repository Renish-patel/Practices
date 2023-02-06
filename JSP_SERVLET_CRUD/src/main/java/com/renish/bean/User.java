package com.renish.bean;

public class User {
	protected int id;

	protected String itemNo;
	protected String itemName;
	protected String date;

	public User(String itemNo, String itemName, String date, String category) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.date = date;
		this.category = category;
	}

	public User(int id, String itemNo, String itemName, String date, String category) {
		super();
		this.id = id;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.date = date;
		this.category = category;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	protected String category;
}
