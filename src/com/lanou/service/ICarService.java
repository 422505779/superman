package com.lanou.service;

import java.util.List;

import com.lanou.bean.Cart;

public interface ICarService {
	public List<Cart> getByPage(int pagenum,int pagecount) throws Exception;
	
	public List<Cart> getByPage(int userid,int pagenum,int pagecount) throws Exception;
	
	public int getCount() throws Exception;
	
	public int getCount(int pid,int uid) throws Exception;
	
	public void delCart(String id) throws Exception;
	
	public void addCart(int userid,int productid) throws Exception;
}
