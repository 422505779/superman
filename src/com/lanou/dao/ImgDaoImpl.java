package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Img;
import com.lanou.util.JDBCUtil;

public class ImgDaoImpl implements IImgDao{

	@Override
	public List<Img> getAll() throws Exception {
		List<Img> list = new ArrayList<Img>();
		String sql = "select * from t_carousel";
		ResultSet rs = JDBCUtil.queryUtil(sql, null);
		while(rs.next()) {
			int id = rs.getInt("id");
			String timg = rs.getString("timg");
			Img img = new Img(id, timg);
			list.add(img);
		}
		return list;
	}

	@Override
	public void addImg(String img) throws Exception {
		String sql = "insert into t_carousel(timg) values('"+img+"')";
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void delImg(String id) throws Exception {
		String sql = "delete from t_carousel where id="+id;
		JDBCUtil.ZengShanGai(sql);
	}

	@Override
	public void editImg(String id, String img) throws Exception {
		String sql = "update t_carousel set timg='"+img+"'";
		JDBCUtil.ZengShanGai(sql);
	}

}
