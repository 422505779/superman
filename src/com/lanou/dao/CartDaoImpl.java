package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Cart;
import com.lanou.bean.Product;
import com.lanou.bean.Type;
import com.lanou.bean.User;
import com.lanou.util.JDBCUtil;

public class CartDaoImpl implements ICartDao{
	private IUserDao uDao = new UserDaoImpl();
	private IProductDao proDao= new ProductDaoImpl();
	@Override
	public List<Cart> getByPage(int pagenum, int pagecount) throws Exception {
		List<Cart> list = new ArrayList<Cart>();
		String sql = "select "
				  +" tc.id id,tu.id userid,tp.id productid,tu.name uname,tp.pname pname,tp.price price "
				  +" from t_cart tc left join t_user tu on tc.userid=tu.id "
				        +" left join t_product tp on tc.productid=tp.id limit "+(pagenum-1)*pagecount+","+pagecount;
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			int id = rs.getInt("id");
			int userid = rs.getInt("userid");
			int productid = rs.getInt("productid");
			String uname = rs.getString("uname");
			String pname = rs.getString("pname");
			double price = rs.getDouble("price");
			Cart cart = new Cart(id, userid, productid, uname, pname, price);
			list.add(cart);
		}
		
		return list;
	}

	@Override
	public int getCount() throws Exception {
		String sql = "select count(id) count from t_cart";
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		if(rs.next()) {
			int count = rs.getInt("count");
			return count;
		}
		return 0;
	}

	@Override
	public void delCart(String id) throws Exception {
		String sql = "delete from t_cart where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public List<Cart> getByPage(int userid, int pagenum, int pagecount) throws Exception {
		List<Cart> list = new ArrayList<Cart>();
		String sql = "select distinct productid from t_cart where userid="+userid;
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		int i=1;
		while(rs.next()) {
			i++;
			List<User> ulist = uDao.getUserById(userid);
			String uname = ulist.get(0).getName();
			int productid = rs.getInt("productid");
			List<Product> plist = proDao.getProById(productid);
			String pname = plist.get(0).getPname();
			double price = plist.get(0).getPrice();
			int count = getCount(productid,userid);
			Cart cart = new Cart(i, userid, productid, uname, pname, price,count);
			list.add(cart);
		}
		
		return list;
	}

	@Override
	public void addCart(int userid, int productid) throws Exception {
		String sql = "insert into t_cart(userid,productid) values('"+userid+"','"+productid+"')";
		JDBCUtil.ZengShanGai(sql);
	}
	
	

	@Override
	public int getCount(int pid,int uid) throws Exception {
		String sql = "select count(id) count from t_cart where userid="+uid+" and productid = " +pid;
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		if(rs.next()) {
			int count = rs.getInt("count");
			return count;
		}
		return 0;
	}

	@Override
	public List<Cart> getByUid(int uid) throws Exception {
		List<Cart> list = new ArrayList<Cart>();
		String sql = "select * from where userid ="+uid;
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			int id = rs.getInt("id");
			int pid = rs.getInt("productid");
			Cart cart = new Cart(id, uid, pid);
			list.add(cart);
		}
		
		return list;
	}

}
