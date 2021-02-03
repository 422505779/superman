package com.lanou.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.github.pagehelper.PageHelper;
import com.lanou.bean.User;
import com.lanou.dao.IUserDao;
import com.lanou.dao.UserDaoImpl;
import com.lanou.util.SessionUtil;

public class UserServiceImpl implements IUserService{
	private IUserDao iud = (IUserDao) SessionUtil.getSqlSessionUtil(IUserDao.class);
	@Override
	public List<User> getByPage(int pagenum, int pagecount) throws Exception {
		PageHelper.startPage(pagenum, pagecount);
		List<User> userList = iud.getByPage(pagenum, pagecount);
		return userList;
	}

	@Override
	public int getCount() throws Exception {
		return iud.getCount();
	}

	@Override
	public void addUser(String name, String pwd, String phone, String mail, String address) throws Exception {
		iud.addUser(name, pwd, phone, mail, address);
	}

	@Override
	public void delUser(String id) throws Exception {
		iud.delUser(id);
	}

	@Override
	public void editUser(String id, String name, String pwd, String phone, String mail, String address)
			throws Exception {
		iud.editUser(id, name, pwd, phone, mail, address);
	}

	@Override
	public User qryByNameAndPwd(String name, String pwd) throws Exception {
		return iud.qryByNameAndPwd(name, pwd);
	}

}
