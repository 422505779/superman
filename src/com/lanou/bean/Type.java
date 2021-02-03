package com.lanou.bean;

import java.io.Serializable;

public class Type implements Serializable{
	private Integer id;
	private String title;
	private int parentid;
	private Object children;
	public Type() {
		super();
	}
	
	
	public Type(Integer id, String title, int parentid) {
		super();
		this.id = id;
		this.title = title;
		this.parentid = parentid;
	}
	

	public Type(Integer id, String title, int parentid, Object children) {
		super();
		this.id = id;
		this.title = title;
		this.parentid = parentid;
		this.children = children;
	}
	public Type(Object children,Integer id, int parentid,String title) {
		super();
		this.id = id;
		this.title = title;
		this.parentid = parentid;
		this.children = children;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}


	public Object getChildren() {
		return children;
	}


	public void setChildren(Object children) {
		this.children = children;
	}
	
	
}
