package com.lanou.bean;

import java.io.Serializable;

public class Product implements Serializable{
	private Integer id;
	private String pname;
	private String pimg;
	private double price;
	private String ptitle;
	private Integer pv;
	private Integer typeid;
	private String typename;
	public Product() {
		super();
	}
	public Product(Integer id, String pname, String pimg, double price, String ptitle, Integer pv, Integer typeid) {
		super();
		this.id = id;
		this.pname = pname;
		this.pimg = pimg;
		this.price = price;
		this.ptitle = ptitle;
		this.pv = pv;
		this.typeid = typeid;
	}
	
	
	public Product(Integer id, String pname, String pimg, double price, String ptitle, Integer pv, String typename) {
		super();
		this.id = id;
		this.pname = pname;
		this.pimg = pimg;
		this.price = price;
		this.ptitle = ptitle;
		this.pv = pv;
		this.typename = typename;
	}
	public Product(Integer id, String pname, String pimg, double price, String ptitle, Integer pv, Integer typeid,
			String typename) {
		super();
		this.id = id;
		this.pname = pname;
		this.pimg = pimg;
		this.price = price;
		this.ptitle = ptitle;
		this.pv = pv;
		this.typeid = typeid;
		this.typename = typename;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public Integer getPv() {
		return pv;
	}
	public void setPv(Integer pv) {
		this.pv = pv;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
}
