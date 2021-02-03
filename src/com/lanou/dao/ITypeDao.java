package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Type;

public interface ITypeDao {
	public List<Type> getAll(int parentid) throws Exception;
	
	public void addType(String typename,int parentid) throws Exception;
	
	public void updateType(int id,String typename) throws Exception;
	
	public void delType(int id) throws Exception;
	
	public List<Type> getAllById(int id) throws Exception;
	
}
