package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Admin;
import com.lanou.bean.Product;
import com.lanou.bean.Type;
import com.lanou.util.JDBCUtil;

public class ProductDaoImpl implements IProductDao{
	private ITypeDao typeDao = new TypeDaoImpl();
	@Override
	public List<Product> getByPage(int pagenum, int pagecount) throws Exception {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from t_product limit "+(pagenum-1)*pagecount+","+pagecount;
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			int id = rs.getInt("id");
			String pname = rs.getString("pname");
			String pimg = rs.getString("pimg");
			double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			int pv = rs.getInt("pv");
			int typeid = rs.getInt("typeid");
			
			List<Type> typeList1 = typeDao.getAllById(typeid);
			String typename1 = typeList1.get(0).getTitle();
			int id1 = typeList1.get(0).getParentid();
			List<Type> typeList2 = typeDao.getAllById(id1);
			String typename2 = typeList2.get(0).getTitle();
			int id2 = typeList2.get(0).getParentid();
			List<Type> typeList3 = typeDao.getAllById(id2);
			String typename3 = typeList3.get(0).getTitle();
			String typename = typename1+"--"+typename2+"--"+typename3;
			
			Product pro = new Product(id, pname, pimg, price, ptitle, pv, typename);
			list.add(pro);
		}
		return list;
	}

	@Override
	public int getCount() throws Exception {
		String sql = "select count(id) count from t_product";
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		if(rs.next()) {
			int count = rs.getInt("count");
			return count;
		}
		return 0;
	}

	@Override
	public void addProduct(String pname, String pimg, String price, String ptitle, String pv, String typeid) throws Exception {
		String sql = "insert into t_product (pname,pimg,price,ptitle,pv,typeid)values('"+pname+"','"+pimg+"','"+price+"','"+ptitle+"','"+pv+"','"+typeid+"')";
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void delProduct(int id) throws Exception {
		String sql = "delete from t_product where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void editProduct(String id, String pname, String pimg, String price, String ptitle, String pv, String typeid)
			throws Exception {
		String sql = "update t_product set pname='"+pname+"',pimg='"+pimg+"',price='"+price+"',ptitle='"+ptitle+"',pv='"+pv+"',typeid='"+typeid+"' where id='"+id+"'";
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public List<Product> getProById(int id) throws Exception {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from t_product where id ="+id;
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		if(rs.next()) {
			String pname = rs.getString("pname");
			String pimg = rs.getString("pimg");
			double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			int pv = rs.getInt("pv");
			int typeid = rs.getInt("typeid");
			Product pro = new Product(id, pname, pimg, price, ptitle, pv, typeid);
			list.add(pro);
		}
		return list;
	}

	@Override
	public List<Product> getProByTypeid(int typeid) throws Exception {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from t_product where typeid ="+typeid;
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			int id = rs.getInt("id");
			String pname = rs.getString("pname");
			String pimg = rs.getString("pimg");
			double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			int pv = rs.getInt("pv");
			Product pro = new Product(id, pname, pimg, price, ptitle, pv, typeid);
			list.add(pro);
		}
		return list;
	}

	@Override
	public List<Product> getProByName(String pname) throws Exception {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from t_product where pname like '%"+pname+"%'";
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		if(rs.next()) {
			int id = rs.getInt("id");
			String pname1 = rs.getString("pname");
			String pimg = rs.getString("pimg");
			double price = rs.getDouble("price");
			String ptitle = rs.getString("ptitle");
			int pv = rs.getInt("pv");
			int typeid = rs.getInt("typeid");
			Product pro = new Product(id, pname1, pimg, price, ptitle, pv, typeid);
			list.add(pro);
		}
		return list;
	}

}
