package com.lanou.bean;

import java.io.Serializable;

public class Cart implements Serializable{
	private Integer id;
	private int userid;
	private int productid;
	private String username;
	private String productname;
	private double price;
	private int count;
	
	
	public Cart() {
		super();
	}
	

	public Cart(Integer id, int userid, int productid) {
		super();
		this.id = id;
		this.userid = userid;
		this.productid = productid;
	}


	public Cart(Integer id, int userid, int productid, String username, String productname) {
		super();
		this.id = id;
		this.userid = userid;
		this.productid = productid;
		this.username = username;
		this.productname = productname;
	}

	
	public Cart(Integer id, int userid, int productid, String username, String productname, double price) {
		super();
		this.id = id;
		this.userid = userid;
		this.productid = productid;
		this.username = username;
		this.productname = productname;
		this.price = price;
	}

	
	public Cart(Integer id, int userid, int productid, String username, String productname, double price, int count) {
		super();
		this.id = id;
		this.userid = userid;
		this.productid = productid;
		this.username = username;
		this.productname = productname;
		this.price = price;
		this.count = count;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public int getProductid() {
		return productid;
	}


	public void setProductid(int productid) {
		this.productid = productid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
	
}
