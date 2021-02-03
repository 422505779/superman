package com.lanou.service;

import java.util.List;

import com.lanou.bean.Cart;
import com.lanou.dao.CartDaoImpl;
import com.lanou.dao.ICartDao;

public class CarServiceImpl implements ICarService{
	private ICartDao carDao = new CartDaoImpl();
	@Override
	public List<Cart> getByPage(int pagenum, int pagecount) throws Exception {
		return carDao.getByPage(pagenum, pagecount);
	}

	@Override
	public int getCount() throws Exception {
		return carDao.getCount();
	}

	@Override
	public void delCart(String id) throws Exception {
		carDao.delCart(id);
	}

	@Override
	public List<Cart> getByPage(int userid, int pagenum, int pagecount) throws Exception {
		return carDao.getByPage(userid, pagenum, pagecount);
	}

	@Override
	public void addCart(int userid, int productid) throws Exception {
		carDao.addCart(userid, productid);
	}

	@Override
	public int getCount(int pid, int uid) throws Exception {
		return carDao.getCount(pid, uid);
	}



}
