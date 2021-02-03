package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Type;
import com.lanou.util.JDBCUtil;

public class TypeDaoImpl implements ITypeDao{

	@Override
	public List<Type> getAll(int parentid) throws Exception {
		List<Type> list = new ArrayList<Type>();
		String sql = "select * from pro_type where parentid="+parentid;
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("typename");
			Type type = new Type(id, title, parentid,null);
			list.add(type);
		}
		return list;
	}

	@Override
	public void addType(String typename, int parentid) throws Exception {
		String sql = "insert into pro_type (typename,parentid)values('"+typename+"',"+parentid+")";
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void updateType(int id, String typename) throws Exception {
		String sql = "update pro_type set typename='"+typename+"' where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void delType(int id) throws Exception {
		String sql = "delete from pro_type where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public List<Type> getAllById(int id) throws Exception {
		List<Type> list = new ArrayList<Type>();
		String sql = "select * from pro_type where id="+id;
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			String title = rs.getString("typename");
			int parentid = rs.getInt("parentid");
			Type type = new Type(id, title, parentid,null);
			list.add(type);
		}
		return list;
	}

}
