package com.lanou.service;

import java.util.List;

import com.lanou.bean.Product;
import com.lanou.dao.IProductDao;
import com.lanou.dao.ProductDaoImpl;

public class ProductServiceImpl implements IProductService{
	private IProductDao proDao = new ProductDaoImpl();
	@Override
	public List<Product> getByPage(int pagenum, int pagecount) throws Exception {
		return proDao.getByPage(pagenum, pagecount);
	}

	@Override
	public int getCount() throws Exception {
		return proDao.getCount();
	}

	@Override
	public void addProduct(String pname, String pimg, String price, String ptitle, String pv, String typeid)
			throws Exception {
		proDao.addProduct(pname, pimg, price, ptitle, pv, typeid);
		
	}

	@Override
	public void delProduct(int id) throws Exception {
		proDao.delProduct(id);
	}

	@Override
	public void editProduct(String id, String pname, String pimg, String price, String ptitle, String pv, String typeid)
			throws Exception {
		proDao.editProduct(id, pname, pimg, price, ptitle, pv, typeid);
	}

	@Override
	public List<Product> getProByTypeid(int typeid) throws Exception {
		return proDao.getProByTypeid(typeid);
	}

	@Override
	public List<Product> getProByName(String pname) throws Exception {
		return proDao.getProByName(pname);
	}
	
}
