package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Order;

public interface IOrderDao {
	public List<Order> getByPage(int pagenum,int pagecount) throws Exception;
	
	public int getCount() throws Exception;
	
	public void delOrder(String id) throws Exception;
}
