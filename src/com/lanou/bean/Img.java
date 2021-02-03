package com.lanou.bean;

import java.io.Serializable;

public class Img implements Serializable{
	private Integer id;
	private String timg;

	public Img() {
		super();
	}

	public Img(String timg) {
		super();
		this.timg = timg;
	}
	
	public Img(Integer id, String timg) {
		super();
		this.id = id;
		this.timg = timg;
	}

	public String getTimg() {
		return timg;
	}

	public void setTimg(String timg) {
		this.timg = timg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
