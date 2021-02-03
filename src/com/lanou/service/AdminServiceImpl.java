package com.lanou.service;

import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.lanou.bean.Admin;
import com.lanou.dao.AdminDaoImpl;
import com.lanou.dao.IAdminDao;
import com.lanou.util.JDBCUtil;
import com.lanou.util.SessionUtil;

public class AdminServiceImpl implements IAdminService{
	private IAdminDao iad = (IAdminDao) SessionUtil.getSqlSessionUtil(IAdminDao.class);
	@Override
	public Admin qryByNameAndPwd(String adminname, String adminpwd) throws Exception {

		
		
		return iad.qryByNameAndPwd(adminname, adminpwd);
	}
	@Override
	public List<Admin> getByPage(int pagenum, int pagecount) throws Exception {
		PageHelper.startPage(pagenum, pagecount);
		List<Admin> adminList = iad.getByPage();
		
		return adminList;
	}
	@Override
	public int getCount() throws Exception {
		return iad.getCount();
	}
	@Override	
	public void addAdmin(String adminname, String adminpwd) throws Exception {
		iad.addAdmin(adminname, adminpwd);
	}
	@Override
	public void delAdmin(int id) throws Exception {
		iad.delAdmin(id);
	}
	@Override
	public void editAdmin(String id, String adminname, String adminpwd) throws Exception {
		iad.editAdmin(id, adminname, adminpwd);
	}

	
	
//	private IAdminDao iad = new AdminDaoImpl();
//	@Override
//	public Admin qryByNameAndPwd(String adminname, String adminpwd) throws Exception {
//		return iad.qryByNameAndPwd(adminname, adminpwd);
//	}
//	@Override
//	public List<Admin> getByPage(int pagenum, int pagecount) throws Exception {
//		return iad.getByPage(pagenum, pagecount);
//	}
//	@Override
//	public int getCount() throws Exception {
//		return iad.getCount();
//	}
//	@Override
//	public void addAdmin(String adminname, String adminpwd) throws Exception {
//		iad.addAdmin(adminname, adminpwd);
//	}
//	@Override
//	public void delAdmin(String id) throws Exception {
//		iad.delAdmin(id);
//		
//	}
//	@Override
//	public void editAdmin(String id, String adminname, String adminpwd) throws Exception {
//		iad.editAdmin(id, adminname, adminpwd);
//		
//	}

}
