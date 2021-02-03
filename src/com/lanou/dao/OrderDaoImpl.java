package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Cart;
import com.lanou.bean.Order;
import com.lanou.util.JDBCUtil;

public class OrderDaoImpl implements IOrderDao{

	@Override
	public List<Order> getByPage(int pagenum, int pagecount) throws Exception {
		List<Order> list = new ArrayList<Order>();
		String sql = "select "
				  +" tor.id id,tu.id userid,tp.id productid,tu.name uname,tp.pname pname,ts.sname sname "
				  +" from t_order tor left join t_user tu on tor.userid=tu.id "
				  		+" left join t_status ts on tor.status=ts.id "
				        +" left join t_product tp on tor.productid=tp.id limit "+(pagenum-1)*pagecount+","+pagecount;
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			String id = rs.getString("id");
			int userid = rs.getInt("userid");
			int productid = rs.getInt("productid");
			String uname = rs.getString("uname");
			String pname = rs.getString("pname");
			String sname = rs.getString("sname");
			Order order = new Order(id, userid, productid, uname, pname, sname);
			list.add(order);
		}
		
		return list;
	}

	@Override
	public int getCount() throws Exception {
		String sql = "select count(id) count from t_order";
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		if(rs.next()) {
			int count = rs.getInt("count");
			return count;
		}
		return 0;
	}

	@Override
	public void delOrder(String id) throws Exception {
		String sql = "delete from t_order where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

}
