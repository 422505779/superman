package com.lanou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lanou.bean.Admin;

public interface IAdminDao {
	public Admin qryByNameAndPwd(@Param("adminname")String adminname,@Param("adminpwd")String adminpwd);
	
	public List<Admin> getByPage();
	
	public int getCount() throws Exception;
	
	public void addAdmin(@Param("adminname")String adminname,@Param("adminpwd")String adminpwd) throws Exception;
	
	public void delAdmin(@Param("id")int id) throws Exception;
	
	public void editAdmin(@Param("id")String id,@Param("adminname")String adminname,@Param("adminpwd")String adminpwd) throws Exception;
}
