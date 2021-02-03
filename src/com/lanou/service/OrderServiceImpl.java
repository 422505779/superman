package com.lanou.service;

import java.util.List;

import com.lanou.bean.Order;
import com.lanou.dao.IOrderDao;
import com.lanou.dao.OrderDaoImpl;

public class OrderServiceImpl implements IOrderService{
	private IOrderDao orDao = new OrderDaoImpl();
	@Override
	public List<Order> getByPage(int pagenum, int pagecount) throws Exception {
		return orDao.getByPage(pagenum, pagecount);
	}

	@Override
	public int getCount() throws Exception {
		return orDao.getCount();
	}

	@Override
	public void delOrder(String id) throws Exception {
		orDao.delOrder(id);
	}
	
}
