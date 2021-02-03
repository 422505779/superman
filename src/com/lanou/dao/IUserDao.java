package com.lanou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lanou.bean.Admin;
import com.lanou.bean.User;

public interface IUserDao {
	public List<User> getByPage(@Param("pagenum")int pagenum,@Param("pagecount")int pagecount) throws Exception;
	
	public int getCount() throws Exception;
	
	public List<User> getUserById(@Param("id")int id) throws Exception;
	
	public void addUser(@Param("name")String name,@Param("pwd")String pwd,@Param("phone")String phone,@Param("mail")String mail,@Param("address")String address) throws Exception;
	
	public void delUser(@Param("id")String id) throws Exception;
	
	public void editUser(@Param("id")String id,@Param("name")String name,@Param("pwd")String pwd,@Param("phone")String phone,@Param("mail")String mail,@Param("address")String address) throws Exception;

	public User qryByNameAndPwd(@Param("name")String name,@Param("pwd")String pwd) throws Exception;
}
