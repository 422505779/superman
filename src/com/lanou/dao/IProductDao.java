package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Admin;
import com.lanou.bean.Product;

public interface IProductDao {
	public List<Product> getByPage(int pagenum,int pagecount) throws Exception;
	
	public List<Product> getProById(int id) throws Exception;
	
	public List<Product> getProByName(String pname) throws Exception;
	
	public List<Product> getProByTypeid(int typeid) throws Exception;
	
	public int getCount() throws Exception;
	
	public void addProduct(String pname,String pimg,String price,String ptitle,String pv,String typeid) throws Exception;

	public void delProduct(int id) throws Exception;
	
	public void editProduct(String id,String pname,String pimg,String price,String ptitle,String pv,String typeid) throws Exception;
}
