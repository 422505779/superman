package com.lanou.service;

import java.util.List;

import com.lanou.bean.Order;

public interface IOrderService {
	public List<Order> getByPage(int pagenum,int pagecount) throws Exception;
	
	public int getCount() throws Exception;
	
	public void delOrder(String id) throws Exception;
}
