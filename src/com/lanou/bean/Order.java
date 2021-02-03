package com.lanou.bean;

import java.io.Serializable;

public class Order implements Serializable{
	private String id;
	private int userid;
	private int productid;
	private String uname;
	private String pname;
	private String status;
	public Order() {
		super();
	}
	public Order(String id, int userid, int productid, String uname, String pname, String status) {
		super();
		this.id = id;
		this.userid = userid;
		this.productid = productid;
		this.uname = uname;
		this.pname = pname;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
